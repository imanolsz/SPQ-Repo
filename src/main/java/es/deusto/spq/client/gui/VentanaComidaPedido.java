package es.deusto.spq.client.gui;

import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import es.deusto.spq.main.Main;


public class VentanaComidaPedido extends JFrame {

	private JFrame frame;
	private JTable TablaMenu;

	/**
	 * Create the application.
	 */
	public VentanaComidaPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	    frame = new JFrame("Menu");
	    frame.setBounds(100, 100, 450, 300);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(new BorderLayout(0, 0));

	    // Definir datos para la tabla
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

	    TablaMenu = new JTable(data, columnNames);
	    
	    // Establecer el renderer de celda personalizado
        TablaMenu.setDefaultRenderer(Object.class, new MiRenderer());
	    
	    JScrollPane scrollPane = new JScrollPane(TablaMenu);
	    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	    // establecer el ancho de las columnas de la tabla
	    TablaMenu.getColumnModel().getColumn(0).setPreferredWidth(200);
	    TablaMenu.getColumnModel().getColumn(1).setPreferredWidth(100);
	    TablaMenu.getColumnModel().getColumn(2).setPreferredWidth(50);

	    Panel panel = new Panel();
	    panel.setBackground(Color.PINK);
	    panel.setForeground(Color.BLACK);
	    frame.getContentPane().add(panel, BorderLayout.SOUTH);
	    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        //Boton que vuelve a la ventana reserva
	    JButton btnAtras = new JButton("Atras");
	    btnAtras.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
                Main.getGestorVentanas().getVentanaReserva().setVisible(true);
				frame.dispose();
	        }
	    });
	    panel.add(btnAtras);

        //Boton que hace que se realice el pedido PORHACER
	    JButton btnPedir = new JButton("Pedir");
	    btnPedir.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        }
	    });
	    panel.add(btnPedir);
	}

	public JTable getTablaMenu() {
		return TablaMenu;
	}

}