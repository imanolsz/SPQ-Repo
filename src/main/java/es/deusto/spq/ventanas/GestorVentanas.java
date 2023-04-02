package es.deusto.spq.ventanas;

public class GestorVentanas {
	
	VentanaInicio VentanaInicioSesion;
	VentanaPrincipal VentanaPrincipal;
	VentanaRegistro VentanaRegistro;
	VentanaMenu VentanaMenu;
	VentanaBuzon VentanaBuzon;
	
	public GestorVentanas() {
		VentanaPrincipal = new VentanaPrincipal();
		VentanaInicioSesion = new VentanaInicio();
		VentanaRegistro = new VentanaRegistro();
		VentanaMenu = new VentanaMenu();
		//VentanaBuzon = new VentanaBuzon(notificaciones);
	}
	
	public VentanaPrincipal getVentanaPrincipal() {
		return VentanaPrincipal;
	}

	public VentanaInicio getVentanaInicio() {
		return VentanaInicioSesion;
	}
	
	public VentanaRegistro getVentanaRegistro() {
		return VentanaRegistro;
	}
	
	public VentanaMenu getVentanaMenu() {
		return VentanaMenu;
	}
	public VentanaBuzon getVentanaBuzon() {
		return VentanaBuzon;
	}
}
