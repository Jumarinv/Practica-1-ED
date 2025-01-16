package gestorAplicacion.administacion;

import UIMain.Main;
import gestorAplicacion.listas.DoubleList;
import gestorAplicacion.listas.DoubleNode;
import gestorAplicacion.usuarios.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solicitud {
    private Usuario usuario;
    private Equipo equipo;
    private String estado;
    private String tipoSolicitud;
    private static DoubleList solicitudes = new DoubleList ();
    private static DoubleList solicitudesAgregar = new DoubleList();
    private static DoubleList solicitudesEliminar = new DoubleList();
    private static DoubleList solicitudesAprobadas = new DoubleList();

    public Solicitud() {
        usuario = null;
        equipo = null;
        estado = null;
        tipoSolicitud = null;
    }

    public Solicitud(Usuario usuario,Equipo equipo,String estado,String tipoSolicitud) {
        this.usuario = usuario;
        this.equipo = equipo;
        this.estado = estado;
        this.tipoSolicitud = tipoSolicitud;
        Solicitud.solicitudes.addLast(this);
    }

    static {

        try {

            File archivo1 = new File ("");
            System.out.println(archivo1.getAbsolutePath());
            File archivo = new File(archivo1.getAbsolutePath()+ "/Clases/src/baseDeDatos/Solicitudes.txt");
            Scanner scan = new Scanner(archivo);

            while (scan.hasNextLine()) {

                String[] soli = scan.nextLine().split("\n");

                for (int l = 0; l < soli.length; l++) {

                    String[] elementosSol = soli[l].split(":");

                    DoubleNode temp = Main.getUsuarios().getHead();

                    while (temp != null) {

                        if (((Usuario) temp.getData()).getId() == Long.parseLong(elementosSol[1])) {

                            break;

                        }
                        temp = temp.getNext();
                    }

                    Usuario usuario = (Usuario) temp.getData();

                    DoubleNode temp1 = Main.getUsuarios().getHead();

                    while (temp1 != null) {

                        if (((Equipo) temp1.getData()).getPlaca() == Long.parseLong(elementosSol[3])) {

                            break;

                        }
                        temp1 = temp1.getNext();
                    }

                    Equipo equipo = (Equipo) temp1.getData();

                    String tipoSolicitud = elementosSol[7];
                    String estado = elementosSol[8];

                    Solicitud tempSolicitud = new Solicitud (usuario, equipo, estado, tipoSolicitud);
                    Solicitud.solicitudes.addLast(tempSolicitud);

                    if (tipoSolicitud.equals("agregar")) {

                        Solicitud.solicitudesAgregar.addLast(tempSolicitud);

                    } else if (tipoSolicitud.equals("eliminar")) {

                        Solicitud.solicitudesEliminar.addLast(tempSolicitud);

                    }



                }
            }

            File archivo2 = new File ("");
            System.out.println(archivo2.getAbsolutePath());
            File archivo11 = new File(archivo1.getAbsolutePath()+ "/Clases/src/baseDeDatos/ControlDeCambios.txt");
            Scanner scaneador = new Scanner(archivo11);

            while (scaneador.hasNextLine()) {

                String[] soli1 = scan.nextLine().split("\n");

                for (int l = 0; l < soli1.length; l++) {

                    String[] elementosSol = soli1[l].split(":");

                    DoubleNode temp = Main.getUsuarios().getHead();

                    while (temp != null) {

                        if (((Usuario) temp.getData()).getId() == Long.parseLong(elementosSol[1])) {

                            break;

                        }
                        temp = temp.getNext();
                    }

                    Usuario usuario = (Usuario) temp.getData();

                    DoubleNode temp1 = Main.getUsuarios().getHead();

                    while (temp1 != null) {

                        if (((Equipo) temp1.getData()).getPlaca() == Long.parseLong(elementosSol[3])) {

                            break;

                        }
                        temp1 = temp1.getNext();
                    }

                    Equipo equipo = (Equipo) temp1.getData();

                    String tipoSolicitud = elementosSol[7];
                    String estado = elementosSol[8];

                    Solicitud tempSolicitud = new Solicitud (usuario, equipo, estado, tipoSolicitud);
                    Solicitud.solicitudesAprobadas.addLast(tempSolicitud);

                }
            }
        }

        catch (FileNotFoundException e) {

            System.out.println("Ha ocurrido un error");
        }
    }

    @Override
    public String toString() {
        return usuario.getNombre() + ":" + usuario.getId() + ":" + equipo.toString() + ":" + ":" + tipoSolicitud + ":" + estado;
    }
    public String toString2() {
       return estado + ":" + tipoSolicitud + ":" +equipo.toString();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public  String imprimirCambios(){
        return tipoSolicitud + ":" +equipo.toString();
    }
}
