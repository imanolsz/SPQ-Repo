package es.deusto.spq.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetallePedidoData {

    @JsonProperty("alimento")
    private String alimento;
    @JsonProperty("cantidad")
    private int cantidad;

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
