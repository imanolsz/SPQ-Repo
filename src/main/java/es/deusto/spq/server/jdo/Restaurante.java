package es.deusto.spq.server.jdo;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalTime;

public class Restaurante {
    private Date fechaApertura;
    private Date fechaCierre;
    private final LocalTime horaApertura;
    private final LocalTime horaCierre;
    private int capacidadTotal; // numero de personas que entran en el restaurante
    private int numReservas = 0; // numero de personas que han reservado

    //Constructor
    public Restaurante(Date fechaApertura, Date fechaCierre, LocalTime horaApertura, LocalTime horaCierre, int capacidadTotal) {
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.capacidadTotal = capacidadTotal;
    }

    public boolean estaAbierto(Date fecha, LocalTime hora) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            return false;
        }
        if (hora.isBefore(horaApertura) || hora.isAfter(horaCierre)) {
            return false;
        }
        return !fecha.before(fechaApertura) && !fecha.after(fechaCierre);
    }
    
    
    
    //Se podría cambiar este criterio:
    /*En principio vamos a creer que si en una última reserva hay 4 personas
    y tan solo queda 1 persona para llenar el restaurante. Se aceptarían las 4 y el restaurante
    se llenaría con 3 personas más de su capacidad.*/
    public boolean estaLleno(){
        if (this.numReservas >= this.capacidadTotal)
            return true;
        return false;
    }
    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    @Override
    public String toString() {
        return "Restaurante [fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", horaApertura="
                + horaApertura + ", horaCierre=" + horaCierre + ", capacidadTotal=" + capacidadTotal + "]";
    }
    
}

