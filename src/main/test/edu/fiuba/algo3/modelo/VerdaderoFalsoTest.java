package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerdaderoFalsoTest {
/*
    @Test
    public void test00LasPreguntasSeCreanCorrectamente() {
        VerdaderoFalso pregunta = new VerdaderoFalso(true);

        assertTrue(pregunta.respuesta());
    }

    @Test
    public void test01SeCreaUnaPreguntaVoFConRespuestaFalseYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");
        VerdaderoFalso pregunta = new VerdaderoFalso(true);
        Respuesta respuesta = jugador.responder(false);

        assertFalse(pregunta.evaluar(respuesta));
    }

    @Test
    public void test02SeCreaUnaPreguntaVoFConRespuestaTrueYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");
        VerdaderoFalso pregunta = new VerdaderoFalso(true);
        Respuesta respuesta = jugador.responder(true);

        assertTrue(pregunta.evaluar(respuesta));
    }

    @Test
    public void test03RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");

        VerdaderoFalso pregunta = new VerdaderoFalso(true);

        ArrayList<Respuesta> respuestas = new  ArrayList<Respuesta>();
        respuestas.add(jugador1.responder(false));
        respuestas.add(jugador2.responder(false));

        pregunta.recibirRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test04RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        VerdaderoFalso pregunta = new VerdaderoFalso(true);

        ArrayList<Respuesta> respuestas = new  ArrayList<Respuesta>();
        respuestas.add(jugador1.responder(true));
        respuestas.add(jugador2.responder(true));

        pregunta.recibirRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test05RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        VerdaderoFalso pregunta = new VerdaderoFalso(true);

        ArrayList<Respuesta> respuestas = new  ArrayList<Respuesta>();
        respuestas.add(jugador1.responder(false));
        respuestas.add(jugador2.responder(true));

        pregunta.recibirRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 1);
    }

 */
}
