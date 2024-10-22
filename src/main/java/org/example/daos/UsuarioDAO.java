package org.example.daos;

import org.example.conexion.ConexionBD;
import org.example.gestion.GestionUsuarios;
import org.example.modelo.Usuario;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO {
    private Connection conexion;
    private GestionUsuarios gestionUsuarios;

    public UsuarioDAO(GestionUsuarios gestionUsuarios) {
        this.conexion = ConexionBD.getConexion();
        this.gestionUsuarios = gestionUsuarios;
    }

    // Método para crear un nuevo usuario
    public void createUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO Usuario (nombre) VALUES (?)";
        PreparedStatement ps = conexion.prepareStatement(query);
        {
            ps.setString(1, usuario.getNombre());
            ps.executeUpdate();
        }
    }

    // Método para mostrar todos los usuarios
    public List<Usuario> listaUsuarios() throws SQLException {
        String sql = "SELECT * FROM Usuario";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);
        {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                gestionUsuarios.añadirUsuario(usuario);
            }
        }
        return gestionUsuarios.getUsuarios();
    }

    // Método para actualizar un usuario
    public void updateUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE Usuario SET nombre = ? WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        {
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getIdUsuario());
            ps.executeUpdate();
            gestionUsuarios.actualizarUsuario(usuario);
        }
    }

    // Método para eliminar un usuario
    public void deleteUsuario(int id) throws SQLException {
        String query = "DELETE FROM Usuario WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        {
            ps.setInt(1, id);
            ps.executeUpdate();
            gestionUsuarios.eliminarUsuario(id);
        }
    }
}
