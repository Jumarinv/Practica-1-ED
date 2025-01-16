package gestorAplicacion.extras;

public class Direccion {
    private String calle;
    private String nomenclatura;
    private String barrio;
    private String ciudad;
    private String edificio;
    private String apto;

    public Direccion() {
        super();
    }


    public Direccion(String calle, String nomenclatura, String barrio, String ciudad, String edificio, String apto) {
        super();
        this.calle = calle;
        this.nomenclatura = nomenclatura;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.edificio = edificio;
        this.apto = apto;
    }


    public Direccion(String calle, String nomenclatura, String barrio, String ciudad) {
        super();
        this.calle = calle;
        this.nomenclatura = nomenclatura;
        this.barrio = barrio;
        this.ciudad = ciudad;
        edificio = "No-aplica";
        apto = "No-aplica";
    }


    @Override
    public String toString() {
        return calle + " " + nomenclatura + " " + barrio + " " + ciudad + " " + edificio + " " + apto;

    }


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getApto() {
        return apto;

    }
}