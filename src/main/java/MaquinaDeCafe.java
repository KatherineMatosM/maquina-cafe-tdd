/**
 * Controlador principal de la maquina dispensadora de cafe.
 * Coordina los subsistemas: Vaso, Cafetera y Azucarero.
 *
 * Flujo de getVasoDeCafe:
 *   1. Verifica stock de vasos del tipo solicitado.
 *   2. Verifica stock de cafe suficiente para el contenido del vaso.
 *   3. Verifica stock de azucar.
 *   4. Si todo esta disponible: descuenta inventarios y retorna "Felicitaciones".
 *   5. Si falta algo: retorna el mensaje de error correspondiente.
 */
public class MaquinaDeCafe {

    // Atributos privados segun diagrama de clases del enunciado
    private Cafetera cafe;
    private Vaso vasosPequeno;
    private Vaso vasosMediano;
    private Vaso vasosGrande;
    private Azucarero azucar;

    // --- Setters y Getters ---

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

    // --- Metodo de seleccion de tipo de vaso ---

    /**
     * Retorna la instancia de Vaso segun el tipo indicado.
     * @param tipoDeVaso "pequeno", "mediano" o "grande"
     * @return instancia de Vaso correspondiente, o null si el tipo no existe
     */
    public Vaso getTipoDeVaso(String tipoDeVaso) {
        switch (tipoDeVaso.toLowerCase()) {
            case "pequeno": return vasosPequeno;
            case "mediano": return vasosMediano;
            case "grande":  return vasosGrande;
            default:        return null;
        }
    }

    // --- Metodo principal de dispensa ---

    /**
     * Intenta dispensar un vaso de cafe con azucar.
     *
     * @param vaso            instancia del tipo de vaso seleccionado
     * @param cantidadDeVasos cuantos vasos se quieren (normalmente 1)
     * @param cantidadDeAzucar cucharadas de azucar solicitadas
     * @return "Felicitaciones" si la operacion fue exitosa,
     *         "No hay Vasos"   si no hay stock del tipo de vaso,
     *         "No hay Cafe"    si no hay cafe suficiente,
     *         "No hay Azucar"  si no hay azucar suficiente.
     */
    public String getVasoDeCafe(Vaso vaso, int cantidadDeVasos, int cantidadDeAzucar) {

        // Paso 1: verificar vasos
        if (!vaso.hasVasos(cantidadDeVasos)) {
            return "No hay Vasos";
        }

        // Paso 2: verificar cafe (el contenido del vaso define las onzas requeridas)
        if (!cafe.hasCafe(vaso.getContenido())) {
            return "No hay Cafe";
        }

        // Paso 3: verificar azucar
        if (!azucar.hasAzucar(cantidadDeAzucar)) {
            return "No hay Azucar";
        }

        // Paso 4: todo disponible, descontar inventarios
        vaso.giveVasos(cantidadDeVasos);
        cafe.giveCafe(vaso.getContenido());
        azucar.giveAzucar(cantidadDeAzucar);

        return "Felicitaciones";
    }
}