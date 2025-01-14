package gestorAplicacion.extras;

public class Fecha {
    private short dd;
    private short mm;
    private short aa;
    public Fecha() {
        super();
    }
    public Fecha(short dd, short mm, short aa) {
        super();
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }

    @Override
    public String toString() {
        return  dd + "/" + mm + "/" + aa;
    }
    public short getDd() {
        return dd;
    }
    public void setDd(short dd) {
        this.dd = dd;
    }
    public short getMm() {
        return mm;
    }
    public void setMm(short mm) {
        this.mm = mm;
    }
    public short getAa() {
        return aa;
    }
    public void setAa(short aa) {
        this.aa = aa;
    }

}
