package org.example.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Constantes que usamos para conectar con la base de datos como es la URL de la base de datos, usuario y contraseña
public class ConexionBD {
    private static final String URL = "jdbc:mariadb://localhost/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Variable estática que mantiene una única conexión abierta
    private static Connection con = null;

    private ConexionBD() {
        try {
            // Cargar el driver de MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
            // Establecer la conexión con la base de datos utilizando la URL, usuario y contraseña
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static Connection getConexion() {
        if (con == null) {
            new ConexionBD();
        }
        return con;
    }
}