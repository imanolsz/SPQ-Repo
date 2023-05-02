package es.deusto.spq.client.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.*;
import es.deusto.spq.main.Main;
import es.deusto.spq.pojo.*;


public class VentanaComidaPedido extends JFrame {

	//private JFrame frame;
	private TablaMenu tablaMenu;
	private JButton btnMenuVegetariano, btnPedir, btnAtras;
	private boolean verVegetariano = true;
	JScrollPane scrollPane;

	public VentanaComidaPedido() {
		this.setTitle("Menu");
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setLocationRelativeTo(null);
	
		tablaMenu = new TablaMenu();
		scrollPane = new JScrollPane(tablaMenu);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.pack();
	
		Panel panel = new Panel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.BLACK);
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnMenuVegetariano = new JButton("Menu vegetariano");
		btnMenuVegetariano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verVegetariano){
					Object[][] filas = tablaMenu.getMenuVegetariano();
					DefaultTableModel modelVeggie = new DefaultTableModel(filas, tablaMenu.getColumnas());
					tablaMenu.setModel(modelVeggie);
					btnMenuVegetariano.setText("Menu completo");
					verVegetariano = false;
				}else{
					tablaMenu = new TablaMenu();
					btnMenuVegetariano.setText("Menu vegetariano");
					verVegetariano = true;
				}
				scrollPane.setViewportView(tablaMenu);
			}
		});
		panel.add(btnMenuVegetariano);
		//Boton que vuelve a la ventana reserva
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaReserva().setVisible(true);
				dispose();
			}
		});
		panel.add(btnAtras);
	
		//Boton que hace que se realice el pedido PORHACER
		btnPedir = new JButton("Pedir");
		panel.add(btnPedir);
		btnPedir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = tablaMenu.getRowCount();
				for (int i = 0; i < row; i++) {
					String cantidadStr = (String) tablaMenu.getValueAt(i, 2);
					try {
						int cantidad = Integer.parseInt(cantidadStr);
						if (cantidad >= 1) {
							String comida = (String) tablaMenu.getValueAt(i,0);
							DetallePedidoData alimento = new DetallePedidoData(comida, cantidad); 
							System.out.println(comida);
							Main.getExampleClient().getPedidoActivo().getListaAlimentos().add(alimento);
						}
			
					} catch (NumberFormatException e) {
						System.out.println("mal conversión");
					}
					Main.getGestorVentanas().getVentanaReserva().setVisible(true);
					dispose();
				}
			}
		});
		
	}

	public JTable getTablaMenu() {
		return tablaMenu;
	}
	
}