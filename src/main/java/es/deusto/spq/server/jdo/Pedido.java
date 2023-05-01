package es.deusto.spq.server.jdo;

import java.util.List;
import java.util.Map;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class Pedido {

    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT) /*Se indica que el valor de la clave primaria se generará de forma automática incrementando el valor de la clave primaria de la última entidad creada*/
    private long id;

    @Persistent
    private List<DetallePedido> listaAlimentos;

    @ForeignKey
    @Persistent
    private Reserva reserva;

    public Pedido(List<DetallePedido> listaAlimentos, Reserva reserva){
        this.listaAlimentos = listaAlimentos;
        this.reserva = reserva;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<DetallePedido>  getlistaAlimentos() {
        return listaAlimentos;
    }

    public void setMapaComidaCantidad(List<DetallePedido> listaAlimentoss) {
        this.listaAlimentos = listaAlimentoss ;
    }

}
