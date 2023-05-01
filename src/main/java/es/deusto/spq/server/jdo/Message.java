package es.deusto.spq.server.jdo;

import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Message {
    private String asunto;
    private String contenido;
    private Date fecha;
    User user=null;
    String text = null;
	long timestamp;

    public Message(String asunto, String contenido, Date fecha) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public Message(String text) {
        this.text = text;
		this.timestamp = System.currentTimeMillis();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String toString() {
        return "Message: message --> " + this.contenido + ", timestamp -->  " + new Date(this.timestamp);
    }
}