package es.deusto.spq.server.jdo;

// import static org.junit.Assert.*;

// import java.time.LocalTime;
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;

// import org.junit.Before;
// import org.junit.Test;

// import es.deusto.spq.pojo.PedidoData;

// import javax.jdo.PersistenceManager;
// import javax.jdo.PersistenceManagerFactory;
// import javax.jdo.JDOHelper;

public class PedidoTest {

    // private Pedido pedido;
    // private DetallePedido detallePedido1;
    // private DetallePedido detallePedido2;
    // private Reserva reserva;
    // private PersistenceManagerFactory pmf;
    // private PersistenceManager pm;

    
    // @Before
    // public void setUp() {
    //     // Creamos los objetos necesarios para la prueba
    //     detallePedido1 = new DetallePedido("Pizza", 3, null);
    //     detallePedido2 = new DetallePedido("Ensalada", 2, null);
    //     List<DetallePedido> listaAlimentos = new ArrayList<DetallePedido>();
    //     listaAlimentos.add(detallePedido1);
    //     listaAlimentos.add(detallePedido2);
        
    //     User user = new User("JohnDoe", "mypassword");
    //     Date fecha = new Date(1234567890000L); // 2009-02-14T00:31:30Z
    //     LocalTime hora = LocalTime.of(14, 30);
    //     int numPersonas = 3;
    //     boolean cancelada = false;
    //     String especificacion = null;
    //     int aparcamiento = 0;
    //     Reserva reserva = new Reserva(fecha, hora, numPersonas, cancelada, especificacion, aparcamiento, user);
        
    //     pedido = new Pedido(listaAlimentos, reserva);
        
    //     // Inicializamos el gestor de persistencia
    //     pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    //     pm = pmf.getPersistenceManager();
    // }

    // @Test
    // public void testGetId() {
    //     long id = 1;
    //     pedido.setId(id);
    //     assertEquals(id, pedido.getId());
    // }

    // @Test
    // public void testGetSetReserva() {
    //     User user = new User("Luis", "1234");
    //     Date fecha = new Date(1234567890000L); // 2009-02-14T00:31:30Z
    //     LocalTime hora = LocalTime.of(14, 30);
    //     int numPersonas = 5;
    //     boolean cancelada = false;
    //     String especificacion = null;
    //     int aparcamiento = 2;
    //     Reserva nuevaReserva = new Reserva(fecha, hora, numPersonas, cancelada, especificacion, aparcamiento, user);
    //     pedido.setReserva(nuevaReserva);
    //     assertEquals(nuevaReserva, pedido.getReserva());
    // }

    // @Test
    // public void testGetSetlistaAlimentos() {
    //     List<DetallePedido> nuevaLista = new ArrayList<DetallePedido>();
    //     nuevaLista.add(detallePedido1);
    //     nuevaLista.add(detallePedido2);
    //     nuevaLista.add(new DetallePedido("Hamburguesa", 2, null));
    //     pedido.setMapaComidaCantidad(nuevaLista);
    //     assertEquals(nuevaLista, pedido.getlistaAlimentos());
    // }

    /*Problema con el persitent ¿JDO? 
    @Test
    public void testGuardarPedido() {
        // Guardamos el objeto en la base de datos
        pm.currentTransaction().begin();
        pm.makePersistent(pedido);
        pm.currentTransaction().commit();

        // Obtenemos el objeto de la base de datos y verificamos que sus atributos coinciden con los que esperamos
        pm.currentTransaction().begin();
        Pedido pedidoDB = pm.getObjectById(Pedido.class, pedido.getId());
        assertEquals(pedido.getReserva(), pedidoDB.getReserva());
        assertEquals(pedido.getlistaAlimentos(), pedidoDB.getlistaAlimentos());
        pm.currentTransaction().commit();
    }

    */
}
