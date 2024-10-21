package org.example.gestion;

import org.example.modelo.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class GestionPresatamos {
    private List<Prestamo> presatamos;

    public GestionPresatamos() {
        this.presatamos = new ArrayList<>();
    }

    public void añadirPrestamo(Prestamo prestamo) {
        presatamos.add(prestamo);
        System.out.println("Prestamo añadido a la lista en memoria.");
    }

    public void actualizarPrestamo(Prestamo prestamoActualizado) {
        for (int i = 0; i < presatamos.size(); i++) {
            if (presatamos.get(i).getIdPrestamo() == prestamoActualizado.getIdPrestamo()) {
                presatamos.set(i, prestamoActualizado);
                System.out.println("Prestamo actualizado en la lista en memoria.");
                break;
            }
        }
    }

    public void eliminarPrestamo(int idPrestamo) {
        presatamos.removeIf(prestamo -> prestamo.getIdPrestamo() == idPrestamo);
        System.out.println("Prestamo eliminado de la lista en memoria.");
    }

    public boolean existePrestamo(int idPrestamo) {
        return presatamos.stream().anyMatch(prestamo -> prestamo.getIdPrestamo() == idPrestamo);
    }

    public void mostrarPrestamos() {
        if (presatamos.isEmpty()) {
            System.out.println("No hay presatamos en la lista.");
        } else {
            for (Prestamo prestamo : presatamos) {
                System.out.println(prestamo);
            }
        }
    }

    public List<Prestamo> getPrestamos() {
        return presatamos;
    }

    public void setPrestamos(List<Prestamo> presatamos) {
        this.presatamos = presatamos;
    }
}