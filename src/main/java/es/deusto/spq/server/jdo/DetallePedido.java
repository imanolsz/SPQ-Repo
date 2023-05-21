package es.deusto.spq.server.jdo;

import javax.jdo.annotations.*;
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

    // Constructor
    public DetallePedido(String comida, int cantidad, Pedido pedido) {
        this.comida = comida;
        this.cantidad = cantidad;
        this.pedido = pedido;
    }
}
