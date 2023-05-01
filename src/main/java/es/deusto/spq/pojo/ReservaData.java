package es.deusto.spq.pojo;


import java.time.LocalTime;
import java.util.Date;

public class ReservaData {
    
    private long id;
    private Date fecha;
    private LocalTime hora;
    private int numPersonas;
    private boolean cancelada;
    private UserData user;
    private String especificacion;
    
    public ReservaData() {
        // Requerido por la serialización (Para poder ser almacenada en un archivo o enviada a través de una red)
    }
    
    public ReservaData(Date fecha, LocalTime hora, int numPersonas, boolean cancelada, String especificacion,UserData user) {
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.cancelada = cancelada;
        this.user = user;
        this.especificacion = especificacion;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public LocalTime getHora() {
        return hora;
    }
    
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    public int getNumPersonas() {
        return numPersonas;
    }
    
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }
    
    public boolean isCancelada() {
        return cancelada;
    }
    
    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }
    
    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }
    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }
    public boolean getCancelada() {
        return false;
    }
}
