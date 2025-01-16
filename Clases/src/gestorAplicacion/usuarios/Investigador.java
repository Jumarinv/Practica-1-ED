package gestorAplicacion.usuarios;
import gestorAplicacion.administacion.Equipo;
import gestorAplicacion.administacion.Solicitud;
import gestorAplicacion.extras.Fecha;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import gestorAplicacion.listas.*;

public class Investigador {
    private Usuario investigador;

    public Investigador(Usuario investigador) {
        this.investigador = investigador;
    }

    public void solicitudAgregarEquipo(String nombre, long placa, Fecha fechaCompra, long precio) {
        Equipo equipoNuevo = new Equipo(nombre, placa, fechaCompra, precio, investigador.getId());
        Solicitud solicitud = new Solicitud(investigador,equipoNuevo,"pendiente");
        investigador.addSolicitudes(solicitud);
        System.out.println("Solicitud de agregar equipo: " + equipoNuevo.toString());
    }
    public static void mostrarInventario(Usuario investigador){

    }
    public static void solicitudEliminarEquipo(Usuario investigador){

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

    }
}