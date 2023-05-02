package es.deusto.spq.server;

import org.junit.*;

import es.deusto.spq.pojo.ReservaData;
import es.deusto.spq.server.jdo.Reserva;

import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class ResourceTest {

	// @BeforeClass
	// public static void setUpClass() throws Exception {
	// 	// Code executed before the first test method
	// }

	// private Resource r1;
	// private Resource r2;

	// @Before
	// public void setUp() throws Exception{
	// 	r1 = new Resource();
	// 	r2 = new Resource();
	// }

	@Test
	public void sayMessage() {
		assertEquals(5,5);
	}
	@Test
	public void registerUser() {
		
	}
	@Test
	public void loginUser() {

	}
	@Test
	public void logout(){
		
	}

	@Test
	public void realizarReserva(){
	}

	@Test
	public void realizarNotificacion() {

	}

	@Test
	public void getNotifications() {

	}
	@Test
	public void sayHello() {

	}
	
	// @Test
    // public void getReservas() {
    //     // Crear una instancia de la clase que contiene el método getReservas
    //     Resource reservasResource = new Resource();

    //     // Llamar al método getReservas y almacenar la respuesta
    //     Response response = reservasResource.getReservas();

    //     // Verificar si la respuesta es correcta (HTTP 200 OK)
    //     assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

    //     // Verificar si el contenido de la respuesta es el esperado (lista de reservas)
    //     List<Reserva> reservas = (List<Reserva>) response.getEntity();
    //     assertNotNull(reservas);
    //     // Aquí se pueden agregar más verificaciones para los datos de las reservas si en un futuro se consideras necesario
    // }


	@Test
    public void hayMesaLibre() { 
		
    }

	@Test
	public void hayMesaLibrebool() {

	}


	@Test
	public void actualizarReserva(){

	}

	@Test
    public void cancelarReserva() {

	}
	@After
	public void tearDown() throws Exception {
		// Code executed after each test
	}
	@AfterClass
	public static void tearDownClass() throws Exception {
		// Code executed after the last test method
	}
}
