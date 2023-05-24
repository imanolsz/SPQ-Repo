package es.deusto.spq.client;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

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

    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

	@BeforeClass
	public static void setUpClass() throws Exception {
		// Code executed before the first test method
	}
	@Before
	public void setUp() throws Exception {
		// Code executed before each test
	}
	@Test
    @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void getReservas() {
        // Crear objetos mock para simular el comportamiento de las clases involucradas

        //El primer objeto mock se llama "mockWebTarget" y es de la clase "WebTarget". La clase WebTarget es parte de la librería Jersey. Este objeto se está creando para simular una petición a un servicio web.
        WebTarget mockWebTarget = mock(WebTarget.class);
       
       //El segundo objeto mock se llama "mockGetReservasWebTarget" y también es de la clase "WebTarget". Este objeto es una simulación de la respuesta a la petición que se hizo en el objeto anterior.
        WebTarget mockGetReservasWebTarget = mock(WebTarget.class);
        
        //El tercer objeto mock se llama "mockInvocationBuilder" y es de la clase "Invocation.Builder". Esta clase representa una petición que se va a hacer a un servicio web.
        Invocation.Builder mockInvocationBuilder = mock(Invocation.Builder.class);
        
        //El cuarto objeto mock se llama "mockResponse" y es de la clase "Response". Esta clase representa la respuesta que se recibe después de hacer una petición a un servicio web.
        Response mockResponse = mock(Response.class);

        // Crear una instancia de la clase que contiene el método getReservas
        ExampleClient clienteReservas = new ExampleClient("127.0.0.1","8080 ");
        
        //Se está asignando el objeto "mockWebTarget" a una propiedad de la instancia de "ExampleClient". Esto se hace para que la instancia de "ExampleClient" utilice el objeto mock en lugar de la clase real "WebTarget".
        clienteReservas.webTarget = mockWebTarget; // Reemplazar el webTarget real con el objeto mock

        // Configurar los objetos mock para simular el comportamiento esperado
        when(mockWebTarget.path("admin/getReservas")).thenReturn(mockGetReservasWebTarget);
        //cuando se llame al método "request" del objeto "mockGetReservasWebTarget" con el argumento "MediaType.APPLICATION_JSON", entonces se debe retornar el objeto "mockInvocationBuilder". Esto es para simular que se está haciendo una petición con un contenido tipo JSON.
        when(mockGetReservasWebTarget.request(MediaType.APPLICATION_JSON)).thenReturn(mockInvocationBuilder);
        //cuando se llame al método "get" del objeto "mockInvocationBuilder", entonces se debe retornar el objeto "mockResponse". Esto es para simular que se ha recibido una respuesta.
        when(mockInvocationBuilder.get()).thenReturn(mockResponse);
        //cuando se llame al método "getStatus" del objeto "mockResponse", entonces se debe retornar el código de estado "200". Esto es para simular que la respuesta ha sido exitosa.
        when(mockResponse.getStatus()).thenReturn(Response.Status.OK.getStatusCode());

        // Crear una lista de reservas simulada para devolver como resultado del método readEntity
        // El método "readEntity" se utiliza para leer la respuesta del servidor como una entidad de un tipo de objeto específico en la aplicación cliente.
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

