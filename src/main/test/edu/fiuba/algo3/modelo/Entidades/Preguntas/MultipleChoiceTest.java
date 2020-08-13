package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
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
    public void test00() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Corea", false);
        pregunta.nuevaOpcion("Uruguay", true);
        pregunta.nuevaOpcion("Colombia", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }


    @Test
    public void test01SeCreaUnaPreguntaChoiceConPuntajeParcialConUnaRespuestaCorrectaYErra() {
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("China", false);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Rusia", false);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.agregarOpcion(pregunta.obtenerOpcion(2)); //elijo una incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }


    @Test
    public void test02SeCreaUnaPreguntaChoiceConPuntajeParcialConUnRespuestaCorrectaYAcierta() {
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("China", false);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Rusia", false);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.agregarOpcion(pregunta.obtenerOpcion(0)); //elijo la única correcta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaDos() {
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Alemania", false);
        pregunta.nuevaOpcion("Brasil", true);
        pregunta.nuevaOpcion("Chile", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());
    }


    @Test
    public void test04SeCreaUnaPreguntaChoiceConPuntajeParcialConMasDeUnaRespuestaCorrectaYAciertaTres() {
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Alemania", false);
        pregunta.nuevaOpcion( "Brasil", true);
        pregunta.nuevaOpcion( "Chile", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test05PuntajeParcialRecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("China", false);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Rusia", false);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test06PuntajeParcialRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.nuevaOpcion("China", false);
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Rusia", false);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test07PuntajeParcailRecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.nuevaOpcion("Japon", false);
        pregunta.nuevaOpcion("España", false);
        pregunta.nuevaOpcion("Colombia", true);
        pregunta.nuevaOpcion("Rusia", false);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test08SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYFalla() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.nuevaOpcion("Japon", false);
        pregunta.nuevaOpcion("España", false);
        pregunta.nuevaOpcion("Colombia", true);
        pregunta.nuevaOpcion("Rusia", false);

        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-1, jugador.puntos());

    }

    @Test
    public void test09SeCreaUnaPreguntaChoiceConPenalidadConUnaRespuestaCorrectaYAcierta() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.nuevaOpcion("China", false);
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Rusia", false);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test10SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaDos() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.nuevaOpcion("Japon", false);
        pregunta.nuevaOpcion("Uruguay", true);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Venezuela", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());
    }

    @Test
    public void test11SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaDos() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.nuevaOpcion("Japon", false);
        pregunta.nuevaOpcion("Uruguay", true);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Venezuela", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador.puntos());
    }

    @Test
    public void test12SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYAciertaTres() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.nuevaOpcion("Japon", false);
        pregunta.nuevaOpcion("Uruguay", true);
        pregunta.nuevaOpcion("Peru", true);
        pregunta.nuevaOpcion("Venezuela", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(3, jugador.puntos());
    }

    @Test
    public void test13SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaYFallaTres() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.nuevaOpcion("Japon", false);
        pregunta.nuevaOpcion("Uruguay", true);
        pregunta.nuevaOpcion("Peru", true);
        pregunta.nuevaOpcion("Alemania", false);
        pregunta.nuevaOpcion("Australia", false);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(4));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-3, jugador.puntos());
    }

    @Test
    public void test14SeCreaUnaPreguntaChoiceConPenalidadConMasDeUnaRespuestaCorrectaAciertaYFallaUnaVez() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.nuevaOpcion("Japon", false);
        pregunta.nuevaOpcion("Uruguay", true);
        pregunta.nuevaOpcion("Peru", true);
        pregunta.nuevaOpcion("Venezuela", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test15ConPenalidadRecibeUnaListaDeRespuestasTodasIncorrectasYAmbosPierdenPuntos() {
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.nuevaOpcion("Portugal", false);
        pregunta.nuevaOpcion("Bolivia", true);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Rusia", false);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador1.puntos());
        assertEquals(-2, jugador2.puntos());
    }

    @Test
    public void test16ConPenalidadRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.nuevaOpcion("Paraguay", true);
        pregunta.nuevaOpcion("Dinamarca", false);
        pregunta.nuevaOpcion("Perú", true);
        pregunta.nuevaOpcion("Venezuela", true);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(2, jugador2.puntos());
    }

    @Test
    public void test17ConPenalidadRecibeUnaListaDeRespuestasDistintasYElQueRespondioBienSumaPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.nuevaOpcion("Uruguay", true);
        pregunta.nuevaOpcion("Japon", false);
        pregunta.nuevaOpcion("Venezuela", true);
        pregunta.nuevaOpcion("Egipto", false);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(-2, jugador1.puntos());
        assertEquals(2, jugador2.puntos());
    }

    @Test
    public void test18SeCreaUnaPreguntaChoiceClasicoConUnaRespuestaCorrectaYFalla() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Portugal", false);
        pregunta.nuevaOpcion("Bolivia", true);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Rusia", false);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test19SeCreaUnaPreguntaChoiceClasicoConUnaRespuestaCorrectaYAcierta() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Sudafrica", false);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Suiza", false);
        pregunta.nuevaOpcion("Bolivia", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test20SeCreaUnaPreguntaChoiceChoiceClasicoConUnaRespuestaCorrectaYAciertaPeroFallaUna() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Sudafrica", false);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Suiza", false);
        pregunta.nuevaOpcion("Bolivia", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test21SeCreaUnaPreguntaChoiceChoiceClasicoConUnaRespuestaCorrectaYAciertaPeroFallaDos() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Sudafrica", false);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Suiza", false);
        pregunta.nuevaOpcion("Bolivia", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test22SeCreaUnaPreguntaChoiceChoiceClasicoConDosRespuestaCorrectaYAciertaLasDos() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Ecuador", true);
        pregunta.nuevaOpcion("China", false);
        pregunta.nuevaOpcion("Malasia", false);
        pregunta.nuevaOpcion("Costa Rica", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test23SeCreaUnaPreguntaChoiceClasicoConDosRespuestaCorrectaYAciertaUnaPeroNoSumaPuntos() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Ecuador", true);
        pregunta.nuevaOpcion("China", false);
        pregunta.nuevaOpcion("Malasia", false);
        pregunta.nuevaOpcion("Costa Rica", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test24SeCreaUnaPreguntaChoiceClasicoConDosRespuestaCorrectaYAciertaDosPeroFallaUna() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Ecuador", true);
        pregunta.nuevaOpcion("China", false);
        pregunta.nuevaOpcion("Malasia", false);
        pregunta.nuevaOpcion("Costa Rica", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test25SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAcierta() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("EEUU", false);
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Brasil", true);
        pregunta.nuevaOpcion("Costa Rica", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test26SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaUnaYNoSumaPuntos() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("EEUU", false);
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Brasil", true);
        pregunta.nuevaOpcion("Costa Rica", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test27SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaTresPeroFallaUna() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("EEUU", false);
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Brasil", true);
        pregunta.nuevaOpcion("Costa Rica", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test28SeCreaUnaPreguntaChoiceClasicoConTresRespuestaCorrectaYAciertaDosPeroNoSumaPuntos() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("EEUU", false);
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Brasil", true);
        pregunta.nuevaOpcion("Costa Rica", true);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test29ClasicoRecibeUnaListaDeRespuestasTodasIncorrectasYAmbosFallan(){
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("China", false);
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Rusia", false);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test30ClasicaRecibeUnaListaDeRespuestasTodasCorrectasYAmbosAciertan(){
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Paraguay", true);
        pregunta.nuevaOpcion("Dinamarca", false);
        pregunta.nuevaOpcion("Perú", true);
        pregunta.nuevaOpcion("Venezuela", true);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test31ClasicaRecibeUnaListaDeRespuestasDistintasYElQueRespondioBienSumaPuntos(){
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Japon", false);
        pregunta.nuevaOpcion("Perú", true);
        pregunta.nuevaOpcion("Venezuela", false);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test32SeCreaUnaPreguntaChoiceConPenalidadConSeisOpcionesYLanzaExcepcion() {
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("Japon", false);
        pregunta.nuevaOpcion("Perú", true);
        pregunta.nuevaOpcion("Venezuela", true);
        pregunta.nuevaOpcion("Italia", false);

        assertThrows(ChoiceTieneMaxCincoOpcionesError.class,
                () -> {
                    pregunta.nuevaOpcion("Francia", false);
                });
    }

    @Test
    public void test34() throws IOException {

        Jugador jugador = new Jugador("LeoProgramador");

        MultipleChoice pregunta1 = preguntasMC.get(0);

        Respuesta respuesta = new Respuesta(jugador, pregunta1);
        respuesta.agregarOpcion(pregunta1.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta1.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta1.evaluarRespuestas(respuestas);
        assertEquals(2, jugador.puntos());


        MultipleChoice pregunta2 = preguntasMC.get(1);

        respuesta = new Respuesta(jugador, pregunta2);
        respuesta.agregarOpcion(pregunta2.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta2.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        pregunta2.evaluarRespuestas(respuestas);
        assertEquals(3, jugador.puntos());
    }
}