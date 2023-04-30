package es.deusto.spq.client.gui;

import es.deusto.spq.pojo.UserData;

public class GestorVentanas {
	
	VentanaInicio VentanaInicioSesion;
	VentanaPrincipal VentanaPrincipal;
	VentanaRegistro VentanaRegistro;
	VentanaMenu VentanaMenu;
	VentanaBuzon VentanaBuzon;
	VentanaConfirmacion VentanaConfirmacion;
	VentanaModificar VentanaModificar;
	VentanaReserva ventanaReserva;
	VentanaContacto ventanaContacto;
	VentanaConsultaReserva ventanaConsultaReserva;
	
	public GestorVentanas() {
		VentanaPrincipal = new VentanaPrincipal();
		ventanaContacto = new VentanaContacto();
		VentanaInicioSesion = new VentanaInicio();
		VentanaRegistro = new VentanaRegistro();
		VentanaMenu = new VentanaMenu();
		VentanaConfirmacion = new VentanaConfirmacion();
		VentanaModificar= new VentanaModificar();
		ventanaReserva = new VentanaReserva();
		ventanaConsultaReserva = new VentanaConsultaReserva();
		UserData user = new UserData();
		VentanaBuzon = new VentanaBuzon(user);
	}
	
	public VentanaPrincipal getVentanaPrincipal() {
		return VentanaPrincipal;
	}

	public VentanaContacto getVentanaContacto() {
		return ventanaContacto;
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
