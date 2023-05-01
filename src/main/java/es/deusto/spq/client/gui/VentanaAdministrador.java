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

        // Crear etiqueta para el título
        JLabel titleLabel = new JLabel("Bienvenido al Panel de Administración");

        // Crear botones para las distintas funcionalidades
        JButton crearReservaButton = new JButton("Crear Reserva");
        JButton editarReservaButton = new JButton("Editar Reserva");
        JButton eliminarReservaButton = new JButton("Eliminar Reserva");
        JButton mostrarMenuButton = new JButton("Mostrar menú");

        // Crear contenedor para organizar los componentes
        JPanel container = new JPanel();
        container.add(titleLabel);
        container.add(crearReservaButton);
        container.add(editarReservaButton);
        container.add(eliminarReservaButton);
        container.add(mostrarMenuButton);

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
            for (ReservaData reserva : reservas) {
                model.addRow(new Object[]{reserva.getId(),reserva.getFecha(), reserva.getHora(), reserva.getCancelada(), reserva.getNumPersonas(), reserva.getUser()});
            }
            tablaReservas.setModel(model);
        }

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
        this.setVisible(true);
    }
}
