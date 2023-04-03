package es.deusto.spq.client.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class VentanaModificar extends JFrame {

	private static final long serialVersionUID = 1L;
    private GridBagConstraints gbc_boxNuevosComensales;
    private GridBagConstraints c_2;
    private JTextField textFecha;
    private GridBagConstraints gbc_lhora;

	public VentanaModificar() {
        // Crear un panel principal y establecer un GridBagLayout
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWeights = new double[]{0.0, 0.0};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        JPanel panel = new JPanel(gbl_panel);

        // Crear los componentes que se van a agregar al panel
        JLabel lhora = new JLabel("Nueva hora de la reserva:");
        JLabel lnumpersonas = new JLabel("Nuevo numero de personas:");
        
        JLabel lnuevafecha = new JLabel("Nueva Fecha:");
        GridBagConstraints gbc_lnuevafecha = new GridBagConstraints();
        gbc_lnuevafecha.insets = new Insets(0, 0, 5, 5);
        gbc_lnuevafecha.gridx = 0;
        gbc_lnuevafecha.gridy = 1;
        panel.add(lnuevafecha, gbc_lnuevafecha);
        
        textFecha = new JTextField();
        GridBagConstraints gbc_textFecha = new GridBagConstraints();
        gbc_textFecha.insets = new Insets(0, 0, 5, 0);
        gbc_textFecha.gridx = 1;
        gbc_textFecha.gridy = 1;
        panel.add(textFecha, gbc_textFecha);
        textFecha.setColumns(10);
        
        //Obtener la fecha en formato Date
        String nombre = textFecha.getText();
        SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy");
        Date fechaReserva;
        try {
            fechaReserva = sdf.parse(textFecha.getText());
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
  

        // Crear las restricciones para los componentes
        GridBagConstraints c;
        gbc_lhora = new GridBagConstraints();
        gbc_lhora.gridx = 0;
        gbc_lhora.gridy = 2;
        gbc_lhora.insets = new Insets(10, 10, 10, 10); // Agregar un margen
        panel.add(lhora, gbc_lhora);
	    
	    JComboBox<LocalTime> boxNuevaHora = new JComboBox<LocalTime>();
	    GridBagConstraints gbc_boxNuevaHora = new GridBagConstraints();
	    gbc_boxNuevaHora.anchor = GridBagConstraints.WEST;
	    gbc_boxNuevaHora.insets = new Insets(0, 0, 5, 0);
	    gbc_boxNuevaHora.gridx = 1;
	    gbc_boxNuevaHora.gridy = 2;
	    panel.add(boxNuevaHora, gbc_boxNuevaHora);
	    boxNuevaHora.addItem(LocalTime.of(13, 0));
        boxNuevaHora.addItem(LocalTime.of(13, 30));
        boxNuevaHora.addItem(LocalTime.of(14, 0));
        boxNuevaHora.addItem(LocalTime.of(14, 30));
        boxNuevaHora.addItem(LocalTime.of(15, 0));
        boxNuevaHora.addItem(LocalTime.of(15, 30));
        boxNuevaHora.addItem(LocalTime.of(20, 30));
        boxNuevaHora.addItem(LocalTime.of(21, 0));
        boxNuevaHora.addItem(LocalTime.of(21, 30));
        boxNuevaHora.addItem(LocalTime.of(22, 0));
        boxNuevaHora.addItem(LocalTime.of(22, 30));
	    
	    
	    c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(10, 10, 10, 10); // Agregar un margen
        panel.add(lnumpersonas, c);
	    
	 

        // Agregar el panel a la ventana
        getContentPane().add(panel);
        JComboBox<Integer> boxNuevosComensales = new JComboBox<Integer>();
        
        gbc_boxNuevosComensales = new GridBagConstraints();
        gbc_boxNuevosComensales.anchor = GridBagConstraints.WEST;
        gbc_boxNuevosComensales.gridx = 1;
        gbc_boxNuevosComensales.gridy = 3;
        gbc_boxNuevosComensales.insets = new Insets(10, 0, 10, 10); // Agregar un margen
        panel.add(boxNuevosComensales, gbc_boxNuevosComensales);
        boxNuevosComensales.addItem(1);
        boxNuevosComensales.addItem(2);
        boxNuevosComensales.addItem(3);
        boxNuevosComensales.addItem(4);
        boxNuevosComensales.addItem(5);
        boxNuevosComensales.addItem(6);
        boxNuevosComensales.addItem(7);
        boxNuevosComensales.addItem(8);
        boxNuevosComensales.addItem(9);
        boxNuevosComensales.addItem(10);
        
        JButton bMenu = new JButton("Menu");
        bMenu.setBackground(new Color(255, 0, 0));
        bMenu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
        		
        	}
        });
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.insets = new Insets(0, 0, 0, 5);
        gbc_button.gridx = 0;
        gbc_button.gridy = 5;
        panel.add(bMenu, gbc_button);
        
        JButton bConfirmar = new JButton("Confirmar");
        bConfirmar.setBackground(new Color(50, 205, 50));
        bConfirmar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
        		
        	}
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 5;
        panel.add(bConfirmar, gbc_btnNewButton);
        
       

        // Configurar las propiedades de la ventana
        setTitle("Reserva");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}