package es.deusto.spq.server.jdo;
import java.util.Date;

import javax.jdo.annotations.*;


@PersistenceCapable(detachable="true")
public class Nota {

    @Persistent   
    private String asunto;

    @Persistent
    private String contenido;
    
    @Persistent
    private Date fecha;
    
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    private Long IDNota;

    public Nota(String asunto, String contenido, Date fecha, Long IDNota) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.IDNota = IDNota;
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
}
