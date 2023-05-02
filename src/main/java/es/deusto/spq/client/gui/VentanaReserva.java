package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.validation.constraints.Null;

import es.deusto.spq.main.Main;
import es.deusto.spq.pojo.PedidoData;
import es.deusto.spq.pojo.ReservaData;

public class VentanaReserva extends JFrame {

	private static final long serialVersionUID = 1L;
    private GridBagConstraints c_1;
    private GridBagConstraints c_2;
    private JTextField textFecha;
    private GridBagConstraints gbc_lhora;
    private JTextField textEspecificacion;
    private int parkingTotal = 0;
    private int parkingOcupado = 0;
    private int parkingLibre = 0;
    private Date fechaD;

	public VentanaReserva() {
        setSize(600, 400);
        // Crear un panel principal y establecer un GridBagLayout
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWeights = new double[]{0.0, 0.0};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        JPanel panel = new JPanel(gbl_panel);

        JLabel lPlazas = new JLabel("Plazas libres: ");
        lPlazas.setLocation(100, 200);
        
        JButton BParking = new JButton("VER PLAZAS DE APARCAMIENTO LIBRES");
        BParking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date fecha = formato.parse(textFecha.getText());
                    fechaD = fecha;
                } catch (ParseException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                parking(fechaD);
                lPlazas.setText("Plazas libres: " + parkingLibre);
                lPlazas.setForeground(Color.yellow);
				dispose();
			}
		});	
        

        panel.add(lPlazas);
        panel.add(BParking);

        // Crear los componentes que se van a agregar al panel
        JLabel lhora = new JLabel("Hora de la reserva:");
        JLabel lnumpersonas = new JLabel("Numero de personas:");
        
        JLabel lfecha = new JLabel("Fecha:");
        GridBagConstraints gbc_lfecha = new GridBagConstraints();
        gbc_lfecha.insets = new Insets(0, 0, 5, 5);
        gbc_lfecha.gridx = 0;
        gbc_lfecha.gridy = 1;
        panel.add(lfecha, gbc_lfecha);
        //comentarioPrueba
        textFecha = new JTextField();
        GridBagConstraints gbc_textFecha = new GridBagConstraints();
        gbc_textFecha.insets = new Insets(0, 0, 5, 0);
        gbc_textFecha.gridx = 1;
        gbc_textFecha.gridy = 1;
        panel.add(textFecha, gbc_textFecha);
        textFecha.setColumns(10);

        // Agregar JLabel "Pedido"
        JLabel lpedido = new JLabel("Pedido:");
        GridBagConstraints gbc_lpedido = new GridBagConstraints();
        gbc_lpedido.insets = new Insets(0, 0, 5, 5);
        gbc_lpedido.gridx = 0;
        gbc_lpedido.gridy = 0;
        panel.add(lpedido, gbc_lpedido);

        // Agregar JLabel "Añadir especificación"
        JLabel lespecificacion = new JLabel("Añadir especificación:");
        GridBagConstraints gbc_lespecificacion = new GridBagConstraints();
        gbc_lespecificacion.insets = new Insets(0, 0, 5, 5);
        gbc_lespecificacion.gridx = 0;
        gbc_lespecificacion.gridy = 4;
        panel.add(lespecificacion, gbc_lespecificacion);

        // Crear las restricciones para los componentes
        GridBagConstraints c;
        gbc_lhora = new GridBagConstraints();
        gbc_lhora.gridx = 0;
        gbc_lhora.gridy = 2;
        gbc_lhora.insets = new Insets(10, 10, 10, 10); // Agregar un margen
        panel.add(lhora, gbc_lhora);
	    
	    JComboBox<LocalTime> boxHora = new JComboBox<LocalTime>();
	    GridBagConstraints gbc_boxHora = new GridBagConstraints();
	    gbc_boxHora.anchor = GridBagConstraints.WEST;
	    gbc_boxHora.insets = new Insets(0, 0, 5, 0);
	    gbc_boxHora.gridx = 1;
	    gbc_boxHora.gridy = 2;
	    panel.add(boxHora, gbc_boxHora);
	    boxHora.addItem(LocalTime.of(13, 0));
        boxHora.addItem(LocalTime.of(13, 30));
        boxHora.addItem(LocalTime.of(14, 0));
        boxHora.addItem(LocalTime.of(14, 30));
        boxHora.addItem(LocalTime.of(15, 0));
        boxHora.addItem(LocalTime.of(15, 30));
        boxHora.addItem(LocalTime.of(20, 30));
        boxHora.addItem(LocalTime.of(21, 0));
        boxHora.addItem(LocalTime.of(21, 30));
        boxHora.addItem(LocalTime.of(22, 0));
        boxHora.addItem(LocalTime.of(22, 30));
	    
	    
	    c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10); // Agregar un margen
        panel.add(lnumpersonas, c);
	    
	 

        // Agregar el panel a la ventana
        getContentPane().add(panel);
        JComboBox<Integer> boxComensales = new JComboBox<Integer>();
        
        c_1 = new GridBagConstraints();
        c_1.anchor = GridBagConstraints.WEST;
        c_1.gridx = 1;
        c_1.gridy = 3;
        c_1.insets = new Insets(10, 0, 10, 10); // Agregar un margen
        panel.add(boxComensales, c_1);
        boxComensales.addItem(1);
        boxComensales.addItem(2);
        boxComensales.addItem(3);
        boxComensales.addItem(4);
        boxComensales.addItem(5);
        boxComensales.addItem(6);
        boxComensales.addItem(7);
        boxComensales.addItem(8);
        boxComensales.addItem(9);
        boxComensales.addItem(10);
        
        JButton bMenu = new JButton("Menu");
        bMenu.setBackground(new Color(255, 0, 0));
        bMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
        		
        	}
        });
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(0, 0, 0, 5);
        gbc_button.gridx = 0;
        gbc_button.gridy = 6;
        panel.add(bMenu, gbc_button);

        // Agregar JButton "Realizar pedido"
        JButton bRealizarPedido = new JButton("Realizar pedido");
        GridBagConstraints gbc_bRealizarPedido = new GridBagConstraints();
        gbc_bRealizarPedido.insets = new Insets(0, 0, 5, 0);
        gbc_bRealizarPedido.gridx = 1;
        gbc_bRealizarPedido.gridy = 0;
        panel.add(bRealizarPedido, gbc_bRealizarPedido);
        bRealizarPedido.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
                Main.getGestorVentanas().getVentanaComidaPedido().setVisible(true);
				dispose();
	        }
	    });

          // Agregar JTextField para especificación
          textEspecificacion = new JTextField();
          GridBagConstraints gbc_textEspecificacion = new GridBagConstraints();
          gbc_textEspecificacion.insets = new Insets(0, 0, 5, 0);
          gbc_textEspecificacion.gridx = 1;
          gbc_textEspecificacion.gridy = 4;
          panel.add(textEspecificacion, gbc_textEspecificacion);
          textEspecificacion.setColumns(10);

          JComboBox<Integer> boxAparcamiento = new JComboBox<Integer>();
        GridBagConstraints gbc_boxAparcamiento = new GridBagConstraints();
        gbc_boxAparcamiento.anchor = GridBagConstraints.WEST;
        gbc_boxAparcamiento.insets = new Insets(0, 0, 5, 0);
        gbc_boxAparcamiento.gridx = 1;
        gbc_boxAparcamiento.gridy = 5;
        panel.add(boxAparcamiento, gbc_boxAparcamiento);
        boxAparcamiento.addItem(0);
        boxAparcamiento.addItem(1);
        boxAparcamiento.addItem(2);
        boxAparcamiento.addItem(3);
        boxAparcamiento.addItem(4);
        boxAparcamiento.addItem(5);


        JButton bConfirmar = new JButton("Confirmar");
        bConfirmar.setBackground(new Color(50, 205, 50));
        bConfirmar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                //Obtener la fecha en formato Date
                SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy");
                Date fechaReserva;
                long token = Main.getExampleClient().getToken();
                String especificacion = textEspecificacion.getText();
                try {
                    fechaReserva = sdf.parse(textFecha.getText());
                    int comensales = (int) boxComensales.getSelectedItem();
                    LocalTime hora = (LocalTime) boxHora.getSelectedItem();
                    PedidoData pedido = new PedidoData(null);
                    int aparcamiento = (int) boxAparcamiento.getSelectedItem();
                    Main.getExampleClient().realizarReserva(fechaReserva, hora, comensales,true,especificacion,pedido, aparcamiento, token);
                } catch (ParseException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
        		Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
        		
        	}
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 6;
        panel.add(bConfirmar, gbc_btnNewButton);


        JLabel laparcamiento = new JLabel("Aparcamiento:");
        GridBagConstraints gbc_laparcamiento = new GridBagConstraints();
        gbc_laparcamiento.insets = new Insets(0, 0, 5, 5);
        gbc_laparcamiento.gridx = 0;
        gbc_laparcamiento.gridy = 5;
        panel.add(laparcamiento, gbc_laparcamiento);

        


        // Configurar las propiedades de la ventana
        setTitle("Reserva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    public int parking(Date fecha){
        //creo un  array de reservas
        List<ReservaData> reservas = Main.getExampleClient().getReservas();
        List<ReservaData> reservasPorFecha = new ArrayList<>();
        for (ReservaData reserva : reservas) {
            if (reserva.getFecha().equals(fecha)) {
                reservasPorFecha.add(reserva);
            }
        }
        for (ReservaData reserva : reservasPorFecha){
            parkingOcupado += reserva.getAparcamiento();
        }
        parkingLibre = parkingTotal - parkingOcupado;
        return parkingLibre;
        
    }
    
}