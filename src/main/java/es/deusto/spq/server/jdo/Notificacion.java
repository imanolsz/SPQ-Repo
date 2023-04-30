package es.deusto.spq.server.jdo;
import java.util.Date;

import javax.jdo.annotations.*;


@PersistenceCapable(detachable="true")
public class Notificacion {

    @Persistent   
    private String asunto;

    @Persistent
    private String contenido;
    
    @Persistent
    private Date fecha;
    
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    private Long IDNotificacion;

    public Notificacion(String asunto, String contenido, Date fecha, Long IDNotificacion) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getIDNotificacion() {
        return IDNotificacion;
    }

    public void setIDNotificacion(Long IDNotificacion) {
        this.IDNotificacion = IDNotificacion;
    }






}
