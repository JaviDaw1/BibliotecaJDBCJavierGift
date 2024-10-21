package org.example.gestion;

import org.example.modelo.LibroAutor;

import java.util.ArrayList;
import java.util.List;

public class GestionLibroAutor {
    private List<LibroAutor> libroAutores;

    public GestionLibroAutor() {
        this.libroAutores = new ArrayList<>();
    }

    public void añadirLibroAutor(LibroAutor libroAutor) {
        libroAutores.add(libroAutor);
        System.out.println("Relación Libro-Autor añadida a la lista en memoria");
    }

    public void actualizarLibroAutor(LibroAutor libroAutorActualizado) {
        for (int i = 0; i < libroAutores.size(); i++) {
            if (libroAutores.get(i).getIdLibro() == libroAutorActualizado.getIdLibro() &&
                    libroAutores.get(i).getIdAutor() == libroAutorActualizado.getIdAutor()) {
                libroAutores.set(i, libroAutorActualizado);
                System.out.println("Relación Libro-Autor actualizada en la lista en memoria");
                break;
            }
        }
    }

    public void eliminarLibroAutor(int idLibro, int idAutor) {
        libroAutores.removeIf(libroAutor ->
                libroAutor.getIdLibro() == idLibro && libroAutor.getIdAutor() == idAutor);
        System.out.println("Relación Libro-Autor eliminada de la lista en memoria");
    }

    public boolean existeLibroAutor(int idLibro, int idAutor) {
        return libroAutores.stream().anyMatch(libroAutor ->
                libroAutor.getIdLibro() == idLibro && libroAutor.getIdAutor() == idAutor);
    }

    public void mostrarLibroAutores() {
        if (libroAutores.isEmpty()) {
            System.out.println("No hay relaciones Libro-Autor en la lista");
        } else {
            for (LibroAutor libroAutor : libroAutores) {
                System.out.println(libroAutor);
            }
        }
    }

    public List<LibroAutor> getLibroAutores() {
        return libroAutores;
    }

    public void setLibroAutores(List<LibroAutor> libroAutores) {
        this.libroAutores = libroAutores;
    }
}
