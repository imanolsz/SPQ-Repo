package es.deusto.spq.client.gui;

import java.time.LocalTime;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.*;
import javax.swing.table.*;

import es.deusto.spq.main.Main;
import es.deusto.spq.pojo.*;
import es.deusto.spq.server.jdo.User;

public class VentanaAdministrador extends JFrame {
    private JTable tablaReservas;
    private JTable tablaMenu;
    private JFrame ventanaTablaMenu;
    private List<ReservaData> r;
    private Timer timer;
    
    public VentanaAdministrador() {
        super("Ventana de Administración");

        // Crear etiqueta para el título
        JLabel titleLabel = new JLabel("Bienvenido al Panel de Administración");

        // Crear botones para las distintas funcionalidades
        JButton crearReservaButton = new JButton("Crear Reserva");
        JButton editarReservaButton = new JButton("Editar Reserva");
        JButton eliminarReservaButton = new JButton("Eliminar Reserva");
        JButton mostrarMenuButton = new JButton("Mostrar menú");
        JButton atras = new JButton("Atras");

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

        
        
        timer = new Timer(5000, e -> {
            List<ReservaData> reservas = Main.getExampleClient().getReservas();
            if (reservas != null && !reservas.equals(r)) {
                r = reservas;
                for (ReservaData reserva : reservas) {
                    System.out.println(reserva.toString()); // Imprimir la reserva en la pantalla
                }
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("ID");
                model.addColumn("Fecha");
                model.addColumn("Hora");
                model.addColumn("Canelada");
                model.addColumn("NumPersonas");
                model.addColumn("UserData");
                for (ReservaData reserva : reservas) {
                    model.addRow(new Object[]{reserva.getId(),reserva.getFecha(), reserva.getHora(), reserva.getCancelada(), reserva.getNumPersonas(), reserva.getUser()});
                }
                tablaReservas.setModel(model);
            }
        });
        timer.start();

        JComboBox<LocalTime> boxHora = new JComboBox<LocalTime>();
	    GridBagConstraints gbc_boxHora = new GridBagConstraints();
	    gbc_boxHora.anchor = GridBagConstraints.WEST;
	    gbc_boxHora.insets = new Insets(0, 0, 5, 0);
	    gbc_boxHora.gridx = 1;
	    gbc_boxHora.gridy = 2;
	    // getContentPane().add(boxHora, gbc_boxHora);
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
        mostrarMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Creacion de la tabla del Menú
                Object[][] data = {
                    {"Croquetas de la abuela", 10.20, 0, "No"},
                    {"Rabas", 4.30, 0, "No"},
                    {"Bravas", 3.50, 0, "Si"},
                    {"Tabla de surtidos ibericos", 7.30, 0, "No"},
                    {"Patatas bacon-queso", 5.00, 0, "No"},
        
                    {"Ensalada de bogavante", 10.20, 0, "No"},
                    {"Menestra de verduras", 7.10, 0, "Si"},
                    {"Risotto", 8.10, 0, "Si"},
                    {"Pasta cabonara con trufa", 9.20, 0, "Si"},
                    {"Cocido", 9.00, 0, "No"},
        
                    {"Rodavallo", 40.00, 0, "No"},
                    {"Bacalao a la bizkaina", 25.20, 0, "No"},
                    {"Chuleton", 45.00, 0, "No"},
                    {"Chuletillas", 30.15, 0, "No"},
                    {"Calamares en su tinta", 15.35, 0, "No"},
        
                    {"Coulant de chocolate", 8.50, 0, "Si"},
                    {"Tarta de queso", 8.00, 0, "Si"},
                    {"Brownie de chocolate", 7.50, 0, "Si"},
                    {"Torrijas", 6.30, 0, "Si"},
        
                    {"Vino tinto", 20.20, 0, ""},
                    {"Vino blanco", 18.30, 0, ""},
                    {"Agua", 2.50, 0, ""},
                    {"Refresco", 2.30, 0, ""},
                };
                String[] columnNames = {"Comida", "Precio", "Cantidad", "Vegetariano"};
        
                tablaMenu = new JTable(data, columnNames);
                
                // Establecer el renderer de celda personalizado
                tablaMenu.setDefaultRenderer(Object.class, new MiRenderer());
                
                // Crear la ventana de la tabla
                ventanaTablaMenu = new JFrame("Menu");
                JScrollPane scrollPane = new JScrollPane(tablaMenu);
                ventanaTablaMenu.add(scrollPane);
                // establecer el ancho de las columnas de la tabla
                tablaMenu.getColumnModel().getColumn(0).setPreferredWidth(200);
                tablaMenu.getColumnModel().getColumn(1).setPreferredWidth(50);
                tablaMenu.getColumnModel().getColumn(2).setPreferredWidth(50);
                tablaMenu.getColumnModel().getColumn(3).setPreferredWidth(70);
        
                ventanaTablaMenu.pack(); // la ventana se ajusta a la tabla
                ventanaTablaMenu.setLocationRelativeTo(null);
                ventanaTablaMenu.setVisible(true);
            }
        });

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
                dispose();
            }
        });

        // Configurar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(container);
    }
}
