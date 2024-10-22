package org.example.main;

import org.example.daos.*;
import org.example.gestion.*;
import org.example.modelo.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    // Instancias de las clases de gestión en memoria
    private GestionAutores gestionAutores = new GestionAutores();
    private GestionLibros gestionLibros = new GestionLibros();
    private GestionUsuarios gestionUsuarios = new GestionUsuarios();
    private GestionPrestamos gestionPrestamos = new GestionPrestamos();
    private GestionLibroAutor gestionLibroAutor = new GestionLibroAutor();

    // Instancias de las clases de dao
    private AutorDAO autorDAO = new AutorDAO(gestionAutores);
    private LibroAutorDAO libroAutorDAO = new LibroAutorDAO(gestionLibroAutor);
    private LibroDAO libroDAO = new LibroDAO(gestionLibros);
    private PrestamoDAO prestamoDAO = new PrestamoDAO(gestionPrestamos);
    private UsuarioDAO usuarioDAO = new UsuarioDAO(gestionUsuarios);
    private Scanner scanner = new Scanner(System.in);

    // Método que inicia el programa y carga los datos iniciales desde la base de datos
    public void iniciar() throws SQLException {
        gestionAutores.setAutores(autorDAO.listaAutores());
        gestionLibros.setLibros(libroDAO.listaLibros());
        gestionUsuarios.setUsuarios(usuarioDAO.listaUsuarios());
        gestionPrestamos.setPrestamos(prestamoDAO.listaPrestamos());
        gestionLibroAutor.setLibroAutores(libroAutorDAO.listaLibroAutor());
        cargarDatosIniciales();

        int opcion;
        do {
            // Menú principal de la aplicación
            System.out.println("\nMENU DE GESTION DE BIBLIOTECA");
            System.out.println("1. Gestionar Autores");
            System.out.println("2. Gestionar Libros");
            System.out.println("3. Gestionar Usuarios");
            System.out.println("4. Gestionar Prestamos");
            System.out.println("5. Gestionar Relación Libro-Autor");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestionarAutores();
                    break;
                case 2:
                    gestionarLibros();
                    break;
                case 3:
                    gestionarUsuarios();
                    break;
                case 4:
                    gestionarPrestamos();
                    break;
                case 5:
                    gestionarLibroAutor();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor seleccione una opción correcta.");
                    break;
            }
        } while (opcion != 0);
    }

    private void cargarDatosIniciales() throws SQLException {
        System.out.println("Datos iniciales cargados desde la base de datos.");
    }

    private void gestionarAutores() throws SQLException {
        int opcion;
        do {
            System.out.println("\nGESTION DE AUTORES");
            System.out.println("1. Añadir Autor");
            System.out.println("2. Actualizar Autor");
            System.out.println("3. Eliminar Autor");
            System.out.println("4. Mostrar Autores");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID del autor: ");
                    int idAutor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre del autor: ");
                    String nombre = scanner.nextLine();
                    autorDAO.createAutor(new Autor(idAutor, nombre));
                    break;
                case 2:
                    System.out.print("ID del autor a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo nombre del autor: ");
                    String nuevoNombre = scanner.nextLine();
                    autorDAO.updateAutor(new Autor(idActualizar, nuevoNombre));
                    System.out.println("El autor no existe.");
                    break;
                case 3:
                    System.out.print("ID del autor a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    autorDAO.deleteAutor(idEliminar);
                    break;
                case 4:
                    gestionAutores.mostrarAutores();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    private void gestionarLibros() throws SQLException {
        int opcion;
        do {
            System.out.println("\nGESTION DE LIBROS");
            System.out.println("1. Añadir Libro");
            System.out.println("2. Actualizar Libro");
            System.out.println("3. Eliminar Libro");
            System.out.println("4. Mostrar Libros");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID del libro: ");
                    int idLibro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("ISBN del libro: ");
                    String isbn = scanner.nextLine();
                    libroDAO.createLibro(new Libro(idLibro, titulo, isbn));
                    break;
                case 2:
                    System.out.print("ID del libro a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo título del libro: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Nuevo ISBN del libro: ");
                    String nuevoIsbn = scanner.nextLine();
                    libroDAO.updateLibro(new Libro(idActualizar, nuevoTitulo, nuevoIsbn));
                    System.out.println("El libro no existe.");

                    break;
                case 3:
                    System.out.print("ID del libro a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    libroDAO.deleteLibro(idEliminar);
                    break;
                case 4:
                    gestionLibros.mostrarLibros();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    private void gestionarUsuarios() throws SQLException {
        int opcion;
        do {
            System.out.println("\nGESTION DE USUARIOS");
            System.out.println("1. Añadir Usuario");
            System.out.println("2. Actualizar Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Mostrar Usuarios");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID del usuario: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    usuarioDAO.createUsuario(new Usuario(idUsuario, nombre));
                    break;
                case 2:
                    System.out.print("ID del usuario a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo nombre del usuario: ");
                    String nuevoNombre = scanner.nextLine();
                    usuarioDAO.updateUsuario(new Usuario(idActualizar, nuevoNombre));
                    System.out.println("El usuario no existe.");
                    break;
                case 3:
                    System.out.print("ID del usuario a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    usuarioDAO.deleteUsuario(idEliminar);
                    break;
                case 4:
                    gestionUsuarios.mostrarUsuarios();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    private void gestionarPrestamos() throws SQLException {
        int opcion;
        do {
            System.out.println("\nGESTION DE PRESTAMOS");
            System.out.println("1. Añadir Préstamo");
            System.out.println("2. Actualizar Préstamo");
            System.out.println("3. Eliminar Préstamo");
            System.out.println("4. Mostrar Préstamos");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID del préstamo: ");
                    int idPrestamo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Fecha de inicio (YYYY-MM-DD): ");
                    String fechaInicio = scanner.nextLine();
                    System.out.print("Fecha final (YYYY-MM-DD): ");
                    String fechaFinal = scanner.nextLine();
                    System.out.print("ID del usuario: ");
                    int idUsuario = scanner.nextInt();
                    System.out.print("ID del libro: ");
                    int idLibro = scanner.nextInt();
                    prestamoDAO.createPrestamo(new Prestamo(idPrestamo, LocalDate.parse(fechaInicio), java.sql.Date.valueOf(fechaFinal), idUsuario, idLibro));
                    break;
                case 2:
                    System.out.print("ID del préstamo a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nueva fecha de inicio (YYYY-MM-DD): ");
                    String nuevaFechaInicio = scanner.nextLine();
                    System.out.print("Nueva fecha final (YYYY-MM-DD): ");
                    String nuevaFechaFinal = scanner.nextLine();
                    System.out.print("ID del usuario: ");
                    int nuevoIdUsuario = scanner.nextInt();
                    System.out.print("ID del libro: ");
                    int nuevoIdLibro = scanner.nextInt();
                    prestamoDAO.updatePrestamo(new Prestamo(idActualizar, LocalDate.parse(nuevaFechaInicio), java.sql.Date.valueOf(nuevaFechaFinal), nuevoIdUsuario, nuevoIdLibro));
                    System.out.println("El préstamo no existe.");
                    break;
                case 3:
                    System.out.print("ID del préstamo a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    prestamoDAO.deletePrestamo(idEliminar);
                    break;
                case 4:
                    gestionPrestamos.mostrarPrestamos();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    private void gestionarLibroAutor() throws SQLException {
        int opcion;
        do {
            System.out.println("\nGESTION DE RELACION LIBRO-AUTOR");
            System.out.println("1. Añadir Relación Libro-Autor");
            System.out.println("2. Eliminar Relación Libro-Autor");
            System.out.println("3. Mostrar Relaciones Libro-Autor");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID del libro: ");
                    int idLibro = scanner.nextInt();
                    System.out.print("ID del autor: ");
                    int idAutor = scanner.nextInt();
                    libroAutorDAO.anadirAutorALibro(new LibroAutor(idLibro, idAutor));
                    break;
                case 2:
                    System.out.print("ID del libro: ");
                    int idLibroEliminar = scanner.nextInt();
                    System.out.print("ID del autor: ");
                    int idAutorEliminar = scanner.nextInt();
                    libroAutorDAO.delete(idLibroEliminar, idAutorEliminar);
                    break;
                case 3:
                    gestionLibroAutor.mostrarLibroAutores();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }
}
