package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionesTest {

    @Test
    public void test01CreoOpcionCorrectaYVerificoQueDevuelvaTrue(){
        OpcionCorrecta opcion = new OpcionCorrecta("Soy correcta");

        assertEquals(true, opcion.esCorrecta());
    }

    @Test
    public void test02CreoOpcionIncorrectaYVerificoQueDevuelvaFalse(){
        OpcionIncorrecta opcion = new OpcionIncorrecta("Soy incorrecta");

        assertEquals(false, opcion.esCorrecta());
    }

    @Test
    public void test03CreoOpcionGrupaYVerificoQueDevuelvaFalseSiLosGruposNoCoinciden(){
        OpcionGrupal opcion = new OpcionGrupal("Soy grupal");

        opcion.setGrupoEsperado("Leo programador");
        opcion.setGrupoActual("Leo genio");

        assertEquals(false, opcion.esCorrecta());
    }

    @Test
    public void test04CreoOpcionGrupaYVerificoQueDevuelvaTrueSiLosGruposCoinciden(){
        OpcionGrupal opcion = new OpcionGrupal("Soy grupal");

        opcion.setGrupoEsperado("Leo programador");
        opcion.setGrupoActual("Leo programador");

        assertEquals(true, opcion.esCorrecta());
    }

    @Test
    public void test05CreoOpcionOrdenadaYVerificoQueDevuelvaTrueSiLasPosicionesCoinciden(){
        OpcionOrdenada opcion = new OpcionOrdenada("Soy ordenada", 2);

        opcion.setPosicionEsperada(2);

        assertEquals(true, opcion.esCorrecta());
    }

    @Test
    public void test06CreoOpcionOrdenadaYVerificoQueDevuelvaFalseSiLasPosicionesNoCoinciden(){
        OpcionOrdenada opcion = new OpcionOrdenada("Soy ordenada", 2);

        opcion.setPosicionEsperada(4);

        assertEquals(false, opcion.esCorrecta());
    }
}
