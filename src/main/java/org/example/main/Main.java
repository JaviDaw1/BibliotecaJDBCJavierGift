package org.example.main;

import org.example.gestion.GestionAutores;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.iniciar();
    }
}