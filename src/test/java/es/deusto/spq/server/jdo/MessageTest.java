package es.deusto.spq.server.jdo;

import java.time.LocalDate;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class MessageTest {
    private String asunto;
    private String contenido;
    private LocalDate fecha;
    User user=null;
    String text = null;
	long timestamp;

    public MessageTest(String asunto, String contenido, LocalDate fecha) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public MessageTest(String text) {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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