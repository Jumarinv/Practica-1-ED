package gestorAplicacion.usuarios;

import gestorAplicacion.listas.DoubleNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Administrador {
    public static void cambiarContrasena(String idUsuario, String nuevaContrasena, String archivo) throws IOException {
        File file = new File(archivo);
        List<String> lineas = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }

        boolean encontrado = false;
        for (int i = 0; i < lineas.size(); i++) {
            String[] datos = lineas.get(i).split(" ");
            if (datos[0].equals(idUsuario)) {

                lineas.set(i, idUsuario + " " + nuevaContrasena + " " + datos[2]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("ID no existe.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
        }

        System.out.println("Contraseña cambiada.");
    }

    public static void eliminarUsuario(String idUsuario, String archivo) throws IOException {
        File file = new File(archivo);
        List<String> lineas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }

        boolean encontrado = false;
        for (Iterator<String> iter = lineas.iterator(); iter.hasNext(); ) {
            String linea = iter.next();
            String[] datos = linea.split(" ");
            if (datos[1].equals(idUsuario)) {
                iter.remove();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("ID no existe.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
        }

        System.out.println("Usuario eliminado.");
    }
    public static void Generarinventarioinvestigador (Usuario usuario){
        String fileName = "Inventario.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            DoubleNode fir = usuario.equipos.first();
            while (fir != null) {
                writer.write(fir.getData().toString());
                writer.newLine();
                fir = fir.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + fileName);
        }
    }
}
