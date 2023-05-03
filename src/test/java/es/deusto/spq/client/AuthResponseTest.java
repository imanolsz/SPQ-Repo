package es.deusto.spq.client;

import org.junit.Test;
import static org.junit.Assert.*;

public class AuthResponseTest {

    @Test
    public void testEmptyConstructor() {
        AuthResponse authResponse = new AuthResponse();
        assertNotNull(authResponse);
    }
    
    @Test
    public void testGetToken() {
        AuthResponse authResponse = new AuthResponse("testToken", true);
        String expectedToken = "testToken";
        String actualToken = authResponse.getToken();
        assertEquals(expectedToken, actualToken);
    }

    @Test
    public void testSetToken() {
        AuthResponse authResponse = new AuthResponse("testToken", true);
        String expectedToken = "newTestToken";
        authResponse.setToken("newTestToken");
        String actualToken = authResponse.getToken();
        assertEquals(expectedToken, actualToken);
    }

    @Test
    public void testIsAdmin() {
        AuthResponse authResponse = new AuthResponse("testToken", true);
        assertTrue(authResponse.isAdmin());
    }

    @Test
    public void testSetAdmin() {
        AuthResponse authResponse = new AuthResponse("testToken", true);
        authResponse.setAdmin(false);
        assertFalse(authResponse.isAdmin());
    }
}
