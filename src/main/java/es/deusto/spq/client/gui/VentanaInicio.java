package es.deusto.spq.client.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import es.deusto.spq.main.Main;


public class VentanaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton bAtras;
	JButton bEntrar;
	JLabel lusuarioDTO;
	JTextField TfusuarioDTO;
	JLabel lPasword;
	JTextField TfPasword;

	public VentanaInicio() {

		setTitle("Inicio sesion");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.decode("#e0a370"));

		bEntrar = new JButton("Entrar");
		panelInferior.add(bEntrar);
		bAtras = new JButton("Atras");
		panelInferior.add(bAtras);
		getContentPane().add(panelInferior, "South");

		lusuarioDTO = new JLabel("Email");
		lusuarioDTO.setBounds(270, 200, 80, 25);
		panel.add(lusuarioDTO);

		TfusuarioDTO = new JTextField();
		TfusuarioDTO.setText("test@test.com");
		TfusuarioDTO.setBounds(330, 200, 160, 25);
		panel.add(TfusuarioDTO);

		lPasword = new JLabel("Password");
		lPasword.setBounds(270, 250, 80, 25);
		panel.add(lPasword);

		TfPasword = new JTextField();
		TfPasword.setText("123456789");
		TfPasword.setBounds(330, 250, 190, 25);
		panel.add(TfPasword);


		getContentPane().add(panel);

		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.getGestorVentanas().getVentanaPrincipal().setVisible(true);
			}
		});

		bEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				Main.getExampleClient().loginUser(TfusuarioDTO.getText(), TfPasword.getText());
				dispose();

			}
		});
	}

}
