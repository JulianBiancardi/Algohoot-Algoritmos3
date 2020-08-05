package edu.fiuba.algo3.modelo.Entidades;
import edu.fiuba.algo3.modelo.Exepciones.MultiplicadorCreadoConFactorInvalidoExcepcion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplicadorTest {

    @Test
    public void test01MultiplicadorSePuedeCrearSinEfectoObteniendoPuntosSinModificar() {
        Multiplicador multiplicador = Multiplicador.crearSinEfecto();

        int puntajeObtenido = multiplicador.obtenerPuntosBonificados(10);
        assertEquals(10, puntajeObtenido);
    }

    @Test
    public void test02MultiplicadorSePuedeCrearConFactorMultiplicacionPositivoObteniendoPuntosModificados() {
        int factorMultiplicador = 10;
        Multiplicador multiplicador = Multiplicador.crearConFactor(factorMultiplicador);

        int puntajeObtenido = multiplicador.obtenerPuntosBonificados(10);

        assertEquals(10 * factorMultiplicador, puntajeObtenido);
    }

    @Test
    public void test03MultiplicadorLanzaExcepcionSiSeCreaConFactorMultiplicacionNegativo() {
        int factorMultiplicador = -1;

        assertThrows(MultiplicadorCreadoConFactorInvalidoExcepcion.class,
                () -> {
                    Multiplicador.crearConFactor(factorMultiplicador);
                });
    }

    @Test
    public void test04MultiplicadorLanzaExcepcionSiSeCreaConFactorMultiplicacionNulo() {
        int factorMultiplicador = 0;

        assertThrows(MultiplicadorCreadoConFactorInvalidoExcepcion.class,
                () -> {
                    Multiplicador.crearConFactor(factorMultiplicador);
                });
    }
}
