package es.deusto.spq.client.gui;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import es.deusto.spq.main.Main;

import java.util.List;
import java.awt.event.*;

public class VentanaHistoria extends JFrame {

    public VentanaHistoria() {

        setSize(1000, 1000);
        JPanel panel = new JPanel(new BorderLayout());

        // Configurar la ventana
        setTitle("Historia de CookingMama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar el componente JTextArea a la ventana
        JTextArea historiaTextArea = new JTextArea();
        historiaTextArea.setEditable(false);
        historiaTextArea.setText("Bienvenidos a CookingMama, un lugar donde la tradición y la pasión por la comida se unen para ofrecerte una experiencia gastronómica única. Permítenos llevarte en un viaje a través de nuestra historia y descubrir cómo nos hemos convertido en el restaurante que conoces hoy. Desde nuestros humildes comienzos en 1953, nos hemos esforzado por deleitar a nuestros comensales con platos exquisitos y un ambiente acogedor. Nuestro fundador, Leo, tenía una visión clara: crear un lugar donde las personas pudieran disfrutar de sabores auténticos y momentos inolvidables. Desde el principio, nos enfocamos en el sabor. Cada plato que servimos está cuidadosamente elaborado con ingredientes frescos y de alta calidad. Nuestros chefs, con su pasión y experiencia, han perfeccionado cada receta para ofrecerte una explosión de sabores en cada bocado. A medida que nos hemos ido desarrollando, hemos tenido el privilegio de recibir reconocimiento y premios en la industria de la restauración. Estos logros nos han motivado a seguir innovando y sorprendiendo a nuestros clientes con nuevas creaciones culinarias. Pero no somos solo un restaurante, somos una parte integral de nuestra comunidad. Nos enorgullece apoyar a productores locales y utilizar ingredientes de temporada para contribuir a un estilo de vida sostenible. Además, hemos establecido colaboraciones con organizaciones benéficas locales y hemos participado en proyectos comunitarios que nos permiten devolver a aquellos que nos han brindado su apoyo. Hoy en día, estamos emocionados de compartir nuestra pasión culinaria contigo. Nuestro equipo de expertos en servicio al cliente está comprometido en brindarte una experiencia excepcional en cada visita. Nos esforzamos por crear un ambiente acogedor y relajado para que puedas disfrutar de una comida memorable con tus seres queridos. Gracias por ser parte de nuestra historia. Esperamos que tu experiencia en CookingMama sea única y te haga sentir como en casa. ¡Te damos la bienvenida a nuestra mesa y esperamos poder deleitarte con nuestras creaciones culinarias durante muchos años más!");
        historiaTextArea.setForeground(Color.blue);
        historiaTextArea.setLineWrap(true); // Ajusta el texto al ancho del área de texto
        historiaTextArea.setWrapStyleWord(true);
        historiaTextArea.setBackground(Color.decode("#e0a370"));
        panel.add(historiaTextArea, BorderLayout.CENTER);
        panel.setBackground(Color.green);

        // Agregar el panel a la ventana
        


        JButton BAtras = new JButton();
        // Código ejemplo para importar una foto
         URL urlImagenA = getClass().getResource("/fotos/atras.png"); // Obtener URL de la imagen
         ImageIcon imagenA = new ImageIcon(urlImagenA); // Crear ImageIcon a partir de la URL
         BAtras.setBounds(100, 100, 50, 50);
         Icon imagA = new ImageIcon(imagenA.getImage().getScaledInstance(BAtras.getWidth(), BAtras.getHeight(), Image.SCALE_DEFAULT)); 
         BAtras.setIcon(imagA);
        
         BAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getGestorVentanas().getVentanaMenu().setVisible(true);
				dispose();
			}
		});	
        panel.add(BAtras,BorderLayout.SOUTH);
        getContentPane().add(panel);
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }
}
