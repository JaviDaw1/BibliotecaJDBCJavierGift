package org.example.modelo;

import java.time.LocalDate;
import java.util.Date;

public class Prestamo {
    private int idPresatamo;
    private LocalDate fechaInicio;
    private Date fechaFinal;
    private int idUsuario;
    private int idLibro;

    public Prestamo(int idPresatamo, LocalDate fechaInicio, Date fechaFinal, int idUsuario, int idLibro) {
        this.idPresatamo = idPresatamo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }

    public int getIdPresatamo() {
        return idPresatamo;
    }

    public void setIdPresatamo(int idPresatamo) {
        this.idPresatamo = idPresatamo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
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
                "idPresatamo=" + idPresatamo +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", idUsuario=" + idUsuario +
                ", idLibro=" + idLibro +
                '}';
    }
}
