package org.example.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibroAutorDAO {
    private Connection conexion;

    public LibroAutorDAO(Connection conexion) {
        this.conexion = conexion;
    }
        public void anadirAutorALibro(int idLibro, int idAutor) throws SQLException {
            String query = "INSERT INTO Libro_Autor (idLibro, idAutor) VALUES (?, ?)";

            PreparedStatement ps = conexion.prepareStatement(query); {
                ps.setInt(1, idLibro);
                ps.setInt(2, idAutor);
                ps.executeUpdate();
        }
    }
}
