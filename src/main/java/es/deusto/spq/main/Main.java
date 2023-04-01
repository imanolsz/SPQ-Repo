package es.deusto.spq.main;

import es.deusto.spq.ventanas.GestorVentanas;
import es.deusto.spq.restaurante.Mensaje;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
    private static GestorVentanas gestorVentanas;
	


	public static void main(String[] args) {


		List<Mensaje> mensajes = new ArrayList<>();

		mensajes.add(new Mensaje("Pedido de comida", "Hola, quiero hacer un pedido de comida para dos personas", LocalDate.now()));
		mensajes.add(new Mensaje("Reserva para mañana", "Hola, quisiera hacer una reserva para mañana a las 8pm", LocalDate.now()));
		mensajes.add(new Mensaje("Queja sobre el servicio", "Buenos días, quiero presentar una queja sobre el servicio que recibí ayer en su restaurante", LocalDate.now()));
		mensajes.add(new Mensaje("Sugerencia de menú", "Hola, quisiera hacer una sugerencia para agregar un plato nuevo al menú", LocalDate.now()));
		mensajes.add(new Mensaje("Solicitud de información", "Buenas tardes, quisiera solicitar información sobre los precios del menú del día", LocalDate.now()));
	
		
		gestorVentanas = new GestorVentanas(mensajes);
		gestorVentanas.getVentanaPrincipal().setVisible(true);
	}
	public static GestorVentanas getGestorVentanas() {
		return gestorVentanas;
	}
}
