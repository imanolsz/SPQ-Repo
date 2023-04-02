package es.deusto.spq.server.jdo;
import java.time.LocalDate;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.annotations.*;
import javax.jdo.Transaction;

@PersistenceCapable(detachable="true")
public class Notificacion {

    @Persistent   
    private String asunto;

    @Persistent
    private String contenido;
    
    @Persistent
    private LocalDate fecha;
    
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    private int IDNotificacion;

    public Notificacion(String asunto, String contenido, LocalDate fecha, int IDNotificacion) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.IDNotificacion = IDNotificacion;
    }


    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getIDNotificacion() {
        return IDNotificacion;
    }

    public void setIDNotificacion(Integer IDNotificacion) {
        this.IDNotificacion = IDNotificacion;
    }



    public static void guardarNotificacionBD(Notificacion notificacion) {
        // insert to notification a test notification
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        
        try {
            tx.begin();
            pm.makePersistent(notificacion);
            tx.commit();
        } catch (Exception ex) {
            System.out.println(" $ Error storing an object: " + ex.getMessage());
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
    }


}
