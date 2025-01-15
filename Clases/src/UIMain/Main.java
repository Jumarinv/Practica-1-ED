package UIMain;

import gestorAplicacion.extras.Fecha;
import gestorAplicacion.listas.DoubleList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import gestorAplicacion.usuarios.Usuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static DoubleList usuarios = new DoubleList();

    public static void main(String[] args) {



        try {

            File archivo1 = new File ("");
            System.out.println(archivo1.getAbsolutePath());
            File archivo = new File(archivo1.getAbsolutePath()+ "/Clases/src/baseDeDatos/Empleados.txt");
            Scanner scan = new Scanner(archivo);

            while (scan.hasNextLine()) {

                String[] usuarios = scan.nextLine().toUpperCase().split("\n");

                for (int l = 0; l < usuarios.length; l++) {

                    String [] user = usuarios[l].toUpperCase().split(":");
                    String nombre = user[0];
                    long id = Long.parseLong(user[1]);
                    String [] tempFecha = user[2].split("/");
                    Fecha fecha = new Fecha (Short.parseShort(tempFecha[0]), Short.parseShort(tempFecha[1]), Short.parseShort(tempFecha[2]));
                    String ciudad = user[3];
                    Long tel = Long.parseLong(user[4]);
                    String correo = user[5];
                    String [] tempdir = user[6].split()
                    Usuario tempuser = new Usuario ();
                }
            }

        }catch (FileNotFoundException e) {

            System.out.println("Ha ocurrido un error");
        }





    }
}