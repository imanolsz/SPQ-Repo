package es.deusto.spq.server.jdo;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class DetallePedido {

    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    private long id;

    @Persistent
    private String comida;

    @Persistent
    private int cantidad;

    @ForeignKey
    @Persistent
    private Pedido pedido;

    public DetallePedido(String comida, int cantidad, Pedido pedido) {
        this.comida = comida;
        this.cantidad = cantidad;
        this.pedido = pedido;
    }

    
}
