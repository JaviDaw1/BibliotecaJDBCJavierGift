package org.example.gestion;

import org.example.modelo.Libro;

import java.util.ArrayList;
import java.util.List;

public class GestionLibros {
    private List<Libro> libros;

    public GestionLibros() {
        this.libros = new ArrayList<>();
    }

    public void añadirLibro(Libro alumno) {
        libros.add(alumno);
        System.out.println("Libro añadido a la lista en memoria.");
    }

    public void actualizarLibro(Libro alumnoActualizado) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIdLibro() == alumnoActualizado.getIdLibro()) {
                libros.set(i, alumnoActualizado);
                System.out.println("Libro actualizado en la lista en memoria.");
                break;
            }
        }
    }

    public void eliminarLibro(int idLibro) {
        libros.removeIf(alumno -> alumno.getIdLibro() == idLibro);
        System.out.println("Libro eliminado de la lista en memoria.");
    }

    public boolean existeLibro(int idLibro) {
        return libros.stream().anyMatch(alumno -> alumno.getIdLibro() == idLibro);
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la lista.");
        } else {
            for (Libro alumno : libros) {
                System.out.println(alumno);
            }
        }
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
