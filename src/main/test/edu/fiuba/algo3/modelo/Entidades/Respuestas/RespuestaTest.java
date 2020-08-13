package edu.fiuba.algo3.modelo.Entidades.Respuestas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.VoF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaTest {

    @Test
    public void test01CreoUnaRespuestaConDosOpcionesIncorrectasVerificoSiEsAsi() {
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, VoF.conModoClasico("Pregunta de Prueba", true));

        respuesta.agregarOpcion(new OpcionBinaria("Soy correcta", true));
        respuesta.agregarOpcion(new OpcionBinaria("Soy incorrecta", false));
        respuesta.agregarOpcion(new OpcionBinaria("Soy incorrecta", false));

        assertEquals(2, respuesta.cantidadOpcionesIncorrectas());
    }

    @Test
    public void test02CreoUnaRespuestaConTresOpcionesCorrectasVerificoSiEsAsi() {
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, VoF.conModoClasico("Pregunta de Prueba", true));

        respuesta.agregarOpcion(new OpcionBinaria("A caballo regalado no se le miran los dientes", true));
        respuesta.agregarOpcion(new OpcionBinaria("Mas vale pajaro en mano que hacer limonada", false));
        respuesta.agregarOpcion(new OpcionBinaria("La vida es bella", false));
        respuesta.agregarOpcion(new OpcionBinaria("Si la vida te da limones has limonada", true));
        respuesta.agregarOpcion(new OpcionBinaria("La vida no es tan bella como parece", true));

        assertEquals(3, respuesta.cantidadOpcionesCorrectas());
    }

    @Test
    public void test03CreoUnaRespuestaYLeSumoPuntosAlResponsableVerificoSusPuntos() {
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, VoF.conModoClasico("Pregunta de Prueba", true));

        respuesta.modificarPuntosJugador(5);

        assertEquals(5, jugador.puntos());
    }

    @Test
    public void test04CreoUnaRespuestaYLeRestoPuntosAlResponsableVerificoSusPuntos() {
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, VoF.conModoClasico("Pregunta de Prueba", true));

        respuesta.modificarPuntosJugador(-3);

        assertEquals(-3, jugador.puntos());
    }

    @Test
    public void test05CreoUnaRespuestaLeRestoYSumoPuntosAlResponsableVerificoSusPuntos() {
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador, VoF.conModoClasico("Pregunta de Prueba", true));

        respuesta.modificarPuntosJugador(-2);
        respuesta.modificarPuntosJugador(4);

        assertEquals(2, jugador.puntos());
    }
}
