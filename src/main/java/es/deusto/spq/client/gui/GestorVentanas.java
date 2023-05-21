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
	VentanaContacto ventanaContacto;
	VentanaConsultaReserva ventanaConsultaReserva;
	VentanaMenuComida ventanaMenuComida;
	VentanaComidaPedido ventanaComidaPedido;
	VentanaAdministrador ventanaAdministrador;
	VentanaRealizarResena ventanaRealizarResena;
	VentanaHorario ventanaHorario;
	
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
		ventanaAdministrador = new VentanaAdministrador();
		//VentanaBuzon = new VentanaBuzon();
		ventanaMenuComida = new VentanaMenuComida();
		ventanaComidaPedido = new VentanaComidaPedido();
		ventanaRealizarResena = new VentanaRealizarResena();
		ventanaHorario = new VentanaHorario();
	}
	public VentanaRealizarResena getVentanaRealizarResena(){
		return ventanaRealizarResena;
	}
	public VentanaAdministrador getVentanaAdministrador() {
		return ventanaAdministrador;
	}

	public VentanaAdministrador setVentanaAdministrador() {
		return ventanaAdministrador;
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
		return (VentanaBuzon = new VentanaBuzon());
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

	public VentanaMenuComida getVentanaMenuComida(){
		return ventanaMenuComida;
	}

	public VentanaComidaPedido getVentanaComidaPedido(){
		return ventanaComidaPedido;
	}

	public VentanaInicio getVentanaInicioSesion() {
		return VentanaInicioSesion;
	}

	public VentanaHorario gVentanaHorario(){
		return ventanaHorario;
	}

	public void setVentanaInicioSesion(VentanaInicio ventanaInicioSesion) {
		VentanaInicioSesion = ventanaInicioSesion;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		VentanaPrincipal = ventanaPrincipal;
	}

	public void setVentanaRegistro(VentanaRegistro ventanaRegistro) {
		VentanaRegistro = ventanaRegistro;
	}

	public void setVentanaMenu(VentanaMenu ventanaMenu) {
		VentanaMenu = ventanaMenu;
	}

	public void setVentanaBuzon(VentanaBuzon ventanaBuzon) {
		VentanaBuzon = ventanaBuzon;
	}

	public void setVentanaConfirmacion(VentanaConfirmacion ventanaConfirmacion) {
		VentanaConfirmacion = ventanaConfirmacion;
	}

	public void setVentanaModificar(VentanaModificar ventanaModificar) {
		VentanaModificar = ventanaModificar;
	}

	public void setVentanaReserva(VentanaReserva ventanaReserva) {
		this.ventanaReserva = ventanaReserva;
	}

	public void setVentanaContacto(VentanaContacto ventanaContacto) {
		this.ventanaContacto = ventanaContacto;
	}

	public void setVentanaConsultaReserva(VentanaConsultaReserva ventanaConsultaReserva) {
		this.ventanaConsultaReserva = ventanaConsultaReserva;
	}

	public void setVentanaMenuComida(VentanaMenuComida ventanaMenuComida) {
		this.ventanaMenuComida = ventanaMenuComida;
	}

	public void setVentanaComidaPedido(VentanaComidaPedido ventanaComidaPedido) {
		this.ventanaComidaPedido = ventanaComidaPedido;
	}

	public void setVentanaAdministrador(VentanaAdministrador ventanaAdministrador) {
		this.ventanaAdministrador = ventanaAdministrador;
	}

	public void setVentanaHorario(VentanaHorario ventanaHorario) {
		this.ventanaHorario= ventanaHorario;
	}

}
