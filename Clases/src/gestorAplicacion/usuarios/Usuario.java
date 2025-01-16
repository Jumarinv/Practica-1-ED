package gestorAplicacion.usuarios;
import gestorAplicacion.extras.Fecha;
import gestorAplicacion.extras.Direccion;
import gestorAplicacion.listas.DoubleList;


public class Usuario {
    private String Nombre;
    private long id;
    private Fecha fecha;
    private String ciudad;
    private long tel;
    private String email;
    private Direccion dir;
    public DoubleList equipos;

    public Usuario() {
        super();
    }
    public Usuario(String nombre, long id) {
        Nombre = nombre;
        this.id = id;
        this.equipos = new DoubleList();
    }


    public Usuario(String nombre, long id, Fecha fecha, String ciudad, long tel, String email, Direccion dir) {
        super();
        Nombre = nombre;
        this.id = id;
        this.fecha = fecha;
        this.ciudad = ciudad;
        this.tel = tel;
        this.email = email;
        this.dir = dir;
        this.equipos = new DoubleList();
    }
    @Override
    public String toString() {
        return Nombre+":"+ id +":"+ fecha+":"+ ciudad+":"+ tel+":"+ email+":"+ dir;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Fecha getFecha() {
        return fecha;
    }
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public long getTel() {
        return tel;
    }
    public void setTel(long tel) {
        this.tel = tel;
    }
    public Direccion getDir() {
        return dir;
    }
    public void setDir(Direccion dir) {
        this.dir = dir;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}

