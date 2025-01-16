package gestorAplicacion.administacion;

import gestorAplicacion.usuarios.Usuario;

public class Solicitud {
    private Usuario usuario;
    private Equipo equipo;
    private String estado;
    private String tipoSolicitud;

    public Solicitud() {
        usuario = null;
        equipo = null;
        estado = null;
        tipoSolicitud = null;
    }

    public Solicitud(Usuario usuario,Equipo equipo,String estado,String tipoSolicitud) {
        this.usuario = usuario;
        this.equipo = equipo;
        this.estado = estado;
        this.tipoSolicitud = tipoSolicitud;
    }

    @Override
    public String toString() {
        return usuario.getNombre() + ":" + usuario.getId() + ":" + equipo.toString() + ":" + estado;
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
