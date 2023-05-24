package es.deusto.spq.pojo;
import org.junit.Rule;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import org.junit.Before;
import org.junit.Test;

public class UserDataTest {
    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

    private UserData userData;

    @Before
    public void setUp() throws Exception {
        userData = new UserData();
    }

    @Test
   // @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetId() {
        userData.setId("test");
        assertEquals("test", userData.getId());
    }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetId() {
        userData.setId("test");
        assertEquals("test", userData.getId());
    }

    @Test
   // @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetPassword() {
        userData.setPassword("password");
        assertEquals("password", userData.getPassword());
    }

    @Test
  //  @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetPassword() {
        userData.setPassword("password");
        assertEquals("password", userData.getPassword());
    }

    @Test
  //  @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testToString() {
        userData.setId("test");
        userData.setPassword("password");
        assertEquals("[id=test, password=password]", userData.toString());
    }

    @Test
  //  @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testIsAdmin() {
        assertFalse(userData.isAdmin());
        userData.setAdmin(true);
        assertTrue(userData.isAdmin());
    }

    @Test
  //  @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetAdmin() {
        assertFalse(userData.isAdmin());
        userData.setAdmin(true);
        assertTrue(userData.isAdmin());
    }
}
