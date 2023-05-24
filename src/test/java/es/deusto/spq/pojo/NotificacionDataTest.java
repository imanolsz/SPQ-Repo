package es.deusto.spq.pojo;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;
import org.junit.Rule;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

public class NotificacionDataTest {
    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testConstructorAndGetters() {
        String asunto = "asunto";
        String contenido = "contenido";
        Date fecha = new Date();
        Long idNotificacion = 1L;
        NotificacionData notificacionData = new NotificacionData(asunto, contenido, fecha, idNotificacion);
        assertEquals(asunto, notificacionData.getAsunto());
        assertEquals(contenido, notificacionData.getContenido());
        assertEquals(fecha, notificacionData.getFecha());
        assertEquals(idNotificacion, notificacionData.getIDNotificacion());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetters() {
        NotificacionData notificacionData = new NotificacionData();
        String asunto = "asunto";
        String contenido = "contenido";
        Date fecha = new Date();
        Long idNotificacion = 1L;
        notificacionData.setAsunto(asunto);
        notificacionData.setContenido(contenido);
        notificacionData.setFecha(fecha);
        notificacionData.setIDNotificacion(idNotificacion);
        assertEquals(asunto, notificacionData.getAsunto());
        assertEquals(contenido, notificacionData.getContenido());
        assertEquals(fecha, notificacionData.getFecha());
        assertEquals(idNotificacion, notificacionData.getIDNotificacion());
    }

    // @Test
    // public void testGuardarNotificacionDataBD() {
    //     NotificacionData notificacionData = new NotificacionData("asunto", "contenido", new Date(), 1L);
    //     NotificacionData.guardarNotificacionDataBD(notificacionData);
    //     // TODO: comprobar que la notificación se ha guardado correctamente en la base de datos
    // }

}
