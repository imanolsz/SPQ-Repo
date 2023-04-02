package es.deusto.spq.modelos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import es.deusto.spq.pojo.NotificacionData;


public class ModeloTablaNotificacionData extends AbstractTableModel {

    private List<NotificacionData> notificaciones;
    private String[] columnas = {"Asunto", "Fecha"};

    public ModeloTablaNotificacionData(List<NotificacionData> notificaciones) {
        this.notificaciones = notificaciones;
    }

    @Override
    public int getRowCount() {
        return notificaciones.size();
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
        NotificacionData notificacion = notificaciones.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return notificacion.getAsunto();
            case 1:
                return notificacion.getFecha();
            default:
                return null;
        }
    }
}

