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

        VoF pregunta = new VoF("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador.responder('B');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02SeCreaUnaPreguntaVoFClasicoConRespuestaTrueYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");

        VoF pregunta = new VoF("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador.responder('A');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");

        VoF pregunta = new VoF("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador1.responder('B');
        jugador2.responder('B');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test04RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        VoF pregunta = new VoF("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador1.responder('A');
        jugador2.responder('A');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test05RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        VoF pregunta = new VoF("Te llamas Leo", new Clasico());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador1.responder('B');
        jugador2.responder('A');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test06SeCreaUnaPreguntaVoFConPenalidadConRespuestaFalseYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");

        VoF pregunta = new VoF("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador.responder('B');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test07SeCreaUnaPreguntaVoFConPenalidadConRespuestaTrueYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");

        VoF pregunta = new VoF("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador.responder('A');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test08RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");

        VoF pregunta = new VoF("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador1.responder('B');
        jugador2.responder('B');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), -1);
    }

    @Test
    public void test09RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        VoF pregunta = new VoF("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador1.responder('A');
        jugador2.responder('A');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test10RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");

        VoF pregunta = new VoF("Te llamas Leo", new ConPenalidad());
        pregunta.agregarOpciones(new Opcion("Opcion de prueba correcta", true));
        pregunta.agregarOpciones(new Opcion("Opcion de prueba incorrecta", false));
        jugador1.responder('B');
        jugador2.responder('A');
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        pregunta.evaluarRespuestas(jugadores);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), 1);
    }

}
