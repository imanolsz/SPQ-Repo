package es.deusto.spq.client.gui;
import javax.swing.JOptionPane;


public class VentanaConfirmacion {

    public static void mostrarMensaje() {
        JOptionPane.showMessageDialog(null, "Su reserva ha sido creada satisfactoriamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }
}
