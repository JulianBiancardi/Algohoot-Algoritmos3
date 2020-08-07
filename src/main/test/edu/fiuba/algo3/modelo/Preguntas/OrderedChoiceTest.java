package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaOrdenada;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {
    /*
    ListaOpciones listaOpcionesPregunta = new ListaOpciones();

    private OpcionOrdenada opcion1 = new OpcionOrdenada("Uno",1);
    private OpcionOrdenada opcion2 = new OpcionOrdenada("Tres",2);
    private OpcionOrdenada opcion3 = new OpcionOrdenada("Cinco",3);
    private OpcionOrdenada opcion4 = new OpcionOrdenada("Diez",4);

    private Jugador jugador = new Jugador("LeoProgramador");

    private Respuesta respuestaJugador = new Respuesta(jugador);

    @Test
    public void test01SeCreaUnaPreguntaOrderedChoiceConTodasLasRespuestasBienOrdenadaYEvalua() {

        listaOpcionesPregunta.agregarOpcionOrdenada(opcion1);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion2);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion3);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion4);

        OrderedChoice pregunta = new OrderedChoice("Ordenar de menor a mayor los numeros", listaOpcionesPregunta);

        respuestaJugador.agregarOpcionOrdenada(opcion1);
        respuestaJugador.agregarOpcionOrdenada(opcion2);
        respuestaJugador.agregarOpcionOrdenada(opcion3);
        respuestaJugador.agregarOpcionOrdenada(opcion4);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test02SeCreaUnaPreguntaOrderedChoiceConUnaRespuestaMalOrdenadaYEvalua() {

        listaOpcionesPregunta.agregarOpcionOrdenada(opcion1);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion2);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion3);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion4);

        OrderedChoice pregunta = new OrderedChoice("Ordenar de menor a mayor los numeros", listaOpcionesPregunta);

        respuestaJugador.agregarOpcionOrdenada(opcion3);
        respuestaJugador.agregarOpcionOrdenada(opcion2);
        respuestaJugador.agregarOpcionOrdenada(opcion1);
        respuestaJugador.agregarOpcionOrdenada(opcion4);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test03SeCreaUnaPreguntaOrderedChoiceConTodasMenosUnaRespuestaBienOrdenadaYEvalua() {

        listaOpcionesPregunta.agregarOpcionOrdenada(opcion1);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion2);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion3);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion4);

        OrderedChoice pregunta = new OrderedChoice("Ordenar de menor a mayor los numeros", listaOpcionesPregunta);

        respuestaJugador.agregarOpcionOrdenada(opcion3);
        respuestaJugador.agregarOpcionOrdenada(opcion2);
        respuestaJugador.agregarOpcionOrdenada(opcion1);
        respuestaJugador.agregarOpcionOrdenada(opcion4);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test04SeCreaUnaPreguntaOrderedChoiceConSoloUnaOpcionSeleccionadaYEvalua() {

        listaOpcionesPregunta.agregarOpcionOrdenada(opcion1);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion2);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion3);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion4);

        OrderedChoice pregunta = new OrderedChoice("Ordenar de menor a mayor los numeros", listaOpcionesPregunta);

        respuestaJugador.agregarOpcionOrdenada(opcion1);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test05SeCreaUnaPreguntaOrderedChoiceConDosOpcionSeleccionadaYEvalua() {

        listaOpcionesPregunta.agregarOpcionOrdenada(opcion1);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion2);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion3);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion4);

        OrderedChoice pregunta = new OrderedChoice("Ordenar de menor a mayor los numeros", listaOpcionesPregunta);

        respuestaJugador.agregarOpcionOrdenada(opcion1);
        respuestaJugador.agregarOpcionOrdenada(opcion2);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test06SeCreaUnaPreguntaOrderedChoiceConTresOpcionSeleccionadaYEvalua() {

        listaOpcionesPregunta.agregarOpcionOrdenada(opcion1);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion2);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion3);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion4);

        OrderedChoice pregunta = new OrderedChoice("Ordenar de menor a mayor los numeros", listaOpcionesPregunta);

        respuestaJugador.agregarOpcionOrdenada(opcion1);
        respuestaJugador.agregarOpcionOrdenada(opcion2);
        respuestaJugador.agregarOpcionOrdenada(opcion3);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test07SeCreaUnaPreguntaOrderedChoiceConSoloDosOpcionesYSeRespondeBienYEvalua() {

        listaOpcionesPregunta.agregarOpcionOrdenada(opcion1);
        listaOpcionesPregunta.agregarOpcionOrdenada(opcion2);

        OrderedChoice pregunta = new OrderedChoice("Ordenar de menor a mayor los numeros", listaOpcionesPregunta);

        respuestaJugador.agregarOpcionOrdenada(opcion1);
        respuestaJugador.agregarOpcionOrdenada(opcion2);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }
    */
    @Test
    public void test08(){

        OrderedChoice pregunta = new OrderedChoice("Ordenar");
        pregunta.agregarOpcion(new OpcionOrdenada("2"));
        pregunta.agregarOpcion(new OpcionOrdenada("3"));
        pregunta.agregarOpcion(new OpcionOrdenada("4"));
        pregunta.agregarOpcion(new OpcionOrdenada("5"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuestaJugador = new RespuestaOrdenada(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test09(){

        OrderedChoice pregunta = new OrderedChoice("Ordenar");
        pregunta.agregarOpcion(new OpcionOrdenada("2"));
        pregunta.agregarOpcion(new OpcionOrdenada("3"));
        pregunta.agregarOpcion(new OpcionOrdenada("4"));
        pregunta.agregarOpcion(new OpcionOrdenada("5"));
        Jugador jugador = new Jugador("LeoProgramador");
        RespuestaOrdenada respuestaJugador = new RespuestaOrdenada(jugador);

        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(0));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(2));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(1));
        respuestaJugador.agregarOpcion(pregunta.obtenerOpcion(3));
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);
        assertEquals(0, jugador.puntos());
    }

    //jugador.crearRespuesta(pregunta);
}
