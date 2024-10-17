package org.example.modelo;

public class Autor {
    private int idAutor;
    private String nombre;
    private int idLibro;

    public Autor(int idAutor, String nombre, int idLibro) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.idLibro = idLibro;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", idLibro=" + idLibro +
                '}';
    }
}
