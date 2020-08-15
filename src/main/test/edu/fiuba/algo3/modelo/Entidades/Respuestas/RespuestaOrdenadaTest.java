package edu.fiuba.algo3.modelo.Entidades.Respuestas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.OrderedChoice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaOrdenadaTest {

    @Test
    public void test01CreoUnaRespuestaOrdenadaConCincoOpcionesYNoAciertaNinguna() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar por edad de mayor a menor");
        pregunta.nuevaOpcion("Cafu");
        pregunta.nuevaOpcion("Ronaldo");
        pregunta.nuevaOpcion("Roman");
        pregunta.nuevaOpcion("Messi");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuestaJugador = new RespuestaOrdenada(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));

        assertEquals(0, respuestaJugador.cantidadOpcionesCorrectas());
    }

    @Test
    public void test02CreoUnaRespuestaOrdenadaConCincoOpcionesYAciertaUna() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar por edad de mayor a menor");
        pregunta.nuevaOpcion("Cafu");
        pregunta.nuevaOpcion("Ronaldo");
        pregunta.nuevaOpcion("Roman");
        pregunta.nuevaOpcion("Messi");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuestaJugador = new RespuestaOrdenada(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));

        assertEquals(1, respuestaJugador.cantidadOpcionesCorrectas());
    }

    @Test
    public void test03CreoUnaRespuestaOrdenadaConCincoOpcionesYAciertaDos() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar por edad de mayor a menor");
        pregunta.nuevaOpcion("Cafu");
        pregunta.nuevaOpcion("Ronaldo");
        pregunta.nuevaOpcion("Roman");
        pregunta.nuevaOpcion("Messi");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuestaJugador = new RespuestaOrdenada(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));

        assertEquals(2, respuestaJugador.cantidadOpcionesCorrectas());
    }

    @Test
    public void test04CreoUnaRespuestaOrdenadaConCincoOpcionesYAciertaTodas() {
        OrderedChoice pregunta = new OrderedChoice("Ordenar por edad de mayor a menor");
        pregunta.nuevaOpcion("Cafu");
        pregunta.nuevaOpcion("Ronaldo");
        pregunta.nuevaOpcion("Roman");
        pregunta.nuevaOpcion("Messi");
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuestaJugador = new RespuestaOrdenada(jugador, pregunta);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));

        assertEquals(4, respuestaJugador.cantidadOpcionesCorrectas());
    }
}
