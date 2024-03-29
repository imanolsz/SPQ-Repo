package es.deusto.spq.server.jdo;

import java.time.*;
import java.util.Date;
import java.util.Calendar;

import javax.jdo.annotations.*;

import es.deusto.spq.pojo.PedidoData;
/**
 * @brief Clase persistente reserva donde se define la reserva de un restaurante
 * 
 * @param fecha la fecha de la reserva
 * @param hora la hora en la que se ha pedido la reserva
 * @param numPersonas las personas que asistiran de esa reserva
 * @param cancelada indica si la reserva ha sido cancelada
 * @param especificacion detalles adicionales de la reserva
 * @param aparcamiento para indicar cuantas plazas necesitan en el parking del restaurante
 * @param pedido los datos del pedido de lo que van a comer en el dia de la reserva
 * @param user el usuario que realiza la reserva
 */
@PersistenceCapable(detachable="true")
public class Reserva {

    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT) /*Se indica que el valor de la clave primaria se generará de forma automática incrementando el valor de la clave primaria de la última entidad creada*/
    private long id;
    @Persistent
    private static final int TIEMPO_LIMITE_MINUTOS = 60; // Define el tiempo límite en minutos
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

    @Persistent
    private int aparcamiento;

    @Persistent
    private PedidoData pedido;

    @ForeignKey
    @Persistent
    private User user;

    public Reserva(Date fecha, LocalTime hora, int numPersonas, boolean cancelada, String especificacion, PedidoData pedido, int aparcamiento, User user){
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.cancelada = cancelada;
        this.user = user;
        this.pedido = pedido;
        this.especificacion = especificacion;
        this.aparcamiento = aparcamiento;
    }
    // Constructor
    public Reserva(Date fecha, LocalTime hora, int numPersonas, boolean cancelada, String especificacion, int aparcamiento, User user){
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.cancelada = cancelada;
        this.user = user;
        this.especificacion = especificacion;
        this.aparcamiento = aparcamiento;
    }
    // Constructor
    public Reserva(Date fecha, LocalTime hora, int numPersonas, boolean cancelada, String especificacion, User user){
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.cancelada = cancelada;
        this.user = user;
        this.especificacion = especificacion;
    }
    // Constructor vacio
    public Reserva(){
        this.fecha = null;
        this.hora = null;
        this.numPersonas = 0;
        this.cancelada = false;
        this.user = null;
        this.especificacion = null;
    }
    // Comprueba si la reserva ha excedido el tiempo límite
    public boolean haExcedidoTiempoLimite() {
        LocalDateTime horaActual = LocalDateTime.now();
        LocalDateTime horaLimite = LocalDateTime.of(convertirDateALocalDate(fecha), hora);

        // Calcula la duración entre la hora actual y la hora límite
        Duration duracion = Duration.between(horaLimite, horaActual);
        long minutosExcedidos = duracion.toMinutes();

        // Comprueba si se ha excedido el tiempo límite
        return minutosExcedidos > TIEMPO_LIMITE_MINUTOS;
    }
    // Convierte un objeto Date a un objeto LocalDate
    private static LocalDate convertirDateALocalDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Los meses en Calendar están indexados desde 0
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return LocalDate.of(year, month, day);
    }
    // Metodo para actualizar una reserva
    public void actualizarReserva(Reserva reserva) {
        this.setFecha(reserva.getFecha());
        this.setHora(reserva.getHora());
        this.setNumPersonas(reserva.getNumPersonas());
        this.setCancelada(reserva.getCancelada());
        this.setUser(reserva.getUser());
        this.setAparcamiento(reserva.getAparcamiento());
    }
    
    public LocalTime getHora() {
        return hora;
    }
    
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    public PedidoData getPedido() {
        return pedido;
    }

    public void setPedido(PedidoData pedido) {
        this.pedido = pedido;
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

    public int getAparcamiento() {
        return aparcamiento;
    }

    public void setAparcamiento(int aparcamiento) {
        this.aparcamiento = aparcamiento;
    }
    public static int getTiempoLimiteMinutos() {
        return TIEMPO_LIMITE_MINUTOS;
    }
}



