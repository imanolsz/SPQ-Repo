package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import java.util.Date;
import org.junit.Rule;

import org.junit.Test;

public class NotaDataTest {
    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testConstructorAndGetters() {
        String asunto = "asunto";
        String contenido = "contenido";
        Date fecha = new Date();
        Long idNota = 1L;
        NotaData notaData = new NotaData(asunto, contenido, fecha, idNota);
        assertEquals(asunto, notaData.getAsunto());
        assertEquals(contenido, notaData.getContenido());
        assertEquals(fecha, notaData.getFecha());
        assertEquals(idNota, notaData.getIDNota());
    }

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testSetters() {
        NotaData notaData = new NotaData();
        String asunto = "asunto";
        String contenido = "contenido";
        Date fecha = new Date();
        Long idNota = 1L;
        notaData.setAsunto(asunto);
        notaData.setContenido(contenido);
        notaData.setFecha(fecha);
        notaData.setIDNota(idNota);
        assertEquals(asunto, notaData.getAsunto());
        assertEquals(contenido, notaData.getContenido());
        assertEquals(fecha, notaData.getFecha());
        assertEquals(idNota, notaData.getIDNota());
    }

    // @Test
    // public void testGuardarNotaDataBD() {
    //     NotaData notaData = new NotaData("asunto", "contenido", new Date(), 1L);
    //     NotaData.guardarNotaDataBD(notaData);
    //     // TODO: comprobar que la nota se ha guardado correctamente en la base de datos
    // }

}
