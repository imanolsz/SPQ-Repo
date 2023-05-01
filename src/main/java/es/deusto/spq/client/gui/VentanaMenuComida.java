package es.deusto.spq.client.gui;

import java.net.URL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import es.deusto.spq.main.Main;




public class VentanaMenuComida extends JFrame {
	
	public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }

	private static final long serialVersionUID = 1L;
	private JButton bCerrar;
	
	
	public VentanaMenuComida(){
		        // Título de la ventana
				super("Ventana Menú Comida");

		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Menu del día" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		
		//Paneles principales
		JPanel panelCentral = new JPanel(new GridBagLayout());
		panelCentral.setBackground(Color.white);
		JPanel panelInferior = new JPanel(new FlowLayout());
		JPanel panelSuperior = new JPanel(new BorderLayout());
		
		//PanelCentral
	

		JPanel panelCentrado = new JPanel(new GridBagLayout());
		panelCentrado.add(panelSuperior, new GridBagConstraints());

		getContentPane().add(panelCentrado, BorderLayout.NORTH);
		panelSuperior.setBackground(Color.decode("#e0a370"));
		panelCentrado.setBackground(Color.decode("#e0a370"));
		
		//PanelInferior
		
		bCerrar = new JButton("Cerrar");
		panelInferior.add(bCerrar);
		getContentPane().add(panelInferior,"South");
		panelInferior.setBackground(Color.decode("#e0a370"));

		
		//Etiqueta de la imagen
		URL urlImagen = getClass().getResource("/fotos/imagenCarta.png"); // // Obtener URL de la imagen	
        ImageIcon imagen = new ImageIcon(urlImagen); // Crear ImageIcon a partir de la URL
		JLabel etiquetaImg = new JLabel(imagen); // Crear JLabel con la imagen 
		etiquetaImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelCentrado.add(etiquetaImg);
		
		

		bCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.getGestorVentanas().getVentanaMenu().setVisible(true);
			}
		});

		


		
	}

}
