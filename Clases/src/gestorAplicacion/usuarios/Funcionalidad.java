package gestorAplicacion.usuarios;

import gestorAplicacion.administacion.Equipo;
import gestorAplicacion.extras.Fecha;
import gestorAplicacion.listas.DoubleList;
import gestorAplicacion.listas.DoubleNode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static gestorAplicacion.usuarios.Administrador.cambiarContrasena;
import static gestorAplicacion.usuarios.Administrador.eliminarUsuario;
import static gestorAplicacion.usuarios.Investigador.*;

public class Funcionalidad {
    private static DoubleList Solicitudes = new DoubleList();
    private static Scanner scann = new Scanner (System.in);

    public static void mostrarOpciones(String tipoUsuario, Usuario usuario) throws IOException {
        if (tipoUsuario.equalsIgnoreCase("investigador")) {
            System.out.println("Opciones para Investigador:");
            System.out.println("1. Consultar lista de equipos en su inventario.");
            System.out.println("2. Solicitar agregar un nuevo equipo.");
            System.out.println("3. Solicitar eliminar un equipo.");
            System.out.println("4. Consultar el estado de sus solicitudes.");
            System.out.println("5. Generar archivo con su inventario.");
            System.out.println("6. Generar archivo con el estado de sus solicitudes.");

            int opcion = scann.nextInt();

            switch (opcion) {

                case 1:
                    mostrarInventario(usuario);
                    break;

                case 2:
                    System.out.println("Ingresa los datos (nombre, placa, fechaCompra, precio) separados por comas:");

                    String input = scann.nextLine();
                    String[] datos = input.split(",");
                    short dd= Short.parseShort(datos[2]);
                    short mm=Short.parseShort(datos[3]);
                    short aa=Short.parseShort(datos[4]);
                    Fecha fechaCompra = new Fecha(dd,mm,aa);
                    solicitudAgregarEquipo(usuario,datos[0], Long.parseLong(datos[1]), fechaCompra,Long.parseLong(datos[5]));

                    break;

                case 3:
                    System.out.println("Ingrese el numero de la placa del equipo que desea eliminar");
                    Long placa = scann.nextLong();
                    solicitudEliminarEquipo(usuario,placa);

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

            }


        } else if (tipoUsuario.equalsIgnoreCase("administrador")) {
            System.out.println("Opciones para Administrador:");
            System.out.println("1. Consultar lista de equipos en su inventario.");
            System.out.println("2. Solicitar agregar un nuevo equipo.");
            System.out.println("3. Solicitar eliminar un equipo.");
            System.out.println("4. Registrar un nuevo usuario.");
            System.out.println("5. Cambiar contraseñas.");
            System.out.println("6. Eliminar un usuario.");
            System.out.println("7. Responder solicitudes de investigadores.");
            System.out.println("8. Generar archivos de control e inventario.");

            int opcion = scann.nextInt();

            switch (opcion) {

                case 1:

                    mostrarLista(usuario);

                    break;

                case 2:
                    System.out.println("Ingresa los datos (nombre, placa, fechaCompra, precio) separados por comas:");
                    String input = scann.nextLine();
                    String[] datos = input.split(",");
                    short dd= Short.parseShort(datos[2]);
                    short mm=Short.parseShort(datos[3]);
                    short aa=Short.parseShort(datos[4]);
                    Fecha fechaCompra = new Fecha(dd,mm,aa);
                    solicitudAgregarEquipo(usuario,datos[0], Long.parseLong(datos[1]), fechaCompra,Long.parseLong(datos[5]));

                    break;

                case 3:
                    System.out.println("Ingrese el numero de la placa del equipo que desea eliminar");
                    Long placa = scann.nextLong();
                    solicitudEliminarEquipo(usuario,placa);

                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Ingrese id de usuario y la nueva contraseña separada por comas para realizar el cambio de contraseña");
                    String entrada = scann.nextLine();
                    String[] datos1 = entrada.split(",");
                    cambiarContrasena(datos1[0], datos1[1], "archivo.txt");

                    break;

                case 6:
                    System.out.println("Ingrese el id del usuario que desea eliminar");
                    String entrada1 = scann.nextLine();
                    eliminarUsuario(entrada1, "archivo.txt");

                    break;

                case 7:

                    break;

                case 8:

                    break;

            }

        } else {
            System.out.println("Tipo de usuario no válido. Por favor, ingrese 'investigador' o 'administrador'.");
        }
    }

    public static void mostrarLista (Usuario usuario) {

        DoubleNode temp = usuario.equipos.getHead();
        int contador = 1;
        while (temp != null) {

            Equipo equipo = (Equipo) temp.getData();

            System.out.println(contador + ". " + equipo);

            temp = temp.getNext();

            contador++;
        }

    }





}
