package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import org.junit.Rule;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import org.junit.Before;
import org.junit.Test;

public class RestauranteTest {

    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

    private Restaurante restaurante;
    private Date fechaApertura;
    private Date fechaCierre;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private int capacidadTotal;

    @Before
    public void setUp() throws Exception {
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.HOUR_OF_DAY, 12);
        calendario.set(Calendar.MINUTE, 0);
        calendario.set(Calendar.SECOND, 0);
        fechaApertura = calendario.getTime();
        calendario.set(Calendar.HOUR_OF_DAY, 22);
        fechaCierre = calendario.getTime();
        horaApertura = LocalTime.of(12, 0);
        horaCierre = LocalTime.of(22, 0);
        capacidadTotal = 50;
        restaurante = new Restaurante(fechaApertura, fechaCierre, horaApertura, horaCierre, capacidadTotal);
    }

    /*
    @Test
    public void testEstaAbierto() {
        // fecha y hora dentro del horario de apertura
        LocalDate fecha = LocalDate.of(2023, 5, 1);
        LocalTime hora = LocalTime.of(13, 0);
        assertTrue(restaurante.estaAbierto(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant()), hora));

    //     // fecha y hora fuera del horario de apertura
    //     hora = LocalTime.of(11, 0);
    //     assertFalse(restaurante.estaAbierto(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant()), hora));

    //     // fecha fuera del rango de apertura
    //     fecha = LocalDate.of(2023, 4, 1);
    //     hora = LocalTime.of(13, 0);
    //     assertFalse(restaurante.estaAbierto(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant()), hora));

        // fecha y hora en día de cierre
        fecha = LocalDate.of(2023, 5, 2);
        hora = LocalTime.of(13, 0);
        assertFalse(restaurante.estaAbierto(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant()), hora));
    }
    */

    /* 
    @Test
    public void testEstaLleno() {
        assertFalse(restaurante.estaLleno());
        restaurante.setNumReservas(2);
        restaurante.setCapacidadTotal(2);
        assertTrue(restaurante.estaLleno());
        restaurante.setCapacidadTotal(5);
        assertFalse(restaurante.estaLleno());
    }
    */

    /* 
    @Test
    public void testGettersAndSetters() {
        Date fechaAperturaTest = new Date(2022, 4, 1);
        restaurante.setFechaApertura(fechaAperturaTest);
        assertEquals(fechaAperturaTest, restaurante.getFechaApertura());
        
    //     Date fechaCierreTest = new Date(2023, 4, 30);
    //     restaurante.setFechaCierre(fechaCierreTest);
    //     assertEquals(fechaCierreTest, restaurante.getFechaCierre());
        
    //     LocalTime horaAperturaTest = LocalTime.of(9, 0);
    //     assertEquals(horaAperturaTest, restaurante.getHoraApertura());
        
    //     LocalTime horaCierreTest = LocalTime.of(21, 0);
    //     assertEquals(horaCierreTest, restaurante.getHoraCierre());
        
        int capacidadTotalTest = 100;
        restaurante.setCapacidadTotal(capacidadTotalTest);
        assertEquals(capacidadTotalTest, restaurante.getCapacidadTotal());
    }
    */

    @Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testToString() {
        String expected = "Restaurante [fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", horaApertura=" + horaApertura
                + ", horaCierre=" + horaCierre + ", capacidadTotal=" + capacidadTotal + "]";
        assertEquals(expected, restaurante.toString());
    }

}