package es.deusto.spq.client.gui;

import es.deusto.spq.main.Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

public class VentanaPrincipal extends JFrame {
	
	public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }

	private static final long serialVersionUID = 1L;
	private JButton bCerrar;
	private JButton bInicio;
	private JButton bRegistrarse;
	
	public VentanaPrincipal(){
		        // Título de la ventana
				super("Ventana Principal");

		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "INICIO" );
		setSize( 800, 600 );
		setLocationRelativeTo( null );
		
		//Paneles principales
		JPanel panelCentral = new JPanel(new GridBagLayout());
		panelCentral.setBackground(Color.white);
		JPanel panelInferior = new JPanel(new FlowLayout());
		JPanel panelSuperior = new JPanel(new BorderLayout());
		
		//PanelCentral
		JLabel lNotificacion = new JLabel("Cooking Mama");
		lNotificacion.setForeground(Color.black);
		lNotificacion.setFont(new Font("Serif", Font.PLAIN, 44));
		panelSuperior.add(lNotificacion, BorderLayout.CENTER);

		JPanel panelCentrado = new JPanel(new GridBagLayout());
		panelCentrado.add(panelSuperior, new GridBagConstraints());

		getContentPane().add(panelCentrado, BorderLayout.NORTH);
		panelSuperior.setBackground(Color.decode("#e0a370"));
		panelCentrado.setBackground(Color.decode("#e0a370"));
		
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
		
		// Panel para centrar la imagen y el texto
		JPanel panelImagenTexto = new JPanel();
		panelImagenTexto.setLayout(new BoxLayout(panelImagenTexto, BoxLayout.Y_AXIS));
		panelImagenTexto.setBackground(Color.white);

		//Etiqueta de la imagen
		URL urlImagen = getClass().getResource("/fotos/LOGO.png"); // // Obtener URL de la imagen	
        ImageIcon imagen = new ImageIcon(urlImagen); // Crear ImageIcon a partir de la URL
		JLabel etiquetaImg = new JLabel(imagen); // Crear JLabel con la imagen 
		etiquetaImg.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelImagenTexto.add(etiquetaImg);

		// Enlace a ventana de políticas de privacidad
		JLabel texto = new JLabel("Política de privacidad y cookies");
		texto.setBackground(Color.red);
		texto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el mouse
		texto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // Cambiar color de fondo al pasar el cursor por encima
				texto.setForeground(Color.gray);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				texto.setForeground(Color.black);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// Crear una instancia de la ventana de políticas y cookies
				VentanaPoliticas ventanaPoliticas = new VentanaPoliticas(VentanaPrincipal.this);
				ventanaPoliticas.setLocationRelativeTo(VentanaPrincipal.this);
			}
		});

		//Agregar elementos a paneles
        texto.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelImagenTexto.add(texto);
		panelCentral.add(panelImagenTexto);
		getContentPane().add(panelCentral, BorderLayout.CENTER);
	}
}
