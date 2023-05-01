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
	private JTable tablaMenu;

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

	    tablaMenu = new TablaMenu();
	    
	    JScrollPane scrollPane = new JScrollPane(tablaMenu);
	    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

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
		return tablaMenu;
	}

}