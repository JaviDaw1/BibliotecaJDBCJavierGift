package org.example.gestion;

import org.example.modelo.Autor;

import java.util.ArrayList;
import java.util.List;

public class GestionAutores {

    private List<Autor> autores;

    public GestionAutores() {
        this.autores = new ArrayList<>();
    }

    public void añadirAutor(Autor autor) {
        autores.add(autor);
        System.out.println("Autor añadido a la lista en memoria.");
    }

    public void actualizarAutor(Autor autorActualizado) {
        for (int i = 0; i < autores.size(); i++) {
            if (autores.get(i).getIdAutor() == autorActualizado.getIdAutor()) {
                autores.set(i, autorActualizado);
                System.out.println("Autor actualizado en la lista en memoria.");
                break;
            }
        }
    }

    public void eliminarAutor(int idAutor) {
        autores.removeIf(autor -> autor.getIdAutor() == idAutor);
        System.out.println("Autor eliminado de la lista en memoria.");
    }

    public boolean existeAutor(int idAutor) {
        return autores.stream().anyMatch(autor -> autor.getIdAutor() == idAutor);
    }

    public void mostrarAutores() {
        if (autores.isEmpty()) {
            System.out.println("No hay autores en la lista.");
        } else {
            for (Autor autor : autores) {
                System.out.println(autor);
            }
        }
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
