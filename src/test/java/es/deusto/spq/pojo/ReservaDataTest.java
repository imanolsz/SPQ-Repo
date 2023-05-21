package es.deusto.spq.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ReservaDataTest {

    private ReservaData reserva;

    @Before
    public void setUp() {
        UserData user = new UserData();
        PedidoData pedidoData = new PedidoData(new ArrayList<DetallePedidoData>( ));
        reserva = new ReservaData(new Date(), LocalTime.now(), 2, false, "especificacion",pedidoData, 0, user);
    }

    @Test
    public void testGetSetId() {
        long id = 1234L;
        reserva.setId(id);
        assertEquals(id, reserva.getId());
    }

    @Test
    public void testGetSetFecha() {
        Date fecha = new Date();
        reserva.setFecha(fecha);
        assertEquals(fecha, reserva.getFecha());
    }

    @Test
    public void testGetSetHora() {
        LocalTime hora = LocalTime.now();
        reserva.setHora(hora);
        assertEquals(hora, reserva.getHora());
    }

    @Test
    public void testGetSetNumPersonas() {
        int numPersonas = 3;
        reserva.setNumPersonas(numPersonas);
        assertEquals(numPersonas, reserva.getNumPersonas());
    }

    @Test
    public void testGetSetCancelada() {
        boolean cancelada = true;
        reserva.setCancelada(cancelada);
        assertTrue(reserva.isCancelada());
    }

    @Test
    public void testGetSetUser() {
        UserData user = new UserData();
        reserva.setUser(user);
        assertEquals(user, reserva.getUser());
    }

    @Test
    public void testGetSetEspecificacion() {
        String especificacion = "especificacion2";
        reserva.setEspecificacion(especificacion);
        assertEquals(especificacion, reserva.getEspecificacion());
    }

    @Test
    public void testConstructor() {
        assertNotNull(reserva);
    }

    @Test
    public void testEmptyConstructor() {
        ReservaData emptyReserva = new ReservaData();
        assertNotNull(emptyReserva);
        assertNull(emptyReserva.getFecha());
        assertNull(emptyReserva.getHora());
        assertEquals(0, emptyReserva.getNumPersonas());
        assertNull(emptyReserva.getUser());
        assertEquals(emptyReserva.getEspecificacion(), "");
    }
}
