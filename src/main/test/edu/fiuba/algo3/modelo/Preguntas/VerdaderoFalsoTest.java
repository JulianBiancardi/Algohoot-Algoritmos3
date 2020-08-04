package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Respuesta;
import edu.fiuba.algo3.modelo.Excepciones.RespuestaJugadorSinOpcionIngresadaExcepcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerdaderoFalsoTest {

    @Test
    public void test01PreguntaVoFClasicaEvaluaListaDeUnaRespuestaDeUnJugadorEligiendoOpcionIncorrectaEntoncesNoAfectaraPuntaje() {
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Verdadero");
        VoF pregunta = VoF.crearEnModoClasico("¿2 + 2 = 4?", opcionCorrecta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionIncorrecta); //elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02PreguntaVoFClasicaEvaluaListaDeUnaRespuestaDeUnJugadorEligiendoOpcionCorrectaAumentandoSuPuntaje() {
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        VoF pregunta = VoF.crearEnModoClasico("¿2 + 2 = 4?", opcionCorrecta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionCorrecta); //elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03PreguntaVoFClasicaEvaluaListaRespuestasDeDosJugadoresEligiendoOpcionesIncorrectasEntoncesNoAfectaraPuntajes(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Falso");
        VoF pregunta = VoF.crearEnModoClasico("¿2 + 2 = 4?", opcionCorrecta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionIncorrecta); //elijo incorrecta
        respuestaJugador2.agregarOpcion(opcionIncorrecta); //elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(0, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test04PreguntaVoFClasicaEvaluaListaRespuestasDeDosJugadoresEligiendoOpcionesCorrectasAumentandoPuntaje(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        VoF pregunta = VoF.crearEnModoClasico("¿2 + 2 = 4?", opcionCorrecta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionCorrecta); //elijo correcta
        respuestaJugador2.agregarOpcion(opcionCorrecta); //elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test05PreguntaVoFClasicaRecibeUnaListaDeRespuestaDeJugadoresYSoloElQueRespondioBienSumaPuntos() {
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Verdadero");
        VoF pregunta = VoF.crearEnModoClasico("¿2 + 2 = 4?", opcionCorrecta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionCorrecta); //elijo correcta
        respuestaJugador2.agregarOpcion(opcionIncorrecta); //elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test06PreguntaVoFPenalizadaEvaluaListaDeUnaRespuestaDeUnJugadorEligiendoOpcionIncorrectaEntoncesDisminuyeSuPuntaje() {
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Verdadero");
        VoF pregunta = VoF.crearEnModoPenalizado("¿2 + 2 = 4?", opcionCorrecta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionIncorrecta); //elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador.puntos());
    }

    @Test
    public void test07PreguntaVoFPenalizadaEvaluaListaDeUnaRespuestaDeUnJugadorEligiendoOpcionCorrectaAumentandoSuPuntaje() {
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        VoF pregunta = VoF.crearEnModoPenalizado("¿2 + 2 = 4?", opcionCorrecta);
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);
        respuestaJugador.agregarOpcion(opcionCorrecta); //elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador.puntos());
    }


    @Test
    public void test08PreguntaVoFConPenalidadRecibeListaRespuestaDeJugadoresDisminuyendoPuntajeAlQueRespondioIncorrecto() {
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Verdadero");
        VoF pregunta = VoF.crearEnModoPenalizado("¿2 + 2 = 4?", opcionCorrecta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionCorrecta); //elijo correcta
        respuestaJugador2.agregarOpcion(opcionIncorrecta); //elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.puntos());
        assertEquals(-1, jugador2.puntos());
    }

    @Test
    public void test09PreguntaVoFConPenalidadRecibeListaRespuestaDeJugadoreEligiendoAmbosIncorrectosEntoncesSeDisminuyePuntajeAmbos(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Verdadero");
        VoF pregunta = VoF.crearEnModoPenalizado("¿2 + 2 = 4?", opcionCorrecta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionIncorrecta); //elijo incorrecta
        respuestaJugador2.agregarOpcion(opcionIncorrecta); //elijo incorrecta
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(-1, jugador1.puntos());
        assertEquals(-1, jugador2.puntos());
    }

    @Test
    public void test10PreguntaVoFConPenalidadRecibeListaRespuestaDeJugadoreEligiendoAmbosCorrectasEntoncesSeAumentaPuntajeAmbos(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Verdadero");
        VoF pregunta = VoF.crearEnModoPenalizado("¿2 + 2 = 4?", opcionCorrecta);
        Jugador jugador1 = new Jugador("LeoProgramador");
        Jugador jugador2 = new Jugador("LeoProgramador");
        Respuesta respuestaJugador1 = new Respuesta(jugador1);
        Respuesta respuestaJugador2 = new Respuesta(jugador2);
        respuestaJugador1.agregarOpcion(opcionCorrecta); //elijo correcta
        respuestaJugador2.agregarOpcion(opcionCorrecta); //elijo correcta
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);

        pregunta.evaluarRespuestas(respuestas);

        assertEquals(1, jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test11PreguntaVoFClasicaEvaluaListaRespuestaJugadoresSinOpcionesIngresadasEntoncesLanzaExcepcion() {
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        VoF pregunta = VoF.crearEnModoClasico("¿2 + 2 = 4?", opcionCorrecta);

        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        assertThrows(RespuestaJugadorSinOpcionIngresadaExcepcion.class,
                () -> {
                    pregunta.evaluarRespuestas(respuestas);
                });
    }

    @Test
    public void test12PreguntaVoFPenalizadaEvaluaListaRespuestaJugadoresSinOpcionesIngresadasEntoncesLanzaExcepcion() {
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        VoF pregunta = VoF.crearEnModoPenalizado("¿2 + 2 = 4?", opcionCorrecta);

        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuestaJugador = new Respuesta(jugador);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador);

        assertThrows(RespuestaJugadorSinOpcionIngresadaExcepcion.class,
                () -> {
                    pregunta.evaluarRespuestas(respuestas);
                });
    }
}