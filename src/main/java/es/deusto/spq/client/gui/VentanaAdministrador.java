package es.deusto.spq.client.gui;

import es.deusto.spq.main.Main;
import es.deusto.spq.pojo.ReservaData;
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
    private List<ReservaData> r;
    private Timer timer;
    
    public VentanaAdministrador() {

        
        super("Ventana de Administración");
        setSize(800, 600);
        // Crear etiqueta para el título
        JLabel titleLabel = new JLabel("Bienvenido al Panel de Administración");
        titleLabel.setBounds(0, 0, 800, 50);

        //Crear jcombobox hora para el parking
        JComboBox<LocalTime> boxHora = new JComboBox<LocalTime>();

        //Crear textfield para fecha
        JTextField textFecha;
        textFecha = new JTextField();

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
        container.add(boxHora);
        container.add(textFecha);
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
                //tablaReservas.setDefaultRenderer(Object.class, renderer);    NO SE PORQUE EL RENDERER DA MAL, SI LOS COLORES DEL MENU NO SALEN ES POR ESTO
        
            }
        });
        timer.start();
    
        
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

        atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
                dispose();
            }
        });

        //Combobox hora
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

        //Textfield hora
        textFecha.setText("Fecha: DD-MM-AAAA");
        // Configurar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(container);
        this.setVisible(true);
    }
}
