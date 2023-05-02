package es.deusto.spq.client.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

import es.deusto.spq.main.Main;

public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton bConsultarReservas;
	JButton bSalir;
	JButton bRealizarReserva;
	JButton BBuzon;
	JButton BContacto;
	JButton bModificarReserva;
	JButton bVisualizarCarta;

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
		 URL urlImagen = getClass().getResource("/fotos/buzon.jpg"); // Obtener URL de la imagen
		 ImageIcon imagen = new ImageIcon(urlImagen); // Crear ImageIcon a partir de la URL
		 BBuzon.setBounds(100, 100, 50, 50);
		 Icon imag = new ImageIcon(imagen.getImage().getScaledInstance(BBuzon.getWidth(), BBuzon.getHeight(), Image.SCALE_DEFAULT)); 
		 BBuzon.setIcon(imag);

		 BContacto = new JButton();
		 // Código ejemplo para importar una foto
		  URL urlImagenC = getClass().getResource("/fotos/contacto.png"); // Obtener URL de la imagen
		  ImageIcon imagenC = new ImageIcon(urlImagenC); // Crear ImageIcon a partir de la URL
		  BContacto.setBounds(100, 100, 50, 50);
		  Icon imagC = new ImageIcon(imagenC.getImage().getScaledInstance(BContacto.getWidth(), BContacto.getHeight(), Image.SCALE_DEFAULT)); 
		  BContacto.setIcon(imagC);

		//boton consultar reserva y añado el boton buzon al panel
		bConsultarReservas = new JButton("Consultar Reservas");
		bConsultarReservas.setBackground(Color.LIGHT_GRAY);
		bVisualizarCarta = new JButton("Visualizar carta");
		bVisualizarCarta.setBackground(Color.LIGHT_GRAY);
		panelCentral.add(BBuzon);
		panelCentral.add(BContacto);
		panelInferior.add(bConsultarReservas);
		panelInferior.add(bVisualizarCarta);

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

		BContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaContacto().setVisible(true);
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

		bVisualizarCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaMenuComida().setVisible(true);
				dispose();
			}
		});

	}
}
