package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionBinaria;
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
        Respuesta respuesta = new Respuesta(jugador, VoF.conModoClasico("Pregunta de Prueba"));
        respuesta.agregarOpcion(new OpcionBinaria("soy correcta pa", true));
        respuesta.agregarOpcion(new OpcionBinaria("soy incorrecta pa", false));
        respuesta.agregarOpcion(new OpcionBinaria("soy correcta", true));
        respuesta.agregarOpcion(new OpcionBinaria("soy incorrecta", false));

        Clasico modo = new Clasico();
        modo.modificarPuntos(respuesta, 2);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test02CreoModoClasicoSumaPuntajeYVerificoPuntos() {
        Jugador jugador = new Jugador("Leito");
        Respuesta respuesta = new Respuesta(jugador, VoF.conModoClasico("Pregunta de Prueba"));
        respuesta.agregarOpcion(new OpcionBinaria("soy correcta pa", true));
        respuesta.agregarOpcion(new OpcionBinaria("soy correcta pa", true));

        Clasico modo = new Clasico();
        modo.modificarPuntos(respuesta, 2);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test03CreoModoPenalidaSumaDosRestaUnoYVerificoPuntos() {
        Jugador jugador = new Jugador("Leito");
        Respuesta respuesta = new Respuesta(jugador, VoF.conModoClasico("Pregunta de Prueba"));
        respuesta.agregarOpcion(new OpcionBinaria("soy correcta pa", true));
        respuesta.agregarOpcion(new OpcionBinaria("soy incorrecta", false));
        respuesta.agregarOpcion(new OpcionBinaria("soy correcta pa", true));

        Penalidad modo = new Penalidad();
        modo.modificarPuntos(respuesta, 2);

        assertEquals(1, jugador.puntos());
    }

    @Test
    public void test04CreoModoPuntajeParcialNoSumaPuntajeYVerificoPuntos() {
        Jugador jugador = new Jugador("Leito");
        Respuesta respuesta = new Respuesta(jugador, VoF.conModoClasico("Pregunta de Prueba"));
        respuesta.agregarOpcion(new OpcionBinaria("soy correcta pa", true));
        respuesta.agregarOpcion(new OpcionBinaria("soy incorrecta", false));
        respuesta.agregarOpcion(new OpcionBinaria("soy correcta pa", true));
        respuesta.agregarOpcion(new OpcionBinaria("soy incorrecta", false));

        PuntajeParcial modo = new PuntajeParcial();
        modo.modificarPuntos(respuesta, 2);

        assertEquals(0, jugador.puntos());
    }

    @Test
    public void test05CreoModoPuntajeParcialSumaPuntajeYVerificoPuntos() {
        Jugador jugador = new Jugador("Leito");
        Respuesta respuesta = new Respuesta(jugador, VoF.conModoClasico("Pregunta de Prueba"));
        respuesta.agregarOpcion(new OpcionBinaria("soy correcta pa", true));
        respuesta.agregarOpcion(new OpcionBinaria("soy correcta pa", true));

        PuntajeParcial modo = new PuntajeParcial();
        modo.modificarPuntos(respuesta, 2);

        assertEquals(2, jugador.puntos());
    }
}
