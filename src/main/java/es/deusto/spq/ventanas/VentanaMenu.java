package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.net.URL;

import es.deusto.spq.main.Main;



public class VentanaMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton bConsultarReservas;
	JButton bSalir;
	JButton bRealizarReserva;
	JButton BBuzon;

	// private Thread t;

	public VentanaMenu() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("MENU");
		setSize(800, 600);
		setLocationRelativeTo(null);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.white);
		JPanel panelCentral = new JPanel(new FlowLayout());
		panelCentral.setBackground(Color.decode("#e0a370"));
		BBuzon = new JButton();
		// Código ejemplo para importar una foto
		URL urlImagen = getClass().getResource("../fotos/buzon.jpg"); // Obtener URL de la imagen
		ImageIcon imagen = new ImageIcon(urlImagen); // Crear ImageIcon a partir de la URL
		BBuzon.setBounds(100, 100, 50, 50);
		Icon imag = new ImageIcon(imagen.getImage().getScaledInstance(BBuzon.getWidth(), BBuzon.getHeight(), Image.SCALE_DEFAULT)); 
		BBuzon.setIcon(imag);
		bConsultarReservas = new JButton("Consultar Reservas");
		panelCentral.add(BBuzon);
		panelInferior.add(bConsultarReservas);
		bSalir = new JButton("Salir");
		panelInferior.add(bSalir);
		bRealizarReserva = new JButton("Realizar reserva");
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = pantalla.height;
	    int width = pantalla.width;
		panelCentral.add(bRealizarReserva);
		bRealizarReserva.setLocation(width, height);
		
		getContentPane().add(panelInferior, "South");
		getContentPane().add(panelCentral,"Center" );

		bConsultarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});

		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
				dispose();
			}
		});


		BBuzon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaBuzon().setVisible(true);
				dispose();
			}
		});

		

	}
}
