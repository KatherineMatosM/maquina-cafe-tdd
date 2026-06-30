/**
 * Representa el deposito de cafe de la maquina.
 * cantidadCafe: onzas de cafe disponibles.
 */
public class Cafetera {

    private int cantidadCafe;

    /**
     * Constructor.
     * @param cantidadCafe onzas iniciales de cafe disponibles
     */
    public Cafetera(int cantidadCafe) {
        this.cantidadCafe = cantidadCafe;
    }

    public void setCantidadDeCafe(int cantidadCafe) {
        this.cantidadCafe = cantidadCafe;
    }

    public int getCantidadCafe() {
        return cantidadCafe;
    }

    /**
     * Consulta si hay suficiente cafe disponible.
     * @param cantidad onzas requeridas
     * @return true si cantidadCafe >= cantidad
     */
    public boolean hasCafe(int cantidad) {
        return cantidadCafe >= cantidad;
    }

    /**
     * Descuenta cafe del deposito.
     * @param cantidad onzas a dispensar
     */
    public void giveCafe(int cantidad) {
        cantidadCafe -= cantidad;
    }
}