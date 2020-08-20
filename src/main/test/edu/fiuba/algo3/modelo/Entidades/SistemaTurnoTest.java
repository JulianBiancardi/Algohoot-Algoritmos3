package edu.fiuba.algo3.modelo.Entidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaTurnoTest {

    @Test
    public void test01AgregoDosJugadoresYCambiaDeTurnoCorrectamente() {
        Jugador jugador;
        SistemaTurnos turno = new SistemaTurnos();

        jugador = new Jugador("Tomas");
        turno.agregarJugador(jugador);

        jugador = new Jugador("Martin");
        turno.agregarJugador(jugador);

        assertEquals("Tomas",turno.jugadorActual().nombre());
        turno.siguienteTurno();
        assertEquals("Martin",turno.jugadorActual().nombre());
        turno.siguienteTurno();
        assertEquals("Tomas",turno.jugadorActual().nombre());
        turno.siguienteTurno();
        assertEquals("Martin",turno.jugadorActual().nombre());
        turno.siguienteTurno();
    }

    @Test
    public void test02AgregoTresJugadoresYCambiaDeTurnoCorrectamente() {
        Jugador jugador;
        SistemaTurnos turno = new SistemaTurnos();

        jugador = new Jugador("Tomas");
        turno.agregarJugador(jugador);

        jugador = new Jugador("Martin");
        turno.agregarJugador(jugador);

        jugador = new Jugador("Chiki");
        turno.agregarJugador(jugador);

        assertEquals("Tomas",turno.jugadorActual().nombre());
        turno.siguienteTurno();
        assertEquals("Martin",turno.jugadorActual().nombre());
        turno.siguienteTurno();
        assertEquals("Chiki",turno.jugadorActual().nombre());
        turno.siguienteTurno();
        assertEquals("Tomas",turno.jugadorActual().nombre());
        turno.siguienteTurno();
        assertEquals("Martin",turno.jugadorActual().nombre());
        turno.siguienteTurno();
        assertEquals("Chiki",turno.jugadorActual().nombre());
    }

}
