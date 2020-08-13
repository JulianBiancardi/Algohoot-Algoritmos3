package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Excepciones.ChoiceTieneMaxCincoOpcionesError;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.RespuestaOrdenada;
import edu.fiuba.algo3.modelo.Excepciones.OrderedTieneMaxCincoOpcionesError;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderedChoiceTest {

    @Test
    public void test01SeCreaUnaPreguntaOrderedChoiceConTodasLasRespuestasBienOrdenadaYEvalua() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar de mayor a menor los numeros");
        pregunta.nuevaOpcion("Uno");
        pregunta.nuevaOpcion("Tres");
        pregunta.nuevaOpcion("Cinco");
        pregunta.nuevaOpcion("Diez");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuesta = new RespuestaOrdenada(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }


    @Test
    public void test02SeCreaUnaPreguntaOrderedChoiceConUnaRespuestaMalOrdenadaYEvalua() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar de mayor a menor los numeros");
        pregunta.nuevaOpcion("Uno");
        pregunta.nuevaOpcion("Tres");
        pregunta.nuevaOpcion("Cinco");
        pregunta.nuevaOpcion("Diez");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuesta = new RespuestaOrdenada(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }


    @Test
    public void test03SeCreaUnaPreguntaOrderedChoiceConTodasMenosUnaRespuestaBienOrdenadaYEvalua() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar de mayor a menor los numeros");
        pregunta.nuevaOpcion("Uno");
        pregunta.nuevaOpcion("Tres");
        pregunta.nuevaOpcion("Cinco");
        pregunta.nuevaOpcion("Diez");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuesta = new RespuestaOrdenada(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test04SeCreaUnaPreguntaOrderedChoiceConSoloUnaOpcionSeleccionadaYEvalua() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar de mayor a menor los numeros");
        pregunta.nuevaOpcion("Uno");
        pregunta.nuevaOpcion("Tres");
        pregunta.nuevaOpcion("Cinco");
        pregunta.nuevaOpcion("Diez");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuesta = new RespuestaOrdenada(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test05SeCreaUnaPreguntaOrderedChoiceConDosOpcionSeleccionadaYEvalua() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar de mayor a menor los numeros");
        pregunta.nuevaOpcion("Uno");
        pregunta.nuevaOpcion("Tres");
        pregunta.nuevaOpcion("Cinco");
        pregunta.nuevaOpcion("Diez");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuesta = new RespuestaOrdenada(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test06SeCreaUnaPreguntaOrderedChoiceConTresOpcionSeleccionadaYEvalua() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar de mayor a menor los numeros");
        pregunta.nuevaOpcion("Uno");
        pregunta.nuevaOpcion("Tres");
        pregunta.nuevaOpcion("Cinco");
        pregunta.nuevaOpcion("Diez");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuesta = new RespuestaOrdenada(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(2));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test07SeCreaUnaPreguntaOrderedChoiceConSoloDosOpcionesYSeRespondeBienYEvalua() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar de mayor a menor los numeros");
        pregunta.nuevaOpcion("Uno");
        pregunta.nuevaOpcion("Tres");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuesta = new RespuestaOrdenada(jugador, pregunta);
        respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
        respuesta.agregarOpcion(pregunta.obtenerOpcion(1));

        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuesta);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test08SeCreaUnaPreguntaOrderedChoiceConMasDeCincoOpcionesYLanzaExepcion() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar de mayor a menor los numeros");
        pregunta.nuevaOpcion("Uno");
        pregunta.nuevaOpcion("Tres");
        pregunta.nuevaOpcion("Cuatro");
        pregunta.nuevaOpcion("Cinco");
        pregunta.nuevaOpcion("Diez");

        assertThrows(OrderedTieneMaxCincoOpcionesError.class,
                () -> {
                    pregunta.nuevaOpcion("Treinta");
                });
    }
}
