package gestorAplicacion.administacion;

import gestorAplicacion.usuarios.Usuario;

public class Solicitud {
    private Usuario usuario;
    private Equipo equipo;
    private String estado;

    public Solicitud() {
        usuario = null;
        equipo = null;
        estado = null;
    }

    public Solicitud(Usuario usuario,Equipo equipo,String estado) {
        this.usuario = usuario;
        this.equipo = equipo;
        this.estado = estado;
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
}
