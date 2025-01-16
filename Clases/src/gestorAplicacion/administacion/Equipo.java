package gestorAplicacion.administacion;
import gestorAplicacion.usuarios.Usuario;
import gestorAplicacion.extras.Fecha;

public class Equipo {

    private String nombre;
    private long placa;
    private Fecha fechaCompra;
    private long precio;
    private long idDueño;

    public Equipo () {
    }

    public Equipo (String nombre, long placa, Fecha fechaCompra, long precio, long idDueño) {

        this.nombre = nombre; this.placa = placa; this.fechaCompra = fechaCompra; this.precio = precio; this.idDueño = idDueño;

    }

    @Override
    public String toString() {
        return (nombre+ ":" + placa + ":" + fechaCompra + ":" + precio + ":" + idDueño);
    }
}
