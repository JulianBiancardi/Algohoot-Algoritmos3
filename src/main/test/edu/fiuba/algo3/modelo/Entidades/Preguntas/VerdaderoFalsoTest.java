package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerdaderoFalsoTest {

    @Test
    public void test00() {
        VoF pregunta = VoF.conModoClasico("Hola?",true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test01SeCreaUnaPreguntaVoFClasicoConRespuestaFalseErraYEvaluaCorrectamente() {
        VoF pregunta = VoF.conModoClasico("¿2 + 2 = 4?",true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1)); //Elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02SeCreaUnaPreguntaVoFClasicoConRespuestaTrueAciertaYEvaluaCorrectamente() {
        VoF pregunta = VoF.conModoClasico("¿2 + 2 = 4?",true);

        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0)); //Elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03VoFClasicoRecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        VoF pregunta = VoF.conModoClasico("¿2 + 2 = 4?",true);

        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1)); //Elijo incorrecta
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1)); //Elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test04VoFClasicoRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        VoF pregunta = VoF.conModoClasico("¿2 + 2 = 4?",true);

        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0)); //Elijo correcta
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0)); //Elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test05VoFClasicoRecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos() {
        VoF pregunta = VoF.conModoClasico("¿2 + 2 = 4?",true);

        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0)); //Elijo correcta
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1)); //Elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test06SeCreaUnaPreguntaVoFConPenalidadConRespuestaFalseErraYEvaluaCorrectamente() {
        VoF pregunta = VoF.conModoPenalidad("¿2 + 2 = 4?",true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1)); //Elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test07SeCreaUnaPreguntaVoFConPenalidadConRespuestaTrueAciertaYEvaluaCorrectamente() {
        VoF pregunta = VoF.conModoPenalidad("¿2 + 2 = 4?",true);

        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0)); //Elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test08VoFConPenalidadRecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        VoF pregunta = VoF.conModoPenalidad("¿2 + 2 = 4?",true);

        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1)); //Elijo incorrecta
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1)); //Elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), -1);
    }

    @Test
    public void test09VoFConPenalidadRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        VoF pregunta = VoF.conModoPenalidad("¿2 + 2 = 4?",true);

        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Tomas");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0)); //Elijo correcta
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0)); //Elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test10VoFConPenalidadRecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        VoF pregunta = VoF.conModoPenalidad("¿2 + 2 = 4?",true);

        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Tomas");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1)); //Elijo correcta
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0)); //Elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test11() throws IOException {
        VoF pregunta = VoF.recuperar("voftest.json");
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }
}
