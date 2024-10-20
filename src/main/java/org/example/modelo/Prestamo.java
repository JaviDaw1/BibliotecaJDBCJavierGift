package org.example.modelo;

import java.time.LocalDate;
import java.util.Date;

public class Prestamo {
    private int idPrestamo;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private int idUsuario;
    private int idLibro;

    public Prestamo(int idPresatamo, LocalDate fechaInicio, LocalDate fechaFinal, int idUsuario, int idLibro) {
        this.idPrestamo = idPresatamo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPresatamo) {
        this.idPrestamo = idPresatamo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPresatamo=" + idPrestamo +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", idUsuario=" + idUsuario +
                ", idLibro=" + idLibro +
                '}';
    }
}
