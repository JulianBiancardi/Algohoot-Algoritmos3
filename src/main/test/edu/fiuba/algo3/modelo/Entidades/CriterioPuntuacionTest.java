package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.CriterioPuntuacion;
import edu.fiuba.algo3.modelo.Entidades.Puntuacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriterioPuntuacionTest {

    @Test
    public void test01CriterioPuntuacionPuedePuntearALaPuntuacionSegunAciertosRecibidos() {
        int factorAumento = 1;
        int factorDisminucion = 1;
        int aciertos = 10;
        int resultadoEsperado = factorAumento * aciertos;

        CriterioPuntuacion criterio = new CriterioPuntuacion(factorAumento, factorDisminucion);
        Puntuacion puntuacion = new Puntuacion();

        criterio.puntuar(puntuacion, aciertos);

        assertEquals(resultadoEsperado, puntuacion.obtenerPuntos());
    }

    @Test
    public void test02CriterioPuntuacionPuedePenalizarALaPuntuacionSegunErroresRecibidosObteniendoPuntuacionConPuntajeNegativo() {
        int factorAumento = 1;
        int factorDisminucion = 1;
        int errores = 10;
        int resultadoEsperado = -1 * factorAumento * errores;
        CriterioPuntuacion criterio = new CriterioPuntuacion(factorAumento, factorDisminucion);
        Puntuacion puntuacion = new Puntuacion();

        criterio.penalizar(puntuacion, errores);

        assertEquals(resultadoEsperado, puntuacion.obtenerPuntos());
    }

    @Test
    public void test03CriterioPuntuacionSeLaPuedeCrearConFactorAumentoYFactorDisminucion() {
        int factorAumento = 1;
        int factorDisminucion = 1;
        CriterioPuntuacion criterio = new CriterioPuntuacion(factorAumento, factorDisminucion);
        assertEquals(factorAumento, criterio.obtenerFactorAumento());
        assertEquals(factorDisminucion, criterio.obtenerFactorDisminucion());
    }

    //@Test
    public void test04CriterioPuntuacionNoSeLaPuedeCrearConFactoresNegativos() {
    }

    //@Test
    public void test05CriterioPuntuacionNoSeLaPuedeCrearConFactoresNulos() {
    }

}
