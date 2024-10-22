package org.example.daos;

import org.example.conexion.ConexionBD;
import org.example.gestion.GestionLibros;
import org.example.modelo.Libro;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class LibroDAO {
    private Connection conexion;
    private GestionLibros gestionLibros;

    public LibroDAO(GestionLibros gestionLibros) {
        this.conexion = ConexionBD.getConexion();
        this.gestionLibros = gestionLibros;
    }

    // Método para crear un nuevo libro
    public void createLibro(Libro libro) throws SQLException {
        String query = "INSERT INTO Libro (titulo, isbn) VALUES (?, ?)";
        PreparedStatement ps = conexion.prepareStatement(query);
        {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
            ps.executeUpdate();
            gestionLibros.añadirLibro(libro);
        }
    }

    // Método para listar los  libros
    public List<Libro> listaLibros() throws SQLException {
        String sql = "SELECT * FROM Libro";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);
        {
            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("isbn")
                );
                gestionLibros.añadirLibro(libro);
            }
        }
        return gestionLibros.getLibros();
    }

    // Método para actualizar un nuevo libro
    public void updateLibro(Libro libro) throws SQLException {
        String query = "UPDATE Libro SET titulo = ?, isbn = ? WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getIsbn());
            ps.setInt(3, libro.getIdLibro());
            ps.executeUpdate();
            gestionLibros.actualizarLibro(libro);
        }
    }

    // Método para borrar un nuevo libro
    public void deleteLibro(int id) throws SQLException {
        String query = "DELETE FROM Libro WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        {
            ps.setInt(1, id);
            ps.executeUpdate();
            gestionLibros.eliminarLibro(id);
        }
    }
}
