package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalTime;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ReservaTest {

    private Reserva reserva;
    private User user;

    @Before
    public void setUp() {
        user = new User("username", "password");
        reserva = new Reserva(new Date(), LocalTime.of(20, 0), 2, false, "especificacion", 0, user);
    }

    @Test
    public void testGetHora() {
        assertNotNull(reserva.getHora());
        assertEquals(LocalTime.of(20, 0), reserva.getHora());
    }

    @Test
    public void testSetHora() {
        reserva.setHora(LocalTime.of(21, 0));
        assertEquals(LocalTime.of(21, 0), reserva.getHora());
    }

    @Test
    public void testGetFecha() {
        assertNotNull(reserva.getFecha());
    }

    @Test
    public void testSetFecha() {
        Date fecha = new Date();
        reserva.setFecha(fecha);
        assertEquals(fecha, reserva.getFecha());
    }

    @Test
    public void testGetNumPersonas() {
        assertEquals(2, reserva.getNumPersonas());
    }

    @Test
    public void testSetNumPersonas() {
        reserva.setNumPersonas(3);
        assertEquals(3, reserva.getNumPersonas());
    }

    @Test
    public void testGetCancelada() {
        assertEquals(false, reserva.getCancelada());
    }

    @Test
    public void testSetCancelada() {
        reserva.setCancelada(true);
        assertEquals(true, reserva.getCancelada());
    }

    @Test
    public void testGetUser() {
        assertNotNull(reserva.getUser());
        assertEquals(user, reserva.getUser());
    }

    @Test
    public void testSetUser() {
        User newUser = new User("newusername", "newpassword");
        reserva.setUser(newUser);
        assertEquals(newUser, reserva.getUser());
    }

    @Test
    public void testGetId() {
        assertEquals(0, reserva.getId());
    }

    @Test
    public void testSetId() {
        reserva.setId(1);
        assertEquals(1, reserva.getId());
    }

    @Test
    public void testGetEspecificacion() {
        assertNotNull(reserva.getEspecificacion());
        assertEquals("especificacion", reserva.getEspecificacion());
    }

    @Test
    public void testSetEspecificacion() {
        reserva.setEspecificacion("nueva especificacion");
        assertEquals("nueva especificacion", reserva.getEspecificacion());
    }
}
