package es.deusto.spq.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.spq.pojo.DirectMessage;
import es.deusto.spq.pojo.MessageData;
import es.deusto.spq.pojo.ReservaData;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.jdo.User; // Mal
import es.deusto.spq.server.jdo.Notificacion;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.List;
=======
import es.deusto.spq.pojo.*;
import es.deusto.spq.server.jdo.User;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

>>>>>>> 822078f89847c628d8f18915a7c0d3f1e1eec861

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleClient {

	protected static final Logger logger = LogManager.getLogger();
	private Client client;
	private WebTarget webTarget;

	public ExampleClient(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/resource", hostname, port));
	}

	public void registerUser(String login, String password) {
		WebTarget registerUserWebTarget = webTarget.path("register");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		
		UserData userData = new UserData();
		userData.setId(login);
		userData.setPassword(password);
		Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			logger.info("User correctly registered");
		}
	}
	public UserData loginUser(String id, String password){
		WebTarget registerUserWebTarget = webTarget.path("login");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		
		UserData userData = new UserData();
		userData.setId(id);
		userData.setPassword(password);
		Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			logger.info("User correctly logged.");
		}
		return userData;
	}
	public void sayMessage(String login, String password, String message) {
		WebTarget sayHelloWebTarget = webTarget.path("sayMessage");
		Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);

		DirectMessage directMessage = new DirectMessage();
		UserData userData = new UserData();
		userData.setId(login);
		userData.setPassword(password);

		directMessage.setUserData(userData);

		MessageData messageData = new MessageData();
		messageData.setMessage(message);
		directMessage.setMessageData(messageData);

		Response response = invocationBuilder.post(Entity.entity(directMessage, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}",response.getStatus());
		} else {
			String responseMessage = response.readEntity(String.class);
			logger.info("* Message coming from the server: '{}'", responseMessage);
		}
	}
	public List<Notificacion> getNotifications(User userParam) {
		WebTarget webTarget = client.target("http://example.com/api/");
		WebTarget notificationsTarget = webTarget.path("getNotifications");
		Invocation.Builder invocationBuilder = notificationsTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(userParam, MediaType.APPLICATION_JSON));
	
		List<Notificacion> notifications = new ArrayList<>(); // Inicializa la lista con una lista vacía
	
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}",response.getStatus());
		} else {
			notifications = response.readEntity(new GenericType<List<Notificacion>>() {});
			logger.info("* Notifications: {}", notifications);
		}
		
		return notifications; // Devuelve la lista, aunque esté vacía si hay un error
	}

	public void realizarReserva(Date fecha, Time hora,  int numPersonas, boolean cancelada, UserData userData) {
		WebTarget registerUserWebTarget = webTarget.path("realizarReserva");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		
		ReservaData reservaData = new ReservaData();
		reservaData.setFecha(fecha);
		reservaData.setHora(hora);
		reservaData.setCancelada(cancelada);
		reservaData.setNumPersonas(numPersonas);
		reservaData.setUser(userData);
		Response response = invocationBuilder.post(Entity.entity(reservaData, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			logger.info("User correctly registered");
		}
	}


	public List<ReservaData> getReservas() {
		WebTarget getReservasWebTarget = webTarget.path("admin/getReservas"); // Crea un objeto WebTarget con la URL del servicio REST que se desea invocar
		Invocation.Builder invocationBuilder = getReservasWebTarget.request(MediaType.APPLICATION_JSON); //  Se crea un objeto Invocation.Builder, que se utiliza para configurar la solicitud REST
		Response response = invocationBuilder.get();  // Se realiza la solicitud REST utilizando el método get() del objeto invocationBuilder, y se almacena la respuesta en un objeto Response.
		if (response.getStatus() != Status.OK.getStatusCode()) { // Se verifica si la respuesta de la solicitud es exitosa, si no es exitosa, se registra un error en el archivo de registro.
			logger.error("Error connecting with the server. Code: {}", response.getStatus()); 
			throw new RuntimeException("Error connecting with the server. Code: " + response.getStatus());
		} else {
			try {
				List<ReservaData> reservas = response.readEntity(new GenericType<List<ReservaData>>() {}); //Se lee la respuesta en formato JSON y se convertierte en una lista de objetos ReservaData. Se utiliza un objeto GenericType para especificar el tipo de objeto que se está convirtiendo.
				if (reservas == null) {
					throw new RuntimeException("Null list of ReservaData returned from the server");
				}
				logger.info("* Reservas obtenidas: '{}'", reservas); // Se registra un mensaje de información en el archivo de registro con la lista de reservas obtenidas
				return reservas;
			} catch (Exception e) {
				logger.error("Error al obtener las reservas: ", e);
				throw new RuntimeException("Error al obtener las reservas", e);
			}
		}
	}

}