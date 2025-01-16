package gestorAplicacion.usuarios;
import gestorAplicacion.administacion.Equipo;
import gestorAplicacion.administacion.Solicitud;
import gestorAplicacion.extras.Fecha;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import gestorAplicacion.listas.*;

public class Investigador {

    public Investigador() {
    }

    public void solicitudAgregarEquipo(Usuario investigador,String nombre, long placa, Fecha fechaCompra, long precio) {
        Equipo equipoNuevo = new Equipo(nombre, placa, fechaCompra, precio, investigador.getId());
        Solicitud solicitud = new Solicitud(investigador,equipoNuevo,"pendiente","Agregar");
        investigador.addSolicitudes(solicitud);
        System.out.println("Solicitud de agregar equipo: " + equipoNuevo.toString());
    }
    public static void mostrarInventario(Usuario investigador){
         DoubleNode temp = investigador.getEquipos().getHead();
         while(temp != null) {
             System.out.println(temp.getData());
             temp = temp.getNext();
        }
    }
    public static void solicitudEliminarEquipo(Usuario investigador, long placa){
        DoubleNode temp = investigador.getEquipos().getHead();
        while ( temp!= null){
            Equipo equipo = (Equipo) temp.getData();
            if(equipo.getPlaca()==placa){
                Solicitud solicitud = new Solicitud(investigador,equipo,"pendiente","Eliminar");
            }
        }

    }

    public static void GenerarInventario (Usuario usuario){
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
    public static void GenerarSolicitud (Usuario usuario){
        String fileName = "Solicitudes.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            DoubleNode fir = usuario.getSolicitudes().first();
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