package edu.fiuba.algo3.modelo.Entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriterioMultiplicadorTest {

    @Test
    public void test01SiCriterioMultiplicadorRecibePuntacionConEfectoMultiplicadorActivoPuntuaraAumentandoPuntajeConDichoEfecto() {
        int factorAumento = 1;
        int factorDisminucion = 1;
        int factorMultiplicador = 10000;
        int aciertos = 10;
        int resultadoEsperado = factorAumento * factorMultiplicador * aciertos;
        CriterioMultiplicador criterio = new CriterioMultiplicador(factorAumento, factorDisminucion);
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.agregarMultiplicador(1, Multiplicador.crearConFactor(factorMultiplicador));

        puntuacion.utilizarMultiplicador(1);
        criterio.puntuar(puntuacion, aciertos);

        assertEquals(resultadoEsperado, puntuacion.obtenerPuntos());
    }

    @Test
    public void test02SiCriterioMultiplicadorRecibePuntacionConEfectoMultiplicadorInactivoPuntuaraAumentandoPuntajeSinDichoEfecto() {
        int factorAumento = 1;
        int factorDisminucion = 1;
        int factorMultiplicador = 10000;
        int aciertos = 10;
        int resultadoEsperado = factorAumento * aciertos;
        CriterioMultiplicador criterio = new CriterioMultiplicador(factorAumento, factorDisminucion);
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.agregarMultiplicador(1, Multiplicador.crearConFactor(factorMultiplicador));

        criterio.puntuar(puntuacion, aciertos);

        assertEquals(resultadoEsperado, puntuacion.obtenerPuntos());
    }

    @Test
    public void test03SiCriterioMultiplicadorRecibePuntacionConEfectoMultiplicadorInactivoPenalizaraDisminuyendoPuntajeSinDichoEfecto() {
        int factorAumento = 1;
        int factorDisminucion = 1;
        int factorMultiplicador = 10000;
        int aciertos = 10;
        int resultadoEsperado = -1 * factorAumento * aciertos;
        CriterioMultiplicador criterio = new CriterioMultiplicador(factorAumento, factorDisminucion);
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.agregarMultiplicador(1, Multiplicador.crearConFactor(factorMultiplicador));

        criterio.penalizar(puntuacion, aciertos);

        assertEquals(resultadoEsperado, puntuacion.obtenerPuntos());
    }

    @Test
    public void test04SiCriterioMultiplicadorRecibePuntacionConEfectoMultiplicadorActivoPenalizaraDisminuyendoPuntajeConDichoEfecto() {
        int factorAumento = 1;
        int factorDisminucion = 1;
        int factorMultiplicador = 10000;
        int aciertos = 10;
        int resultadoEsperado = -1 * factorMultiplicador * factorAumento * aciertos;
        CriterioMultiplicador criterio = new CriterioMultiplicador(factorAumento, factorDisminucion);
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.agregarMultiplicador(1, Multiplicador.crearConFactor(factorMultiplicador));

        puntuacion.utilizarMultiplicador(1);
        criterio.penalizar(puntuacion, aciertos);

        assertEquals(resultadoEsperado, puntuacion.obtenerPuntos());
    }
}
