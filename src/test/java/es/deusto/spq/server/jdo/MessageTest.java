package es.deusto.spq.server.jdo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class MessageTest {

	private Message message;
	
	@Before
	public void setUp() throws Exception {
		message = new Message("Asunto del mensaje", "Contenido del mensaje", new Date());
	}

	@Test
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
