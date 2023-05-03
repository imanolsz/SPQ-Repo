package es.deusto.spq.server;

import org.junit.Test;
import static org.junit.Assert.*;


public class AuthServiceTest {

    @Test
    public void testGetToken() {
        AuthService authService = new AuthService("testToken", true);
        String expectedToken = "testToken";
        String actualToken = authService.getToken();
        assertEquals(expectedToken, actualToken);
    }

    @Test
    public void testSetToken() {
        AuthService authService = new AuthService("testToken", true);
        String expectedToken = "newTestToken";
        authService.setToken("newTestToken");
        String actualToken = authService.getToken();
        assertEquals(expectedToken, actualToken);
    }

    @Test
    public void testIsAdmin() {
        AuthService authService = new AuthService("testToken", true);
        assertTrue(authService.isAdmin());
    }

    @Test
    public void testSetAdmin() {
        AuthService authService = new AuthService("testToken", true);
        authService.setAdmin(false);
        assertFalse(authService.isAdmin());
    }
}

