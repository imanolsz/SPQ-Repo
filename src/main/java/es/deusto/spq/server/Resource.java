package es.deusto.spq.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.User;
import es.deusto.spq.server.jdo.Message;
import es.deusto.spq.pojo.DirectMessage;
import es.deusto.spq.pojo.MessageData;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.jdo.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
            tx.begin();
            logger.info("Checking whether the user already exits or not: '{}'", userData.getId());
			User user = null;
			try {
				user = pm.getObjectById(User.class, userData.getId());
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				logger.info("Exception launched: {}", jonfe.getMessage());
			}
			logger.info("User: {}", user);
			if (user != null) {
				logger.info("Setting password user: {}", user);
				user.setPassword(userData.getPassword());
				logger.info("Password set user: {}", user);
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

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello() {
		return Response.ok("Hello world!").build();
	}

	@GET
	@Path("/admin/reservas")
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
}
