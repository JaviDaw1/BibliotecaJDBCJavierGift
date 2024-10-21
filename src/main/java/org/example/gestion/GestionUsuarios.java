package org.example.gestion;

import org.example.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    private List<Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void añadirUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario añadido a la lista en memoria.");
    }

    public void actualizarUsuario(Usuario usuarioActualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario() == usuarioActualizado.getIdUsuario()) {
                usuarios.set(i, usuarioActualizado);
                System.out.println("Usuario actualizado en la lista en memoria.");
                break;
            }
        }
    }

    public void eliminarUsuario(int idUsuario) {
        usuarios.removeIf(usuario -> usuario.getIdUsuario() == idUsuario);
        System.out.println("Usuario eliminado de la lista en memoria.");
    }

    public boolean existeUsuario(int idUsuario) {
        return usuarios.stream().anyMatch(usuario -> usuario.getIdUsuario() == idUsuario);
    }

    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios en la lista.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
