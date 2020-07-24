package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerdaderoFalsoTest {

    @Test
    public void test01SeCreaUnaPreguntaVoFClasicoConRespuestaFalseYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        VoF pregunta = new VoF("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02SeCreaUnaPreguntaVoFClasicoConRespuestaTrueYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        VoF pregunta = new VoF("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        VoF pregunta = new VoF("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador1));
        respuestas.add(new Respuesta(opciones.get(1), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test04RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        VoF pregunta = new VoF("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador1));
        respuestas.add(new Respuesta(opciones.get(0), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test05RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        VoF pregunta = new VoF("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador1));
        respuestas.add(new Respuesta(opciones.get(0), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test06SeCreaUnaPreguntaVoFConPenalidadConRespuestaFalseYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        VoF pregunta = new VoF("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test07SeCreaUnaPreguntaVoFConPenalidadConRespuestaTrueYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        VoF pregunta = new VoF("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test08RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        VoF pregunta = new VoF("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador1));
        respuestas.add(new Respuesta(opciones.get(1), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), -1);
    }

    @Test
    public void test09RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        VoF pregunta = new VoF("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador1));
        respuestas.add(new Respuesta(opciones.get(0), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test10RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        VoF pregunta = new VoF("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador1));
        respuestas.add(new Respuesta(opciones.get(0), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), 1);
    }
}
