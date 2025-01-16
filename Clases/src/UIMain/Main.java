package UIMain;

import gestorAplicacion.extras.Direccion;
import gestorAplicacion.extras.Fecha;
import gestorAplicacion.listas.DoubleList;
import gestorAplicacion.administacion.Contraseña;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gestorAplicacion.listas.DoubleNode;
import gestorAplicacion.usuarios.Usuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static DoubleList usuarios = new DoubleList();
    private static DoubleList contraseñas = new DoubleList();

    public void IngresoAdmin () {

    }

    public void IngresoInvestigador() {

    }

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
                    String [] tempdir = user[6].split(" ");
                    Direccion direccion = new Direccion(tempdir[0],tempdir[1],tempdir[2],tempdir[3],tempdir[4],tempdir[5]);

                    Usuario tempuser = new Usuario (nombre, id, fecha, ciudad, tel, correo, direccion);
                    Main.usuarios.addLast(tempuser);
                }
            }

            File archivoContraseñas = new File(archivo1.getAbsolutePath()+ "/Clases/src/baseDeDatos/Password.txt");
            Scanner scanner = new Scanner(archivoContraseñas);

            while (scanner.hasNextLine()) {

                String[] contras = scanner.nextLine().split("\n");

                for (int l = 0; l < contras.length; l++) {

                    String [] userpassword = contras[l].split(" ");

                    //Print contraseñas e id
                    System.out.println(userpassword[0] + " " + userpassword[1]);

                    Contraseña tempcontraseña = new Contraseña(userpassword[0], userpassword[1], userpassword[2]);
                    Main.contraseñas.addLast(tempcontraseña);

                }

            }

            boolean acceso = true;
            Scanner lector = new Scanner(System.in);

            while (acceso) {

                DoubleNode temp = contraseñas.getHead();

                while (temp != null){

                    System.out.println("Ingrese su ID");
                    String id = lector.nextLine();
                    System.out.println("Ingrese su contraseña");
                    String contraseña = lector.nextLine();

                    System.out.println(id + " " + contraseña);

                    if (((Contraseña) (temp.getData())).getId().equals(id) && (((Contraseña) (temp.getData())).getContraseña().equals(contraseña)))  {

                        System.out.println("Bienvenido");
                        Contraseña tempData = (Contraseña) (temp.getData());


                    }

                    else {

                        System.out.println("Ingrese un ID y contraseña validos");
                        continue;
                    }


                    temp = temp.getNext();
                }



                
            }



        }catch (FileNotFoundException e) {

            System.out.println("Ha ocurrido un error");
        }





    }
}