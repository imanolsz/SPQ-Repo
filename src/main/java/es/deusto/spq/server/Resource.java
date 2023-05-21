package es.deusto.spq.server;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

import javax.jdo.*;

import es.deusto.spq.pojo.*;
import es.deusto.spq.server.jdo.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import javax.inject.Singleton;

import org.apache.logging.log4j.*;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class Resource {

	
	protected static final Logger logger = LogManager.getLogger();
	static Map<Long, User> serverState = new HashMap<>();
	private int cont = 0;
	PersistenceManager pm= null; // Una instancia de una consulta, objeto que representa una consulta en una base de datos
	private Transaction tx=null; // Una transacción es un conjunto de operaciones que se realizan sobre una base de datos, y que se consideran como una única unidad de trabajo.
	// constructor

	public Resource(PersistenceManager pm) {
        this.pm = pm;
    }
	
	public Resource() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
			if (this.tx != null && this.tx.isActive()) {
				this.tx.rollback();
			}
			this.tx = pm.currentTransaction();
	}

	@POST
	@Path("/sayMessage")
	public Response sayMessage(DirectMessage directMessage) {
		User user = null;
		try{
			tx.begin();
			logger.info("Creating query ...");
			
			try (Query<?> q = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE login == \"" + directMessage.getUserData().getId() + "\" &&  password == \"" + directMessage.getUserData().getPassword() + "\"")) {
				q.setUnique(true);
				user = (User)q.execute();
				
				logger.info("User retrieved: {}", user);
				if (user != null)  {
					Message message = new Message(directMessage.getMessageData().getMessage());
					user.getMessages().add(message);
					pm.makePersistent(user);					 
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
		
		if (user != null) {
			cont++;
			logger.info(" * Client number: {}", cont);
			MessageData messageData = new MessageData();
			messageData.setMessage(directMessage.getMessageData().getMessage());
			return Response.ok(messageData).build();
		} else {
			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for message delivery are not correct").build();
		}
	}
	
	@POST
	@Path("/register")
	public Response registerUser(UserData userData) {
		Transaction localTx = pm.currentTransaction();
		try {
			User user = null;
			if (!localTx.isActive()) {
				localTx.begin();
			}
			logger.info("Checking whether the user already exits or not: '{}'", userData.getId());
			try {
				user = pm.getObjectById(User.class, userData.getId());
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				logger.info("Exception launched: {}", jonfe.getMessage());
			}
			logger.info("User: {}", user);
			if (user != null) {
				logger.info("Usuario ya registrado: {}", user);
				System.out.println("objt creado");
			} else {
				user = new User(userData.getId(), userData.getPassword());
				logger.info("Creating user: {}", user);
				pm.makePersistent(user);
				logger.info("User created: {}", user);
			}
			localTx.commit();
			return Response.ok().build();
		} finally {
			if (localTx.isActive()) {
				localTx.rollback();
			}
		}
	}
	
	@POST
	@Path("/login")
	public Response loginUser(UserData userData) {
		try {
			User user = null;
			tx.begin();
			logger.info("Checking whether the user already exists or not: '{}'", userData.getId());
			try {
				user = pm.getObjectById(User.class, userData.getId());
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				logger.info("Exception launched: {}", jonfe.getMessage());
			}
			if (user != null && user.getPassword().equals(userData.getPassword())) {
				try (Query<?> q = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE id == \"" + user.getId() + "\" && password == \"" + user.getPassword() + "\" && admin == " + user.isAdmin())) {
					q.setUnique(true);
					user = (User)q.execute();
					logger.info("User: {}", user);
					if (user != null) {
						pm.makePersistent(user);
						Long token = Calendar.getInstance().getTimeInMillis();
						this.serverState.put(token, user);
						if (user.isAdmin()) {
							logger.info("Admin logged: {}", user);
							return Response.ok().entity(new AuthService(token.toString(), true)).build();
						} else {
							logger.info("User logged: {}", user);
							return Response.ok().entity(new AuthService(token.toString(), false)).build();
						}
					} else {
						logger.info("User not found");
						return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
					}
				} catch (Exception e) {
					e.printStackTrace();
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
				}
			} else if(user != null && user.getPassword().equals(userData.getPassword()) == false ){
				logger.info("Incorrect password for user '{}'", userData.getId());
				return Response.status(Response.Status.UNAUTHORIZED).entity("Incorrect password").build();
			} else {
				logger.info("Incorrect user '{}'", userData.getId());
				return Response.status(Response.Status.UNAUTHORIZED).entity("Incorrect User").build();
			}
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
	}
	
	
	@POST
	@Path("/logout")
	public Response logout(long token) throws RemoteException {
		try
        {	
            tx.begin();
            if (this.serverState.containsKey(token)) {
				// Logout means remove the User from Server State
				this.serverState.remove(token);
			} else {
				throw new RemoteException("User is not logged in!");
			}
			
			tx.commit();
			return Response.ok().build();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
		}
	}


@POST
@Path("/realizarReserva")
public Response realizarReserva(ReservaData reservaData, @HeaderParam("Authorization") String authorizationHeader) {
    try {	
        Reserva reserva = null;
        Pedido pedido = null;
        List<DetallePedido> alimentos = new ArrayList<>();
        tx.begin();
        //Desenmascarar usuario activo
        String tokenString = authorizationHeader.substring("Bearer ".length()).trim();
        long token = Long.parseLong(tokenString);
        System.out.println(token);
        User foundUser = serverState.get(token);
        System.out.println(foundUser);
        if (this.serverState.containsKey(token)) {
            User usuario = this.serverState.get(token);
            System.out.println(usuario.getId());
            reserva = new Reserva(reservaData.getFecha(), reservaData.getHora(), reservaData.getNumPersonas(), reservaData.getCancelada(), reservaData.getEspecificacion(), reservaData.getAparcamiento(),usuario);
			pedido = new Pedido(new ArrayList<DetallePedido>(), reserva);
            for (DetallePedidoData detallePedidoData : reservaData.getPedido().getListaAlimentos()) {
                DetallePedido detallePedido = new DetallePedido(detallePedidoData.getAlimento(),detallePedidoData.getCantidad(),pedido);
				pedido.getlistaAlimentos().add(detallePedido);
       		 }
		
        logger.info("Realizando reserva: '{}'", reservaData.getId());
        pm.makePersistent(reserva);
		pm.makePersistent(pedido);
        for (DetallePedido alimento : alimentos) {
            pm.makePersistent(alimento);
        }}else{
			logger.info("No se ha podido hacer la reserva : '{}'");
		}
        tx.commit();
        return Response.ok().build();
		
    } finally {
        if (tx.isActive()) {
            tx.rollback();
        }
    }
}

@POST
@Path("/realizarResena")
public Response realizarResena(ResenaData resenaData, @HeaderParam("Authorization") String authorizationHeader) {
try {	
	tx.begin();
	String pr = resenaData.getResena();
	Resena resena = new Resena(pr);
	pm.makePersistent(resena);
	tx.commit();
    return Response.ok().build();
} finally {
	if (tx.isActive()) {
		tx.rollback();
	}
}
}

	@POST
	@Path("/realizarNotificacion")
	public Response realizarNotificacion(NotificacionData notificacionData ) {
		try
        {	
			Notificacion notificacion = null;
            tx.begin();
			//paso de notificacionData a notificacion
			notificacion = new Notificacion(notificacionData.getAsunto(), notificacionData.getContenido(), notificacionData.getFecha(),notificacionData.getIDNotificacion());
            logger.info("Realizando notificacion: '{}'", notificacionData.getIDNotificacion());
			pm.makePersistent(notificacion);
			tx.commit();
			NotificacionData.guardarNotificacionDataBD(notificacionData);
			return Response.ok().build();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
		}
	}

	@POST
	@Path("/realizarNota")
	public Response realizarNota(NotaData notaData ) {
		try
        {	
			Nota nota = null;
            tx.begin();
			//paso de notificacionData a notificacion
			nota = new Nota(notaData.getAsunto(), notaData.getContenido(), notaData.getFecha(),notaData.getIDNota());
            logger.info("Realizando notificacion: '{}'", notaData.getIDNota());
			pm.makePersistent(nota);
			tx.commit();
			NotaData.guardarNotaDataBD(notaData);
			return Response.ok().build();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
		}
	}

	@POST
	@Path("/getNotifications")
	public Response getNotifications(User userParam) {
		List<Notificacion> notifications = new ArrayList<>();
	
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
	
		try {
			tx.begin();
			
			// find in notification where userParam.getId is equal to IDNotificacion
			Query<Notificacion> query = pm.newQuery(Notificacion.class);
			//userParam.setId("1");
			//query.setFilter("IDNOTIFICACION == " + Long.parseLong(userParam.getId()));
			notifications = query.executeList();
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error retrieving notifications: " + ex.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

		System.out.println(" $ Notifications retrieved: " + notifications.size());
	
		return Response.ok(notifications).build();
	}
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello() {
		return Response.ok("Hello world!").build();
	}

	@GET
	@Path("/admin/getReservas")
	public Response getReservas() {
		try { 
			tx.begin(); // Comienza una transacción para realizar operaciones en la base de datos.
			List<Reserva> reservas = new ArrayList<>();
			Query<Reserva> query = pm.newQuery(Reserva.class); // Crea una instancia de una consulta
			query.setOrdering("fecha desc, hora asc"); // Orden de la consulta, Las reservas se ordenan primero por fecha y luego por hora
			reservas = query.executeList(); // Ejecuta una consulta en la base de datos y devuelve los resultados en forma de una lista de objetos
			tx.commit(); // Confirma la transacción.
			return Response.ok(reservas).build(); // Retorna una respuesta HTTP 200 (OK) con la lista de reservas como cuerpo de la respuesta.
		} catch (Exception e) {
			logger.error("Error en el método getReservas: ", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build(); // Retorna una respuesta HTTP 500 (Internal Server Error) si se produce una excepción.
		} finally { // Bloque finally se ejecuta siempre, independientemente de si se produce una excepción o no.
			if (tx.isActive()) { // Si la transacción está activa (si no se realizo el tx.commit), hace un rollback de la transacción.
				tx.rollback(); // Operación que revierte una transacción y deshace todos los cambios realizados en la base de datos desde el inicio de la misma
			}
		}
	}

	 /*
	 @GET
	 @Path("/admin/getReservasFiltradas")
	 public Response getReservasFiltradas(Date fecha, LocalTime hora) {
	 	try { 
			tx.begin(); // Comienza una transacción para realizar operaciones en la base de datos.
	 		List<Reserva> reservas = new ArrayList<>();
	 		Query<Reserva> query = pm.newQuery(Reserva.class); // Crea una instancia de una consulta
	 		query.setFilter("cancelada == true || cancelada == false"); // Filtro para la consulta, devolverá todas las reservas, tanto canceladas como no canceladas
	 		query.setOrdering("fecha desc, hora asc"); // Orden de la consulta, Las reservas se ordenan primero por fecha y luego por hora
	 		reservas = query.executeList(); // Ejecuta una consulta en la base de datos y devuelve los resultados en forma de una lista de objetos
	 		List<Reserva> reservasFiltradas = new ArrayList<>();
	 		for (Reserva reserva : reservas) {
	 			if (reserva.getFecha().equals(fecha) && reserva.getHora().equals(hora)) {
	 				reservasFiltradas.add(reserva);
	 			}
	 		}
 			tx.commit(); // Confirma la transacción.
	 		return Response.ok(reservasFiltradas).build(); // Retorna una respuesta HTTP 200 (OK) con la lista de reservas como cuerpo de la respuesta.
	 	} catch (Exception e) {
	 		logger.error("Error en el método getReservas: ", e);
	 		return Response.status(Status.INTERNAL_SERVER_ERROR).build(); // Retorna una respuesta HTTP 500 (Internal Server Error) si se produce una excepción.
	 	} finally { // Bloque finally se ejecuta siempre, independientemente de si se produce una excepción o no.
	 		if (tx.isActive()) { // Si la transacción está activa (si no se realizo el tx.commit), hace un rollback de la transacción.
	 			tx.rollback(); // Operación que revierte una transacción y deshace todos los cambios realizados en la base de datos desde el inicio de la misma
	 		}
	 	}
	 }
	  */
	@GET
    @Path("/hayMesaLibre")
    @Produces(MediaType.APPLICATION_JSON) //  Anotación que indica que el método produce una respuesta en formato JSON.
    public Response hayMesaLibre(@QueryParam("fecha") Date fecha, @QueryParam("hora") Time hora, @QueryParam("numPersonas") int numPersonas) { // Acepta tres parámetros de consulta HTTP: fecha, hora y numPersonas.
        boolean mesaLibre = hayMesaLibrebool(fecha, hora, numPersonas);
        return Response.ok().entity(mesaLibre).build(); // Se construye y se devuelve la respuesta HTTP completa, con un código de estado "200 OK". En este caso, la respuesta es un booleano mesaLibre en formato JSON.
		
    }

	// Booleano para el método /hayMesaLibre
	public boolean hayMesaLibrebool(Date fecha, Time hora, int numPersonas) {
		int CAPACIDAD_MAXIMA_RESTAURANTE = 100; // Ejemplo
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("nombreDeLaUnidadDePersistencia"); // Obtener una instancia de PersistenceManagerFactory
		PersistenceManager pm = pmf.getPersistenceManager(); // Se crea una instancia del objeto PersistenceManager, que se utiliza para interactuar con la base de datos.
		boolean mesaLibre = false;
		
		try { 
			// Obtener todas las reservas para la fecha y hora especificadas y que no hayan sido canceladas
			Query<Reserva> query = pm.newQuery(Reserva.class);
			query.setFilter("fecha == fechaParam && hora == horaParam && cancelada == false");
			query.declareParameters("java.util.Date fechaParam, java.sql.Time horaParam"); // Declarar los parámetros que se utilizan en una consulta
			List<Reserva> reservas = (List<Reserva>) query.execute(fecha, hora); // Se ejecuta la consulta

			// Calcular el número de personas en las reservas encontradas
			int numPersonasReservadas = 0;
			for (Reserva reserva : reservas) {
				numPersonasReservadas += reserva.getNumPersonas();
				}
	
			// Comprobar si hay suficiente espacio para la nueva reserva
			if (numPersonasReservadas + numPersonas <= CAPACIDAD_MAXIMA_RESTAURANTE) {
				mesaLibre = true;
			}
		} finally {
			pm.close(); // Se cierra el objeto PersistenceManager.
	}

		return mesaLibre;
	}


	@GET
	@Path("/admin/setReservas")
	public Response actualizarReserva(ReservaData reservaData){
		Reserva reserva = null;
		try{
			tx.begin();
			logger.info("Comprobando que la reserva {} existe.", reservaData.getId());
			try {
				reserva = pm.getObjectById(Reserva.class, reservaData.getId());
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				logger.info("Exception launched: {}", jonfe.getMessage());
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			}
			if(reserva != null){
				reserva.setId(reservaData.getId());
				//reserva.setFecha(reservaData.getFecha());
				reserva.setCancelada(reservaData.getCancelada());
				reserva.setHora(reservaData.getHora());
				reserva.setNumPersonas(reservaData.getNumPersonas());
				//reserva.setUser(reservaData.getUser()); //TODO

				try(Query<?> q = pm.newQuery("UPDATE"+ Reserva.class.getName()+ " SET fecha== \"" + reserva.getFecha() + ", cancelada== \""+ reserva.getCancelada() + ", hora== \"" + reserva.getHora() + ", numpersonas== \"" + reserva.getNumPersonas()+ " WHERE id == \"" + reserva.getId()+ " \" && user== \"" + reserva.getUser() +"+ \"")){
					logger.info("La reserva {} ha sido modificada.", reserva.getId());
				}catch(Exception e){
					logger.error("Error en el método actualizarReservas: ", e);
					e.printStackTrace();
				}
			}else{
				logger.info("La reserva {} no existe.", reservaData.getId());
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			}
			return Response.ok().build();
		}
		finally
        {
			if (tx.isActive())
            {
				tx.rollback();
            }
		}
	}

	//Falta comprobación: método que borra una reserva pasada por parametro
	@POST
    @Path("/cancelarReserva")
    public Response cancelarReserva(ReservaData reservadata) {
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        //pasar de reservadata a reserva
        Reserva reserva = new Reserva();
        reserva.setFecha(reservadata.getFecha());
        reserva.setHora(reservadata.getHora());
        reserva.setNumPersonas(reservadata.getNumPersonas());
        reserva.setCancelada(reservadata.isCancelada());
        //pasar de userdata a user
        User user = new User();
        user.setId(reservadata.getUser().getId());
        user.setPassword(reservadata.getUser().getPassword());
        reserva.setUser(user);
        reserva.setId(reservadata.getId());


        try {
            tx.begin();
            pm.deletePersistent(reserva);

            tx.commit();
            return Response.ok().build();
        } catch (Exception ex) {
            System.out.println(" $ Error borrando reserva: " + ex.getMessage());
            tx.rollback();
            return Response.serverError().build();
        } finally {
            pm.close();
        }
	}

	public User getUserByUsername(String username) {
		User user = null;
		try {
			Query<User> query = pm.newQuery(User.class);
			query.setFilter("this.username == usernameParam");
			query.declareParameters("String usernameParam");
			List<User> results = (List<User>) query.execute(username);
			System.out.println(results + "lista vacia");
			if (!results.isEmpty()) {
				user = results.get(0);
			}
		} catch (Exception e) {
			// Manejar excepción
		} finally {
			pm.close();
		}
		return user;
	}
}
