package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import org.junit.Before;
import org.junit.Test;

public class ReservaDataTest {
    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

    private ReservaData reserva;

    @Before
    public void setUp() {
        UserData user = new UserData();
        PedidoData pedidoData = new PedidoData(new ArrayList<DetallePedidoData>( ));
        reserva = new ReservaData(new Date(), LocalTime.now(), 2, false, "especificacion",pedidoData, 0, user);
    }

    @Test
   // @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetSetId() {
        long id = 1234L;
        reserva.setId(id);
        assertEquals(id, reserva.getId());
    }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetSetFecha() {
        Date fecha = new Date();
        reserva.setFecha(fecha);
        assertEquals(fecha, reserva.getFecha());
    }

    @Test
   // @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetSetHora() {
        LocalTime hora = LocalTime.now();
        reserva.setHora(hora);
        assertEquals(hora, reserva.getHora());
    }

    @Test
   // @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetSetNumPersonas() {
        int numPersonas = 3;
        reserva.setNumPersonas(numPersonas);
        assertEquals(numPersonas, reserva.getNumPersonas());
    }

    @Test
   // @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetSetCancelada() {
        boolean cancelada = true;
        reserva.setCancelada(cancelada);
        assertTrue(reserva.isCancelada());
    }

    @Test
   // @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetSetUser() {
        UserData user = new UserData();
        reserva.setUser(user);
        assertEquals(user, reserva.getUser());
    }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetSetEspecificacion() {
        String especificacion = "especificacion2";
        reserva.setEspecificacion(especificacion);
        assertEquals(especificacion, reserva.getEspecificacion());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testConstructor() {
        assertNotNull(reserva);
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testEmptyConstructor() {
        ReservaData emptyReserva = new ReservaData();
        assertNotNull(emptyReserva);
        assertNull(emptyReserva.getFecha());
        assertNull(emptyReserva.getHora());
        assertEquals(0, emptyReserva.getNumPersonas());
        assertNull(emptyReserva.getUser());
        assertEquals(emptyReserva.getEspecificacion(), "");
    }
}
