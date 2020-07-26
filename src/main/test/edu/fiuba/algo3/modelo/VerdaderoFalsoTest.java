package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.ConPenalidad;
import edu.fiuba.algo3.modelo.Preguntas.VoF;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {

    @Test
    public void test01SeCreaUnaPreguntaVoFClasicoConRespuestaFalseYEvaluaCorrectamente() {
        OpcionIncorrecta opcionElegidaPorJugador = new OpcionIncorrecta("Es verdadera");
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionElegidaPorJugador);
        OpcionCorrecta opcionPreguntaCorrecta = new OpcionCorrecta("Es falso");
        VoF pregunta = new VoF("¿2 + 2 = 5?", new Clasico(), opcionPreguntaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02SeCreaUnaPreguntaVoFClasicoConRespuestaTrueYEvaluaCorrectamente() {
        OpcionCorrecta opcionElegidaPorJugador = new OpcionCorrecta("Es verdadera");
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionElegidaPorJugador);
        OpcionCorrecta opcionPreguntaCorrecta = new OpcionCorrecta("Es verdadera");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new Clasico(), opcionPreguntaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        OpcionIncorrecta opcionElegidaPorJugador1 = new OpcionIncorrecta("Es falsa");
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(opcionElegidaPorJugador1);
        OpcionIncorrecta opcionElegidaPorJugador2 = new OpcionIncorrecta("Es falsa");
        Jugador jugador2 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(opcionElegidaPorJugador2);

        OpcionCorrecta opcionPreguntaCorrecta = new OpcionCorrecta("Es verdadera");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new Clasico(), opcionPreguntaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test04RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        OpcionCorrecta opcionElegidaPorJugador1 = new OpcionCorrecta("Es verdadera");
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(opcionElegidaPorJugador1);
        OpcionCorrecta opcionElegidaPorJugador2 = new OpcionCorrecta("Es verdadera");
        Jugador jugador2 = new Jugador("JulianCraack");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(opcionElegidaPorJugador2);

        OpcionCorrecta opcionPreguntaCorrecta = new OpcionCorrecta("Es verdadera");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new Clasico(), opcionPreguntaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test05RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos() {
        OpcionIncorrecta opcionElegidaPorJugador1 = new OpcionIncorrecta("Es falsa");
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(opcionElegidaPorJugador1);
        OpcionCorrecta opcionElegidaPorJugador2 = new OpcionCorrecta("Es verdadera");
        Jugador jugador2 = new Jugador("JulianCraack");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(opcionElegidaPorJugador2);

        OpcionCorrecta opcionPreguntaCorrecta = new OpcionCorrecta("Es verdadera");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new Clasico(), opcionPreguntaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test06SeCreaUnaPreguntaVoFConPenalidadConRespuestaFalseYEvaluaCorrectamente() {
        OpcionIncorrecta opcionElegidaPorJugador = new OpcionIncorrecta("Es verdadera");
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionElegidaPorJugador);
        OpcionCorrecta opcionPreguntaCorrecta = new OpcionCorrecta("Es falsa");
        VoF pregunta = new VoF("¿2 + 2 = 5?", new ConPenalidad(), opcionPreguntaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test07SeCreaUnaPreguntaVoFConPenalidadConRespuestaTrueYEvaluaCorrectamente() {
        OpcionIncorrecta opcionElegidaPorJugador = new OpcionIncorrecta("Es falsa");
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionElegidaPorJugador);
        OpcionCorrecta opcionPreguntaCorrecta = new OpcionCorrecta("Es verdadera");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new ConPenalidad(), opcionPreguntaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test08RecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        OpcionIncorrecta opcionElegidaPorJugador1 = new OpcionIncorrecta("Es falsa");
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(opcionElegidaPorJugador1);
        OpcionIncorrecta opcionElegidaPorJugador2 = new OpcionIncorrecta("Es falsa");
        Jugador jugador2 = new Jugador("JulianCraack");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(opcionElegidaPorJugador2);

        OpcionCorrecta opcionPreguntaCorrecta = new OpcionCorrecta("Es verdadera");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new ConPenalidad(), opcionPreguntaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), -1);
    }

    @Test
    public void test09RecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        OpcionCorrecta opcionElegidaPorJugador1 = new OpcionCorrecta("Es verdadera");
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(opcionElegidaPorJugador1);
        OpcionCorrecta opcionElegidaPorJugador2 = new OpcionCorrecta("Es verdadera");
        Jugador jugador2 = new Jugador("JulianCraack");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(opcionElegidaPorJugador2);

        OpcionCorrecta opcionPreguntaCorrecta = new OpcionCorrecta("Es verdadera");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new ConPenalidad(), opcionPreguntaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test10RecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        OpcionIncorrecta opcionElegidaPorJugador1 = new OpcionIncorrecta("Es FAAAALSA");
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        respuestaJugador1.agregarOpcion(opcionElegidaPorJugador1);
        OpcionCorrecta opcionElegidaPorJugador2 = new OpcionCorrecta("Es verdadera");
        Jugador jugador2 = new Jugador("JulianCraack");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador2.agregarOpcion(opcionElegidaPorJugador2);

        OpcionCorrecta opcionPreguntaCorrecta = new OpcionCorrecta("Es verdadera");
        VoF pregunta = new VoF("¿2 + 2 = 4?", new ConPenalidad(), opcionPreguntaCorrecta);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), 1);
    }
}
