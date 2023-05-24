package es.deusto.spq.server.jdo;

import static org.junit.Assert.*;

import java.util.Date;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MessageTest {

	@Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));
	private Message message;
	
	@Before
	public void setUp() throws Exception {
		message = new Message("Asunto del mensaje", "Contenido del mensaje", new Date());
	}

	@Test
   // @JUnitPerfTest(threads = 10, durationMs = 2000)
	public void testGettersAndSetters() {
		message.setAsunto("Nuevo asunto");
		assertEquals("Nuevo asunto", message.getAsunto());
		
		message.setContenido("Nuevo contenido");
		assertEquals("Nuevo contenido", message.getContenido());
		
		Date nuevaFecha = new Date();
		message.setFecha(nuevaFecha);
		assertEquals(nuevaFecha, message.getFecha());
		
		User user = new User();
		message.setUser(user);
		assertEquals(user, message.getUser());
		
		Long timestamp = 123456789L;
		message.setTimestamp(timestamp);
		assertEquals(timestamp, message.getTimestamp());
	}

	@Test
	public void testToString() {
		assertEquals("Message: message --> Contenido del mensaje, timestamp -->  " + new Date(message.getTimestamp()), message.toString());
	}
}
