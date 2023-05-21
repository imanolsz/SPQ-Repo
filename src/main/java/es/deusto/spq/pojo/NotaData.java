package es.deusto.spq.pojo;

import java.util.Date;

import javax.jdo.*;
public class NotaData {
    // Atributos
    private String asunto;
    private String contenido;
    private Date fecha;
    private Long IDNota;
    // Constructor
    public NotaData(String asunto, String contenido, Date fecha, Long IDNota) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.IDNota = IDNota;
    }
    // Constructor vacio
    public NotaData() {
        this.asunto = "";
        this.contenido = "";
        this.fecha = null;
        this.IDNota = null;
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

    public Long getIDNota() {
        return IDNota;
    }

    public void setIDNota(Long IDNota) {
        this.IDNota = IDNota;
    }
    // Metodo para guardar la nota en la BD
    public static void guardarNotaDataBD(NotaData Notadata) {
        // insert to notification a test notification
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
    
        try {
            tx.begin();
            pm.makePersistent(Notadata);
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
