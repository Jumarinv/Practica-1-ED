package UIMain;

import gestorAplicacion.administacion.Equipo;
import gestorAplicacion.extras.Direccion;
import gestorAplicacion.extras.Fecha;
import gestorAplicacion.listas.DoubleList;
import gestorAplicacion.administacion.Contraseña;
import gestorAplicacion.usuarios.Funcionalidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import gestorAplicacion.listas.DoubleNode;
import gestorAplicacion.usuarios.Usuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static DoubleList usuarios = new DoubleList();
    private static DoubleList contraseñas = new DoubleList();
    private static DoubleList equipos = new DoubleList();

    public static void ordenarEquipos () {

        DoubleNode tempUser = Main.usuarios.getHead();

        while (tempUser != null) {

            ordenar(((Usuario) tempUser.getData()).getEquipos());

            tempUser = tempUser.getNext();
        }

    }

    public static void intercambiar(DoubleNode node1, DoubleNode node2) {
        Equipo temp = (Equipo) node1.getData();
        node1.setData(node2.getData());
        node2.setData(temp);
    }

    public static void ordenar (DoubleList L) {
        DoubleNode current = L.getHead();

        while (current != null) {
            DoubleNode minNode = current;
            DoubleNode temp = current.getNext();

            while (temp != null) {
                if (((Equipo) temp.getData()).getPlaca() < ((Equipo) minNode.getData()).getPlaca()) {
                    minNode = temp;
                }
                temp = temp.getNext();
            }

            if (minNode != current) {
                intercambiar(current, minNode);
            }

            current = current.getNext();
        }
    }

    public static void imprimir () {

        System.out.println("Elija una opcion");
        System.out.println("1. Ingresar");
        System.out.println("2. Guardar y salir");

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

            File archivoInventario = new File(archivo1.getAbsolutePath()+ "/Clases/src/baseDeDatos/InventarioGeneral.txt");
            Scanner scanner1 = new Scanner(archivoInventario);

            while (scanner1.hasNextLine()) {

                String[] inventario = scanner1.nextLine().split("\n");

                for (int l = 0; l < inventario.length; l++) {

                    String [] equipo = inventario[l].split(":");

                    String nombre = equipo[0];
                    long placa = Long.parseLong(equipo[1]);
                    String [] tempFecha1 = equipo[2].split("/");
                    Fecha fecha1 = new Fecha (Short.parseShort(tempFecha1[0]), Short.parseShort(tempFecha1[1]), Short.parseShort(tempFecha1[2]));
                    long precio = Long.parseLong(equipo[3]);
                    long idDueño = Long.parseLong(equipo[4]);

                    Equipo tempEquipo = new Equipo(nombre, placa, fecha1, precio, idDueño);
                    equipos.addLast(tempEquipo);

                    DoubleNode tempUser = Main.usuarios.getHead();
                    while (tempUser != null) {

                        if (((Usuario) (tempUser.getData())).getId() == idDueño) {

                            ((Usuario) (tempUser.getData())).equipos.addLast(tempEquipo);
                        }

                        tempUser = tempUser.getNext();
                    }


                }

            }
            //ordenamiento listas
            ordenar(equipos);
            ordenarEquipos();

            iniciarSesion();





        }catch (FileNotFoundException e) {

            System.out.println("Ha ocurrido un error");

        } catch (IOException e) {

            System.out.println("IO Exception");
        }


    }

    public static void iniciarSesion () {


        try {

            boolean acceso = true;
            Scanner lector = new Scanner(System.in);

            while (acceso) {

                Scanner lector1 = new Scanner(System.in);
                imprimir();
                int opcion = lector1.nextInt();

                if (opcion == 1) {


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

                            DoubleNode tempusuario = usuarios.first();

                            while (tempusuario != null) {

                                if (((Usuario) tempusuario.getData()).getId() == Long.parseLong(id)) {

                                    break;
                                }
                                tempusuario = tempusuario.getNext();
                            }

                            if (tempData.getRol().equals("Administrador")){

                                System.out.println("Ingresaste como administrador");
                                Funcionalidad.mostrarOpciones("administrador", (Usuario) tempusuario.getData());
                                lector1.next();

                            }

                            else if (tempData.getRol().equals("Investigador")){

                                System.out.println("Ingresaste como investigador");
                                Funcionalidad.mostrarOpciones("investigador", (Usuario) tempusuario.getData());
                                lector1.next();


                            }



                        }

                        else {

                            System.out.println("Ingrese un ID y contraseña validos");
                            continue;
                        }


                        temp = temp.getNext();
                    }


                }

                else if (opcion == 2) {

                    System.out.println("Guardando");
                    System.exit(1);
                    acceso = false;

                }


            }

        }

        catch (IOException e) {

            System.out.println("IO Exception");
        }

    }

    public static DoubleList getUsuarios() {
        return usuarios;
    }
    public static void agregarUsuario(Usuario usuario){
        usuarios.addLast(usuario);

    }
}