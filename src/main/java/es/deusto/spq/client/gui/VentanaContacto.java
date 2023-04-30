package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.*;
import javax.validation.constraints.Null;

import es.deusto.spq.pojo.NotificacionData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.client.ExampleClient;
import es.deusto.spq.main.Main;
import es.deusto.spq.modelos.ModeloTablaNotificacionData;


public class VentanaContacto extends JFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Thread t;

    public VentanaContacto() {


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("CONTACTO");
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.orange);

        JLabel direccionLabel = new JLabel("DIRECCIÓN:");
        direccionLabel.setBounds(120, 120, 100, 20);
        direccionLabel.setForeground(Color.black);
        panel.add(direccionLabel);

        JTextArea direccionTextArea = new JTextArea(" SAN FRANTZISKO KALEA, 10, 48003 BILBO, BIZKAIA");
        direccionTextArea.setBounds(240, 120, 300, 20);
        direccionTextArea.setForeground(Color.blue);
        direccionTextArea.setBackground(Color.orange);
        panel.add(direccionTextArea);

        JLabel telefonoLabel = new JLabel("TELÉFONO:");
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
        telefonoTextArea.setBounds(240, 220, 200, 20);
        telefonoTextArea.setForeground(Color.blue);
        telefonoTextArea.setBackground(Color.orange);
        panel.add(telefonoTextArea);

        JLabel mapaLabel = new JLabel("MAPA:");
        mapaLabel.setBounds(123, 320, 100, 20);
        mapaLabel.setForeground(Color.black);
        panel.add(mapaLabel);
   
        
        BAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
			}
		});	

        
        getContentPane().add(panel);


    }

}
