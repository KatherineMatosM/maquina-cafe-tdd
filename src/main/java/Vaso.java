/**
 * Representa un contenedor de vaso con capacidad fija y stock de unidades.
 * cantidadVasos: numero de vasos disponibles en inventario.
 * contenido: capacidad en onzas del tipo de vaso (3, 5 o 7).
 */
public class Vaso {

    private int cantidadVasos;
    private int contenido;

    /**
     * Constructor.
     * @param cantidadVasos numero inicial de vasos disponibles
     * @param contenido     capacidad en onzas del vaso
     */
    public Vaso(int cantidadVasos, int contenido) {
        this.cantidadVasos = cantidadVasos;
        this.contenido = contenido;
    }

    public void setCantidadVasos(int cantidadVasos) {
        this.cantidadVasos = cantidadVasos;
    }

    public int getCantidadVasos() {
        return cantidadVasos;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public int getContenido() {
        return contenido;
    }

    /**
     * Consulta si hay suficientes vasos disponibles.
     * @param cantidad cantidad requerida
     * @return true si cantidadVasos >= cantidad
     */
    public boolean hasVasos(int cantidad) {
        return cantidadVasos >= cantidad;
    }

    /**
     * Descuenta vasos del inventario.
     * @param cantidad vasos a retirar
     */
    public void giveVasos(int cantidad) {
        cantidadVasos -= cantidad;
    }
}