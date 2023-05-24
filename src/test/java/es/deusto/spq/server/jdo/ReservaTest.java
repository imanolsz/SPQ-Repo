package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import java.time.LocalTime;
import java.util.Date;
import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;

public class ReservaTest {
    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

    private Reserva reserva;
    private User user;

    @Before
    public void setUp() {
        user = new User("username", "password");
        reserva = new Reserva(new Date(), LocalTime.of(20, 0), 2, false, "especificacion", 0, user);
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetHora() {
        assertNotNull(reserva.getHora());
        assertEquals(LocalTime.of(20, 0), reserva.getHora());
    }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetHora() {
        reserva.setHora(LocalTime.of(21, 0));
        assertEquals(LocalTime.of(21, 0), reserva.getHora());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetFecha() {
        assertNotNull(reserva.getFecha());
    }

    @Test
   // @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetFecha() {
        Date fecha = new Date();
        reserva.setFecha(fecha);
        assertEquals(fecha, reserva.getFecha());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetNumPersonas() {
        assertEquals(2, reserva.getNumPersonas());
    }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetNumPersonas() {
        reserva.setNumPersonas(3);
        assertEquals(3, reserva.getNumPersonas());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetCancelada() {
        assertEquals(false, reserva.getCancelada());
    }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetCancelada() {
        reserva.setCancelada(true);
        assertEquals(true, reserva.getCancelada());
    }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetUser() {
        assertNotNull(reserva.getUser());
        assertEquals(user, reserva.getUser());
    }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetUser() {
        User newUser = new User("newusername", "newpassword");
        reserva.setUser(newUser);
        assertEquals(newUser, reserva.getUser());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetId() {
        assertEquals(0, reserva.getId());
    }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetId() {
        reserva.setId(1);
        assertEquals(1, reserva.getId());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetEspecificacion() {
        assertNotNull(reserva.getEspecificacion());
        assertEquals("especificacion", reserva.getEspecificacion());
    }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetEspecificacion() {
        reserva.setEspecificacion("nueva especificacion");
        assertEquals("nueva especificacion", reserva.getEspecificacion());
    }
}
