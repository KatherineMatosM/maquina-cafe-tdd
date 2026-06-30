/**
 * Representa el deposito de azucar de la maquina.
 * cantidadDeAzucar: cucharadas de azucar disponibles.
 */
public class Azucarero {

    private int cantidadDeAzucar;

    /**
     * Constructor.
     * @param cantidadDeAzucar cucharadas iniciales disponibles
     */
    public Azucarero(int cantidadDeAzucar) {
        this.cantidadDeAzucar = cantidadDeAzucar;
    }

    public void setCantidadDeAzucar(int cantidadDeAzucar) {
        this.cantidadDeAzucar = cantidadDeAzucar;
    }

    public int getCantidadAzucar() {
        return cantidadDeAzucar;
    }

    /**
     * Consulta si hay suficiente azucar disponible.
     * @param cantidad cucharadas requeridas
     * @return true si cantidadDeAzucar >= cantidad
     */
    public boolean hasAzucar(int cantidad) {
        return cantidadDeAzucar >= cantidad;
    }

    /**
     * Descuenta azucar del deposito.
     * @param cantidad cucharadas a dispensar
     */
    public void giveAzucar(int cantidad) {
        cantidadDeAzucar -= cantidad;
    }
}