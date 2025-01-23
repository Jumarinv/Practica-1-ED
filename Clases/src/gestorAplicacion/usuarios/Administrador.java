package gestorAplicacion.usuarios;

import UIMain.Main;
import gestorAplicacion.administacion.Contraseña;
import gestorAplicacion.administacion.Solicitud;
import gestorAplicacion.extras.Direccion;
import gestorAplicacion.extras.Fecha;
import gestorAplicacion.listas.DoubleList;
import gestorAplicacion.listas.DoubleNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static UIMain.Main.agregarUsuario;


public class Administrador extends Investigador {
    public static void cambiarContrasena(String id, String nuevaContraseña, File archivo) {
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 3 && partes[0].equals(id)) {
                    lineas.add(id + " " + nuevaContraseña + " " + partes[2]);
                    encontrado = true;
                } else {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        if (!encontrado) {
            System.out.println("ID no encontrado en el archivo.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String l : lineas) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void eliminarUsuario(String idUsuario, File archivo1, File archivo2) {
        List<String> lineas1 = new ArrayList<>();
        List<String> lineas2 = new ArrayList<>();
        boolean eliminado1 = false;
        boolean eliminado2 = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo1))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length > 1 && partes[1].equals(idUsuario)) {
                    eliminado1 = true;
                } else {
                    lineas1.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo 1: " + e.getMessage());
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo2))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length > 1 && partes[0].equals(idUsuario)) {
                    eliminado2 = true;
                } else {
                    lineas2.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo 2: " + e.getMessage());
            return;
        }

        if (!eliminado1 && !eliminado2) {
            System.out.println("Usuario no encontrado en ninguno de los archivos.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo1))) {
            for (String l : lineas1) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo 1: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo2))) {
            for (String l : lineas2) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo 2: " + e.getMessage());
        }
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
    public static void GenerarinventarioGeneral(){
       DoubleList usuarios = Main.getUsuarios();
       DoubleNode fir = usuarios.first();
        File archivo1 = new File ("");
        String fileName = archivo1.getAbsolutePath() + "/Clases/src/baseDeDatos/InventarioGeneral.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            while (fir != null) {
                DoubleNode fi = ((Usuario)fir.getData()).getEquipos().first();
                while (fi != null) {
                    writer.write(fi.getData().toString());
                    writer.newLine();
                    fi = fi.getNext();
                }
                fir = fir.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + fileName);
        }


    }
    public static void GenerarControlCambios(DoubleList cambios){

        File archivo1 = new File ("");
        String fileName = archivo1.getAbsolutePath() + "/Clases/src/baseDeDatos/ControlDeCambios.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            DoubleNode fir = cambios.first();
            while (fir != null) {
                writer.write(((Solicitud)fir.getData()).toString());
                writer.newLine();
                fir = fir.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + fileName);
        }

    }
    public static void GenerarPendientesAgregar(DoubleList agregar){
        String fileName = "PendientesAgregar.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            DoubleNode fir = agregar.first();
            while (fir != null) {
                writer.write(((Solicitud)fir.getData()).toString2());
                writer.newLine();
                fir = fir.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + fileName);
        }

    }
    public static void GenerarPendientesEliminar(DoubleList eliminar){
        String fileName = "PendientesEliminar.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            DoubleNode fir = eliminar.first();
            while (fir != null) {
                writer.write(((Solicitud)fir.getData()).toString2());
                writer.newLine();
                fir = fir.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + fileName);
        }

    }
    public static void ConsultarCambios(DoubleList cambios){
        DoubleNode fir = cambios.first();
        while(fir != null) {
            System.out.println(((Solicitud)fir.getData()).imprimirCambios());
            fir = fir.getNext();
        }
    }

    public static Usuario crearUsuarioDesdeConsola(Scanner scanner) {
        System.out.print("Nombre: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();

        System.out.print("ID: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.print("Fecha de nacimiento (dd mm aaaa): ingrese cada dato 1 por 1 y le da enter ");
        short dd = Short.parseShort(scanner.next());
        short mm = Short.parseShort(scanner.next());
        short aa = Short.parseShort(scanner.next());


        Fecha fecha = new Fecha(dd, mm, aa);

        System.out.print("Ciudad: ");
        scanner.nextLine();
        String ciudad = scanner.nextLine();

        System.out.print("Teléfono: ");
        long tel = Long.parseLong(scanner.nextLine());

        System.out.print("Email: ");

        String email = scanner.nextLine();

        System.out.print("Calle: ");

        String calle = scanner.nextLine();

        System.out.print("Nomenclatura: ");

        String nomenclatura = scanner.nextLine();

        System.out.print("Barrio: ");

        String barrio = scanner.nextLine();

        System.out.print("Ciudad de la dirección: ");

        String ciudadDireccion = scanner.nextLine();

        Direccion direccion = new Direccion(calle, nomenclatura, barrio, ciudadDireccion);

        return new Usuario(nombre, id, fecha, ciudad, tel, email, direccion);
    }
     public static void crearUsuario(Scanner scanner,File archivo1, File archivo2){
        Usuario usuario = crearUsuarioDesdeConsola(scanner);
         agregarUsuario(usuario);
         agregarUsuarioArchivo(archivo1,usuario);

         System.out.println("Ingrese contraseña");
         String contra = scanner.nextLine();
         System.out.println("Ingrese rol");
         String rol = scanner.nextLine();
         Contraseña contraseña = new Contraseña(String.valueOf(usuario.getId()),contra,rol);
         agregarContraseña(archivo2,contraseña);
     }
    public static void Consultaragregar(DoubleList agregar){
        DoubleNode fir = agregar.first();
        while(fir != null) {
            System.out.println(((Solicitud)fir.getData()).imprimirCambios());
            fir = fir.getNext();
        }
    }
    public static void agregarContraseña(File archivo, Contraseña objeto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(objeto.getId()+" "+objeto.getContraseña()+" "+objeto.getRol());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    public static void agregarUsuarioArchivo(File archivo, Usuario objeto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(objeto.toString());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    public static void Consultareliminar(DoubleList eliminar){
        DoubleNode fir = eliminar.first();
        while(fir != null) {
            System.out.println(((Solicitud)fir.getData()).imprimirCambios());
            fir = fir.getNext();
        }
    }


}


