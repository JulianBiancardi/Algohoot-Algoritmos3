package edu.fiuba.algo3.modelo.Entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorTest {

    @Test
    public void test01MultiplicadorSePuedeCrearSinEfectoObteniendoPuntosSinModificar() {
        Multiplicador multiplicador = Multiplicador.crearMultiplicadorNulo();

        int puntajeObtenido = multiplicador.aplicarMultiplicador(10);
        assertEquals(10, puntajeObtenido);
    }

    @Test
    public void test02MultiplicadorDobleModificaPuntosCorrectamente(){
        Multiplicador multiplicador = Multiplicador.crearMultiplicadorDoble();

        int puntajeObtenido = multiplicador.aplicarMultiplicador(10);

        assertEquals(10 * 2, puntajeObtenido);
    }

    @Test
    public void test03MultiplicadorTripleModificaPuntosCorrectamente(){
        Multiplicador multiplicador = Multiplicador.crearMultiplicadorTriple();

        int puntajeObtenido = multiplicador.aplicarMultiplicador(10);

        assertEquals(10 * 3, puntajeObtenido);
    }
}
