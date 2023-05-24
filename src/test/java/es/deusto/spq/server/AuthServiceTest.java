package es.deusto.spq.server;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;


public class AuthServiceTest {
    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetToken() {
        AuthService authService = new AuthService("testToken", true);
        String expectedToken = "testToken";
        String actualToken = authService.getToken();
        assertEquals(expectedToken, actualToken);
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetToken() {
        AuthService authService = new AuthService("testToken", true);
        String expectedToken = "newTestToken";
        authService.setToken("newTestToken");
        String actualToken = authService.getToken();
        assertEquals(expectedToken, actualToken);
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testIsAdmin() {
        AuthService authService = new AuthService("testToken", true);
        assertTrue(authService.isAdmin());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetAdmin() {
        AuthService authService = new AuthService("testToken", true);
        authService.setAdmin(false);
        assertFalse(authService.isAdmin());
    }
}

