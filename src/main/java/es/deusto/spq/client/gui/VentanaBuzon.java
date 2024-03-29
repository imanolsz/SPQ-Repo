package es.deusto.spq.client.gui;

import es.deusto.spq.main.Main;
import es.deusto.spq.pojo.*;
import es.deusto.spq.client.*;
import es.deusto.spq.modelos.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.URL;
import java.util.List;
import java.awt.event.*;
/**
 * @brief La ventana donde los usuarios dejan comentarios para el restaurante
 * Extiende de JFrame para crear la ventana al inicializar la clase.
 */
public class VentanaBuzon extends JFrame {

	private static final long serialVersionUID = 1L;

    // CONSTRUCTOR
    public VentanaBuzon() {

        ExampleClient ec = Main.getExampleClient();

        //creo userdata
        UserData user = new UserData();
        user.setId((Long.toString(Main.getExampleClient().getToken())));
        List<NotificacionData> notificaciones = ec.getNotifications(user);
        
        JButton BAtras = new JButton();
        // Código ejemplo para importar una foto
         URL urlImagenA = getClass().getResource("/fotos/atras.png"); // Obtener URL de la imagen
         ImageIcon imagenA = new ImageIcon(urlImagenA); // Crear ImageIcon a partir de la URL
         BAtras.setBounds(100, 100, 50, 50);
         Icon imagA = new ImageIcon(imagenA.getImage().getScaledInstance(BAtras.getWidth(), BAtras.getHeight(), Image.SCALE_DEFAULT)); 
         BAtras.setIcon(imagA);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("BUZÓN");
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Creamos el modelo de tabla con los datos de los Notificacions
        ModeloTablaNotificacionData modelo = new ModeloTablaNotificacionData(notificaciones);

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
        getContentPane().add(BAtras, BorderLayout.SOUTH);

        // Agregamos un listener a la tabla para actualizar el contenido de la notificacion
        tablaNotificaciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int filaSeleccionada = tablaNotificaciones.getSelectedRow();
                if (filaSeleccionada != -1) { // Si se ha seleccionado una fila
                    NotificacionData notificacionSeleccionada = notificaciones.get(filaSeleccionada);
                    String contenido = notificacionSeleccionada.getContenido();
                    contenidoNotificacion.setText(contenido);
                }
            }
        });
        BAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
			}
		});	
    }
}
