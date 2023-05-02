package es.deusto.spq.client;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.junit.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import javax.ws.rs.core.MediaType;

import es.deusto.spq.pojo.ReservaData;
import es.deusto.spq.pojo.UserData;
public class ExampleClientTest {
	@BeforeClass
	public static void setUpClass() throws Exception {
		// Code executed before the first test method
	}
	@Before
	public void setUp() throws Exception {
		// Code executed before each test
	}
	@Test
    public void getReservas() {
        // Crear objetos mock para simular el comportamiento de las clases involucradas
        WebTarget mockWebTarget = mock(WebTarget.class);
        WebTarget mockGetReservasWebTarget = mock(WebTarget.class);
        Invocation.Builder mockInvocationBuilder = mock(Invocation.Builder.class);
        Response mockResponse = mock(Response.class);

        // Crear una instancia de la clase que contiene el método getReservas
        ExampleClient clienteReservas = new ExampleClient("127.0.0.1","8080 ");
        clienteReservas.webTarget = mockWebTarget; // Reemplazar el webTarget real con el objeto mock

        // Configurar los objetos mock para simular el comportamiento esperado
        when(mockWebTarget.path("admin/getReservas")).thenReturn(mockGetReservasWebTarget);
        when(mockGetReservasWebTarget.request(MediaType.APPLICATION_JSON)).thenReturn(mockInvocationBuilder);
        when(mockInvocationBuilder.get()).thenReturn(mockResponse);
        when(mockResponse.getStatus()).thenReturn(Response.Status.OK.getStatusCode());

        // Crear una lista de reservas simulada para devolver como resultado del método readEntity
        List<ReservaData> reservasSimuladas = new ArrayList<>();

		Date fecha = Date.valueOf("2022-05-10");
		LocalTime hora = LocalTime.parse("13:00");
		UserData usuario = new UserData("usuario1", "password1", true);
		ReservaData reservaSimulada = new ReservaData(fecha, hora, 4, false, "", usuario);
		reservasSimuladas.add(reservaSimulada);
        // Agregar más reservas a la lista si fuera necesario

        when(mockResponse.readEntity(new GenericType<List<ReservaData>>() {})).thenReturn(reservasSimuladas);

        // Llamar al método getReservas y almacenar la respuesta
        List<ReservaData> reservas = clienteReservas.getReservas();

        // Verificar si la respuesta es la esperada (lista de reservas)
        assertNotNull(reservas);
        assertEquals(reservasSimuladas, reservas);
        // Aquí se pueden agregar más verificaciones para los datos si fuera necesario
    }
}

