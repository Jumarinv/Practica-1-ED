package gestorAplicacion.usuarios;

import gestorAplicacion.listas.DoubleList;
import gestorAplicacion.listas.DoubleNode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Funcionalidad {
    private DoubleList Solicitudes = new DoubleList();

    public void mostrarOpciones(String tipoUsuario) {
        if (tipoUsuario.equalsIgnoreCase("investigador")) {
            System.out.println("Opciones para Investigador:");
            System.out.println("1. Consultar lista de equipos en su inventario.");
            System.out.println("2. Solicitar agregar un nuevo equipo.");
            System.out.println("3. Solicitar eliminar un equipo.");
            System.out.println("4. Consultar el estado de sus solicitudes.");
            System.out.println("5. Generar archivo con su inventario.");
            System.out.println("6. Generar archivo con el estado de sus solicitudes.");
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
        } else {
            System.out.println("Tipo de usuario no válido. Por favor, ingrese 'investigador' o 'administrador'.");
        }
    }



}
