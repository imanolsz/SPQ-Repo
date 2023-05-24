package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import org.junit.Test;
import org.junit.Rule;

public class NotaTest {

    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

    @Test
    public void testConstructorAndGetters() {
        String asunto = "asunto";
        String contenido = "contenido";
        Date fecha = new Date();
        Long idNota = 1L;
        Nota nota = new Nota(asunto, contenido, fecha, idNota);
        assertEquals(asunto, nota.getAsunto());
        assertEquals(contenido, nota.getContenido());
        assertEquals(fecha, nota.getFecha());
        assertEquals(idNota, nota.getIDNota());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetters() {
        Nota nota = new Nota("", "", new Date(), 0L);
        String asunto = "asunto";
        String contenido = "contenido";
        Date fecha = new Date();
        Long idNota = 1L;
        nota.setAsunto(asunto);
        nota.setContenido(contenido);
        nota.setFecha(fecha);
        nota.setIDNota(idNota);
        assertEquals(asunto, nota.getAsunto());
        assertEquals(contenido, nota.getContenido());
        assertEquals(fecha, nota.getFecha());
        assertEquals(idNota, nota.getIDNota());
    }

}
