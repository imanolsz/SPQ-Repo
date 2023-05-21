package es.deusto.spq.client.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import es.deusto.spq.main.Main;
import es.deusto.spq.pojo.ResenaData;


public class VentanaRealizarResena extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton bAtras;
	JButton bRealizarResena;
	JTextField TfResena;
	

	public VentanaRealizarResena() {

		setTitle("Inicio sesion");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.decode("#e0a370"));

		bRealizarResena = new JButton("Entrar");
		panelInferior.add(bRealizarResena);
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior, "South");


		TfResena = new JTextField();
		TfResena.setText("test@test.com");
		TfResena.setBounds(330, 200, 160, 25);
		panel.add(TfResena);

		

		getContentPane().add(panel);

		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
			}
		});

		bRealizarResena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResenaData resena = new ResenaData(TfResena.getText());
				Main.getExampleClient().realizarResena(resena);
				dispose();
				Main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
			}
		});
	}

}
