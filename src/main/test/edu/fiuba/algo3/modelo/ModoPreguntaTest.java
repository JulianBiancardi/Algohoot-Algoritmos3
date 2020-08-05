package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.Penalidad;
import edu.fiuba.algo3.modelo.Preguntas.ModosPreguntas.PuntajeParcial;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModoPreguntaTest {

    @Test
    public void test01CreoModoClasicoNoSumaPuntajeYVerificoPuntos() {
        Jugador jugador = new Jugador("Leito");
        Respuesta respuesta = new Respuesta(jugador);
        respuesta.agregarOpcion(new OpcionCorrecta("soy correcta pa"));
        respuesta.agregarOpcion(new OpcionIncorrecta("soy incorrecta pa"));
        respuesta.agregarOpcion(new OpcionCorrecta("soy correcta"));
        respuesta.agregarOpcion(new OpcionIncorrecta("soy incorrecta"));

        Clasico modo = new Clasico();
        modo.modificarPuntos(respuesta, 2);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02CreoModoClasicoSumaPuntajeYVerificoPuntos() {
        Jugador jugador = new Jugador("Leito");
        Respuesta respuesta = new Respuesta(jugador);
        respuesta.agregarOpcion(new OpcionCorrecta("soy correcta pa"));
        respuesta.agregarOpcion(new OpcionCorrecta("soy correcta"));

        Clasico modo = new Clasico();
        modo.modificarPuntos(respuesta, 2);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03CreoModoPenalidaSumaDosRestaUnoYVerificoPuntos() {
        Jugador jugador = new Jugador("Leito");
        Respuesta respuesta = new Respuesta(jugador);
        respuesta.agregarOpcion(new OpcionCorrecta("soy correcta pa"));
        respuesta.agregarOpcion(new OpcionIncorrecta("soy incorrecta pa"));
        respuesta.agregarOpcion(new OpcionCorrecta("soy correcta"));

        Penalidad modo = new Penalidad();
        modo.modificarPuntos(respuesta, 2);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test04CreoModoPuntajeParcialNoSumaPuntajeYVerificoPuntos() {
        Jugador jugador = new Jugador("Leito");
        Respuesta respuesta = new Respuesta(jugador);
        respuesta.agregarOpcion(new OpcionCorrecta("soy correcta pa"));
        respuesta.agregarOpcion(new OpcionIncorrecta("soy incorrecta pa"));
        respuesta.agregarOpcion(new OpcionCorrecta("soy correcta"));
        respuesta.agregarOpcion(new OpcionIncorrecta("soy incorrecta"));

        PuntajeParcial modo = new PuntajeParcial();
        modo.modificarPuntos(respuesta, 2);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test05CreoModoPuntajeParcialSumaPuntajeYVerificoPuntos() {
        Jugador jugador = new Jugador("Leito");
        Respuesta respuesta = new Respuesta(jugador);
        respuesta.agregarOpcion(new OpcionCorrecta("soy correcta pa"));
        respuesta.agregarOpcion(new OpcionCorrecta("soy correcta"));

        PuntajeParcial modo = new PuntajeParcial();
        modo.modificarPuntos(respuesta, 2);

        assertEquals(2, jugador.puntos());
    }
}
