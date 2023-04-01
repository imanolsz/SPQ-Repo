package es.deusto.spq.main;


import javax.ws.rs.client.Client;
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
		gestorVentanas.getVentanaPrincipal().setVisible(true);
	}
	public static GestorVentanas getGestorVentanas() {
		return gestorVentanas;
	}
	public static ExampleClient getExampleClient(){
		return exampleClient;
	}
}
