package es.deusto.spq.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.*;


import java.util.List;

import es.deusto.spq.modelos.ModeloTablaNotificaciones;
import es.deusto.spq.server.jdo.Notificacion;

public class VentanaBuzon extends JFrame {




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Thread t;

    public VentanaBuzon(List<Notificacion> notificaciones) {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("BUZÓN");
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Creamos el modelo de tabla con los datos de los Notificacions
        ModeloTablaNotificaciones modelo = new ModeloTablaNotificaciones(notificaciones);

        // Creamos la tabla con el modelo
        JTable tablaNotificaciones = new JTable(modelo);

        // Agregamos la tabla a un JScrollPane para permitir el desplazamiento
        JScrollPane scrollPaneTabla = new JScrollPane(tablaNotificaciones);

        // Creamos un JTextArea para mostrar el contenido del Notificacion
        JTextArea contenidoNotificacion = new JTextArea();
        contenidoNotificacion.setEditable(false);

        // Agregamos el JTextArea a un JScrollPane para permitir el desplazamiento
        JScrollPane scrollPaneNotificacion = new JScrollPane(contenidoNotificacion);

        // Creamos un panel para la tabla
        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setPreferredSize(new Dimension(400, 600));
        panelTabla.add(scrollPaneTabla, BorderLayout.CENTER);

        // Creamos un panel para el contenido del Notificacion
        JPanel panelNotificacion = new JPanel(new BorderLayout());
        panelNotificacion.setPreferredSize(new Dimension(400, 600));
        panelNotificacion.add(scrollPaneNotificacion, BorderLayout.CENTER);

        // Agregamos los paneles al contenedor principal
        getContentPane().add(panelTabla, BorderLayout.WEST);
        getContentPane().add(panelNotificacion, BorderLayout.CENTER);

        // Agregamos un listener a la tabla para actualizar el contenido de la notificacion
        tablaNotificaciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int filaSeleccionada = tablaNotificaciones.getSelectedRow();
                if (filaSeleccionada != -1) { // Si se ha seleccionado una fila
                    Notificacion notificacionSeleccionada = notificaciones.get(filaSeleccionada);
                    String contenido = notificacionSeleccionada.getContenido();
                    contenidoNotificacion.setText(contenido);
                }
            }
        });

    }

}
