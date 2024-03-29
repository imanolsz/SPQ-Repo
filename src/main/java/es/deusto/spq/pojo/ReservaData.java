package es.deusto.spq.pojo;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalTime;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservaData {
    // Atributos
    @JsonProperty("id")
    private long id;
    @JsonProperty("fecha")
    private Date fecha;
    @JsonProperty("hora")
    private LocalTime hora;
    @JsonProperty("numPersonas")
    private int numPersonas;
    @JsonProperty("cancelada")
    private boolean cancelada;
    @JsonProperty("user")
    private UserData user;
    @JsonProperty("especificacion")
    private String especificacion;
    @JsonProperty("aparcamiento")
    private int aparcamiento;
    @JsonProperty("pedido")
    private PedidoData pedido;
    // CONSTRUCTOR
    public ReservaData() {
        // Requerido por la serialización (Para poder ser almacenada en un archivo o enviada a través de una red)
        this.id = 0;
        this.fecha = null;
        this.hora = null;
        this.numPersonas = 0;
        this.cancelada = false;
        this.user = null;
        this.especificacion = "";
        this.aparcamiento = 0;
        this.pedido = null;
    }
    // CONSTRUCTOR
    public ReservaData(Date fecha, LocalTime hora, int numPersonas, boolean cancelada, String especificacion, PedidoData pedido, int aparcamiento, UserData user) {
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.cancelada = cancelada;
        this.user = user;
        this.especificacion = especificacion;
        this.aparcamiento = aparcamiento;
        this.pedido = pedido;
    }
    // CONSTRUCTOR
    public ReservaData(Date fecha, LocalTime hora, int numPersonas, boolean cancelada, String especificacion, UserData user) {
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

    public int getAparcamiento() {
        return aparcamiento;
    }

    public void setAparcamiento(int aparcamiento) {
        this.aparcamiento = aparcamiento;
    }

    public PedidoData getPedido() {
        return pedido;
    }

    public void setPedido(PedidoData pedido) {
        this.pedido = pedido;
    }

    public boolean getCancelada() {
        return false;
    }
    @Override
    public String toString() {
        return "ReservaData{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", numPersonas=" + numPersonas +
                ", cancelada=" + cancelada +
                ", user=" + user +
                ", especificacion='" + especificacion + '\'' +
                '}';
    }
}
