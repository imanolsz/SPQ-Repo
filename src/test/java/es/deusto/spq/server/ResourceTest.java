package es.deusto.spq.server;

import org.junit.*;

import static org.junit.Assert.*;

public class ResourceTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
		// Code executed before the first test method
	}

	private Resource r1;
	private Resource r2;

	@Before
	public void setUp() throws Exception{
		r1 = new Resource();
		r2 = new Resource();
	}

	@Test
	public void sayMessage() {
		assertEquals(5,5);
	}
	@Test
	public void registerUser() {
		
	}
	@Test
	public void loginUser() {

	}
	@Test
	public void logout(){
		
	}

	@Test
	public void realizarReserva(){
	}
	@Test
	public void realizarNotificacion() {

	}

	@Test
	public void getNotifications() {

	}
	@Test
	public void sayHello() {

	}
	@Test
	public void getReservas() {

	}

<<<<<<< HEAD

	@POST
	@Path("/getNotifications")
	public Response getNotifications(User userParam) {
		List<Notificacion> notifications = new ArrayList<>();
	
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
	
		try {
			tx.begin();
	
			Query<Notificacion> query = pm.newQuery(Notificacion.class, "usuario == userParam");
			query.declareParameters(User.class.getName() + " userParam");
	
			
			notifications.add((Notificacion)query.execute(userParam));
	
			
	
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error retrieving notifications: " + ex.getMessage());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	
		return Response.ok(notifications).build();
	}
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello() {
		return Response.ok("Hello world!").build();
	}

	@GET
	@Path("/admin/getReservas")
	public Response getReservas() {
		try { 
			tx.begin(); // Comienza una transacción para realizar operaciones en la base de datos.
			List<Reserva> reservas = new ArrayList<>();
			Query<Reserva> query = pm.newQuery(Reserva.class); // Crea una instancia de una consulta
			query.setFilter("cancelada == true || cancelada == false"); // Filtro para la consulta, devolverá todas las reservas, tanto canceladas como no canceladas
			query.setOrdering("fecha desc, hora asc"); // Orden de la consulta, Las reservas se ordenan primero por fecha y luego por hora
			reservas = query.executeList(); // Ejecuta una consulta en la base de datos y devuelve los resultados en forma de una lista de objetos
			tx.commit(); // Confirma la transacción.
			return Response.ok(reservas).build(); // Retorna una respuesta HTTP 200 (OK) con la lista de reservas como cuerpo de la respuesta.
		} catch (Exception e) {
			logger.error("Error en el método getReservas: ", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build(); // Retorna una respuesta HTTP 500 (Internal Server Error) si se produce una excepción.
		} finally { // Bloque finally se ejecuta siempre, independientemente de si se produce una excepción o no.
			if (tx.isActive()) { // Si la transacción está activa (si no se realizo el tx.commit), hace un rollback de la transacción.
				tx.rollback(); // Operación que revierte una transacción y deshace todos los cambios realizados en la base de datos desde el inicio de la misma
			}
		}
	}


	 @GET
	 @Path("/admin/getReservasFiltradas")
	 public Response getReservasFiltradas(Date fecha, Time hora) {
	 	try { 
	 		tx.begin(); // Comienza una transacción para realizar operaciones en la base de datos.
	 		List<Reserva> reservas = new ArrayList<>();
	 		Query<Reserva> query = pm.newQuery(Reserva.class); // Crea una instancia de una consulta
	 		query.setFilter("cancelada == true || cancelada == false"); // Filtro para la consulta, devolverá todas las reservas, tanto canceladas como no canceladas
	 		query.setOrdering("fecha desc, hora asc"); // Orden de la consulta, Las reservas se ordenan primero por fecha y luego por hora
	 		reservas = query.executeList(); // Ejecuta una consulta en la base de datos y devuelve los resultados en forma de una lista de objetos
	 		List<Reserva> reservasFiltradas = new ArrayList<>();
	 		for (Reserva reserva : reservas) {
	 			if (reserva.getFecha().equals(fecha) && reserva.getHora().equals(hora)) {
	 				reservasFiltradas.add(reserva);
	 			}
	 		}
	 		tx.commit(); // Confirma la transacción.
	 		return Response.ok(reservasFiltradas).build(); // Retorna una respuesta HTTP 200 (OK) con la lista de reservas como cuerpo de la respuesta.
	 	} catch (Exception e) {
	 		logger.error("Error en el método getReservas: ", e);
	 		return Response.status(Status.INTERNAL_SERVER_ERROR).build(); // Retorna una respuesta HTTP 500 (Internal Server Error) si se produce una excepción.
	 	} finally { // Bloque finally se ejecuta siempre, independientemente de si se produce una excepción o no.
	 		if (tx.isActive()) { // Si la transacción está activa (si no se realizo el tx.commit), hace un rollback de la transacción.
	 			tx.rollback(); // Operación que revierte una transacción y deshace todos los cambios realizados en la base de datos desde el inicio de la misma
	 		}
	 	}
	 }


	@GET
    @Path("/hayMesaLibre")
    @Produces(MediaType.APPLICATION_JSON) //  Anotación que indica que el método produce una respuesta en formato JSON.
    public Response hayMesaLibre(@QueryParam("fecha") Date fecha, @QueryParam("hora") Time hora, @QueryParam("numPersonas") int numPersonas) { // Acepta tres parámetros de consulta HTTP: fecha, hora y numPersonas.
        boolean mesaLibre = hayMesaLibrebool(fecha, hora, numPersonas);
        return Response.ok().entity(mesaLibre).build(); // Se construye y se devuelve la respuesta HTTP completa, con un código de estado "200 OK". En este caso, la respuesta es un booleano mesaLibre en formato JSON.
=======
	@Test
    public void hayMesaLibre() { 
>>>>>>> 53d1fc54a9226cac8536fe768cb20e5f59adeade
		
    }

	@Test
	public void hayMesaLibrebool() {

	}


	@Test
	public void actualizarReserva(){

	}

	@Test
    public void cancelarReserva() {

	}
	@After
	public void tearDown() throws Exception {
		// Code executed after each test
	}
	@AfterClass
	public static void tearDownClass() throws Exception {
		// Code executed after the last test method
	}
}
