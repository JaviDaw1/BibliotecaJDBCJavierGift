package org.example.modelo;

public class Libro {
    private int idLibro;
    private String titulo;
    private String isbn;

    public Libro(int idLibro, String titulo, String isbn) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    // Getters y setters
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

}
