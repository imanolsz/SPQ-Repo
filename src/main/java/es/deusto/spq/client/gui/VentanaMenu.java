package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
	JButton bModificarReserva;

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
		URL urlImagen = getClass().getResource("/client/fotos/buzon.jpg");
		// Obtener URL de la imagen
		 if(urlImagen != null){
			ImageIcon imagen = new ImageIcon(urlImagen); // Crear ImageIcon a partir de la URL
			BBuzon.setBounds(100, 100, 50, 50);
			 Icon imag = new ImageIcon(imagen.getImage().getScaledInstance(BBuzon.getWidth(), BBuzon.getHeight(), Image.SCALE_DEFAULT)); 
		 	BBuzon.setIcon(imag);
		 }
		 
		 

		//boton consultar reserva y añado el boton buzon al panel
		bConsultarReservas = new JButton("Consultar Reservas");
		bConsultarReservas.setBackground(Color.LIGHT_GRAY);
		panelCentral.add(BBuzon);
		panelInferior.add(bConsultarReservas);

		//boton salir
		bSalir = new JButton("Salir");
		bSalir.setBackground(Color.RED);
		panelInferior.add(bSalir);

		//boton realizar reserva y caracteristicas de la ventana
		bRealizarReserva = new JButton("Realizar reserva");
		bRealizarReserva.setBackground(Color.GREEN);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = pantalla.height;
	    int width = pantalla.width;
		panelCentral.add(bRealizarReserva);
		bRealizarReserva.setLocation(width, height);

		//boton modificar reserva
		bModificarReserva = new JButton("Modificar reserva");
		bModificarReserva.setBackground(Color.ORANGE);
		panelInferior.add(bModificarReserva);
		
		//Paneles
		getContentPane().add(panelInferior, "South");
		getContentPane().add(panelCentral,"Center" );

		//Action listener de los botones
		bConsultarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaConsultaReserva().setVisible(true);
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

		bModificarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaModificar().setVisible(true);
				dispose();
			}
		});

		bRealizarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaReserva().setVisible(true);
				dispose();
			}
		});

		
	}
}
