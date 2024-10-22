package org.example.gestion;

import org.example.modelo.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class GestionPrestamos {
    private List<Prestamo> prestamos;

    public GestionPrestamos() {
        this.prestamos = new ArrayList<>();
    }

    public void añadirPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
        System.out.println("Prestamo añadido a la lista en memoria.");
    }

    public void actualizarPrestamo(Prestamo prestamoActualizado) {
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getIdPrestamo() == prestamoActualizado.getIdPrestamo()) {
                prestamos.set(i, prestamoActualizado);
                System.out.println("Prestamo actualizado en la lista en memoria.");
                break;
            }
        }
    }

    public void eliminarPrestamo(int idPrestamo) {
        prestamos.removeIf(prestamo -> prestamo.getIdPrestamo() == idPrestamo);
        System.out.println("Prestamo eliminado de la lista en memoria.");
    }

    public boolean existePrestamo(int idPrestamo) {
        return prestamos.stream().anyMatch(prestamo -> prestamo.getIdPrestamo() == idPrestamo);
    }

    public void mostrarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay prestamos en la lista.");
        } else {
            for (Prestamo prestamo : prestamos) {
                System.out.println(prestamo);
            }
        }
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}