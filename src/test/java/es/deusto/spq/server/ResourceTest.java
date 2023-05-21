package es.deusto.spq.server;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

import com.mysql.cj.Query;

import es.deusto.spq.pojo.DirectMessage;
import es.deusto.spq.pojo.MessageData;
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
    
        resource = new Resource(pm);  // Pasamos el PersistenceManager simulado a la instancia de Resource
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


    // This is a basic test that ensures the constructor sets up the PersistenceManager correctly.
    @Test
    public void testConstructorWithPm() {
        Resource resourceWithPm = new Resource(pm);
        assertNotNull(resourceWithPm);
    }
    
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

        User user = new User();
        user.setLogin(ud.getId());
        user.setPassword(ud.getPassword());

        Query query = Mockito.mock(Query.class);
        Mockito.when(pm.newQuery(anyString())).thenReturn(query);
        Mockito.when(query.execute()).thenReturn(user);
        
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
        Mockito.when(pm.newQuery(anyString())).thenReturn(query);
        Mockito.when(query.execute()).thenReturn(null);
        
        Response response = resource.sayMessage(dm);

        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }
    */
}