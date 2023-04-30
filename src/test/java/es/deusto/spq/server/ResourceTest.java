package es.deusto.spq.server;

import org.junit.*;

import static org.junit.Assert.*;

public class ResourceTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
		// Code executed before the first test method
	}

	private Resource r1;
	private Resource r2;

	@Before
	public void setUp() throws Exception{
		r1 = new Resource();
		r2 = new Resource();
	}

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
	@Test
	public void getReservas() {

	}

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
