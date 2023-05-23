package es.deusto.spq.server;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import org.mockito.Mockito;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.jdo.User;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.core.Response;

public class ResourceTest {
    private Resource resource;
    private PersistenceManagerFactory pmf;
    private PersistenceManager pm;
    private Transaction tx;
    
    @Before
    public void setup() {
        pmf = Mockito.mock(PersistenceManagerFactory.class);
        pm = Mockito.mock(PersistenceManager.class);
        tx = Mockito.mock(Transaction.class);
    
        Mockito.when(pmf.getPersistenceManager()).thenReturn(pm);
        Mockito.when(pm.currentTransaction()).thenReturn(tx);
    
        resource = new Resource(pm);
        Resource.serverState = new HashMap<>(); // Reinicia serverState antes de cada prueba
    }
    
    @Test
    public void testSayHello() {
        Response response = resource.sayHello();
        assertEquals(200, response.getStatus());
        assertEquals("Hello world!", response.getEntity());
    }
    
    @Test
    public void testRegisterUser() {
        UserData userData = new UserData();
        userData.setId("testUser");
        userData.setPassword("testPass");

        Mockito.when(pm.getObjectById(User.class, userData.getId())).thenThrow(new javax.jdo.JDOObjectNotFoundException());
        Mockito.when(tx.isActive()).thenReturn(true);

        Response response = resource.registerUser(userData);
        assertEquals(200, response.getStatus());
    }
    @Test
    public void testConstructorWithPm() {
        Resource resourceWithPm = new Resource(pm);
        assertNotNull(resourceWithPm);
    }

    /* 
    @Test
    public void testLoginUser() {
        UserData userData = new UserData();
        userData.setId("testUser");
        userData.setPassword("testPass");

        Mockito.when(pm.getObjectById(User.class, userData.getId())).thenThrow(new javax.jdo.JDOObjectNotFoundException());
        Mockito.when(tx.isActive()).thenReturn(true);

        Response response = resource.loginUser(userData);
        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }
    */

    
    /* 
    @Test
    public void testSayMessage() {
        DirectMessage dm = new DirectMessage();
        UserData ud = new UserData();
        ud.setId("testUser");
        ud.setPassword("testPass");
        dm.setUserData(ud);

        MessageData md = new MessageData();
        md.setMessage("test message");
        dm.setMessageData(md);

        UserData user = new UserData();
        user.setPassword(ud.getPassword());

        Query query = Mockito.mock(Query.class);
        Mockito.when(pm.newQuery(toString())).thenReturn((javax.jdo.Query) query);
        Mockito.when(((javax.jdo.Query) query).execute()).thenReturn(user);
        
        Response response = resource.sayMessage(dm);

        assertEquals(200, response.getStatus());
        assertEquals(md.getMessage(), ((MessageData)response.getEntity()).getMessage());
    }

    @Test
    public void testSayMessageWithInvalidUser() {
        DirectMessage dm = new DirectMessage();
        UserData ud = new UserData();
        ud.setId("testUser");
        ud.setPassword("testPass");
        dm.setUserData(ud);

        MessageData md = new MessageData();
        md.setMessage("test message");
        dm.setMessageData(md);

        Query query = Mockito.mock(Query.class);
        Mockito.when(pm.newQuery(toString())).thenReturn((javax.jdo.Query) query);
        Mockito.when(((javax.jdo.Query) query).execute()).thenReturn(null);
        
        Response response = resource.sayMessage(dm);

        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }
    */
    /*
    @Test
    public void testLogout() throws NullPointerException, RemoteException {
        // Prepare
        long token = 123L;
        User user = new User();
        Resource.serverState.put(token, user);
        
        // Execute
        Response response = resource.logout(token);
        
        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertFalse(Resource.serverState.containsKey(token));
    }
    */
    /* 
    @Test(expected = RemoteException.class)
    public void testLogoutNotLoggedIn() throws RemoteException {
        // Prepare
        long token = 123L;
        
        // This should throw a RemoteException because the user is not logged in
        resource.logout(token);
    }
    */

    /* 
    @Test
    public void testRealizarReserva() {

        Date currentDate = new Date(System.currentTimeMillis());
        LocalTime currentTime = LocalTime.now();

        long token = 123L;
        User user = new User();
        Resource.serverState.put(token, user);
        
        ReservaData reservaData = new ReservaData();
        reservaData.setFecha(currentDate);
        reservaData.setHora(currentTime);
        reservaData.setNumPersonas(4);
        reservaData.setCancelada(false);
        reservaData.setEspecificacion("Especificacion");
        reservaData.setAparcamiento(1);
        
        PedidoData pedidoData = new PedidoData(); // Create a new PedidoData
        List<DetallePedidoData> listaAlimentos = new ArrayList<>(); // Create a list for alimentos
        pedidoData.setListaAlimentos(listaAlimentos); // Assign the list to the pedidoData
        reservaData.setPedido(pedidoData); // Assign the pedidoData to the reservaData

        String authorizationHeader = "Bearer " + token;

        // Execute
        Response response = resource.realizarReserva(reservaData, authorizationHeader);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
    */

    /* 
    @Test
    public void testCancelarReserva() {
        // Prepare
        ReservaData reservaData = new ReservaData();
        reservaData.setFecha(new Date(0));  
        reservaData.setHora(LocalTime.parse("12:34:56"));
        reservaData.setNumPersonas(4);
        reservaData.setCancelada(false);

        UserData user = new UserData();
        user.setId("testUser");
        user.setPassword("testPass");
        reservaData.setUser(user);

        // Execute
        Response response = resource.cancelarReserva(reservaData);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        verify(tx).begin();
        verify(pm).deletePersistent(any());
        verify(tx).commit();
        verify(pm).close();
    }
    */
}