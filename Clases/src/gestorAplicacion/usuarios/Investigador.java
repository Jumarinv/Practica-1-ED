package gestorAplicacion.usuarios;
import gestorAplicacion.administacion.Equipo;
import gestorAplicacion.extras.Fecha;
import gestorAplicacion.listas.DoubleList;

public class Investigador {
    private Usuario investigador;

    public Investigador(Usuario investigador) {
        this.investigador = investigador;
    }

    public void solicitudAgregarEquipo(String nombre, long placa, Fecha fechaCompra, long precio) {
        Equipo equipoNuevo = new Equipo(nombre, placa, fechaCompra, precio, investigador.getId());
        System.out.println("Solicitud de agregar equipo: " + equipoNuevo.toString());
    }

    public void GenerarInventario

    {
        fileName = "Inventario.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            DoubleNode fir = investigador.equipos.first();
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

