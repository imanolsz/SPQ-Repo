package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.*;
import javax.validation.constraints.Null;

import es.deusto.spq.pojo.NotificacionData;

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

        JTextArea telefonoTextArea = new JTextArea("684156979");
        telefonoTextArea.setBounds(240, 220, 200, 20);
        telefonoTextArea.setForeground(Color.blue);
        telefonoTextArea.setBackground(Color.orange);
        panel.add(telefonoTextArea);

        JLabel mapaLabel = new JLabel("MAPA:");
        mapaLabel.setBounds(123, 320, 100, 20);
        mapaLabel.setForeground(Color.black);
        panel.add(mapaLabel);
   

        
        getContentPane().add(panel);


    }

}
