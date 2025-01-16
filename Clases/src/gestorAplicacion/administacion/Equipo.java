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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPlaca() {
        return placa;
    }

    public void setPlaca(long placa) {
        this.placa = placa;
    }

    public Fecha getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Fecha fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public long getIdDueño() {
        return idDueño;
    }

    public void setIdDueño(long idDueño) {
        this.idDueño = idDueño;
    }

    @Override
    public String toString() {
        return (nombre+ ":" + placa + ":" + fechaCompra + ":" + precio + ":" + idDueño);
    }
}
