package org.example.daos;

import org.example.modelo.Usuario;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para crear un nuevo usuario
    public void createUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO Usuario (nombre) VALUES (?)";
        PreparedStatement ps = conexion.prepareStatement(query); {
            ps.setString(1, usuario.getNombre());
            ps.executeUpdate();
        }
    }

    // Método para mostrar todos los usuarios
    public List<Usuario> listaUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql); {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    // Método para actualizar un usuario
    public void updateUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE Usuario SET nombre = ? WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query); {
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getIdUsuario());
            ps.executeUpdate();
        }
    }

    // Método para eliminar un usuario
    public void deleteUsuario(int id) throws SQLException {
        String query = "DELETE FROM Usuario WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query); {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
