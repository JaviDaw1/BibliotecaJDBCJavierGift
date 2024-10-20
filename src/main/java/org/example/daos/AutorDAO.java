package org.example.daos;

import org.example.modelo.Autor;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class AutorDAO {
    private Connection conexion;

    public AutorDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para crear un nuevo autor
    public void createAutor(Autor autor) throws SQLException {
        String query = "INSERT INTO Autor (nombre) VALUES (?)";
        PreparedStatement ps = conexion.prepareStatement(query); {
            ps.setString(1, autor.getNombre());
            ps.executeUpdate();
        }
    }

    // Método para mostrar todos los autores
    public List<Autor> listaAutores() throws SQLException {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM Autor";
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql); {
            while (rs.next()) {
                Autor autor = new Autor(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                autores.add(autor);
            }
        }
        return autores;
    }

    // Método para actualizar un autor
    public void updateAutor(Autor autor) throws SQLException {
        String query = "UPDATE Autor SET nombre = ? WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query); {
            ps.setString(1, autor.getNombre());
            ps.setInt(2, autor.getIdAutor());
            ps.executeUpdate();
        }
    }

    // Método para eliminar un autor
    public void deleteAutor(int id) throws SQLException {
        String query = "DELETE FROM Autor WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(query); {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

