package es.deusto.spq.modelos;

import org.junit.*;
import org.junit.Rule;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.pojo.NotificacionData;

public class ModeloTablaNotificacionDataTest{

	@Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));
	
    private ModeloTablaNotificacionData modelo;
    private List<NotificacionData> notificaciones;

	@Before
	public void setUp() throws Exception {
		notificaciones = new ArrayList<>();
		notificaciones.add(new NotificacionData("Asunto 1", "Contenido 1", new Date(2021 - 1900, 0, 1), 1L));
		notificaciones.add(new NotificacionData("Asunto 2", "Contenido 2", new Date(2021 - 1900, 0, 1), 2L));
		notificaciones.add(new NotificacionData("Asunto 3", "Contenido 3", new Date(2021 - 1900, 0, 1), 3L));
		modelo = new ModeloTablaNotificacionData(notificaciones);
	}
	

    @Test
	//@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetRowCount() {
        assertEquals(3, modelo.getRowCount());
    }

    @Test
	//@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetColumnCount() {
        assertEquals(2, modelo.getColumnCount());
    }

    @Test
	//@JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetColumnName() {
        assertEquals("Asunto", modelo.getColumnName(0));
        assertEquals("Fecha", modelo.getColumnName(1));
    }

	@Test
	//@JUnitPerfTest(threads = 10, durationMs = 2000)
	public void testGetValueAt() {
		assertEquals("Asunto 1", modelo.getValueAt(0, 0));
		assertNotNull(modelo.getValueAt(0, 1)); // la fecha no debe ser nula
		assertEquals("Asunto 2", modelo.getValueAt(1, 0));
		assertNotNull(modelo.getValueAt(1, 1)); // la fecha no debe ser nula
		assertEquals("Asunto 3", modelo.getValueAt(2, 0));
		assertNotNull(modelo.getValueAt(2, 1)); // la fecha no debe ser nula
		assertNull(modelo.getValueAt(2, 2));    // la posición 2,2 debe ser nula
	}
	
}

