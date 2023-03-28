package es.deusto.spq.restaurante;

import java.sql.*;
import java.time.LocalDate;

public class Reserva {
    private LocalDate fecha;
    private Time hora;
    private int numPersonas;

    public Reserva(LocalDate fecha, Time hora, int numPersonas){
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
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

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }
    
}
