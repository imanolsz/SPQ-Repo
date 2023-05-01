package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class NotaDataTest {

    @Test
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

    @Test
    public void testGuardarNotaDataBD() {
        NotaData notaData = new NotaData("asunto", "contenido", new Date(), 1L);
        NotaData.guardarNotaDataBD(notaData);
        // TODO: comprobar que la nota se ha guardado correctamente en la base de datos
    }

}
