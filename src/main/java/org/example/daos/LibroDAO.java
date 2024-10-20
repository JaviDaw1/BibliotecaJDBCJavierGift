package org.example.daos;

import org.example.modelo.Libro;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class LibroDAO {
    private Connection conexion;

    public LibroDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void createLibro(Libro libro) throws SQLException {
        String query = "INSERT INTO Libro (titulo, isbn) VALUES (?, ?)";
        PreparedStatement ps = conexion.prepareStatement(query); {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
            ps.executeUpdate();
        }
    }

    public List<Libro> listaLibros() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libro";
             Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql); {
            while (rs.next()) {
               Libro libro = new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("isbn"), rs.getInt("idAutor"));
                libros.add(libro);
            }
        }
        return libros;
    }

    public void updateLibro(Libro libro) throws SQLException {
        String query = "UPDATE Libro SET titulo = ?, isbn = ? WHERE id = ?";
             PreparedStatement ps = conexion.prepareStatement(query); {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
           ps.setInt(3, libro.getIdLibro());
            ps.executeUpdate();
        }
    }

    public void deleteLibro(int id) throws SQLException {
        String query = "DELETE FROM Libro WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query); {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
