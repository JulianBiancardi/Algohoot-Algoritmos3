package edu.fiuba.algo3.modelo.Entidades.Opciones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OpcionesTest {

    @Test
    public void test01CreoOpcionCorrectaYVerificoQueDevuelvaTrue(){
        OpcionBinaria opcion = new OpcionBinaria("Soy correcta", true);

        assertTrue(opcion.esCorrecta());
    }

    @Test
    public void test02CreoOpcionIncorrectaYVerificoQueDevuelvaFalse(){
        OpcionBinaria opcion = new OpcionBinaria("Soy incorrecta", false);

        assertFalse(opcion.esCorrecta());
    }


    @Test
    public void test03CreoOpcionGrupaYVerificoQueDevuelvaFalseSiLosGruposNoCoinciden(){
        OpcionGrupal opcion = new OpcionGrupal("Soy grupal", "Leo programador");

        opcion.setGrupoActual("Leo genio");

        assertFalse(opcion.esCorrecta());
    }

    @Test
    public void test04CreoOpcionGrupaYVerificoQueDevuelvaTrueSiLosGruposCoinciden(){
        OpcionGrupal opcion = new OpcionGrupal("Soy grupal", "Leo programador");

        opcion.setGrupoActual("Leo programador");

        assertTrue(opcion.esCorrecta());
    }

    @Test
    public void test05CreoOpcionOrdenadaYVerificoQueDevuelvaTrueSiLasPosicionesCoinciden(){
        OpcionOrdenada opcion = new OpcionOrdenada("Soy ordenada",2);

        opcion.setPosicionActual(2);

        assertTrue(opcion.esCorrecta());
    }

    @Test
    public void test06CreoOpcionOrdenadaYVerificoQueDevuelvaFalseSiLasPosicionesNoCoinciden(){
        OpcionOrdenada opcion = new OpcionOrdenada("Soy desordenada", 2);

        opcion.setPosicionActual(3);

        assertFalse(opcion.esCorrecta());
    }
}
