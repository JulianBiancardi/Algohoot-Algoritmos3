/*
package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Excepciones.ChoiceTieneMaxCincoOpcionesError;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultipleChoiceTest {
    ArrayList<MultipleChoice> preguntasMC = new ArrayList<>();

    @BeforeEach
    public void setUp() throws IOException {
        String texto = Files.readString(Path.of("preguntas/multiplechoicetest.json"));
        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        JsonArray preguntas = jsonObject.getAsJsonArray("MultipleChoice");

        for (JsonElement jsonPregunta : preguntas) {
            MultipleChoice pregunta = MultipleChoice.recuperar(jsonPregunta.getAsJsonObject());
            preguntasMC.add(pregunta);
        }
    }

    @Test
    public void test01PreguntaChoiceConPuntajeParcialJugadorRespondeMal() {
        MultipleChoice pregunta = preguntasMC.get(0);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        // Elijo una incorrecta
        respuesta.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }


    @Test
    public void test02PreguntaChoiceConPuntajeParcialJugadorRespondeUnaBien() {
        MultipleChoice pregunta = preguntasMC.get(0);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        // Elijo una correcta
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03PreguntaChoiceConPuntajeParcialJugadorRespondeDosBien() {
        MultipleChoice pregunta = preguntasMC.get(0);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        // Elijo dos correcta
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());
    }


    @Test
    public void test04PreguntaChoiceConPuntajeParcialJugadorRespondeTresBien() {
        MultipleChoice pregunta = preguntasMC.get(0);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        // Elijo tres correcta
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test05PuntajeParcialRecibeUnaListaDeRespuestasIncorrectasYNingunoSumaPuntos(){
        MultipleChoice pregunta = preguntasMC.get(0);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test06PuntajeParcialRecibeUnaListaDeRespuestasConCorrectasYAmbosSumanPuntos(){
        MultipleChoice pregunta = preguntasMC.get(0);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(2, jugador2.puntos());
    }

    @Test
    public void test07PuntajeParcialRecibeUnaListaDeRespuestasYSoloElQueRespondioBienSumaPuntos(){
        MultipleChoice pregunta = preguntasMC.get(0);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(3, jugador2.puntos());
    }

    @Test
    public void test08PreguntaChoiceConPenalidadJugadorRespondeUnaMal() {
        MultipleChoice pregunta = preguntasMC.get(1);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elijo una incorrecta
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test09PreguntaChoiceConPenalidadJugadorRespondeUnaBien() {
        MultipleChoice pregunta = preguntasMC.get(1);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elijo una correcta
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test10PreguntaChoiceConPenalidadJugadorRespondeDosBien() {
        MultipleChoice pregunta = preguntasMC.get(1);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elijo dos correctas
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test11PreguntaChoiceConPenalidadJugadorRespondeDosMal() {
        MultipleChoice pregunta = preguntasMC.get(1);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elijo dos incorrectas
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador.puntos());
    }

    @Test
    public void test12PenalidadRecibeUnaListaDeRespuestasIncorrectasYAmbosPierdenPuntos() {
        MultipleChoice pregunta = preguntasMC.get(1);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-1, jugador1.puntos());
        assertEquals(-2, jugador2.puntos());
    }

    @Test
    public void test13PenalidadRecibeUnaListaDeRespuestasCorrectasYAmbosSumanPuntos() {
        MultipleChoice pregunta = preguntasMC.get(1);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(2, jugador2.puntos());
    }

    @Test
    public void test14PenalidadRecibeUnaListaDeRespuestasYSumaPuntosElQueAcertoPierdeElQueRespondioMal() {
        MultipleChoice pregunta = preguntasMC.get(1);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador1.puntos());
        assertEquals(2, jugador2.puntos());
    }

    @Test
    public void test15PreguntaChoiceClasicoJugadorRespondeMal() {
        MultipleChoice pregunta = preguntasMC.get(2);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elijo incorrecta
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test16PreguntaChoiceClasicoJugadorRespondeBien() {
        MultipleChoice pregunta = preguntasMC.get(2);
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
    public void test17PreguntaChoiceClasicoJugadorRespondeUnaBienYUnaMal() {
        MultipleChoice pregunta = preguntasMC.get(2);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elijo una correcta y una incorrecta
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test18PreguntaChoiceClasicoJugadorRespondeUnaBienYDosMal() {
        MultipleChoice pregunta = preguntasMC.get(2);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elijo una correcta y dos incorrectas
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test19PreguntaChoiceChoiceClasicoConDosRespuestaCorrectaYAciertaLasDos() {
        MultipleChoice pregunta = preguntasMC.get(3);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elije las dos correctas
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test20PreguntaChoiceClasicoConDosRespuestaCorrectaYAciertaUnaPeroNoSumaPuntos() {
        MultipleChoice pregunta = preguntasMC.get(3);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elije solo una correctas
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test21PreguntaChoiceClasicoConDosRespuestaCorrectaYAciertaDosPeroFallaUna() {
        MultipleChoice pregunta = preguntasMC.get(3);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        // Elije las dos correctas pero una incorrecta
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test22ClasicoRecibeUnaListaDeRespuestasIncorrectasYAmbosNosSumanPuntos(){
        MultipleChoice pregunta = preguntasMC.get(3);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test23ClasicaRecibeUnaListaDeRespuestasCorrectasYAmbosSumanPuntos(){
        MultipleChoice pregunta = preguntasMC.get(3);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test24ClasicaRecibeUnaListaDeRespuestasYElQueRespondioBienSumaPuntos(){
        MultipleChoice pregunta = preguntasMC.get(3);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test25JugadorRespondeVariasPreguntas(){
        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta = preguntasMC.get(0);
        Respuesta respuesta = new Respuesta(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        // Respondio dos bien
        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());

        pregunta = preguntasMC.get(1);
        respuesta = new Respuesta(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        // Respondio una bien y una mal
        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());

        pregunta = preguntasMC.get(2);
        respuesta = new Respuesta(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        // Respondio una bien y una mal
        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());

        pregunta = preguntasMC.get(3);
        respuesta = new Respuesta(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        // Respondio correcto
        pregunta.evaluarRespuestas(respuestas);
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test26SeCreaUnaPreguntaChoiceConPenalidadConSeisOpcionesYLanzaExcepcion() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Japon", false);
        pregunta.nuevaOpcion("Perú", true);
        pregunta.nuevaOpcion("Venezuela", true);
        pregunta.nuevaOpcion("Italia", false);

        assertThrows(ChoiceTieneMaxCincoOpcionesError.class,
                () -> pregunta.nuevaOpcion("Francia", false));
    }
}*/
