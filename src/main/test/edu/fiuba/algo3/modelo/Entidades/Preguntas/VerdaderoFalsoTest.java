/*
package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    ArrayList<VoF> preguntasVoF = new ArrayList<>();

    @BeforeEach
    public void setUp() throws IOException {
        String texto = Files.readString(Path.of("preguntas/voftest.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        JsonArray preguntas = jsonObject.getAsJsonArray("VoF");

        for (JsonElement jsonPregunta : preguntas) {
            VoF pregunta = VoF.recuperar(jsonPregunta.getAsJsonObject());
            preguntasVoF.add(pregunta);
        }
    }

    @Test
    public void test01PreguntaVoFClasicoConRespuestaFalseJugadorRespondeMal() {
        VoF pregunta = preguntasVoF.get(1);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elijo incorrecta
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02PreguntaVoFClasicoConRespuestaTrueJugadorRespondeBien() {
        VoF pregunta = preguntasVoF.get(0);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elijo correcta
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03VoFClasicoRecibeUnaListaDeRespuestasIncorrectasYNingunoSumaPuntos(){
        VoF pregunta = preguntasVoF.get(0);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test04VoFClasicoRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        VoF pregunta = preguntasVoF.get(0);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test05VoFClasicoRecibeUnaListaDeRespuestasYSoloElQueRespondioBienSumaPuntos() {
        VoF pregunta = preguntasVoF.get(1);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test06PreguntaVoFConPenalidadConRespuestaFalseJugadoreRespondeMal() {
        VoF pregunta = preguntasVoF.get(3);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elijo incorrecta
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test07PreguntaVoFConPenalidadConRespuestaTrueJugadoreRespondeBien() {
        VoF pregunta = preguntasVoF.get(3);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elijo incorrecta
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test08VoFConPenalidadRecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        VoF pregunta = preguntasVoF.get(3);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), -1);
    }

    @Test
    public void test09VoFConPenalidadRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        VoF pregunta = preguntasVoF.get(3);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Tomas");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test10VoFConPenalidadRecibeUnaListaDeRespuestasYSoloElQueRespondioBienSumaPuntos(){
        VoF pregunta = preguntasVoF.get(2);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Jugador jugador2 = new Jugador("Tomas");
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test21JugadorRespondeVariasPreguntas(){
        Jugador jugador = new Jugador("LeoProgramador");

        VoF pregunta = preguntasVoF.get(0);
        Respuesta respuesta = new Respuesta(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        // Respondio bien
        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());

        pregunta = preguntasVoF.get(1);
        respuesta = new Respuesta(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        // Respondio mal
        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());

        pregunta = preguntasVoF.get(2);
        respuesta = new Respuesta(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        // Respondio bien
        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());

        pregunta = preguntasVoF.get(3);
        respuesta = new Respuesta(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        // Respondio mal
        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }
}
*/
