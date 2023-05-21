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

    // Constructor
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
    // Metodo para enviar notificacion al cliente sobre el limite de tiempo de la reserva
    public void enviarNotificacionLimiteTiempo(Reserva reserva) {
        // Obtener la duración máxima de la reserva
        int duracionMaximaMinutos = Reserva.getTiempoLimiteMinutos();

        // Generar el contenido de la notificación
        String contenido = "Su reserva tiene una duración máxima de " + duracionMaximaMinutos + " minutos. " +
                "Si desea ampliarla, por favor póngase en contacto con el restaurante.";

        // Crear una nueva instancia de la notificación
        Notificacion notificacion = new Notificacion("Límite de tiempo de reserva", contenido, new Date(), null);

        // Enviar la notificación al cliente
        enviarNotificacionCliente(notificacion, reserva.getUser().getEmail());
    }
    // Metodo para enviar notificacion al cliente
    private void enviarNotificacionCliente(Notificacion notificacion, String email) {
        // Aquí iría el código para enviar la notificación al cliente por correo electrónico o cualquier otro medio
        System.out.println("Notificación enviada al cliente: " + email);
        System.out.println("Asunto: " + notificacion.getAsunto());
        System.out.println("Contenido: " + notificacion.getContenido());
        System.out.println("Fecha: " + notificacion.getFecha());
    }
}
