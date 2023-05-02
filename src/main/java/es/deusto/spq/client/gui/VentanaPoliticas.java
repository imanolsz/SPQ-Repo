package es.deusto.spq.client.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPoliticas extends JDialog {

    public VentanaPoliticas(JFrame parent) {
        // Título de la ventana
        super(parent, "Políticas y Cookies - Restaurante", true); // Usamos JDialog para que sea modal

        // Panel superior con etiqueta de título
        JPanel panelTitulo = new JPanel();
        panelTitulo.add(new JLabel("<html><h3>Políticas y Cookies - Restaurante</h3></html>"));

        // JEditorPane con políticas y cookies
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false); // deshabilitar la edición del contenido
        editorPane.setContentType("text/html");
        editorPane.setText("<html>"
                + "<p style=\"text-align:justify;\">En nuestro restaurante nos preocupamos por ofrecer a nuestros clientes la mejor experiencia culinaria posible. "
                + "Para lograrlo, utilizamos cookies y otras tecnologías para recopilar información sobre el uso que hacen nuestros clientes de nuestra web. "
                + "Esto nos ayuda a personalizar y mejorar su experiencia, y a mantener un registro de sus preferencias para futuras visitas.</p>"
                + "<p style=\"text-align:justify;\">Nos comprometemos a respetar la privacidad de nuestros clientes y a proteger sus datos personales de acuerdo con las leyes y regulaciones aplicables. "
                + "Si tienes alguna pregunta sobre nuestras políticas de privacidad o cookies, no dudes en ponerte en contacto con nosotros.</p>"
                + "<p style=\"text-align:justify;\">Gracias por confiar en nosotros.</p>"
                + "</html>");

        // JScrollPane para permitir desplazamiento por el contenido
        JScrollPane scrollPane = new JScrollPane(editorPane);

        // Panel inferior con botón de aceptar
        JPanel panelBoton = new JPanel();
        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana
            }
        });
        panelBoton.add(botonAceptar);

        // Configuramos las propiedades de la ventana
        setLayout(new BorderLayout());
        add(panelTitulo, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);
        setPreferredSize(new Dimension(500, 400)); // Establecemos un tamaño medio por defecto
        
        // Centrar la ventana de políticas en el centro de la ventana padre
        SwingUtilities.invokeLater(() -> {
            int x = (int) ((parent.getWidth() - this.getWidth()) / 2) + parent.getX();
            int y = (int) ((parent.getHeight() - this.getHeight()) / 2) + parent.getY();
            this.setLocation(x, y);
        });

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Usamos DISPOSE_ON_CLOSE para que solo cierre esta ventana
        pack();
        setVisible(true);
    }
}


