package es.deusto.spq.client.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

// Clase de renderizado personalizada para colorear filas
public class MiRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Colorear las filas según las especificaciones
        if (row < 5) {
            c.setBackground(new Color(255, 182, 193)); // Rosa claro
        } else if (row < 10) {
            c.setBackground(new Color(255, 255, 153)); // Amarillo claro
        } else if (row < 15) {
            c.setBackground(new Color(173, 216, 230)); // Azul claro
        } else if (row < 19) {
            c.setBackground(new Color(255, 165, 0, 100)); // Naranja claro (con transparencia)
        } else {
            c.setBackground(new Color(144, 238, 144)); // Verde claro
        }

        if (isSelected) {
            c.setForeground(table.getSelectionForeground());
        } else {
            c.setForeground(table.getForeground());
        }

        return c;
    }
}