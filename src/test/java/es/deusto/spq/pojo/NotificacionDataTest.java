package es.deusto.spq.pojo;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class NotificacionDataTest {

    @Test
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

    @Test
    public void testGuardarNotificacionDataBD() {
        NotificacionData notificacionData = new NotificacionData("asunto", "contenido", new Date(), 1L);
        NotificacionData.guardarNotificacionDataBD(notificacionData);
        // TODO: comprobar que la notificación se ha guardado correctamente en la base de datos
    }

}
