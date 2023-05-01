package es.deusto.spq.client.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//La tabla donde se muestran todos los ingredientes
public class TablaMenu extends JTable{
    String[] columnas = {"Comida", "Precio", "Cantidad", "Vegetariano"};
    public TablaMenu(){
        Object[][] platos= {
            {"Croquetas de la abuela", 10.20, "0", "No"},
                {"Rabas", 4.30, "0", "No"},
                {"Bravas", 3.50, "0", "Si"},
                {"Tabla de surtidos ibericos", 7.30, "0", "No"},
                {"Patatas bacon-queso", 5.00, "0", "No"},

                {"Ensalada de bogavante", 10.20, "0", "No"},
                {"Menestra de verduras", 7.10, "0", "Si"},
                {"Risotto", 8.10, "0", "Si"},
                {"Pasta cabonara con trufa", 9.20, "0", "Si"},
                {"Cocido", 9.00, "0", "No"},

                {"Rodavallo", 40.00, "0", "No"},
                {"Bacalao a la bizkaina", 25.20, "0", "No"},
                {"Chuleton", 45.00, "0", "No"},
                {"Chuletillas", 30.15, "0", "No"},
                {"Calamares en su tinta", 15.35, "0", "No"},

                {"Coulant de chocolate", 8.50, "0", "Si"},
                {"Tarta de queso", 8.00, "0", "Si"},
                {"Brownie de chocolate", 7.50, "0", "Si"},
                {"Torrijas", 6.30, "0", "Si"},

                {"Vino tinto", 20.20, "0", ""},
                {"Vino blanco", 18.30, "0", ""},
                {"Agua", 2.50, "0", ""},
                {"Refresco", 2.30, "0", ""},
        };
        DefaultTableModel model = new DefaultTableModel(platos, columnas);
        setModel(model);
        // Establecer el renderer de celda personalizado
        setDefaultRenderer(Object.class, new MiRenderer());
        // establecer el ancho de las columnas de la tabla
        getColumnModel().getColumn(0).setPreferredWidth(200);
        getColumnModel().getColumn(1).setPreferredWidth(50);
        getColumnModel().getColumn(2).setPreferredWidth(50);
        getColumnModel().getColumn(3).setPreferredWidth(70);
    }

    // Filtra las filas de la tabla dejando solo los vegetarianos
    public Object[][] getMenuVegetariano(){
        DefaultTableModel model = (DefaultTableModel)getModel();
        int numFilas = model.getRowCount();
        Object[][] rows = new Object[numFilas][4];
        int contadorFilas = 0;
        for (int i=0; i< numFilas; i++){
            String vegetariano = (String)model.getValueAt(i, 3);
            if(vegetariano.equals("Si") || vegetariano.equals("")){
                rows[contadorFilas][0] = model.getValueAt(i, 0);
                rows[contadorFilas][1] = model.getValueAt(i, 1);
                rows[contadorFilas][2] = model.getValueAt(i, 2);
                rows[contadorFilas][3] = model.getValueAt(i, 3);
                contadorFilas++;
            }
        }
        // si no encuentra ninguna devuelve un array vacío
        if(contadorFilas == 0)
            return new Object[0][4];
        // Si se encontraron filas devuelve las filas encontradas
        Object[][] result = new Object[contadorFilas][4];
        for (int i=0; i < contadorFilas; i++){
            result[i][0] = rows[i][0];
            result[i][1] = rows[i][1];
            result[i][2] = rows[i][2];
            result[i][3] = rows[i][3];
        }
        return result;
    }

    public String[] getColumnas() {
        return columnas;
    }
    
}
