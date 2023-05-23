package es.deusto.spq.server;
/* 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

import es.deusto.spq.main.Main;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.jdo.User;

public class ResourcePerfTest {

    private static final PersistenceManagerFactory pmf = Mockito.mock(PersistenceManagerFactory.class);
    private Resource resource;
    private PersistenceManager pm;
    private Transaction tx;
    private WebTarget target;

    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

    @BeforeClass
    public static void prepareTests() throws Exception {
        Mockito.when(pmf.getPersistenceManager()).thenReturn(Mockito.mock(PersistenceManager.class));
    }

    @Before
    public void setup() {
        pm = pmf.getPersistenceManager();
        tx = Mockito.mock(Transaction.class);

        Mockito.when(pm.currentTransaction()).thenReturn(tx);

        resource = new Resource(pm);
        Resource.serverState = new HashMap<>(); // Reinicia serverState antes de cada prueba

        // create the client
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI).path("resource");
    }

    @AfterClass
    public static void tearDown() {
        pmf.close();
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSayHelloPerf() {
        Response response = target.path("hello").request().get();
        assertEquals(200, response.getStatus());
        assertEquals("Hello world!", response.readEntity(String.class));
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testRegisterUserPerf() {
        UserData userData = new UserData();
        userData.setId("testUser");
        userData.setPassword("testPass");

        Mockito.when(pm.getObjectById(User.class, userData.getId()))
                .thenThrow(new javax.jdo.JDOObjectNotFoundException());
        Mockito.when(tx.isActive()).thenReturn(true);

        Response response = resource.registerUser(userData);
        assertEquals(200, response.getStatus());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testConstructorWithPmPerf() {
        Resource resourceWithPm = new Resource(pm);
        assertNotNull(resourceWithPm);
    }
}

*/
