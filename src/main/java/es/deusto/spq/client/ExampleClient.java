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
import es.deusto.spq.pojo.NotaData;
import es.deusto.spq.pojo.ReservaData;
import es.deusto.spq.pojo.UserData;

import java.sql.Time;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.client.ClientConfig;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import es.deusto.spq.pojo.NotificacionData;

public class ExampleClient {

	protected static final Logger logger = LogManager.getLogger();
	private Client client;
	private WebTarget webTarget;
	private long token = -1;
	int ID = 0;

	public ExampleClient(String hostname, String port) {
		ClientConfig config = new ClientConfig();

    // Crear un ObjectMapper y registrar el módulo JavaTimeModule
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    // Crear un JacksonJaxbJsonProvider y establecer el ObjectMapper personalizado
    JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
    provider.setMapper(objectMapper);

    // Registrar el provider y la característica JacksonFeature en la configuración del cliente
    config.register(provider);
    config.register(JacksonFeature.class);

    // Crear un nuevo cliente JAX-RS utilizando la configuración personalizada
    client = ClientBuilder.newClient(config);
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
	public AuthResponse loginUser(String id, String password){
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
			AuthResponse authResponse = response.readEntity(AuthResponse.class);
			if (authResponse.isAdmin()) {
				logger.info("Admin user logged in. Token: {}", authResponse.getToken());
			} else {
				logger.info("Regular user logged in. Token: {}", authResponse.getToken());
			}
			this.token = Long.parseLong(authResponse.getToken());
        	logger.info("User correctly logged. Token: {}", token);
       		return authResponse;
		}
		return null;
	}

	public void logout() {
		WebTarget registerUserWebTarget = webTarget.path("logout");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(this.token, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			logger.info("User correctly registered");
		}
		this.token = -1;
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
	public List<NotificacionData> getNotifications(UserData userParam) {
		WebTarget notificationsTarget = webTarget.path("getNotifications");
		Invocation.Builder invocationBuilder = notificationsTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(userParam, MediaType.APPLICATION_JSON));
	
		List<NotificacionData> notifications = new ArrayList<>(); // Inicializa la lista con una lista vacía
	
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}",response.getStatus());
		} else {
			notifications = response.readEntity(new GenericType<List<NotificacionData>>() {});
			logger.info("* Notifications: {}", notifications);
		}
		
		System.out.println(notifications);
		return notifications; // Devuelve la lista, aunque esté vacía si hay un error
	}

	public void realizarReserva(Date fecha, LocalTime hora,  int numPersonas, boolean cancelada, long token) {
		WebTarget registerUserWebTarget = webTarget.path("realizarReserva");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		//Date date = fecha; // crea un objeto Date
		//java.time.Instant instant = date.toInstant(); // convierte Date a Instant
		//Date Date = instant.atZone(ZoneId.systemDefault()).toLDate(); // convierte Instant a LocalDate

		// Agregar token como header personalizado
		invocationBuilder.header("Authorization", "Bearer " + token);

		//creo una NotificacionData para el usuario
		/*NotificacionData NotificacionData = new NotificacionData();
		NotificacionData.setIDNotificacionData(ID);
		ID += 1;
		NotificacionData.setFecha(Date);
		NotificacionData.setAsunto("Confirmacion de reserva");
		NotificacionData.setContenido("Su reserva se ha realizado correctamente. El dia " + fecha + " a las " + hora + " para " + numPersonas + " personas.");
		*/
		
		ReservaData reservaData = new ReservaData();
		reservaData.setFecha(fecha);
		reservaData.setHora(hora);
		reservaData.setCancelada(cancelada);
		reservaData.setNumPersonas(numPersonas);
		Response response = invocationBuilder.post(Entity.entity(reservaData, MediaType.APPLICATION_JSON));
		
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			realizarNotificacion(reservaData,token);
			logger.info("La reserva se ha realizado");
		
		}
	}


	

	public void realizarNotificacion(ReservaData reserva, Long token) {
		WebTarget registerUserWebTarget = webTarget.path("realizarNotificacion");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Date date = reserva.getFecha(); // crea un objeto Date
		java.time.Instant instant = date.toInstant(); // convierte Date a Instant
		Date date2 = Date.from(instant.atZone(ZoneId.systemDefault()).toInstant()); // convierte Instant a LocalDate


		//creo una NotificacionData para el usuario
		NotificacionData NotificacionData = new NotificacionData();
		NotificacionData.setIDNotificacion(token);
		NotificacionData.setFecha(date2);
		NotificacionData.setAsunto("Confirmacion de reserva");
		NotificacionData.setContenido("Su reserva se ha realizado correctamente. El dia " + reserva.getFecha() + " a las " + reserva.getHora() + " para " + reserva.getNumPersonas() + " personas.");
		
		
		Response response = invocationBuilder.post(Entity.entity(NotificacionData, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		} else {
			logger.info("User correctly registered");
		}
	}



	public void realizarNota(ReservaData reserva, String asunto, String contenido) {
		WebTarget registerUserWebTarget = webTarget.path("realizarNota");
		Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		Date date = reserva.getFecha(); // crea un objeto Date
		java.time.Instant instant = date.toInstant(); // convierte Date a Instant
		Date date2 = Date.from(instant.atZone(ZoneId.systemDefault()).toInstant()); // convierte Instant a LocalDate


		//creo una NotificacionData para el usuario
		NotaData NotaData= new NotaData();
		NotaData.setIDNota(token);
		NotaData.setFecha(date2);
		NotaData.setAsunto(asunto);
		NotaData.setContenido(contenido + reserva.getFecha() + " a las " + reserva.getHora() + " para " + reserva.getNumPersonas() + " personas.");
		
		
		Response response = invocationBuilder.post(Entity.entity(NotaData, MediaType.APPLICATION_JSON));
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
	public long getToken() {
		return token;
	}


	public List<ReservaData> getReservasFiltradas(Date fecha, LocalTime hora) {
		WebTarget getReservasWebTarget = webTarget.path("admin/getReservasFiltradas"); // Crea un objeto WebTarget con la URL del servicio REST que se desea invocar
		Invocation.Builder invocationBuilder = getReservasWebTarget.request(MediaType.APPLICATION_JSON); //  Se crea un objeto Invocation.Builder, que se utiliza para configurar la solicitud REST
		Response response = invocationBuilder.get();  // Se realiza la solicitud REST utilizando el método get() del objeto invocationBuilder, y se almacena la respuesta en un objeto Response.
		if (response.getStatus() != Status.OK.getStatusCode()) { // Se verifica si la respuesta de la solicitud es exitosa, si no es exitosa, se registra un error en el archivo de registro.
			logger.error("Error connecting with the server. Code: {}", response.getStatus()); 
			throw new RuntimeException("Error connecting with the server. Code: " + response.getStatus());
		} else {
			try {
				List<ReservaData> reservas = response.readEntity(new GenericType<List<ReservaData>>() {}); //Se lee la respuesta en formato JSON y se convertierte en una lista de objetos ReservaData. Se utiliza un objeto GenericType para especificar el tipo de objeto que se está convirtiendo.
				List<ReservaData> reservasFiltradas = new ArrayList<>();
				for (ReservaData reserva : reservas) {
					if (reserva.getFecha().equals(fecha) && reserva.getHora().equals(hora)) {
						reservasFiltradas.add(reserva);
					}
				}
				if (reservas == null) {
					throw new RuntimeException("Null list of ReservaData returned from the server");
				}
				logger.info("* Reservas obtenidas: '{}'", reservas); // Se registra un mensaje de información en el archivo de registro con la lista de reservas obtenidas
				return reservasFiltradas;
			} catch (Exception e) {
				logger.error("Error al obtener las reservas: ", e);
				throw new RuntimeException("Error al obtener las reservas", e);
			}
		}
	}

	/*borrar
	public void cancelarReserva(ReservaData reserva) {
        WebTarget registerUserWebTarget = webTarget.path("cancelarReserva");
        Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

		ReservaData reservaData = new ReservaData();
		reservaData.setFecha(reserva.getFecha());
		reservaData.setHora(reserva.getHora());
		reservaData.setCancelada(reserva.getCancelada());
		reservaData.setNumPersonas(reserva.getNumPersonas());
		reservaData.setUser(reserva.getUser());
		Response response = invocationBuilder.post(null);
        if (response.getStatus() != Status.OK.getStatusCode()) {
            logger.error("Error connecting with the server. Code: {}", response.getStatus());
        } else {
            logger.info("User correctly registered");
        }
    }
	*/

	public void cancelarReserva(ReservaData reservaData) {
        WebTarget registerUserWebTarget = webTarget.path("cancelarReserva");
        Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.post(Entity.entity(reservaData, MediaType.APPLICATION_JSON));
        if (response.getStatus() != Status.OK.getStatusCode()) {
            logger.error("Error connecting with the server. Code: {}", response.getStatus());
        } else {
            logger.info("User correctly registered");
        }
    }

	public boolean hayMesaLibre(ReservaData reservaData) {
		boolean mesaLibre = false;
	
		WebTarget hayMesaLibreWebTarget = webTarget.path("hayMesaLibre")
				.queryParam("fecha", reservaData.getFecha()) // Se agrega un parámetro de consulta HTTP llamado "fecha", que tiene el valor de la propiedad fecha del objeto reservaData
				.queryParam("hora", reservaData.getHora())
				.queryParam("numPersonas", reservaData.getNumPersonas());
	
		Invocation.Builder invocationBuilder = hayMesaLibreWebTarget.request(MediaType.APPLICATION_JSON); // Se establece el tipo de medio que se espera en la respuesta HTTP
	
		Response response = invocationBuilder.get(); //  Se envía una solicitud HTTP GET
	
		if (response.getStatus() == Status.OK.getStatusCode()) { // Se verifica si el código de estado de la respuesta HTTP es 200 OK.
			mesaLibre = response.readEntity(Boolean.class); // Si el código de estado de la respuesta HTTP es 200 OK, se lee el contenido de la respuesta como un objeto booleano, y se asigna a la variable mesaLibre.
		} else {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
		}
	
		return mesaLibre;
	}

	
}

