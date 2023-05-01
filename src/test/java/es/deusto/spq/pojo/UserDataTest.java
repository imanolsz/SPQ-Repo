package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class UserDataTest {

    private UserData userData;

    @Before
    public void setUp() throws Exception {
        userData = new UserData();
    }

    @Test
    public void testGetId() {
        userData.setId("test");
        assertEquals("test", userData.getId());
    }

    @Test
    public void testSetId() {
        userData.setId("test");
        assertEquals("test", userData.getId());
    }

    @Test
    public void testGetPassword() {
        userData.setPassword("password");
        assertEquals("password", userData.getPassword());
    }

    @Test
    public void testSetPassword() {
        userData.setPassword("password");
        assertEquals("password", userData.getPassword());
    }

    @Test
    public void testToString() {
        userData.setId("test");
        userData.setPassword("password");
        assertEquals("[id=test, password=password]", userData.toString());
    }

    @Test
    public void testIsAdmin() {
        assertFalse(userData.isAdmin());
        userData.setAdmin(true);
        assertTrue(userData.isAdmin());
    }

    @Test
    public void testSetAdmin() {
        assertFalse(userData.isAdmin());
        userData.setAdmin(true);
        assertTrue(userData.isAdmin());
    }
}
