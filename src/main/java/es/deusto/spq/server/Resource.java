package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

import es.deusto.spq.pojo.DirectMessage;
import es.deusto.spq.pojo.MessageData;
import es.deusto.spq.pojo.ReservaData;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.jdo.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.spq.server.jdo.Notificacion;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {

	protected static final Logger logger = LogManager.getLogger();

	private int cont = 0;
	private PersistenceManager pm=null; // Una instancia de una consulta, objeto que representa una consulta en una base de datos
	private Transaction tx=null; // Una transacción es un conjunto de operaciones que se realizan sobre una base de datos, y que se consideran como una única unidad de trabajo.

	public Resource() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
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
		try
        {	
			User user = null;
            tx.begin();
            logger.info("Checking whether the user already exits or not: '{}'", userData.getId());
			try {
				user = pm.getObjectById(User.class, userData.getId());
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				logger.info("Exception launched: {}", jonfe.getMessage());
			}
			logger.info("User: {}", user);
			if (user != null) {
				logger.info("Usuario ya registrado: {}", user);
			} else {
				logger.info("Creating user: {}", user);
				user = new User(userData.getId(), userData.getPassword());
				pm.makePersistent(user);					 
				logger.info("User created: {}", user);
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
	@Path("/login")
	public Response loginUser(UserData userData) {
		try
        {	
			User user = null;
            tx.begin();
            logger.info("Checking whether the user already exits or not: '{}'", userData.getId());
			try {
				user = pm.getObjectById(User.class, userData.getId());
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				logger.info("Exception launched: {}", jonfe.getMessage());
			}
			try (Query<?> q = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE login == \"" + user.getId() + "\" &&  password == \"" + user.getPassword() + "\" && admin == \""+ user.isAdmin()+"\"")) {
				q.setUnique(true);
				user = (User)q.execute();
				
				logger.info("User: {}", user);
				if (user != null)  {
					if(user.isAdmin()){
						logger.info("Admin logged: {}", user);
					}else{
						logger.info("User logged: {}", user);
					}
					pm.makePersistent(user);					 
				}else{
					try {
						user = pm.getObjectById(User.class, userData.getId());
					} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
						logger.info("Exception launched: {}", jonfe.getMessage());
					}
					try (Query<?> q2 = pm.newQuery("SELECT FROM" + User.class.getName() + " WHERE login == \"" + user.getId() + " \"")){
						q2.setUnique(true);
						user = (User)q.execute();
						logger.info("User: {}", user);
						if (user != null)  {
							logger.info("Contraseña incorrecta");
							pm.makePersistent(user);					 
						}else{
							try {
								user = pm.getObjectById(User.class, userData.getId());
							} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
								logger.info("Exception launched: {}", jonfe.getMessage());
							}
							try (Query<?> q3= pm.newQuery("SELECT FROM" + User.class.getName() + " WHERE password == \"" + user.getId() + " \"")){
								q3.setUnique(true);
								user = (User)q.execute();
								logger.info("User: {}", user);
								if (user != null)  {
									logger.info("Nombre de usuario  	incorrecto");
									pm.makePersistent(user);		 
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
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
	public Response realizarReserva(ReservaData reservaData) {
		try
        {	
			Reserva reserva = null;
            tx.begin();
			reserva = new Reserva(reservaData.getFecha(), reservaData.getHora(), reservaData.getNumPersonas(),reservaData.getCancelada(),reservaData.getusername());
            logger.info("Realizando reserva: '{}'", reservaData.getId());
			pm.makePersistent(reserva)
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
	@Path("/getNotifications")
	public Response getNotifications(User userParam) {
		List<Notificacion> notifications = new ArrayList<>();
	
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
	
		try {
			tx.begin();
	
			Query<Notificacion> query = pm.newQuery(Notificacion.class, "usuario == userParam");
			query.declareParameters(User.class.getName() + " userParam");
	
			
			notifications.add((Notificacion)query.execute(userParam));
	
			
	
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error retrieving notifications: " + ex.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	
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
			query.setFilter("cancelada == true || cancelada == false"); // Filtro para la consulta, devolverá todas las reservas, tanto canceladas como no canceladas
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
				reserva.setFecha(reservaData.getFecha());
				reserva.setCancelada(reservaData.getCancelada());
				reserva.setHora(reservaData.getHora());
				reserva.setNumPersonas(reservaData.getNumPersonas());
				reserva.setUsername(reservaData.getusername());

				try(Query<?> q = pm.newQuery("UPDATE"+ Reserva.class.getName()+ " SET fecha== \"" + reserva.getFecha() + ", cancelada== \""+ reserva.getCancelada() + ", hora== \"" + reserva.getHora() + ", numpersonas== \"" + reserva.getNumPersonas()+ " WHERE id == \"" + reserva.getId()+ " \" && username== \"" + reserva.getUsername() +"+ \"")){
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
}
