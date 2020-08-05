package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaTest {

    @Test
    public void test01CreoUnaRespuestaConDosOpcionesIncorrectasVerificoSiEsAsi() {
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.agregarOpcion(new OpcionCorrecta("Soy correcta pa"));
        respuesta.agregarOpcion(new OpcionIncorrecta("Soy incorrecta pa"));
        respuesta.agregarOpcion(new OpcionIncorrecta("No soy correcta ndea"));

        assertEquals(2, respuesta.cantidadOpcionesIncorrectas());
    }

    @Test
    public void test02CreoUnaRespuestaConTresOpcionesCorrectasVerificoSiEsAsi() {
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.agregarOpcion(new OpcionCorrecta("A caballo regalado no se le miran los dientes"));
        respuesta.agregarOpcion(new OpcionIncorrecta("Mas vale pajaro en mano que hacer limonada"));
        respuesta.agregarOpcion(new OpcionIncorrecta("La vida es bella"));
        respuesta.agregarOpcion(new OpcionCorrecta("Si la vida te da limones has limonada"));
        respuesta.agregarOpcion(new OpcionCorrecta("La vida no es tan bella como parece"));

        assertEquals(3, respuesta.cantidadOpcionesCorrectas());
    }

    @Test
    public void test03CreoUnaRespuestaYLeSumoPuntosAlResponsableVerificoSusPuntos() {
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.puntuarJugador(5);

        assertEquals(5, jugador.puntos());
    }

    @Test
    public void test04CreoUnaRespuestaYLeRestoPuntosAlResponsableVerificoSusPuntos() {
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.penalizarJugador(3);

        assertEquals(-3, jugador.puntos());
    }

    @Test
    public void test05CreoUnaRespuestaLeRestoYSumoPuntosAlResponsableVerificoSusPuntos() {
        Jugador jugador = new Jugador("LeoProgramador");
        Respuesta respuesta = new Respuesta(jugador);

        respuesta.penalizarJugador(2);
        respuesta.puntuarJugador(4);

        assertEquals(2, jugador.puntos());
    }

}
