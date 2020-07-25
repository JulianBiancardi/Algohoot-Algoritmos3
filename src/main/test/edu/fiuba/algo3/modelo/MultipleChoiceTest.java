package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {

    @Test
    public void test01SeCreaUnaPreguntaChoiceConPuntajeParcialConRespuestaUnaCorrectaYFalla() {
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador.responder('C');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02SeCreaUnaPreguntaChoiceConPuntajeParcialConUnRespuestaCorrectaYAcierta() {
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador.responder('A');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaDos() {
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        jugador.responder('A');
        jugador.responder('C');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test04SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaTres() {
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        jugador.responder('A');
        jugador.responder('C');
        jugador.responder('D');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test05RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador1.responder('B');
        jugador2.responder('D');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);


        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test06RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador1.responder('B');
        jugador2.responder('B');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test07RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador1.responder('C');
        jugador2.responder('A');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test08SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYFalla() {
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador.responder('B');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test09SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYAcierta() {
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador.responder('B');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test10SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaDos() {
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        jugador.responder('B');
        jugador.responder('D');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test11SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaDos() {
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        jugador.responder('A');
        jugador.responder('C');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(-2, jugador.puntos());
    }

    @Test
    public void test12SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaTres() {
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        jugador.responder('B');
        jugador.responder('C');
        jugador.responder('D');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test13SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaTres() {
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador.responder('A');
        jugador.responder('C');
        jugador.responder('D');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(-3, jugador.puntos());
    }

    @Test
    public void test14SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaAciertaYFallaUnaVez() {
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        jugador.responder('A');
        jugador.responder('D');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test15RecibeUnaListaDeRespuestasTodasIncorrectasYAmbosPierdenPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador1.responder('A');
        jugador1.responder('C');
        jugador2.responder('C');
        jugador2.responder('D');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(jugador1.puntos(), -2);
        assertEquals(jugador2.puntos(), -2);
    }

    @Test
    public void test16RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        jugador1.responder('A');
        jugador2.responder('A');
        jugador2.responder('D');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 2);
    }

    @Test
    public void test17RecibeUnaListaDeRespuestasDistintasYElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        MultipleChoice pregunta = new MultipleChoice("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador1.responder('B');
        jugador1.responder('D');
        jugador2.responder('A');
        jugador2.responder('C');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(jugador1.puntos(), -2);
        assertEquals(jugador2.puntos(), 2);
    }
}
