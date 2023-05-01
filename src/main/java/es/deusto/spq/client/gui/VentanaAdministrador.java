package es.deusto.spq.client.gui;

import java.time.LocalTime;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.*;

import es.deusto.spq.main.Main;
import es.deusto.spq.pojo.ReservaData;

public class VentanaAdministrador extends JFrame {
    private JTable tablaReservas;
    private JTable tablaMenu;
    private JFrame ventanaTablaMenu;
    
    public VentanaAdministrador() {

        
        super("Ventana de Administración");
        setSize(800, 600);
        // Crear etiqueta para el título
        JLabel titleLabel = new JLabel("Bienvenido al Panel de Administración");
        titleLabel.setBounds(0, 0, 800, 50);

        // Crear botones para las distintas funcionalidades
        JButton crearReservaButton = new JButton("Crear Reserva");
        JButton editarReservaButton = new JButton("Editar Reserva");
        JButton eliminarReservaButton = new JButton("Eliminar Reserva");
        JButton mostrarMenuButton = new JButton("Mostrar menú");
        JButton atras = new JButton("Atrás");

        // Crear contenedor para organizar los componentes
        JPanel container = new JPanel();
        container.add(titleLabel);
        container.add(crearReservaButton);
        container.add(editarReservaButton);
        container.add(eliminarReservaButton);
        container.add(mostrarMenuButton);
        container.add(atras);

        //Crear la tabla
        tablaReservas = new JTable();
        tablaMenu = new JTable();
        container.add(tablaReservas);
        container.add(tablaMenu);

        List<ReservaData> reservas = Main.getExampleClient().getReservas();
        if (reservas != null) {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Fecha");
            model.addColumn("Hora");
            model.addColumn("Canelada");
            model.addColumn("NumPersonas");
            model.addColumn("UserData");
            model.addColumn("Especificación");
            
            for (ReservaData reserva : reservas) {
                model.addRow(new Object[]{reserva.getId(),reserva.getFecha(), reserva.getHora(), reserva.getCancelada(), reserva.getNumPersonas(), reserva.getUser(), reserva.getEspecificacion()});
            }
            tablaReservas.setModel(model);

            //COLORES PARA EVENTOS
            // Crear el renderizador para las filas que cumplen la condición
            TableCellRenderer renderer = new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                            row, column);
                    String espec = (String) table.getModel().getValueAt(row, 6);
                    if (espec != null && espec.equals("cumpleaños")) {
                        c.setBackground(new Color(200, 255, 200)); // Pintar fila de color verde claro
                    } 
                    else if(espec != null && espec.equals("boda")){
                        c.setBackground(new Color(255, 255, 153)); // Pintar fila de color amarillo claro
                    }
                    else if(espec != null && espec.equals("comunion")){
                        c.setBackground(new Color(173, 216, 230)); // Pintar fila de color azul claro
                    }
                    else if(espec != null && espec.equals("graduacion")){
                        c.setBackground(new Color(255, 182, 193)); // Pintar fila de color rosa claro
                    }
                    else if(espec != null && espec.equals("babyshower")){
                        c.setBackground(new Color(255, 165, 0, 100)); // Pintar fila de color naranja claro
                    }
                    else {
                        c.setBackground(Color.WHITE); // Dejar fondo en blanco
                    }
                    return c;
                }
            };
            tablaReservas.setDefaultRenderer(Object.class, renderer);
        }

        JComboBox<LocalTime> boxHora = new JComboBox<LocalTime>();
	    GridBagConstraints gbc_boxHora = new GridBagConstraints();
	    gbc_boxHora.anchor = GridBagConstraints.WEST;
	    gbc_boxHora.insets = new Insets(0, 0, 5, 0);
	    gbc_boxHora.gridx = 1;
	    gbc_boxHora.gridy = 2;
	 //   getContentPane().add(boxHora, gbc_boxHora);
	    boxHora.addItem(LocalTime.of(13, 0));
        boxHora.addItem(LocalTime.of(13, 30));
        boxHora.addItem(LocalTime.of(14, 0));
        boxHora.addItem(LocalTime.of(14, 30));
        boxHora.addItem(LocalTime.of(15, 0));
        boxHora.addItem(LocalTime.of(15, 30));
        boxHora.addItem(LocalTime.of(20, 30));
        boxHora.addItem(LocalTime.of(21, 0));
        boxHora.addItem(LocalTime.of(21, 30));
        boxHora.addItem(LocalTime.of(22, 0));
        boxHora.addItem(LocalTime.of(22, 30));

        
        //Activar boton para CREAR y MOSTRAR la tabla
        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
                dispose();
            }
        });

        mostrarMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tablaMenu = new TablaMenu();
                ventanaTablaMenu = new JFrame("Menu");
                JScrollPane scrollPane = new JScrollPane(tablaMenu);
                ventanaTablaMenu.add(scrollPane);
                ventanaTablaMenu.pack(); // la ventana se ajusta a la tabla
                ventanaTablaMenu.setLocationRelativeTo(null);
                ventanaTablaMenu.setVisible(true);
            }
        });

        // Configurar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(container);
    }
}
