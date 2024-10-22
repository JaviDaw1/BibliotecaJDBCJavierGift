package org.example.modelo;

import java.time.LocalDate;
import java.util.Date;

public class Prestamo {
    private int idPrestamo;
    private LocalDate fechaInicio;
    private Date fechaFinal;
    private int idUsuario;
    private int idLibro;

    public Prestamo(int idPrestamo, LocalDate fechaInicio, Date fechaFinal, int idUsuario, int idLibro) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }

    // Getters y setters
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public java.sql.Date getFechaFinal() {
        return (java.sql.Date) fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
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
                "idPrestamo=" + idPrestamo +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", idUsuario=" + idUsuario +
                ", idLibro=" + idLibro +
                '}';
    }
}
