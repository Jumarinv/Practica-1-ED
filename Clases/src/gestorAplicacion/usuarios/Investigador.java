package gestorAplicacion.usuarios;
import gestorAplicacion.listas.DoubleList;

public class Investigador extends Usuario{

    private DoubleList Equipos;

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

