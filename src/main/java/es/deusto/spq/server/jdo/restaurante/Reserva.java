package es.deusto.spq.server.jdo.restaurante;

import java.sql.*;
import java.time.LocalDate;

public class Reserva {
    private LocalDate fecha;
    private Time hora;
    private int numPersonas;
    private int key;
    private boolean cancelada;

    public Reserva(LocalDate fecha, Time hora, int numPersonas, int key, boolean cancelada){
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.key = key;
        this.cancelada = cancelada;
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

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public boolean getCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }
    
}



