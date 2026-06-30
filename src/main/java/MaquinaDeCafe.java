public class MaquinaDeCafe {

    private Cafetera cafe;
    private Vaso vasosPequeno;
    private Vaso vasosMediano;
    private Vaso vasosGrande;
    private Azucarero azucar;

    public void setCafetera(Cafetera cafe) {
        this.cafe = cafe;
    }

    public Cafetera getCafetera() {
        return cafe;
    }

    public void setVasosPequeno(Vaso vasosPequeno) {
        this.vasosPequeno = vasosPequeno;
    }

    public Vaso getVasosPequeno() {
        return vasosPequeno;
    }

    public void setVasosMediano(Vaso vasosMediano) {
        this.vasosMediano = vasosMediano;
    }

    public Vaso getVasosMediano() {
        return vasosMediano;
    }

    public void setVasosGrande(Vaso vasosGrande) {
        this.vasosGrande = vasosGrande;
    }

    public Vaso getVasosGrande() {
        return vasosGrande;
    }

    public void setAzucarero(Azucarero azucar) {
        this.azucar = azucar;
    }

    public Azucarero getAzucarero() {
        return azucar;
    }

    public Vaso getTipoDeVaso(String tipoDeVaso) {
        switch (tipoDeVaso.toLowerCase()) {
            case "pequeno": return vasosPequeno;
            case "mediano": return vasosMediano;
            case "grande":  return vasosGrande;
            default:        return null;
        }
    }

    public String getVasoDeCafe(Vaso vaso, int cantidadDeVasos, int cantidadDeAzucar) {

        if (!vaso.hasVasos(cantidadDeVasos)) {
            return "No hay Vasos";
        }

        if (!cafe.hasCafe(vaso.getContenido())) {
            return "No hay Cafe";
        }

        if (!azucar.hasAzucar(cantidadDeAzucar)) {
            return "No hay Azucar";
        }

        vaso.giveVasos(cantidadDeVasos);
        cafe.giveCafe(vaso.getContenido());
        azucar.giveAzucar(cantidadDeAzucar);

        return "Felicitaciones";
    }
}