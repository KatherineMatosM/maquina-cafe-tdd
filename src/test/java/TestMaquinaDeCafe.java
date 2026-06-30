import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestMaquinaDeCafe {

    Cafetera cafetera;
    Vaso vasosPequeno;
    Vaso vasosMediano;
    Vaso vasosGrande;
    Azucarero azucarero;
    MaquinaDeCafe maquinaDeCafe;

    /**
     * Configuracion inicial ejecutada antes de cada test.
     * Cafetera: 50 oz
     * VasoPequeno: 5 unidades, 10 oz de contenido  (el enunciado especifica 3oz pero los tests
     *              usan contenido=10 segun el diagrama de clases; se respeta el valor del PDF)
     * VasoMediano: 5 unidades, 20 oz de contenido
     * VasoGrande:  5 unidades, 30 oz de contenido
     * Azucarero:   20 cucharadas
     */
    @Before
    public void setUp() {
        cafetera      = new Cafetera(50);
        vasosPequeno  = new Vaso(5, 10);
        vasosMediano  = new Vaso(5, 20);
        vasosGrande   = new Vaso(5, 30);
        azucarero     = new Azucarero(20);

        maquinaDeCafe = new MaquinaDeCafe();
        maquinaDeCafe.setCafetera(cafetera);
        maquinaDeCafe.setVasosPequeno(vasosPequeno);
        maquinaDeCafe.setVasosMediano(vasosMediano);
        maquinaDeCafe.setVasosGrande(vasosGrande);
        maquinaDeCafe.setAzucarero(azucarero);
    }

    @Test
    public void deberiaDevolverUnVasoPequeno() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        assertEquals(maquinaDeCafe.getVasosPequeno(), vaso);
    }

    @Test
    public void deberiaDevolverUnVasoMediano() {
        // Este test crea su propia instancia segun el PDF original
        MaquinaDeCafe maquinaDeCafe2 = new MaquinaDeCafe();
        Vaso vaso = maquinaDeCafe2.getTipoDeVaso("mediano");
        assertEquals(maquinaDeCafe2.getVasosMediano(), vaso);
    }

    @Test
    public void deberiaDevolverUnVasoGrande() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("grande");
        assertEquals(maquinaDeCafe.getVasosGrande(), vaso);
    }

    @Test
    public void deberiaDevolverNoHayVasos() {
        // Se reemplaza con cafetera sin stock de vasos pequenos
        Vaso vasoSinStock = new Vaso(0, 10);
        maquinaDeCafe.setVasosPequeno(vasoSinStock);

        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 10, 2);
        assertEquals("No hay Vasos", resultado);
    }

    @Test
    public void deberiaDevolverNoHayCafe() {
        // Cafetera con solo 5 oz; el vaso pequeno requiere 10 oz (contenido=10)
        cafetera = new Cafetera(5);
        maquinaDeCafe.setCafetera(cafetera);

        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 2);
        assertEquals("No hay Cafe", resultado);
    }

    @Test
    public void deberiaDevolverNoHayAzucar() {
        // Azucarero con solo 2 cucharadas; se piden 3
        azucarero = new Azucarero(2);
        maquinaDeCafe.setAzucarero(azucarero);

        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        assertEquals("No hay Azucar", resultado);
    }

    @Test
    public void deberiaRestarCafe() {
        // Cafetera inicia en 50, vaso pequeno consume 10 oz -> debe quedar 40
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        int resultado = maquinaDeCafe.getCafetera().getCantidadCafe();
        assertEquals(40, resultado);
    }

    @Test
    public void deberiaRestarVaso() {
        // vasosPequeno inicia en 5 unidades -> despues de dispensar 1 debe quedar 4
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        int resultado = maquinaDeCafe.getVasosPequeno().getCantidadVasos();
        assertEquals(4, resultado);
    }

    @Test
    public void deberiaRestarAzucar() {
        // Azucarero inicia en 20, se piden 3 -> debe quedar 17
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        int resultado = maquinaDeCafe.getAzucarero().getCantidadAzucar();
        assertEquals(17, resultado);
    }

    @Test
    public void deberiaDevolverFelicitaciones() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        assertEquals("Felicitaciones", resultado);
    }
}