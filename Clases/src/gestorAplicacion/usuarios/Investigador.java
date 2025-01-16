package gestorAplicacion.usuarios;
import gestorAplicacion.administacion.Equipo;
import gestorAplicacion.listas.DoubleList;

public class Investigador {
    private Usuario investigador;

    public Investigador(Usuario investigador) {
        this.investigador = investigador;
    }
}
public void GenerarInventario{
    fileName = "Inventario.txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        DoubleNode fir = Usuario.equipos.first();
        while (fir != null) {
            writer.write(fir.getData().toString());
            writer.newLine();
            fir = fir.getNext();
        }
    } catch (IOException e) {
        System.out.println("Error al escribir en el archivo: " + fileName);
    }

