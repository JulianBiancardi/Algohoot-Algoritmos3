package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaGrupal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    @Test
    public void test01AmbosGruposConDosRespuestasCorrectasCadaUnoRespondeCorrectamente(){

        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares", nombreGrupo1, nombreGrupo2);
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("2"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("3"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("4"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("5"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta, nombreGrupo1, nombreGrupo2);

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
    public void test02AmbosGruposConDosRespuestasCorrectasCadaUnoRespondeIncorrectamente(){

        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares",nombreGrupo1, nombreGrupo2);
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("2"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("3"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("4"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("5"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta, nombreGrupo1, nombreGrupo2);

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
        RespuestaGrupal respuestaJugador = new RespuestaGrupal(jugador, pregunta, nombreGrupo1, nombreGrupo2);

        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcionGrupo1(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcionGrupo2(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test04AmbosGruposConDosRespuestasCorrectasCadaUnoRespondenAmbosCorrectamente(){

        String nombreGrupo1 = "Numeros Pares";
        String nombreGrupo2 = "Numeros Impares";
        GroupChoice pregunta = new GroupChoice("Separar en Pares e Impares",nombreGrupo1, nombreGrupo2);
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("2"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("3"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("4"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("5"));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Julianaso");
        RespuestaGrupal respuestaJugador1 = new RespuestaGrupal(jugador1, pregunta, nombreGrupo1, nombreGrupo2);
        RespuestaGrupal respuestaJugador2 = new RespuestaGrupal(jugador2, pregunta, nombreGrupo1, nombreGrupo2);

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
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
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
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("2"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("3"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("4"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("5"));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Joaco");
        RespuestaGrupal respuestaJugador1 = new RespuestaGrupal(jugador1, pregunta, nombreGrupo1, nombreGrupo2);
        RespuestaGrupal respuestaJugador2 = new RespuestaGrupal(jugador2, pregunta, nombreGrupo1, nombreGrupo2);

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
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
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
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("2"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("4"));
        pregunta.agregarOpcionGrupo1(new OpcionGrupal("6"));
        pregunta.agregarOpcionGrupo2(new OpcionGrupal("5"));
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("Fede");
        RespuestaGrupal respuestaJugador1 = new RespuestaGrupal(jugador1, pregunta, nombreGrupo1, nombreGrupo2);
        RespuestaGrupal respuestaJugador2 = new RespuestaGrupal(jugador2, pregunta, nombreGrupo1, nombreGrupo2);

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
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }
}
