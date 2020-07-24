package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RespuestaTest {

    @Test
    public void test00LaRespuestaSeCreaCorrectamente() {
        Jugador jugador = new Jugador("Joaco");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        Respuesta respuesta = new Respuesta(opciones.get(0), jugador);

        assertEquals(jugador, respuesta.responsable());
        assertEquals(opciones.get(0), respuesta.valor());
    }

    @Test
    public void test01LaRespuestaDelegaLaSumaDePuntosCorrectamente() {
        Jugador jugador = new Jugador("Joaco");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(new Opcion("Opcion de prueba correcta", true));
        Respuesta respuesta = new Respuesta(opciones.get(0), jugador);

        respuesta.sumarPuntos(1);

        assertEquals(1 ,jugador.puntos());
    }
}
