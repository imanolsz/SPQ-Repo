package es.deusto.spq.ventanas;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import es.deusto.spq.main.Main;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lemail;
	JTextField tfemail;
	JLabel lPasword;
	JTextField tfPasword;
	JButton bRegistrarse;
	JButton bAtras;

	public VentanaRegistro() {

		setTitle("Registro");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(null);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.decode("#e0a370"));

		lemail = new JLabel("Email");
		lemail.setBounds(270, 200, 80, 25);
		panel.add(lemail);

		tfemail = new JTextField();
		tfemail.setBounds(330, 200, 160, 25);
		tfemail.setText("test@test.com");
		panel.add(tfemail);

		lPasword = new JLabel("Password");
		lPasword.setBounds(270, 250, 80, 25);
		panel.add(lPasword);

		tfPasword = new JTextField();
		tfPasword.setText("123456789");
		tfPasword.setBounds(330, 250, 190, 25);
		panel.add(tfPasword);

		getContentPane().add(panel);

		bRegistrarse = new JButton("Registrarse");
		panelInferior.add(bRegistrarse);
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior, "South");

		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
				dispose();
			}
		});
		bRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				}
		});
	}
}

