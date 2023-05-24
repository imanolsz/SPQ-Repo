package es.deusto.spq.client;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

public class AuthResponseTest {

    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testEmptyConstructor() {
        AuthResponse authResponse = new AuthResponse();
        assertNotNull(authResponse);
    }
    
    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetToken() {
        AuthResponse authResponse = new AuthResponse("testToken", true);
        String expectedToken = "testToken";
        String actualToken = authResponse.getToken();
        assertEquals(expectedToken, actualToken);
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetToken() {
        AuthResponse authResponse = new AuthResponse("testToken", true);
        String expectedToken = "newTestToken";
        authResponse.setToken("newTestToken");
        String actualToken = authResponse.getToken();
        assertEquals(expectedToken, actualToken);
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testIsAdmin() {
        AuthResponse authResponse = new AuthResponse("testToken", true);
        assertTrue(authResponse.isAdmin());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetAdmin() {
        AuthResponse authResponse = new AuthResponse("testToken", true);
        authResponse.setAdmin(false);
        assertFalse(authResponse.isAdmin());
    }
}
