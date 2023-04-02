package es.deusto.spq.client.gui;

import java.net.URL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import es.deusto.spq.main.Main;




public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton bCerrar;
	private JButton bInicio;
	private JButton bRegistrarse;
	
	public VentanaPrincipal(){
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "INICIO" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		
		//Paneles principales
		JPanel panelCentral = new JPanel(new BorderLayout());
		panelCentral.setBackground(Color.white);
		JPanel panelInferior = new JPanel(new FlowLayout());
		JPanel panelSuperior = new JPanel(new BorderLayout());
		
		//PanelCentral
		JLabel lMensaje = new JLabel("                       Cooking Mama");
		lMensaje.setForeground(Color.black);
		lMensaje.setFont(new Font("Serif", Font.PLAIN, 44));
		panelSuperior.add(lMensaje);
		getContentPane().add(panelSuperior,"North");
		panelSuperior.setBackground(Color.decode("#e0a370"));
		
		//PanelInferior
		bInicio = new JButton("Iniciar Sesion");
		panelInferior.add(bInicio);
		bRegistrarse = new JButton("Registrarse");
		panelInferior.add(bRegistrarse);
		bCerrar = new JButton("Cerrar");
		panelInferior.add(bCerrar);
		getContentPane().add(panelInferior,"South");
		panelInferior.setBackground(Color.decode("#e0a370"));

		
		
		bInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaInicio().setVisible(true);
				dispose();
			}	
		});
		bRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.getGestorVentanas().getVentanaRegistro().setVisible(true);
			}
		});
		bCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//ETIQUETA IMAGEN
		URL urlImagen = getClass().getResource("../fotos/LOGO.jpg"); // // Obtener URL de la imagen
        ImageIcon imagen = new ImageIcon(urlImagen); // Crear ImageIcon a partir de la URL
		JLabel etiquetaImg = new JLabel(imagen); // Crear JLabel con la imagen 
		etiquetaImg.setBounds(10, 20, 512, 512);
		panelCentral.add(etiquetaImg);
		getContentPane().add(panelCentral,"Center");
		
	}

}
