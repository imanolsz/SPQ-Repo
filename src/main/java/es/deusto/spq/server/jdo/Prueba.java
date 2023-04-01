import javax.jdo.annotations.*;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import java.util.List;
import java.util.Date;

@PersistenceCapable(identityType = IdentityType.APPLICATION, table = "Reservas")
public class Administrador {
    
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    
    @Persistent(column = "nombre")
    private String nombre;
    
    @Persistent(column = "fecha")
    private Date fecha;
    
    @Persistent(column = "hora")
    private String hora;
    
    @Persistent(column = "cantidad_personas")
    private int cantidadPersonas;
    
    @Persistent(column = "Cancelada")
    private boolean cancelada;
    
    public Administrador(String nombre, Date fecha, String hora, int cantidadPersonas, boolean cancelada) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.cantidadPersonas = cantidadPersonas;
        this.cancelada = cancelada;
    }
    
    // Constructor vacío necesario para JDO
    public Administrador() {}
    
    public static void obtenerReservas() {
        // Obtener el PersistenceManager
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("nombre_unidad_de_persistencia");
        PersistenceManager pm = pmf.getPersistenceManager();
        
        try {
            Query<Administrador> query = pm.newQuery(Administrador.class);
            List<Administrador> reservas = query.executeList();
            
            for (Administrador reserva : reservas) {
                if (reserva.cancelada) {
                    System.out.println("Reserva cancelada:");
                } else {
                    System.out.println("Reserva confirmada:");
                }
                
                System.out.println("ID: " + reserva.id);
                System.out.println("Nombre: " + reserva.nombre);
                System.out.println("Fecha: " + reserva.fecha);
                System.out.println("Hora: " + reserva.hora);
                System.out.println("Cantidad de personas: " + reserva.cantidadPersonas);
                System.out.println();
            }
        } finally {
            pm
        // Cerrar el PersistenceManager cuando terminamos de utilizarlo
        pm.close();
    }
}