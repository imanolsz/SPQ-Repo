package es.deusto.spq.restaurante;

import java.time.LocalDate;

public class Mensaje {
    private String asunto;
    private String contenido;
    private LocalDate fecha;

    public Mensaje(String asunto, String contenido, LocalDate fecha) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
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
}
