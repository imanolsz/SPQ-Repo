package es.deusto.spq.main;

import org.apache.logging.log4j.*;
import es.deusto.spq.client.*;
import es.deusto.spq.client.gui.*;
/**
 * @brief La clase principal para ejecutar la aplicación java
 * 
 * @param gestorVentanas el gestor donde se inicializar todas las ventanas de la aplicacion
 * @param exampleClient el cliente que usa y ejecuta la aplicacion
 * @param logger el objeto logger para la información de la conexion cliente-servidor
 * @param BASE_URI null
 */
public class Main {
    private static GestorVentanas gestorVentanas;
	private static ExampleClient exampleClient;
	protected static final Logger logger = LogManager.getLogger();
    public static final String BASE_URI = null;
	
	public static void main(String[] args) {

		if (args.length != 2) {
			logger.info("Use: java Client.Client [host] [port]");
			System.exit(0);
		}

		String hostname = args[0];
		String port = args[1];
		
		exampleClient = new ExampleClient(hostname, port);
		gestorVentanas = new GestorVentanas();

		gestorVentanas.getVentanaPrincipal().setVisible(true);
	}
	public static GestorVentanas getGestorVentanas() {
		return gestorVentanas;
	}
	public static ExampleClient getExampleClient(){
		return exampleClient;
	}
}