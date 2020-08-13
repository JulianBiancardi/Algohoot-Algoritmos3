package edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Excepciones.PreguntaNoAceptaExclusividadError;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PreguntaExclusividadTest {

    @Test
    public void test01ChoiceClasicoUnJugadorRespondeCorrectoYAplicaUnaExclusividad(){
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("Venezuela", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(2,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void test02ChoiceClasicoAmbosJugadorRespondenCorrectoYNingunoSuma(){
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void test03ChoiceClasicoUnJugadorRespondeCorrectoYAplicaDosExclusividades(){
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        jugador1.activarExclusividad(respuestaJugador1);
        jugador2.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(4, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test04ChoiceClasicoUnNingunJugadorRespondeCorrectoYNoAplicaExclusividad(){
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        jugador1.activarExclusividad(respuestaJugador1);
        jugador2.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test05ChoiceParcialUnJugadorRespondeCorrectoYAplicaUnaExclusividad(){
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(4,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void test06ChoiceParcialAmbosJugadorRespondenCorrectoYNoAplicaExclusividad(){
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(2));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void test07ChoiceParcialUnJugadorRespondeCorrectoYAplicaDosExclusividades(){
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        jugador1.activarExclusividad(respuestaJugador1);
        jugador2.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(8,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void test08ChoiceParcialNingunJugadorRespondeCorrectoYNoAplicaExclusividad(){
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        jugador1.activarExclusividad(respuestaJugador1);
        jugador2.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void test09ChoiceConPenalidadUnJugadorIntentaAplicarExclusividadYLanzaExcepcion(){
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        assertThrows(PreguntaNoAceptaExclusividadError.class,
                () -> {
                    jugador1.activarExclusividad(respuestaJugador1);
                });
    }

    @Test
    public void test10ChoiceClasicoUnJugadorIntentaAplicaExclusividadMasDeDosVecesYSoloAplicaDosVeces(){
        // PREGUNTA 1
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 2
        pregunta = MultipleChoice.conModoClasico("Paises de Europa");
        pregunta.agregarOpcion("Italia", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Grecia", true);
        pregunta.agregarOpcion("Venezuela", false);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 3
        pregunta = MultipleChoice.conModoClasico("Paises de Asia");
        pregunta.agregarOpcion("Argentina", false);
        pregunta.agregarOpcion("Japon", true);
        pregunta.agregarOpcion("Perú", false);
        pregunta.agregarOpcion("Venezuela", true);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(5,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void test11ChoiceClasicoUnJugadorErraUnaIntentaAplicaExclusividadMasDeDosVecesYSoloAplicaCuandoAcierta(){
        // PREGUNTA 1
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 2
        pregunta = MultipleChoice.conModoClasico("Paises de Europa");
        pregunta.agregarOpcion("Italia", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Grecia", true);
        pregunta.agregarOpcion("Venezuela", false);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 3
        pregunta = MultipleChoice.conModoClasico("Paises de Asia");
        pregunta.agregarOpcion("Argentina", false);
        pregunta.agregarOpcion("Japon", true);
        pregunta.agregarOpcion("Perú", false);
        pregunta.agregarOpcion("Venezuela", true);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(3,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void test12ChoiceClasicoUnJugadorErraDosIntentaAplicaExclusividadMasDeDosVecesYSoloAplicaCuandoAcierta(){
        // PREGUNTA 1
        MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 2
        pregunta = MultipleChoice.conModoClasico("Paises de Europa");
        pregunta.agregarOpcion("Italia", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Grecia", true);
        pregunta.agregarOpcion("Venezuela", false);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 3
        pregunta = MultipleChoice.conModoClasico("Paises de Asia");
        pregunta.agregarOpcion("Argentina", false);
        pregunta.agregarOpcion("Japon", true);
        pregunta.agregarOpcion("Perú", false);
        pregunta.agregarOpcion("Venezuela", true);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void test13ChoiceParcialUnJugadorIntentaAplicaExclusividadMasDeDosVecesYSoloAplicaDosVeces(){
        // PREGUNTA 1
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 2
        pregunta = MultipleChoice.conModoPuntajeParcial("Paises de Europa");
        pregunta.agregarOpcion("Italia", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Grecia", true);
        pregunta.agregarOpcion("Venezuela", false);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 3
        pregunta = MultipleChoice.conModoPuntajeParcial("Paises de Asia");
        pregunta.agregarOpcion("Argentina", false);
        pregunta.agregarOpcion("Japon", true);
        pregunta.agregarOpcion("Perú", false);
        pregunta.agregarOpcion("Venezuela", true);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(10,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void test14ChoiceParcialUnJugadorErraUnaIntentaAplicaExclusividadMasDeDosVecesYSoloAplicaCuandoAcierta(){
        // PREGUNTA 1
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 2
        pregunta = MultipleChoice.conModoPuntajeParcial("Paises de Europa");
        pregunta.agregarOpcion("Italia", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Grecia", true);
        pregunta.agregarOpcion("Venezuela", false);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 3
        pregunta = MultipleChoice.conModoPuntajeParcial("Paises de Asia");
        pregunta.agregarOpcion("Argentina", false);
        pregunta.agregarOpcion("Japon", true);
        pregunta.agregarOpcion("Perú", false);
        pregunta.agregarOpcion("Venezuela", true);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(6,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }

    @Test
    public void test15ChoiceParcialUnJugadorErraDosIntentaAplicaExclusividadMasDeDosVecesYSoloAplicaCuandoAcierta(){
        // PREGUNTA 1
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Perú", true);
        pregunta.agregarOpcion("China", false);
        Jugador jugador1 = new Jugador("Carlos Tevez");
        Jugador jugador2 = new Jugador("Ariana Grande");
        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);
        Respuesta respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 2
        pregunta = MultipleChoice.conModoPuntajeParcial("Paises de Europa");
        pregunta.agregarOpcion("Italia", true);
        pregunta.agregarOpcion("Japon", false);
        pregunta.agregarOpcion("Grecia", true);
        pregunta.agregarOpcion("Venezuela", false);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        // PREGUNTA 3
        pregunta = MultipleChoice.conModoPuntajeParcial("Paises de Asia");
        pregunta.agregarOpcion("Argentina", false);
        pregunta.agregarOpcion("Japon", true);
        pregunta.agregarOpcion("Perú", false);
        pregunta.agregarOpcion("Venezuela", true);
        respuestaJugador1 = new Respuesta(jugador1, pregunta);
        respuestaJugador2 = new Respuesta(jugador2, pregunta);

        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador1.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador2.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        jugador1.activarExclusividad(respuestaJugador1);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(2,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }
}