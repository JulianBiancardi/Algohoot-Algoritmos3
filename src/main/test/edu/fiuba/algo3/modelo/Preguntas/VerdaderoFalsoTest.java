package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.VoF;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {

    @Test
    public void test01SeCreaUnaPreguntaVoFClasicoConRespuestaFalseErraYEvaluaCorrectamente() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        VoF pregunta = VoF.conModoClasico("¿2 + 2 = 4?", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(1)); //Elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02SeCreaUnaPreguntaVoFClasicoConRespuestaTrueAciertaYEvaluaCorrectamente() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        VoF pregunta = VoF.conModoClasico("¿2 + 2 = 4?", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0)); //Elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03VoFClasicoRecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        VoF pregunta = VoF.conModoClasico("¿2 + 2 = 4?", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(1)); //Elijo incorrecta
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(1)); //Elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test04VoFClasicoRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        VoF pregunta = VoF.conModoClasico("¿2 + 2 = 4?", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Jugador jugador2 = new Jugador("Fede");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(0)); //Elijo correcta
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(0)); //Elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test05VoFClasicoRecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        VoF pregunta = VoF.conModoClasico("¿2 + 2 = 4?", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Jugador jugador2 = new Jugador("Julian");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(1)); //Elijo incorrecta
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(0)); //Elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 0);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test06SeCreaUnaPreguntaVoFConPenalidadConRespuestaFalseErraYEvaluaCorrectamente() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        VoF pregunta = VoF.conModoPenalidad("¿2 + 2 = 4?", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(1)); //Elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test07SeCreaUnaPreguntaVoFConPenalidadConRespuestaTrueAciertaYEvaluaCorrectamente() {
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        VoF pregunta = VoF.conModoPenalidad("¿2 + 2 = 4?", listaOpcionesPregunta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        respuestaJugador.agregarOpcion(listaOpcionesPregunta.obtener(0)); //Elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test08VoFConPenalidadRecibeUnaListaDeRespuestasTodasIncorrectasYNingunoSumaPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        VoF pregunta = VoF.conModoPenalidad("¿2 + 2 = 4?", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Jugador jugador2 = new Jugador("Joaco");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(1)); //Elijo incorrecta
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(1)); //Elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), -1);
    }

    @Test
    public void test09VoFConPenalidadRecibeUnaListaDeRespuestasTodasCorrectasYAmbosSumanPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        VoF pregunta = VoF.conModoPenalidad("¿2 + 2 = 4?", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Jugador jugador2 = new Jugador("Tomas");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(0)); //Elijo correcta
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(0)); //Elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), 1);
        assertEquals(jugador2.puntos(), 1);
    }

    @Test
    public void test10VoFConPenalidadRecibeUnaListaDeRespuestasDistintasYSoloElQueRespondioBienSumaPuntos(){
        ListaOpciones listaOpcionesPregunta = new ListaOpciones();
        listaOpcionesPregunta.agregarOpcion(new OpcionCorrecta("Verdadero"));
        listaOpcionesPregunta.agregarOpcion(new OpcionIncorrecta("Falso"));
        VoF pregunta = VoF.conModoPenalidad("¿2 + 2 = 4?", listaOpcionesPregunta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Jugador jugador2 = new Jugador("Julian");
        Respuesta respuestaJugador2 = new Respuesta(jugador2);

        respuestaJugador1.agregarOpcion(listaOpcionesPregunta.obtener(1)); //Elijo incorrecta
        respuestaJugador2.agregarOpcion(listaOpcionesPregunta.obtener(0)); //Elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        pregunta.evaluarRespuestas(respuestas);

        assertEquals(jugador1.puntos(), -1);
        assertEquals(jugador2.puntos(), 1);
    }
}
