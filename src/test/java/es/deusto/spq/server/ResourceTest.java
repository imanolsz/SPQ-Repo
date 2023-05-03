package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import static org.hamcrest.CoreMatchers.not;

import javax.jdo.Query;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;
import javax.ws.rs.core.Response;
import static org.mockito.ArgumentMatchers.eq;

import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import static org.junit.Assert.fail;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.jdo.Reserva;
import es.deusto.spq.server.jdo.User;

@RunWith(MockitoJUnitRunner.class)
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



    // @InjectMocks
    // private Resource loginService;

    // @Mock
    // private org.apache.logging.log4j.Logger logger;

    // @Mock
    // private PersistenceManager pm;

    // @Mock
    // private Transaction tx;

    // @Mock
    // private HashMap<Long, User> serverState;

    // @Before
    // public void setUp() {
    //     when(pm.getObjectById(eq(User.class), anyString())).thenAnswer(invocation -> {
    //         String id = invocation.getArgument(1);
    //         if ("testId".equals(id)) {
    //             return new User("testId", "testPassword");
    //         } else {
    //             throw new javax.jdo.JDOObjectNotFoundException();
    //         }
    //     });
    //     when(tx.isActive()).thenReturn(true);
    // }
    
    
    /*
    @Test
    public void testLoginUser_validUser_success() {
        User user1 = new User("testId", "testPassword", false);
        when(pm.getObjectById(User.class, user1.getId())).thenReturn(user1);
        UserData userData1 = new UserData(user1.getId(), user1.getPassword(), false);
        Response response1 = loginService.loginUser(userData1);
        assertEquals(Response.Status.OK.getStatusCode(), response1.getStatus());
    }
     */

    // @Test
    // public void testLoginUser_invalidPassword_unauthorized() {
    //     User user2 = new User("testId", "testPassword");
    //     when(pm.getObjectById(User.class, user2.getId())).thenReturn(user2);
    //     UserData userData2 = new UserData(user2.getId(), "wrongPassword", false);
    //     Response response2 = loginService.loginUser(userData2);
    //     assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response2.getStatus());
    // }

    // @Test
    // public void testLoginUser_invalidUser_unauthorized() {
    //     UserData userData3 = new UserData("invalidId", "testPassword", false);
    //     Response response3 = loginService.loginUser(userData3);
    //     assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response3.getStatus());
    // }

    /* 
    @Test
    public void testLoginUser_error_internalServerError() {
        User user1 = new User("testId", "testPassword");
        UserData userData4 = new UserData(user1.getId(), user1.getPassword(), false);
    
        try {
            Response response4 = loginService.loginUser(userData4);
            fail("Expected an RuntimeException to be thrown");
        } catch (RuntimeException e) {
            // If the exception is caught, the test passes.
        }
    }
    */
    
    // @Test
	// public void sayMessage() {
	// 	assertEquals(5,5);
	// }
	// @Test
	// public void registerUser() {
		
	// }
    
	// @Test
	// public void logout(){
		
	// }

	// @Test
	// public void realizarReserva(){
	// }

	// @Test
	// public void realizarNotificacion() {

	// }

	// @Test
	// public void getNotifications() {

	// }
	// @Test
	// public void sayHello() {

	// }
	
	//  @Test
    //  public void getReservas() {
    //      // Crear una instancia de la clase que contiene el método getReservas
    //      Resource reservasResource = new Resource();

    //      // Llamar al método getReservas y almacenar la respuesta
    //      Response response = reservasResource.getReservas();

    //      // Verificar si la respuesta es correcta (HTTP 200 OK)
    //      assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

    //      // Verificar si el contenido de la respuesta es el esperado (lista de reservas)
    //      List<Reserva> reservas = (List<Reserva>) response.getEntity();
    //      assertNotNull(reservas);
    //      // Aquí se pueden agregar más verificaciones para los datos de las reservas si en un futuro se consideras necesario
    //  }


	// @Test
    // public void hayMesaLibre() { 
		
    // }

	// @Test
	// public void hayMesaLibrebool() {

	// }


	// @Test
	// public void actualizarReserva(){

	// }

	// @Test
    // public void cancelarReserva() {

	// }
	// @After
	// public void tearDown() throws Exception {
	// 	// Code executed after each test
	// }
	// @AfterClass
	// public static void tearDownClass() throws Exception {
	// 	// Code executed after the last test method
	// }
}
