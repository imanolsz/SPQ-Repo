package es.deusto.spq.server;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
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

        resource = new Resource();
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

    // Implementa pruebas similares para los demás métodos en la clase Resource.
    // Recuerda que estas pruebas son muy básicas y pueden necesitar más
    // funcionalidades como mockear más métodos/objetos, comprobar si se
    // llaman ciertos métodos, etc.
}