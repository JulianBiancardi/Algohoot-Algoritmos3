package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;  //Para que funcionen las test

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals; //Para los assertions

public class Verdadero_FalsoTest {

    @Test
    public void test01SeCreaUnaPreguntaVoF() {

        VerdaderoFalso pregunta = new VerdaderoFalso(true);

        assertEquals(pregunta.evaluar(new Respuesta(false,null)), false);
        assertEquals(pregunta.evaluar(new Respuesta(true,null)), true);
    }

    @Test
    public void test02RecibeUnaListaDeRespuestasTodasIncorrectas(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JoaqoElCapi");

        VerdaderoFalso pregunta = new VerdaderoFalso(true);

        ArrayList<Respuesta> respuestas = new  ArrayList<Respuesta>();
        Respuesta respuesta1 = jugador1.responder(false);
        Respuesta respuesta2 = jugador2.responder(false);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.recibirRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test03RecibeUnaListaDeRespuestasTodasCorrectas(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        VerdaderoFalso pregunta = new VerdaderoFalso(true);

        ArrayList<Respuesta> respuestas = new  ArrayList<Respuesta>();
        Respuesta respuesta1 = jugador1.responder(true);
        Respuesta respuesta2 = jugador2.responder(true);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.recibirRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test04RecibeUnaListaDeRespuestasDistintas(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        VerdaderoFalso pregunta = new VerdaderoFalso(true);

        ArrayList<Respuesta> respuestas = new  ArrayList<Respuesta>();
        Respuesta respuesta1 = jugador1.responder(false);
        Respuesta respuesta2 = jugador2.responder(true);
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.recibirRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 1);
    }
}
