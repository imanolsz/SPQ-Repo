package es.deusto.spq.modelos;

import es.deusto.spq.restaurante.Mensaje;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaMensajes extends AbstractTableModel {

    private List<Mensaje> mensajes;
    private String[] columnas = {"Asunto", "Fecha"};

    public ModeloTablaMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    @Override
    public int getRowCount() {
        return mensajes.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mensaje mensaje = mensajes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mensaje.getAsunto();
            case 1:
                return mensaje.getFecha();
            default:
                return null;
        }
    }
}

