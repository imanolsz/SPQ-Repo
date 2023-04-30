package es.deusto.spq.pojo;

import java.util.Date;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class NotaData {
    
    private String asunto;
    private String contenido;
    private Date fecha;
    private Long IDNota;

    public NotaData(String asunto, String contenido, Date fecha, Long IDNota) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.IDNota = IDNota;
    }

    public NotaData(){
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
