package es.deusto.spq.client.gui;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.main.Main;
import es.deusto.spq.pojo.ReservaData;

public class VentanaAdministrador extends JFrame {
    private JTable tablaReservas;

    public VentanaAdministrador() {
        super("Ventana de Administración");

        // Crear etiqueta para el título
        JLabel titleLabel = new JLabel("Bienvenido al Panel de Administración");

        // Crear botones para las distintas funcionalidades
        JButton crearReservaButton = new JButton("Crear Reserva");
        JButton editarReservaButton = new JButton("Editar Reserva");
        JButton eliminarReservaButton = new JButton("Eliminar Reserva");

        // Crear contenedor para organizar los componentes
        JPanel container = new JPanel();
        container.add(titleLabel);
        container.add(crearReservaButton);
        container.add(editarReservaButton);
        container.add(eliminarReservaButton);

        //Crear la tabla
        tablaReservas = new JTable();
        container.add(tablaReservas);


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

        // Configurar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(container);
    }

}
