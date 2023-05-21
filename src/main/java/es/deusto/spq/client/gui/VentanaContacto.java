package es.deusto.spq.client.gui;

import es.deusto.spq.main.Main;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
import java.awt.event.*;

public class VentanaContacto extends JFrame {

	private static final long serialVersionUID = 1L;

    // Constructor
    public VentanaContacto() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("CONTACTO");
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#e0a370"));

        JLabel direccionLabel = new JLabel("Direción:");
        direccionLabel.setBounds(120, 120, 100, 20);
        direccionLabel.setForeground(Color.black);
        panel.add(direccionLabel);

        JTextArea direccionTextArea = new JTextArea(" SAN FRANTZISKO KALEA, 10, 48003 BILBO, BIZKAIA");
        direccionTextArea.setEditable(false);
        direccionTextArea.setBounds(240, 120, 300, 20);
        direccionTextArea.setForeground(Color.blue);
        direccionTextArea.setBackground(Color.decode("#e0a370"));
        panel.add(direccionTextArea);

        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoLabel.setBounds(120, 220, 100, 20);
        telefonoLabel.setForeground(Color.black);
        panel.add(telefonoLabel);

        JButton BAtras = new JButton();
        // Código ejemplo para importar una foto
         URL urlImagenA = getClass().getResource("/fotos/atras.png"); // Obtener URL de la imagen
         ImageIcon imagenA = new ImageIcon(urlImagenA); // Crear ImageIcon a partir de la URL
         BAtras.setBounds(100, 100, 50, 50);
         Icon imagA = new ImageIcon(imagenA.getImage().getScaledInstance(BAtras.getWidth(), BAtras.getHeight(), Image.SCALE_DEFAULT)); 
         BAtras.setIcon(imagA);
        
         getContentPane().add(BAtras, BorderLayout.SOUTH);

        JTextArea telefonoTextArea = new JTextArea("684156979");
        telefonoTextArea.setEditable(false);
        telefonoTextArea.setBounds(240, 220, 200, 20);
        telefonoTextArea.setForeground(Color.blue);
        telefonoTextArea.setBackground(Color.decode("#e0a370"));
        panel.add(telefonoTextArea);

        JLabel mapaLabel = new JLabel("MAPA:");
        mapaLabel.setBounds(123, 320, 100, 20);
        mapaLabel.setForeground(Color.black);
        panel.add(mapaLabel);
   
        URL urlImagenMapa = getClass().getResource("/fotos/imagenMapa.png");
        ImageIcon imagenMapa = new ImageIcon(urlImagenMapa);
        
        // Reducir el tamaño de la imagen a 1/4 de su tamaño original
        int newWidth = imagenMapa.getIconWidth() / 4;
        int newHeight = imagenMapa.getIconHeight() / 4;
        Image scaledImage = imagenMapa.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        JLabel etiquetaImgMapa = new JLabel(scaledIcon);

        // Ajustar las coordenadas X e Y de etiquetaImgMapa para que esté a la derecha de mapaLabel
        int newX = mapaLabel.getX() + mapaLabel.getWidth() + 20;
        int newY = mapaLabel.getY();
        etiquetaImgMapa.setBounds(newX, newY, newWidth, newHeight);
        panel.add(etiquetaImgMapa);

        BAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
			}
		});	

        getContentPane().add(panel);
    }
}