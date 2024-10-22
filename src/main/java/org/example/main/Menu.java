package org.example.main;

import org.example.gestion.*;
import org.example.modelo.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Menu {

 private GestionAutores gestionAutores = new GestionAutores();
 private GestionLibros gestionLibros = new GestionLibros();
 private GestionUsuarios gestionUsuarios = new GestionUsuarios();
 private GestionPrestamos gestionPrestamos = new GestionPrestamos();
 private GestionLibroAutor gestionLibroAutor = new GestionLibroAutor();
 private Scanner scanner = new Scanner(System.in);

 public void iniciar() {
  int opcion;
  do {
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

 private void gestionarAutores() {
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
     System.out.print("Nombre del autor: ");
     scanner.nextLine();
     String nombre = scanner.nextLine();
     gestionAutores.añadirAutor(new Autor(idAutor, nombre));
     break;
    case 2:
     System.out.print("ID del autor a actualizar: ");
     int idActualizar = scanner.nextInt();
     if (gestionAutores.existeAutor(idActualizar)) {
      System.out.print("Nuevo nombre del autor: ");
      scanner.nextLine();
      String nuevoNombre = scanner.nextLine();
      gestionAutores.actualizarAutor(new Autor(idActualizar, nuevoNombre));
     } else {
      System.out.println("El autor no existe.");
     }
     break;
    case 3:
     System.out.print("ID del autor a eliminar: ");
     int idEliminar = scanner.nextInt();
     gestionAutores.eliminarAutor(idEliminar);
     break;
    case 4:
     gestionAutores.mostrarAutors();
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

 private void gestionarLibros() {
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
     System.out.print("Título del libro: ");
     scanner.nextLine();
     String titulo = scanner.nextLine();
     System.out.print("ISBN del libro: ");
     String isbn = scanner.nextLine();
     gestionLibros.añadirLibro(new Libro(idLibro, titulo, isbn));
     break;
    case 2:
     System.out.print("ID del libro a actualizar: ");
     int idActualizar = scanner.nextInt();
     if (gestionLibros.existeLibro(idActualizar)) {
      System.out.print("Nuevo título del libro: ");
      scanner.nextLine();
      String nuevoTitulo = scanner.nextLine();
      System.out.print("Nuevo ISBN del libro: ");
      String nuevoIsbn = scanner.nextLine();
      gestionLibros.actualizarLibro(new Libro(idActualizar, nuevoTitulo, nuevoIsbn));
     } else {
      System.out.println("El libro no existe.");
     }
     break;
    case 3:
     System.out.print("ID del libro a eliminar: ");
     int idEliminar = scanner.nextInt();
     gestionLibros.eliminarLibro(idEliminar);
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

 private void gestionarUsuarios() {
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
     System.out.print("Nombre del usuario: ");
     scanner.nextLine();
     String nombre = scanner.nextLine();
     gestionUsuarios.añadirUsuario(new Usuario(idUsuario, nombre));
     break;
    case 2:
     System.out.print("ID del usuario a actualizar: ");
     int idActualizar = scanner.nextInt();
     if (gestionUsuarios.existeUsuario(idActualizar)) {
      System.out.print("Nuevo nombre del usuario: ");
      scanner.nextLine();
      String nuevoNombre = scanner.nextLine();
      gestionUsuarios.actualizarUsuario(new Usuario(idActualizar, nuevoNombre));
     } else {
      System.out.println("El usuario no existe.");
     }
     break;
    case 3:
     System.out.print("ID del usuario a eliminar: ");
     int idEliminar = scanner.nextInt();
     gestionUsuarios.eliminarUsuario(idEliminar);
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

 private void gestionarPrestamos() {
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
     System.out.print("Fecha de inicio (YYYY-MM-DD): ");
     LocalDate fechaInicio = LocalDate.parse(scanner.next());
     System.out.print("Fecha final (YYYY-MM-DD): ");
     Date fechaFinal = java.sql.Date.valueOf(scanner.next());
     System.out.print("ID del usuario: ");
     int idUsuario = scanner.nextInt();
     System.out.print("ID del libro: ");
     int idLibro = scanner.nextInt();
     gestionPrestamos.añadirPrestamo(new Prestamo(idPrestamo, fechaInicio, fechaFinal, idUsuario, idLibro));
     break;
    case 2:
     System.out.print("ID del préstamo a actualizar: ");
     int idActualizar = scanner.nextInt();
     if (gestionPrestamos.existePrestamo(idActualizar)) {
      System.out.print("Nueva fecha de inicio (YYYY-MM-DD): ");
      LocalDate nuevaFechaInicio = LocalDate.parse(scanner.next());
      System.out.print("Nueva fecha final (YYYY-MM-DD): ");
      Date nuevaFechaFinal = java.sql.Date.valueOf(scanner.next());
      System.out.print("Nuevo ID del usuario: ");
      int nuevoIdUsuario = scanner.nextInt();
      System.out.print("Nuevo ID del libro: ");
      int nuevoIdLibro = scanner.nextInt();
      Prestamo prestamoActualizado = new Prestamo(idActualizar, nuevaFechaInicio, nuevaFechaFinal, nuevoIdUsuario, nuevoIdLibro);
      gestionPrestamos.actualizarPrestamo(prestamoActualizado);
     } else {
      System.out.println("El préstamo no existe.");
     }
     break;
    case 3:
     System.out.print("ID del préstamo a eliminar: ");
     int idEliminar = scanner.nextInt();
     gestionPrestamos.eliminarPrestamo(idEliminar);
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
 private void gestionarLibroAutor() {
  int opcion;
  do {
   System.out.println("\n--- Gestionar Relación Libro-Autor ---");
   System.out.println("1. Añadir Relación Libro-Autor");
   System.out.println("2. Actualizar Relación Libro-Autor");
   System.out.println("3. Eliminar Relación Libro-Autor");
   System.out.println("4. Mostrar Relaciones Libro-Autor");
   System.out.println("0. Volver al menú principal");
   System.out.print("Elija una opción: ");
   opcion = scanner.nextInt();
   scanner.nextLine(); // Consumir el salto de línea

   switch (opcion) {
    case 1 -> {
     System.out.print("Ingrese ID del Libro: ");
     int idLibro = scanner.nextInt();
     System.out.print("Ingrese ID del Autor: ");
     int idAutor = scanner.nextInt();
     LibroAutor libroAutor = new LibroAutor(idLibro, idAutor);
     gestionLibroAutor.añadirLibroAutor(libroAutor);
    }
    case 2 -> {
     System.out.print("Ingrese ID del Libro para actualizar: ");
     int idLibro = scanner.nextInt();
     System.out.print("Ingrese ID del Autor para actualizar: ");
     int idAutor = scanner.nextInt();
     LibroAutor libroAutorActualizado = new LibroAutor(idLibro, idAutor);
     gestionLibroAutor.actualizarLibroAutor(libroAutorActualizado);
    }
    case 3 -> {
     System.out.print("Ingrese ID del Libro para eliminar: ");
     int idLibro = scanner.nextInt();
     System.out.print("Ingrese ID del Autor para eliminar: ");
     int idAutor = scanner.nextInt();
     gestionLibroAutor.eliminarLibroAutor(idLibro, idAutor);
    }
    case 4 -> gestionLibroAutor.mostrarLibroAutores();
    case 0 -> System.out.println("Volviendo al menú principal...");
    default -> System.out.println("Opción no válida.");
   }
  } while (opcion != 0);
 }
}
