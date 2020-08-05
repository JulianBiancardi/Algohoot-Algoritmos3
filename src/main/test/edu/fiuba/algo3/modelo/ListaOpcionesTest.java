package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.ListaOpciones;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaOpcionesTest {

    @Test
    public void test01CreoListaOpcionesConDosCorrectasVerificoCantidadCorrectas() {
        ListaOpciones opciones = new ListaOpciones();

        opciones.agregarOpcion(new OpcionCorrecta("2 + 7 = 9"));
        opciones.agregarOpcion(new OpcionIncorrecta("2 + 7 = 3"));
        opciones.agregarOpcion(new OpcionCorrecta("2 + 4 = 6"));

        assertEquals(2, opciones.cantidadOpcionesCorrectas());
    }

    @Test
    public void test02CreoListaOpcionesConTresIncorrectasVerificoCantidadIncorrectas() {
        ListaOpciones opciones = new ListaOpciones();

        opciones.agregarOpcion(new OpcionCorrecta("2 + 7 = 9"));
        opciones.agregarOpcion(new OpcionIncorrecta("2 + 7 = 3"));
        opciones.agregarOpcion(new OpcionCorrecta("2 + 4 = 6"));
        opciones.agregarOpcion(new OpcionIncorrecta("2 + 4 = 7"));
        opciones.agregarOpcion(new OpcionIncorrecta("8 + 7 = 3"));

        assertEquals(3, opciones.cantidadOpcionesIncorrectas());
    }

    @Test
    public void test03CreoListaOpcionesConCincoOpcionesOrdenadasVerificoCantidadCorrectas() {
        ListaOpciones opciones = new ListaOpciones();

        opciones.agregarOpcionOrdenada(new OpcionOrdenada("5", 2));
        opciones.agregarOpcionOrdenada(new OpcionOrdenada("25", 4));
        opciones.agregarOpcionOrdenada(new OpcionOrdenada("2", 1));
        opciones.agregarOpcionOrdenada(new OpcionOrdenada("10", 3));
        opciones.agregarOpcionOrdenada(new OpcionOrdenada("60", 5));

        assertEquals(5, opciones.cantidadOpcionesCorrectas());
    }

    @Test
    public void test04CreoListaOpcionesConOpcionesObtengoLaTerceraOpcion() {
        ListaOpciones opciones = new ListaOpciones();
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("Soy la elegida");

        opciones.agregarOpcion(new OpcionCorrecta("2 + 7 = 9"));
        opciones.agregarOpcion(new OpcionIncorrecta("2 + 7 = 3"));
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(new OpcionIncorrecta("2 + 4 = 7"));
        opciones.agregarOpcion(new OpcionIncorrecta("8 + 7 = 3"));

        assertEquals(terceraOpcion, opciones.obtener(2));
    }

    @Test
    public void test05CreoListaOpcionesConCincoOpcionesVerificoTamaño() {
        ListaOpciones opciones = new ListaOpciones();
        OpcionCorrecta terceraOpcion = new OpcionCorrecta("Soy la elegida");

        opciones.agregarOpcion(new OpcionCorrecta("2 + 7 = 9"));
        opciones.agregarOpcion(new OpcionIncorrecta("2 + 7 = 3"));
        opciones.agregarOpcion(terceraOpcion);
        opciones.agregarOpcion(new OpcionIncorrecta("2 + 4 = 7"));
        opciones.agregarOpcion(new OpcionIncorrecta("8 + 7 = 3"));

        assertEquals(5, opciones.tamaño());
    }
}
