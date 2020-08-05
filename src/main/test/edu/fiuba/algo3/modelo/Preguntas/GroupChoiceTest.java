package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaGrupal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    @Test
    public void test01AmbosGruposCon2RespuestasCorrectasCadaUnoRespondeCorrectamente(){

        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares",nombreGrupo1, nombreGrupo2);
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("2"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("3"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("4"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("5"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, nombreGrupo1, nombreGrupo2);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test02AmbosGruposCon2RespuestasCorrectasCadaUnoRespondeIncorrectamente(){

        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares",nombreGrupo1, nombreGrupo2);
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("2"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("3"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("4"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("5"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, nombreGrupo1, nombreGrupo2);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test03GruposConDistintaCantidadDeOpcionesRespondeCorrectamente(){

        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares",nombreGrupo1, nombreGrupo2);
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("2"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("4"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("6"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("5"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, nombreGrupo1, nombreGrupo2);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }
}
