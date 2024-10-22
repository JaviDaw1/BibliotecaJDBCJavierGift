package org.example.daos;

import org.example.conexion.ConexionBD;
import org.example.gestion.GestionPrestamos;
import org.example.modelo.Prestamo;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class PrestamoDAO {
    private Connection conexion;
    private GestionPrestamos gestionPrestamos;

    public PrestamoDAO(GestionPrestamos gestionPrestamos) {
        this.conexion = ConexionBD.getConexion();
        this.gestionPrestamos = gestionPrestamos;
    }

    // Método para crear un nuevo préstamo.
    public void createPrestamo(Prestamo prestamo) throws SQLException {
        String query = "INSERT INTO Prestamo (prestamoId, fechaInicio, fechaFin, idUsuario, idLibro) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(query);
        {
            ps.setInt(1, prestamo.getIdPrestamo());
            ps.setDate(2, Date.valueOf(prestamo.getFechaInicio()));
            ps.setDate(3, prestamo.getFechaFinal());
            ps.setInt(4, prestamo.getIdUsuario());
            ps.setInt(5, prestamo.getIdLibro());
            ps.executeUpdate();
            gestionPrestamos.añadirPrestamo(prestamo);
        }
    }

    // Método para mostrar todos los préstamos
    public List<Prestamo> listaPrestamos() throws SQLException {
        String sql = "SELECT * FROM Prestamo";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);
        {
            while (rs.next()) {
                Prestamo prestamo = new Prestamo(
                        rs.getInt("id"),
                        rs.getDate("fechaInicio").toLocalDate(),
                        rs.getDate("fechaFin"),
                        rs.getInt("usuarioid"),
                        rs.getInt("libroid")
                );
                gestionPrestamos.añadirPrestamo(prestamo);
            }
        }
        return gestionPrestamos.getPrestamos();
    }

    // Método para actualizar un préstamo
    public void updatePrestamo(Prestamo prestamo) throws SQLException {
        String query = "UPDATE Prestamo SET fechaInicio = ?, fechaFin = ?, idUsuario = ?, idLibro = ? WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        {
            ps.setDate(1, Date.valueOf(prestamo.getFechaInicio()));
            ps.setDate(2, prestamo.getFechaFinal());
            ps.setInt(3, prestamo.getIdUsuario());
            ps.setInt(4, prestamo.getIdLibro());
            ps.setInt(5, prestamo.getIdPrestamo());
            ps.executeUpdate();
            gestionPrestamos.actualizarPrestamo(prestamo);
        }
    }

    // Método para eliminar un préstamo
    public void deletePrestamo(int id) throws SQLException {
        String query = "DELETE FROM Prestamo WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        {
            ps.setInt(1, id);
            ps.executeUpdate();
            gestionPrestamos.eliminarPrestamo(id);
        }
    }
}



