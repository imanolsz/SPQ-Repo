package es.deusto.spq.pojo;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoData {
    @JsonProperty("listaAlimentos")
    private List<DetallePedidoData> listaAlimentos;
    // CONSTRUCTOR
    public PedidoData() {
        this.listaAlimentos = null;
    }
    // CONSTRUCTOR
    public PedidoData(List<DetallePedidoData> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    public List<DetallePedidoData> getListaAlimentos() {
        return listaAlimentos;
    }

    public void setListaAlimentos(List<DetallePedidoData> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }
}

