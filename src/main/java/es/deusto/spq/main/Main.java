package es.deusto.spq.main;

import es.deusto.spq.ventanas.GestorVentanas;

public class Main {
    private static GestorVentanas gestorVentanas;
	
	public static void main(String[] args) {
		
		gestorVentanas = new GestorVentanas();
		gestorVentanas.getVentanaPrincipal().setVisible(true);
	}
	public static GestorVentanas getGestorVentanas() {
		return gestorVentanas;
	}
}
