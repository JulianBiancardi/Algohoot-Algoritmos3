package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {

    @Test
    public void test01SeCreaUnaPreguntaVoFClasicoConRespuestaFalseYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");
        VoF pregunta = new VoF("¿2 + 2 = 5?", new Clasico(), false);
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02SeCreaUnaPreguntaVoFClasicoConRespuestaTrueYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new Clasico(), true);
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new Clasico(), true);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        Respuesta respuesta1 = new Respuesta(jugador1);
        respuesta1.agregarOpcion(opcionesPosibles.obtener(1));
        Respuesta respuesta2 = new Respuesta(jugador2);
        respuesta2.agregarOpcion(opcionesPosibles.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 0);
    }

    @Test
    public void test04RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new Clasico(), true);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        Respuesta respuesta1 = new Respuesta(jugador1);
        respuesta1.agregarOpcion(opcionesPosibles.obtener(0));
        Respuesta respuesta2 = new Respuesta(jugador2);
        respuesta2.agregarOpcion(opcionesPosibles.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test05RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos() {
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new Clasico(), true);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        Respuesta respuesta1 = new Respuesta(jugador1);
        respuesta1.agregarOpcion(opcionesPosibles.obtener(1));
        Respuesta respuesta2 = new Respuesta(jugador2);
        respuesta2.agregarOpcion(opcionesPosibles.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test06SeCreaUnaPreguntaVoFConPenalidadConRespuestaFalseYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");
        VoF pregunta = new VoF("¿2 + 2 = 5?", new ConPenalidad(), false);
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test07SeCreaUnaPreguntaVoFConPenalidadConRespuestaTrueYEvaluaCorrectamente() {
        Jugador jugador = new Jugador("LeoProgramador");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new ConPenalidad(), true);
        Respuesta respuesta = new Respuesta(jugador);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        respuesta.agregarOpcion(opcionesPosibles.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test08RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new ConPenalidad(), true);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        Respuesta respuesta1 = new Respuesta(jugador1);
        respuesta1.agregarOpcion(opcionesPosibles.obtener(1));
        Respuesta respuesta2 = new Respuesta(jugador2);
        respuesta2.agregarOpcion(opcionesPosibles.obtener(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), -1);
    }

    @Test
    public void test09RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new ConPenalidad(), true);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        Respuesta respuesta1 = new Respuesta(jugador1);
        respuesta1.agregarOpcion(opcionesPosibles.obtener(0));
        Respuesta respuesta2 = new Respuesta(jugador2);
        respuesta2.agregarOpcion(opcionesPosibles.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test10RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("JulianCraack");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new ConPenalidad(), true);

        ListaOpciones opcionesPosibles = pregunta.obtenerOpciones();
        Respuesta respuesta1 = new Respuesta(jugador1);
        respuesta1.agregarOpcion(opcionesPosibles.obtener(1));
        Respuesta respuesta2 = new Respuesta(jugador2);
        respuesta2.agregarOpcion(opcionesPosibles.obtener(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), 1);
    }
}
