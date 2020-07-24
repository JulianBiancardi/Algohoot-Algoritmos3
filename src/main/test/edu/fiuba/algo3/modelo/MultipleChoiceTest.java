package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {

    @Test
    public void test01SeCreaUnaPreguntaChoiceConPuntajeParcialConRespuestaUnaCorrectaYFalla() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(2), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02SeCreaUnaPreguntaChoiceConPuntajeParcialConUnRespuestaCorrectaYAcierta() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaDos() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador));
        respuestas.add(new Respuesta(opciones.get(2), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test04SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaTres() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador));
        respuestas.add(new Respuesta(opciones.get(2), jugador));
        respuestas.add(new Respuesta(opciones.get(3), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test05RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador1));
        respuestas.add(new Respuesta(opciones.get(3), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test06RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador1));
        respuestas.add(new Respuesta(opciones.get(1), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test07RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new Clasico());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(2), jugador1));
        respuestas.add(new Respuesta(opciones.get(0), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test08SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYFalla() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        VoF pregunta = new VoF("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test09SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYAcierta() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test10SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaDos() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador));
        respuestas.add(new Respuesta(opciones.get(3), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test11SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaDos() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador));
        respuestas.add(new Respuesta(opciones.get(2), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-2, jugador.puntos());
    }

    @Test
    public void test12SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaTres() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador));
        respuestas.add(new Respuesta(opciones.get(2), jugador));
        respuestas.add(new Respuesta(opciones.get(3), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test13SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaTres() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador));
        respuestas.add(new Respuesta(opciones.get(2), jugador));
        respuestas.add(new Respuesta(opciones.get(3), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-3, jugador.puntos());
    }

    @Test
    public void test14SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaAciertaYFallaUnaVez() {
        Jugador jugador = new Jugador("LeoProgramador");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador));
        respuestas.add(new Respuesta(opciones.get(3), jugador));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test15RecibeUnaListaDeRespuestasTodasIncorrectasYAmbosPierdenPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador1));
        respuestas.add(new Respuesta(opciones.get(2), jugador1));
        respuestas.add(new Respuesta(opciones.get(2), jugador2));
        respuestas.add(new Respuesta(opciones.get(3), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -2);
        assertEquals(jugador2.puntos(), -2);
    }

    @Test
    public void test16RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(0), jugador1));
        respuestas.add(new Respuesta(opciones.get(0), jugador2));
        respuestas.add(new Respuesta(opciones.get(3), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 2);
    }

    @Test
    public void test17RecibeUnaListaDeRespuestasDistintasYElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        opciones.add(new Opcion("Opcion de prueba incorrecta", false));
        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", opciones, new ConPenalidad());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(new Respuesta(opciones.get(1), jugador1));
        respuestas.add(new Respuesta(opciones.get(3), jugador1));
        respuestas.add(new Respuesta(opciones.get(0), jugador2));
        respuestas.add(new Respuesta(opciones.get(2), jugador2));
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -2);
        assertEquals(jugador2.puntos(), 2);
    }
}
