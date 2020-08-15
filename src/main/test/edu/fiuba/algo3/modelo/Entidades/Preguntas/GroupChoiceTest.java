package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.RespuestaGrupal;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.RespuestaOrdenada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {
    ArrayList<GroupChoice> preguntasGC = new ArrayList<>();

    @BeforeEach
    public void setUp() throws IOException {
        String texto = Files.readString(Path.of("preguntas/groupchoicetest.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        JsonArray preguntas = jsonObject.getAsJsonArray("GroupChoice");

        for (JsonElement jsonPregunta : preguntas) {
            GroupChoice pregunta = GroupChoice.recuperar(jsonPregunta.getAsJsonObject());
            preguntasGC.add(pregunta);
        }
    }

    @Test
    public void test01AmbosGruposConDosRespuestasCorrectasCadaUnoRespondeCorrectamente(){
        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares", nombreGrupo1, nombreGrupo2);
        pregunta.nuevaOpcionGrupo1("2");
        pregunta.nuevaOpcionGrupo2("3");
        pregunta.nuevaOpcionGrupo1("4");
        pregunta.nuevaOpcionGrupo2("5");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test02AmbosGruposConDosRespuestasCorrectasCadaUnoRespondeIncorrectamente(){
        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares",nombreGrupo1, nombreGrupo2);
        pregunta.nuevaOpcionGrupo1("2");
        pregunta.nuevaOpcionGrupo2("3");
        pregunta.nuevaOpcionGrupo1("4");
        pregunta.nuevaOpcionGrupo2("5");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test03GruposConDistintaCantidadDeOpcionesRespondeCorrectamente(){
        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares",nombreGrupo1, nombreGrupo2);
        pregunta.nuevaOpcionGrupo1("2");
        pregunta.nuevaOpcionGrupo1("4");
        pregunta.nuevaOpcionGrupo1("6");
        pregunta.nuevaOpcionGrupo2("5");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test04AmbosGruposConDosRespuestasCorrectasCadaUnoRespondenAmbosCorrectamente(){
        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares",nombreGrupo1, nombreGrupo2);
        pregunta.nuevaOpcionGrupo1("2");
        pregunta.nuevaOpcionGrupo2("3");
        pregunta.nuevaOpcionGrupo1("4");
        pregunta.nuevaOpcionGrupo2("5");
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Julianaso");
        RespuestaGrupal respuestaJugador1 = new RespuestaGrupal(jugador1, pregunta);
        RespuestaGrupal respuestaJugador2 = new RespuestaGrupal(jugador2, pregunta);

        //Responde jugador1
        respuestaJugador1.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcionGrupo1(pregunta.obtenerOpcion(2));
        respuestaJugador1.agregarOpcionGrupo2(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        //Responde jugador2
        respuestaJugador2.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcionGrupo1(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcionGrupo2(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test05AmbosGruposConDosRespuestasCorrectasCadaUnoAmbosRespondeIncorrectamente(){
        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares",nombreGrupo1, nombreGrupo2);
        pregunta.nuevaOpcionGrupo1("2");
        pregunta.nuevaOpcionGrupo2("3");
        pregunta.nuevaOpcionGrupo1("4");
        pregunta.nuevaOpcionGrupo2("5");
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        RespuestaGrupal respuestaJugador1 = new RespuestaGrupal(jugador1, pregunta);
        RespuestaGrupal respuestaJugador2 = new RespuestaGrupal(jugador2, pregunta);

        //Responde jugador1
        respuestaJugador1.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcionGrupo2(pregunta.obtenerOpcion(2));
        respuestaJugador1.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        //Responde jugador2
        respuestaJugador2.agregarOpcionGrupo1(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcionGrupo2(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcionGrupo2(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test06GruposConDistintaCantidadDeOpcionesUnoRespondeCorrectamenteYOtroNo(){
        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares",nombreGrupo1, nombreGrupo2);
        pregunta.nuevaOpcionGrupo1("2");
        pregunta.nuevaOpcionGrupo1("4");
        pregunta.nuevaOpcionGrupo1("6");
        pregunta.nuevaOpcionGrupo2("5");
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Fede");
        RespuestaGrupal respuestaJugador1 = new RespuestaGrupal(jugador1, pregunta);
        RespuestaGrupal respuestaJugador2 = new RespuestaGrupal(jugador2, pregunta);

        //Responde jugador1
        respuestaJugador1.agregarOpcionGrupo1(pregunta.obtenerOpcion(3));
        respuestaJugador1.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcionGrupo2(pregunta.obtenerOpcion(2));

        //Responde jugador2
        respuestaJugador2.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcionGrupo1(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test07() {
        GroupChoice pregunta = preguntasGC.get(0);
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuesta = new RespuestaGrupal(jugador, pregunta);

        respuesta.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcionGrupo2(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }
}
