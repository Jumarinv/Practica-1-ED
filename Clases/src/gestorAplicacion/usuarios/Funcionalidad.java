package gestorAplicacion.usuarios;

import UIMain.Main;
import gestorAplicacion.administacion.Equipo;
import gestorAplicacion.administacion.Solicitud;
import gestorAplicacion.extras.Fecha;
import gestorAplicacion.listas.DoubleList;
import gestorAplicacion.listas.DoubleNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static UIMain.Main.*;
import static gestorAplicacion.administacion.Solicitud.*;
import static gestorAplicacion.usuarios.Administrador.*;
import static gestorAplicacion.usuarios.Investigador.*;
import static UIMain.Main.getUsuarios;

public class Funcionalidad {
    private static DoubleList Solicitudes = new DoubleList();
    private static Scanner scann = new Scanner (System.in);

    public static void mostrarOpciones(String tipoUsuario, Usuario usuario) throws IOException {

        boolean status = true;
        while (status) {
            if (tipoUsuario.equalsIgnoreCase("investigador")) {
                System.out.println("Opciones para Investigador:");
                System.out.println("1. Consultar lista de equipos en su inventario.");
                System.out.println("2. Solicitar agregar un nuevo equipo.");
                System.out.println("3. Solicitar eliminar un equipo.");
                System.out.println("4. Consultar el estado de sus solicitudes.");
                System.out.println("5. Generar archivo con su inventario.");
                System.out.println("6. Generar archivo con el estado de sus solicitudes.");
                System.out.println("7. Cerrar sesion");

                int opcion = scann.nextInt();

                switch (opcion) {

                    case 1:
                        mostrarLista(usuario);
                        break;

                    case 2:
                        System.out.println("Ingresa los datos nombre, placa(numero), día(numero), mes(numero), año(numero), precio(numero) separados por comas:");
                        scann.nextLine();
                        String input = scann.nextLine().trim();


                        if (input.isEmpty()) {
                            System.out.println("Error: No ingresaste datos.");
                            return;
                        }


                        String[] datos = input.split(",");


                        if (datos.length < 6) {
                            System.out.println("Error: Debes ingresar 6 valores separados por comas.");
                            System.out.println("Ejemplo: Laptop,ABC123,12,05,2023,2500000");
                            return;
                        }

                        try {

                            for (int i = 0; i < datos.length; i++) {
                                datos[i] = datos[i].trim();
                            }


                            short dd = Short.parseShort(datos[2]);
                            short mm = Short.parseShort(datos[3]);
                            short aa = Short.parseShort(datos[4]);


                            Fecha fechaCompra = new Fecha(dd, mm, aa);


                            solicitudAgregarEquipo(usuario, datos[0], Long.parseLong(datos[1]), fechaCompra, Long.parseLong(datos[5]));

                            System.out.println("Datos procesados correctamente.");

                        } catch (NumberFormatException e) {
                            System.out.println("Error: Asegúrate de ingresar números válidos para el día, mes, año y precio.");
                        }

                        break;

                    case 3:
                        System.out.println("Ingrese el numero de la placa del equipo que desea eliminar");
                        Long placa = scann.nextLong();
                        solicitudEliminarEquipo(usuario, placa);

                        break;

                    case 4:
                        MostrarEstadoSolicitud(usuario);
                        break;

                    case 5:
                        GenerarInventario(usuario);
                        break;

                    case 6:
                        GenerarSolicitud(usuario);
                        break;

                    case 7:

                        Main.iniciarSesion();
                        status = false;
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
                System.out.println("8. Generar inventario del administrador");
                System.out.println("9. Generar inventario del centro de investigación");
                System.out.println("10. Generar archivo de control de cambios");
                System.out.println("11. Generar archivo de solicitudes pendientes para agregar");
                System.out.println("12. Generar archivo de solicitudes pendientes para eliminar");
                System.out.println("13. Consultar control de cambios");
                System.out.println("14. Consultar solicitudes para agregar");
                System.out.println("15. Consultar solicitudes para eliminar");
                System.out.println("16. Salir");

                int opcion = scann.nextInt();

                switch (opcion) {

                    case 1:

                        mostrarLista(usuario);

                        break;

                    case 2:
                        System.out.println("Ingresa los datos nombre, placa(numero), día(numero), mes(numero), año(numero), precio(numero) separados por comas:");
                        scann.nextLine();
                        String input = scann.nextLine().trim();


                        if (input.isEmpty()) {
                            System.out.println("Error: No ingresaste datos.");
                            return;
                        }


                        String[] datos = input.split(",");


                        if (datos.length < 6) {
                            System.out.println("Error: Debes ingresar 6 valores separados por comas.");
                            System.out.println("Ejemplo: Laptop,ABC123,12,05,2023,2500000");
                            return;
                        }

                        try {

                            for (int i = 0; i < datos.length; i++) {
                                datos[i] = datos[i].trim();
                            }


                            short dd = Short.parseShort(datos[2]);
                            short mm = Short.parseShort(datos[3]);
                            short aa = Short.parseShort(datos[4]);


                            Fecha fechaCompra = new Fecha(dd, mm, aa);


                            solicitudAgregarEquipo(usuario, datos[0], Long.parseLong(datos[1]), fechaCompra, Long.parseLong(datos[5]));

                            System.out.println("Datos procesados correctamente.");

                        } catch (NumberFormatException e) {
                            System.out.println("Error: Asegúrate de ingresar números válidos para el día, mes, año y precio.");
                        }


                        break;

                    case 3:
                        System.out.println("Inventario de equipos");
                        mostrarInventario(usuario);

                        System.out.println("Ingrese el numero de la placa del equipo que desea eliminar");
                        Long placa = scann.nextLong();
                        solicitudEliminarEquipo(usuario, placa);

                        break;

                    case 4:
                        File archivo0 = new File ("");
                        File archivoContraseñas1 = new File(archivo0.getAbsolutePath()+ "/Clases/src/baseDeDatos/Password.txt");
                        File archivo3 = new File(archivo0.getAbsolutePath()+ "/Clases/src/baseDeDatos/Empleados.txt");
                        crearUsuario(scann,archivo3,archivoContraseñas1);

                        break;

                    case 5:
                        File archivo1 = new File ("");
                        System.out.println(archivo1.getAbsolutePath());
                        File archivoContraseñas = new File(archivo1.getAbsolutePath()+ "/Clases/src/baseDeDatos/Password.txt");
                        System.out.println("Ingrese id de usuario y la nueva contraseña separada por comas para realizar el cambio de contraseña");
                        scann.nextLine();
                        String entrada = scann.nextLine();
                        String[] datos1 = entrada.split(",");
                        cambiarContrasena(datos1[0], datos1[1], archivoContraseñas);

                        break;

                    case 6:
                        File archivo2= new File ("");
                        System.out.println(archivo2.getAbsolutePath());
                        File archivo = new File(archivo2.getAbsolutePath()+ "/Clases/src/baseDeDatos/Empleados.txt");
                        File archivoContraseñas2 = new File(archivo2.getAbsolutePath()+ "/Clases/src/baseDeDatos/Password.txt");
                        System.out.println("Ingrese el id del usuario que desea eliminar");
                        scann.nextLine();
                        String entrada1 = scann.nextLine();
                        eliminarUsuario(entrada1,archivo,archivoContraseñas2);
                        DoubleNode temp = getUsuarios().getHead();
                         while (temp!=null){
                             Long nid = Long.parseLong(entrada1);
                             Usuario user = (Usuario) temp.getData();
                             if(user.getId()==nid){
                                 getUsuarios().remove(temp);
                                 break;
                             }else{
                                 temp= temp.getNext();
                             }
                         }



                        break;

                    case 7:

                        aceptarDenegar();

                        break;

                    case 8:
                        Generarinventarioinvestigador(usuario);
                        break;
                    case 9:
                        GenerarinventarioGeneral();
                        break;
                    case 10:
                        GenerarControlCambios(getC());
                        break;
                    case 11:
                        GenerarPendientesAgregar(getA());
                        break;
                    case 12:
                        GenerarPendientesEliminar(getE());
                        break;
                    case 13:
                        ConsultarCambios(getC());
                        break;
                    case 14:
                        Consultaragregar(getA());
                        break;
                    case 15:
                        Consultareliminar(getE());
                        break;

                    case 16:
                        Main.iniciarSesion();
                        status = false;
                        break;

                }

            } else {
                System.out.println("Tipo de usuario no válido. Por favor, ingrese 'investigador' o 'administrador'.");

            }
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

    public static void aceptarDenegar () {

        Scanner scan = new Scanner(System.in);

        DoubleNode temp = Solicitud.getSolicitudes().getHead();

        while (temp != null) {

            if (((Solicitud) temp.getData()).getEstado().equals("pendiente")) {

                System.out.println(temp.getData());

                System.out.println("Desea Aprobar la solicitud?");
                System.out.println("1. Aprobar");
                System.out.println("2. Denegar");

                int opcion = scan.nextInt();

                if (opcion == 1) {

                    ((Solicitud) temp.getData()).setEstado("aprobada");
                    solicitudesAprobadas.addLast(temp.getData());

                    if (((Solicitud) temp.getData()).getTipoSolicitud().equals("Agregar")) {

                        ((Solicitud) temp.getData()).getUsuario().getEquipos().addLast(((Solicitud) temp.getData()).getEquipo());
                        //Main.ordenar(((Solicitud) temp.getData()).getUsuario().getEquipos());
                        //getSolicitudes().remove(temp);
                    }

                    else if (((Solicitud) temp.getData()).getTipoSolicitud().equals("Eliminar")) {

                        ((Solicitud) temp.getData()).getUsuario().getEquipos().remove(temp);
                        //Main.ordenar(((Solicitud) temp.getData()).getUsuario().getEquipos());
                        getSolicitudes().remove(temp);
                    }
                }

                else if (opcion ==  2) {

                    ((Solicitud) temp.getData()).setEstado("denegada");
                    getSolicitudes().remove(temp);
                }
            }

            temp = temp.getNext();
        }
    }





}
