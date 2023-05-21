package es.deusto.spq.client.gui;

import es.deusto.spq.main.Main;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaHorario extends JFrame {
    private JLabel labelDia;
    private JComboBox<String> comboBoxDias;
    private JLabel labelComida;
    private JLabel labelCena;

    public VentanaHorario() {
        // Configuración de la ventana
        setTitle("Horarios de comida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // Utilizamos GridBagLayout

        // Crear restricciones para el diseño de GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL; // Expandir componentes horizontalmente
        constraints.insets = new Insets(10, 10, 10, 10); // Espacios entre los componentes

        // Label "Día"
        labelDia = new JLabel("Día de la semana:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(labelDia, constraints);

        // ComboBox de los días de la semana
        comboBoxDias = new JComboBox<>(new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"});
        comboBoxDias.addActionListener(new ComboBoxListener());
        constraints.gridx = 1;
        add(comboBoxDias, constraints);

        // Label "Comida"
        labelComida = new JLabel("Horario de comida:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(labelComida, constraints);

        // Label "Cena"
        labelCena = new JLabel("Horario de cena:");
        constraints.gridy = 2;
        add(labelCena, constraints);

        // Botón "Atrás"
        JButton botonAtras = new JButton("Atrás");
        botonAtras.addActionListener(new AtrasButtonListener());
        constraints.gridy = 3;
        add(botonAtras, constraints);

        // Ajustar tamaño y mostrar la ventana
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    // Clase interna para manejar los eventos de selección de la ComboBox
    private class ComboBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String diaSeleccionado = (String) comboBoxDias.getSelectedItem();

            // Asignar el rango de horas según el día seleccionado
            switch (diaSeleccionado) {
                case "Lunes":
                    labelComida.setText("Horario de comida: 13:00 - 15:00");
                    labelCena.setText("Horario de cena: 20:30 - 23:00");
                    break;
                case "Martes":
                    labelComida.setText("Horario de comida: DESCANSO SEMANAL");
                    labelCena.setText("Horario de cena: DESCANSO SEMANAL");
                    break;
                case "Miércoles":
                    labelComida.setText("Horario de comida: 13:00 - 15:00");
                    labelCena.setText("Horario de cena: 20:30 - 23:00");
                    break;
                case "Jueves":
                    labelComida.setText("Horario de comida: 13:00 - 15:00");
                    labelCena.setText("Horario de cena: 20:30 - 23:00");
                    break;
                case "Viernes":
                    labelComida.setText("Horario de comida: 13:00 - 16:00");
                    labelCena.setText("Horario de cena: 20:00 - 00:00");
                    break;
                case "Sábado":
                    labelComida.setText("Horario de comida: 12:30 - 16:30");
                    labelCena.setText("Horario de cena: 20:00 - 00:30");
                    break;
                case "Domingo":
                    labelComida.setText("Horario de comida: 12:30 - 16:30");
                    labelCena.setText("Horario de cena: 21:00 - 00:00");
                    break;
            }
        }
    }

    // Clase interna para manejar el evento del botón "Atrás"
    private class AtrasButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
    }

}
