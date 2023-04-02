package es.deusto.spq.pojo;

import java.sql.Time;
import java.time.LocalDate;

public class ReservaData {
    
    private long id;
    private LocalDate fecha;
    private Time hora;
    private int numPersonas;
    private boolean cancelada;
    private String username;
    
    public ReservaData() {
        // Requerido por la serialización (Para poder ser almacenada en un archivo o enviada a través de una red)
    }
    
    public ReservaData(LocalDate fecha, Time hora, int numPersonas, boolean cancelada, String username) {
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.cancelada = cancelada;
        this.username = username;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public Time getHora() {
        return hora;
    }
    
    public void setHora(Time hora) {
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
    
    public String getusername() {
        return username;
    }
    
    public void setusername(String username) {
        this.username = username;
    }

    public boolean getCancelada() {
        return false;
    }
}
