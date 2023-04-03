package es.deusto.spq.client.gui;

public class GestorVentanas {
	
	VentanaInicio VentanaInicioSesion;
	VentanaPrincipal VentanaPrincipal;
	VentanaRegistro VentanaRegistro;
	VentanaMenu VentanaMenu;
	VentanaBuzon VentanaBuzon;
	VentanaConfirmacion VentanaConfirmacion;
	VentanaModificar VentanaModificar;
	VentanaReserva ventanaReserva;
	VentanaConsultaReserva ventanaConsultaReserva;
	
	public GestorVentanas() {
		VentanaPrincipal = new VentanaPrincipal();
		VentanaInicioSesion = new VentanaInicio();
		VentanaRegistro = new VentanaRegistro();
		VentanaMenu = new VentanaMenu();
		VentanaConfirmacion = new VentanaConfirmacion();
		VentanaModificar= new VentanaModificar();
		ventanaReserva = new VentanaReserva();
		ventanaConsultaReserva = new VentanaConsultaReserva();
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

	public VentanaConfirmacion getVentanaConfirmacion() {
		return VentanaConfirmacion;
	}

	public VentanaModificar getVentanaModificar(){
		return VentanaModificar;
	}

	public VentanaReserva getVentanaReserva(){
		return ventanaReserva;
	}

	public VentanaConsultaReserva getVentanaConsultaReserva(){
		return ventanaConsultaReserva;
	}
}
