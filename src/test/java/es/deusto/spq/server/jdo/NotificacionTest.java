package es.deusto.spq.server.jdo;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class NotificacionTest {
    private Notificacion notificacion;

    @Test
    public void testGetSetAsunto() {
        notificacion = new Notificacion("asunto", "contenido", new Date(), 1L);
        notificacion.setAsunto("asunto_modificado");
        assertEquals("asunto_modificado", notificacion.getAsunto());
    }

    @Test
    public void testGetSetContenido() {
        notificacion = new Notificacion("asunto", "contenido", new Date(), 1L);
        notificacion.setContenido("contenido_modificado");
        assertEquals("contenido_modificado", notificacion.getContenido());
    }

    @Test
    public void testGetSetFecha() {
        Date fecha = new Date();
        notificacion = new Notificacion("asunto", "contenido", fecha, 1L);
        assertEquals(fecha, notificacion.getFecha());
    }

    @Test
    public void testGetSetIDNotificacion() {
        notificacion = new Notificacion("asunto", "contenido", new Date(), 1L);
        notificacion.setIDNotificacion(2L);
        assertEquals(Long.valueOf(2), notificacion.getIDNotificacion());
    }
}
