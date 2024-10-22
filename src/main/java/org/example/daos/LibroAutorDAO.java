package org.example.daos;

import org.example.conexion.ConexionBD;
import org.example.gestion.GestionLibroAutor;
import org.example.modelo.Libro;
import org.example.modelo.LibroAutor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroAutorDAO {
    private Connection conexion;
    private GestionLibroAutor gestionLibroAutor;

    public LibroAutorDAO(GestionLibroAutor gestionLibroAutor) {
        this.conexion = ConexionBD.getConexion();
        this.gestionLibroAutor = gestionLibroAutor;
    }

    public void anadirAutorALibro(LibroAutor libroAutor) throws SQLException {
        String query = "INSERT INTO Libro_Autor (idLibro, idAutor) VALUES (?, ?)";

        PreparedStatement ps = conexion.prepareStatement(query);
        {
            ps.setInt(1, libroAutor.getIdAutor());
            ps.setInt(2, libroAutor.getIdLibro());
            ps.executeUpdate();
            gestionLibroAutor.añadirLibroAutor(libroAutor);
        }
    }

    public List<LibroAutor> listaLibroAutor() throws SQLException {
        String sql = "SELECT * FROM Libro_Autor";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);
        {
            while (rs.next()) {
                LibroAutor libroAutor = new LibroAutor(
                        rs.getInt("idAutor"),
                        rs.getInt("idLibro")
                );
                gestionLibroAutor.añadirLibroAutor(libroAutor);
            }
        }
        return gestionLibroAutor.getLibroAutores();
    }
    public void delete(int idLibro, int idUsuario) throws SQLException {
        String elimina = "DELETE FROM Libro_Autor WHERE idLibro=?, idUsuario= ?";
        try (PreparedStatement ps = conexion.prepareStatement(elimina)) {
            ps.setInt(1, idLibro);
            ps.setInt(2, idUsuario);
            ps.executeUpdate();
            gestionLibroAutor.eliminarLibroAutor(idLibro, idUsuario);
        }
        System.out.println("Alumno eliminado");
    }
}
