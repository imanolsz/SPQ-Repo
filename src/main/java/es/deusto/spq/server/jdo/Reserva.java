package es.deusto.spq.server.jdo;

import java.sql.Time;
import java.time.LocalDate;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class Reserva {

    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT) /*Se indica que el valor de la clave primaria se generará de forma automática incrementando el valor de la clave primaria de la última entidad creada*/
    private long id;
    
    @Persistent
    private LocalDate fecha;
    
    @Persistent
    private Time hora;
    
    @Persistent
    private int numPersonas;
    
    @Persistent
    private boolean cancelada;

    @ForeignKey
    @Persistent
    private User user;

    public Reserva(LocalDate fecha, Time hora, int numPersonas, boolean cancelada, User user){
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.cancelada = cancelada;
        this.user = user;
    }
    
    public Time getHora() {
        return hora;
    }
    
    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public LocalDate getFecha() {
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
    
}



