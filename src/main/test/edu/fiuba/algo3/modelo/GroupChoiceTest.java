package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    @Test
    public void test01AmbosGruposCon2RespuestasCorrectasCadaUnoRespondeCorrectamente(){

        GroupChoice pregunta = new GroupChoice("Numeros Pares - Numeros Impares","Numeros Pares", "Numeros Impares");
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("2"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("3"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("4"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("5"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, "Numeros Pares", "Numeros Impares");


        respuestaJugador.agregarOpcionLista1((OpcionGrupal) pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionLista1((OpcionGrupal) pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionLista2((OpcionGrupal) pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionLista2((OpcionGrupal) pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test02AmbosGruposCon2RespuestasCorrectasCadaUnoRespondeIncorrectamente(){

        GroupChoice pregunta = new GroupChoice("Numeros Pares - Numeros Impares","Numeros Pares", "Numeros Impares");
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("2"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("3"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("4"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("5"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, "Numeros Pares", "Numeros Impares");


        respuestaJugador.agregarOpcionLista1((OpcionGrupal) pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionLista1((OpcionGrupal) pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionLista2((OpcionGrupal) pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionLista2((OpcionGrupal) pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test03GruposConDistintaCantidadDeOpcionesRespondeCorrectamente(){

        GroupChoice pregunta = new GroupChoice("Numeros Pares - Numeros Impares","Numeros Pares", "Numeros Impares");
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("2"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("4"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("6"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("5"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, "Numeros Pares", "Numeros Impares");


        respuestaJugador.agregarOpcionLista1((OpcionGrupal) pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionLista1((OpcionGrupal) pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionLista1((OpcionGrupal) pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionLista2((OpcionGrupal) pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }
}
