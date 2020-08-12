package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTest {


    @Test
    public void test01AgregoRondasAlJuego() {
        Juego juego = new Juego();
        VoF vof;
        MultipleChoice multipleChoice;

        //Agrego pregunta Verdadero Falso
        vof = VoF.conModoPenalidad("2 + 2 = 4",true);
        juego.agregarRonda(vof);

        //Agrego pregunta Verdadero Falso
        vof = VoF.conModoPenalidad("2 * 10 = 20",true);
        juego.agregarRonda(vof);

        //Agrego pregunta Mutiple Choice
        multipleChoice = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        multipleChoice.agregarOpcion("Argentina", true);
        multipleChoice.agregarOpcion("China", false);
        multipleChoice.agregarOpcion("Egipto", false);
        multipleChoice.agregarOpcion("Rusia", false);
        juego.agregarRonda(multipleChoice);

        assertEquals(3,juego.cantidadRondas());
    }

    @Test
    public void test02AgregoRondasAlJuegoYSeVanEliminandoAMedidaQueSePiden() {
        Juego juego = new Juego();
        VoF vof;
        MultipleChoice multipleChoice;

        //Agrego pregunta Verdadero Falso
        vof = VoF.conModoPenalidad("2 + 2 = 4",true);
        juego.agregarRonda(vof);

        //Agrego pregunta Verdadero Falso
        vof = VoF.conModoPenalidad("2 * 10 = 20",true);
        juego.agregarRonda(vof);

        //Agrego pregunta Mutiple Choice
        multipleChoice = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        multipleChoice.agregarOpcion("Argentina", true);
        multipleChoice.agregarOpcion("China", false);
        multipleChoice.agregarOpcion("Egipto", false);
        multipleChoice.agregarOpcion("Rusia", false);
        juego.agregarRonda(multipleChoice);

        //Pido todas las preguntas
        juego.obtenerPregunta();
        juego.obtenerPregunta();
        juego.obtenerPregunta();

        assertEquals(0,juego.cantidadRondas());
    }

    @Test
    public void test03CreoElJuegoYAgregoJugadores() {
        Juego juego = new Juego();
        Jugador jugador;

        jugador = new Jugador("Tomas");
        juego.agregarJugador(jugador);

        jugador = new Jugador("Martin");
        juego.agregarJugador(jugador);

        jugador = new Jugador("Lucas");
        juego.agregarJugador(jugador);

        jugador = new Jugador("Juan");
        juego.agregarJugador(jugador);

        assertEquals(4,juego.cantidadJugadores());
    }

    @Test
    public void test04ElJuegoDeterminaCorrectamenteElGanador() {
        Juego juego = new Juego();

        Jugador jugador1 = new Jugador("Tomas");
        jugador1.modificarPuntos(0);

        Jugador jugador2 = new Jugador("Martin");
        jugador2.modificarPuntos(10);

        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);

        assertEquals("Martin",juego.obtenerGanador().nombre());
    }

    @Test
    public void test05CreoElJuegoConDosJugadoresYConUnaPreguntaVoFYObtengoGanador() {
        Juego juego = new Juego();
        Jugador jugador;
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        Respuesta respuesta;

        jugador = new Jugador("Tomas");
        juego.agregarJugador(jugador);

        jugador = new Jugador("Martin");
        juego.agregarJugador(jugador);

        //Agrego pregunta Verdadero Falso
        VoF vof = VoF.conModoClasico("2 + 2 = 4",true);
        juego.agregarRonda(vof);


        //Este while se puede cambiar depende de como vaya a ser la implemetación de la App
        while (juego.hayRondasDisponibles()){
            Pregunta pregunta = juego.obtenerPregunta();
            //Mandar a la vista

            //Esto estaría bueno reemplzaralo por un for pero todos responendrían igual
            //si lo hardcodeo asi
            jugador = juego.turnoDe();
            //Mandar a la viste el jugador
            respuesta = new Respuesta(jugador, pregunta);
            respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
            respuestas.add(respuesta);
            juego.siguienteTurno();

            jugador = juego.turnoDe();
            respuesta = new Respuesta(jugador, pregunta);
            respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
            respuestas.add(respuesta);

            pregunta.evaluarRespuestas(respuestas);
            respuestas.clear();
        }

        assertEquals("Martin",juego.obtenerGanador().nombre());
        assertEquals(1,juego.obtenerGanador().puntos());
    }

    @Test
    public void test06CreoElJuegoConDosJugadoresYTresPreguntaVoFYObtengoGanador() {
        Juego juego = new Juego();
        Jugador jugador;
        Pregunta pregunta;
        VoF vof;
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        Respuesta respuesta;

        jugador = new Jugador("Tomas");
        juego.agregarJugador(jugador);

        jugador = new Jugador("Martin");
        juego.agregarJugador(jugador);

        //Agrego pregunta Verdadero Falso
        vof = VoF.conModoClasico("2 + 2 = 4",true);
        juego.agregarRonda(vof);

        //Agrego pregunta Verdadero Falso
        vof = VoF.conModoClasico("10 - 12 = -2",false);
        juego.agregarRonda(vof);

        //Agrego pregunta Verdadero Falso
        vof = VoF.conModoClasico("5 + 7 = 12",true);
        juego.agregarRonda(vof);


        //Este while se puede cambiar depende de como vaya a ser la implemetación de la App
        while (juego.hayRondasDisponibles()){
            pregunta = juego.obtenerPregunta();
            //pregunta.mostrarse()

            //Esto estaría bueno reemplzaralo por un for pero todos responendrían igual
            //si lo hardcodeo asi

            //Juega Tomás
            jugador = juego.turnoDe();
            respuesta = new Respuesta(jugador, pregunta);
            respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
            respuestas.add(respuesta);
            juego.siguienteTurno();

            //Juega Martin
            jugador = juego.turnoDe();
            respuesta = new Respuesta(jugador, pregunta);
            respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
            respuestas.add(respuesta);
            juego.siguienteTurno();

            pregunta.evaluarRespuestas(respuestas);
            respuestas.clear();
        }

        assertEquals("Martin",juego.obtenerGanador().nombre());
        assertEquals(2,juego.obtenerGanador().puntos());
    }

    @Test
    public void test07CreoElJuegoConTresJugadoresYConUnaPreguntaMultipleChoiceYObtengoGanador() {
        Juego juego = new Juego();
        Jugador jugador;
        Pregunta pregunta;
        MultipleChoice multipleChoice;
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        Respuesta respuesta;

        jugador = new Jugador("Tomas");
        juego.agregarJugador(jugador);

        jugador = new Jugador("Martin");
        juego.agregarJugador(jugador);

        jugador = new Jugador("Chiki");
        juego.agregarJugador(jugador);

        //Agrego pregunta MultipleChoice
        multipleChoice = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        multipleChoice.agregarOpcion("Argentina", true);
        multipleChoice.agregarOpcion("China", false);
        multipleChoice.agregarOpcion("Egipto", false);
        multipleChoice.agregarOpcion("Rusia", false);

        juego.agregarRonda(multipleChoice);

        //Este while se puede cambiar depende de como vaya a ser la implemetación de la App
        while (juego.hayRondasDisponibles()){
            pregunta = juego.obtenerPregunta();

            //Esto estaría bueno reemplzaralo por un for pero todos responendrían igual
            //si lo hardcodeo asi

            //Juega Tomás
            jugador = juego.turnoDe();
            respuesta = new Respuesta(jugador, pregunta);
            respuesta.agregarOpcion(pregunta.obtenerOpcion(1));
            respuestas.add(respuesta);
            juego.siguienteTurno();

            //Juega Martin
            jugador = juego.turnoDe();
            respuesta = new Respuesta(jugador, pregunta);
            respuesta.agregarOpcion(pregunta.obtenerOpcion(0));
            respuestas.add(respuesta);
            juego.siguienteTurno();

            //Juega Chiki
            jugador = juego.turnoDe();
            respuesta = new Respuesta(jugador, pregunta);
            respuesta.agregarOpcion(pregunta.obtenerOpcion(3));
            respuestas.add(respuesta);
            juego.siguienteTurno();


            pregunta.evaluarRespuestas(respuestas);
            respuestas.clear();
        }

        assertEquals("Martin",juego.obtenerGanador().nombre());
        assertEquals(1,juego.obtenerGanador().puntos());
    }
}

