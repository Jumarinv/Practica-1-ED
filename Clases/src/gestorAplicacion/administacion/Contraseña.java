package gestorAplicacion.administacion;

public class Contraseña {

    private String id;
    private String contraseña;
    private String rol;

    public Contraseña (){

    }

    public Contraseña (String id, String contraseña, String rol) {

        this.id = id; this.contraseña = contraseña; this.rol = rol;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
