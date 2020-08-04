package edu.fiuba.algo3.modelo.Entidades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test00ElJugadorSeCreaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");

        assertEquals("LeoProgramador", jugador.nombre());
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test01ElJugadorSumaPuntosCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");

        jugador.sumarPuntos(3);
        assertEquals(3, jugador.puntos());
        jugador.sumarPuntos(2);
        assertEquals(5, jugador.puntos());
    }
}
