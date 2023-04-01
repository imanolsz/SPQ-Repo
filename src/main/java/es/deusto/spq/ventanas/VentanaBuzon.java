package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import es.deusto.spq.restaurante.Mensaje;
import es.deusto.spq.modelos.ModeloTablaMensajes;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.net.URL;
import javax.swing.JTextArea;

import es.deusto.spq.main.Main;



public class VentanaBuzon extends JFrame {




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Thread t;

    public VentanaBuzon(List<Mensaje> mensajes) {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("BUZÓN");
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Creamos el modelo de tabla con los datos de los mensajes
        ModeloTablaMensajes modelo = new ModeloTablaMensajes(mensajes);

        // Creamos la tabla con el modelo
        JTable tablaMensajes = new JTable(modelo);

        // Agregamos la tabla a un JScrollPane para permitir el desplazamiento
        JScrollPane scrollPaneTabla = new JScrollPane(tablaMensajes);

        // Creamos un JTextArea para mostrar el contenido del mensaje
        JTextArea contenidoMensaje = new JTextArea();
        contenidoMensaje.setEditable(false);

        // Agregamos el JTextArea a un JScrollPane para permitir el desplazamiento
        JScrollPane scrollPaneMensaje = new JScrollPane(contenidoMensaje);

        // Creamos un panel para la tabla
        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setPreferredSize(new Dimension(400, 600));
        panelTabla.add(scrollPaneTabla, BorderLayout.CENTER);

        // Creamos un panel para el contenido del mensaje
        JPanel panelMensaje = new JPanel(new BorderLayout());
        panelMensaje.setPreferredSize(new Dimension(400, 600));
        panelMensaje.add(scrollPaneMensaje, BorderLayout.CENTER);

        // Agregamos los paneles al contenedor principal
        getContentPane().add(panelTabla, BorderLayout.WEST);
        getContentPane().add(panelMensaje, BorderLayout.CENTER);

        // Agregamos un listener a la tabla para actualizar el contenido del mensaje
        tablaMensajes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int filaSeleccionada = tablaMensajes.getSelectedRow();
                if (filaSeleccionada != -1) { // Si se ha seleccionado una fila
                    Mensaje mensajeSeleccionado = mensajes.get(filaSeleccionada);
                    String contenido = mensajeSeleccionado.getContenido();
                    contenidoMensaje.setText(contenido);
                }
            }
        });

    }

}
