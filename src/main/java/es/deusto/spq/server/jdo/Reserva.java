package es.deusto.spq.server.jdo;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class Reserva {

    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT) /*Se indica que el valor de la clave primaria se generará de forma automática incrementando el valor de la clave primaria de la última entidad creada*/
    private long id;
    
    @Persistent
    private Date fecha;
    
    @Persistent
    private LocalTime hora;
    
    @Persistent
    private int numPersonas;
    
    @Persistent
    private boolean cancelada;

    @Persistent
    private String especificacion;

    @ForeignKey
    @Persistent
    private User user;

    public Reserva(Date fecha, LocalTime hora, int numPersonas, boolean cancelada, String especificacion, User user){
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.cancelada = cancelada;
        this.user = user;
        this.especificacion = especificacion;
    }

    public Reserva(){
        
    }
    
    public void actualizarReserva(Reserva reserva) {
        this.setFecha(reserva.getFecha());
        this.setHora(reserva.getHora());
        this.setNumPersonas(reserva.getNumPersonas());
        this.setCancelada(reserva.getCancelada());
        this.setUser(reserva.getUser());
    }
    
    public LocalTime getHora() {
        return hora;
    }
    
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }
    
    public int getNumPersonas() {
        return numPersonas;
    }
    
    public boolean getCancelada() {
        return cancelada;
    }
    
    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }
    
}



