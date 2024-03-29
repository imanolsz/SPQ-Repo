package es.deusto.spq.pojo;

import java.util.Date;

import javax.jdo.*;

public class NotificacionData {
    // ATRIBUTOS
    private String asunto;
    private String contenido;
    private Date fecha;
    private Long IDNotificacion;
    // CONSTRUCTOR
    public NotificacionData(String asunto, String contenido, Date fecha, Long IDNotificacion) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.IDNotificacion = IDNotificacion;
    }
    // CONSTRUCTOR vacio
    public NotificacionData() {
        this.asunto = "";
        this.contenido = "";
        this.fecha = null;
        this.IDNotificacion = null;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getIDNotificacion() {
        return IDNotificacion;
    }

    public void setIDNotificacion(Long IDNotificacionData) {
        this.IDNotificacion = IDNotificacionData;
    }
    // Agrega los getters y setters correspondientes
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
            System.err.println("Error almacenando el objeto: " + ex.getMessage());
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            pm.close();
        }
    }
}
