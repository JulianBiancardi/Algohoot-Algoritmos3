package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RespuestaTest {

    @Test
    public void test00LaRespuestaSeCreaCorrectamente() {
        Jugador jugador = new Jugador("Joaco");
        Respuesta respuesta = new Respuesta(true, jugador);

        assertEquals(jugador, respuesta.responsable());
        assertTrue(respuesta.valor());
    }

    @Test
    public void test01LaRespuestaDelegaLaSumaDePuntosCorrectamente() {
        Jugador jugador = new Jugador("Joaco");
        Respuesta respuesta = new Respuesta(true, jugador);

        respuesta.sumarPuntos(1);

        assertEquals(1 ,jugador.puntos());
    }
}
