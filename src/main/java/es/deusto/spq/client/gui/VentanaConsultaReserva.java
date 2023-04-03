
package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.net.URL;

import es.deusto.spq.main.Main;
import es.deusto.spq.pojo.ReservaData;

public class VentanaConsultaReserva extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton bConsultarReservas;
	JButton bSalir;
	JButton bRealizarReserva;
	JButton BBuzon;
	JButton bCancelarReserva;
	JTable tableReservasUsuario;

	// private Thread t;

	public VentanaConsultaReserva() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("MENU");
		setSize(800, 600);
		setLocationRelativeTo(null);
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.white);
		JPanel panelCentral = new JPanel(new FlowLayout());
		panelCentral.setBackground(Color.decode("#e0a370"));
		BBuzon = new JButton();
		// Código ejemplo para importar una foto
		URL urlImagen = getClass().getResource("../fotos/buzon.jpg"); // Obtener URL de la imagen
		ImageIcon imagen = new ImageIcon(urlImagen); // Crear ImageIcon a partir de la URL
		BBuzon.setBounds(100, 100, 50, 50);
		Icon imag = new ImageIcon(imagen.getImage().getScaledInstance(BBuzon.getWidth(), BBuzon.getHeight(), Image.SCALE_DEFAULT)); 
		BBuzon.setIcon(imag);
		bConsultarReservas = new JButton("Consultar reservas");

		//añado el boton buzon al panel
		panelCentral.add(BBuzon);
		panelInferior.add(bConsultarReservas);

		//boton salir
		bSalir = new JButton("Salir");
		bSalir.setBackground(Color.LIGHT_GRAY);
		panelInferior.add(bSalir);

		//boton realizar reserva y caracteristicas de la ventana
		bRealizarReserva = new JButton("Realizar reserva");
		bRealizarReserva.setBackground(Color.GREEN);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = pantalla.height;
	    int width = pantalla.width;
		panelCentral.add(bRealizarReserva);
		bRealizarReserva.setLocation(width, height);

		//boton cancelar reserva
		bCancelarReserva = new JButton("Cancelar reserva");
		bCancelarReserva.setBackground(Color.RED);
		panelInferior.add(bCancelarReserva);
		
		//Paneles
		getContentPane().add(panelInferior, "South");
		getContentPane().add(panelCentral,"Center" );
		
        //Tabla INCOMPLETA para mostrar las reservas del usuario
		tableReservasUsuario = new JTable();
		panelCentral.add(tableReservasUsuario);

		//List<ReservaData> reservas = Main.getExampleClient().getReservas();
		List<ReservaData> reservas = null;
		if (reservas != null) {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Fecha");
			model.addColumn("Hora");
			model.addColumn("Cancelada");
			model.addColumn("NumPersonas");
			model.addColumn("UserData");

			// para poder filtrar las reservas por el id que queremos.
			for (int i = 0; i < reservas.size(); i++) {
				ReservaData reserva = reservas.get(i);
				//Falta que con ese token encontremos el id del cliente que esta conectado mediante el mapa que los une en resources
				if (reserva.getId() == Main.getExampleClient().getToken()) { // Solo se agregan las reservas con el id que queremos
					model.addRow(new Object[]{reserva.getId(), reserva.getFecha(), reserva.getHora(), reserva.getCancelada(), reserva.getNumPersonas(), reserva.getUser()});
				}
			}

			tableReservasUsuario.setModel(model);
		}



		//Action listener de los botones

		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
			}
		});

		BBuzon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaBuzon().setVisible(true);
				dispose();
			}
		});	

		//Implementar el listener del metodo que cancele una reserva
		bCancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		bRealizarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaReserva().setVisible(true);
				dispose();
			}
		});

		
	}
}
