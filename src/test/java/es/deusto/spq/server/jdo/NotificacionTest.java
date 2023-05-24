package es.deusto.spq.server.jdo;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import java.util.Date;

public class NotificacionTest {

    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));
    private Notificacion notificacion;

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetSetAsunto() {
        notificacion = new Notificacion("asunto", "contenido", new Date(), 1L);
        notificacion.setAsunto("asunto_modificado");
        assertEquals("asunto_modificado", notificacion.getAsunto());
    }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetSetContenido() {
        notificacion = new Notificacion("asunto", "contenido", new Date(), 1L);
        notificacion.setContenido("contenido_modificado");
        assertEquals("contenido_modificado", notificacion.getContenido());
    }

    // @Test
    // @JUnitPerfTest(threads = 10, durationMs = 2000)
    // public void testGetSetFecha() {
    //     Date fecha = new Date();
    //     notificacion = new Notificacion("asunto", "contenido", fecha, 1L);
    //     assertEquals(fecha, notificacion.getFecha());
    // }

    @Test
    //@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetSetIDNotificacion() {
        notificacion = new Notificacion("asunto", "contenido", new Date(), 1L);
        notificacion.setIDNotificacion(2L);
        assertEquals(Long.valueOf(2), notificacion.getIDNotificacion());
    }
}
