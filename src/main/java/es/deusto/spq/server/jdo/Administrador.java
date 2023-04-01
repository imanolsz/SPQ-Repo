package es.deusto.spq.server.jdo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Administrador {
    
    private Connection connection; // La conexión a la base de datos SQL
    
    public Administrador() {
        
        // Creamos la conexión a la base de datos
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/create-messages?useSSL=false", "spq", "spq");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void obtenerReservas() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Reservas");
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");
                int cantidadPersonas = resultSet.getInt("cantidad_personas");
                boolean cancelada = resultSet.getBoolean("Cancelada");
                
                if (cancelada) {
                    System.out.println("Reserva cancelada:");
                } else {
                    System.out.println("Reserva confirmada:");
                }
                
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Fecha: " + fecha);
                System.out.println("Hora: " + hora);
                System.out.println("Cantidad de personas: " + cantidadPersonas);
                System.out.println();
            }
            
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

  
