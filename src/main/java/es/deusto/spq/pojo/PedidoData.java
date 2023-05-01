package es.deusto.spq.pojo;

import java.util.List;

public class PedidoData {
    private List<DetallePedidoData> listaAlimentos;

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
