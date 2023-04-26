package es.deusto.spq.pojo;
import java.time.LocalDate;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;


public class NotificacionDataTest {


    private String asunto;


    private String contenido;
    

    private LocalDate fecha;


    private int IDNotificacionData;

    public NotificacionDataTest(String asunto, String contenido, LocalDate fecha, int IDNotificacionData) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.IDNotificacionData = IDNotificacionData;
    }

    public NotificacionDataTest() {
        // required by serialization
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

    public Integer getIDNotificacionData() {
        return IDNotificacionData;
    }

    public void setIDNotificacionData(Integer IDNotificacionData) {
        this.IDNotificacionData = IDNotificacionData;
    }



    public static void guardarNotificacionDataBD(NotificacionData notificaciondata) {
        // insert to notification a test notification
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        
        try {
            tx.begin();
            pm.makePersistent(notificaciondata);
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
