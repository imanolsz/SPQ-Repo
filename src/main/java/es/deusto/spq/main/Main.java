package es.deusto.spq.main;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import es.deusto.spq.client.ExampleClient;
import es.deusto.spq.ventanas.GestorVentanas;

public class Main {
    private static GestorVentanas gestorVentanas;
	private static ExampleClient exampleClient;
	protected static final Logger logger = LogManager.getLogger();
	


	public static void main(String[] args) {

		if (args.length != 2) {
			logger.info("Use: java Client.Client [host] [port]");
			System.exit(0);
		}

		String hostname = args[0];
		String port = args[1];
		
		exampleClient = new ExampleClient(hostname, port);
		gestorVentanas = new GestorVentanas();

		// List<Notificacion> Notificaciones = new ArrayList<>();

		// Notificaciones.add(new Notificacion("Pedido de comida", "Hola, quiero hacer un pedido de comida para dos personas", LocalDate.now()));
		// Notificaciones.add(new Notificacion("Reserva para mañana", "Hola, quisiera hacer una reserva para mañana a las 8pm", LocalDate.now()));
		// Notificaciones.add(new Notificacion("Queja sobre el servicio", "Buenos días, quiero presentar una queja sobre el servicio que recibí ayer en su restaurante", LocalDate.now()));
		// Notificaciones.add(new Notificacion("Sugerencia de menú", "Hola, quisiera hacer una sugerencia para agregar un plato nuevo al menú", LocalDate.now()));
		// Notificaciones.add(new Notificacion("Solicitud de información", "Buenas tardes, quisiera solicitar información sobre los precios del menú del día", LocalDate.now()));
	
		
		// gestorVentanas = new GestorVentanas(Notificaciones);
		//gestorVentanas.getVentanaPrincipal().setVisible(true);
	}
	public static GestorVentanas getGestorVentanas() {
		return gestorVentanas;
	}
	public static ExampleClient getExampleClient(){
		return exampleClient;
	}

}