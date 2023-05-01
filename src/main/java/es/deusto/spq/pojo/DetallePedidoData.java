package es.deusto.spq.pojo;

public class DetallePedidoData {

    private String alimento;
    private int cantidad;
    private long pedidoId;

    public DetallePedidoData() {
        // Requerido por la serialización (para poder ser almacenada en un archivo o enviada a través de una red)
    }

    public DetallePedidoData(String alimento, int cantidad) {
        this.alimento = alimento;
        this.cantidad = cantidad;
        
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
}
