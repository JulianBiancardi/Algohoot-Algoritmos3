package edu.fiuba.algo3.modelo.Opciones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrupoTest {

    @Test
    public void test01CreoGrupoConUnaIncorrectaYVerificoQueDevuelvaBienCantidadCorrectas(){
        OpcionGrupal opcion = new OpcionGrupal("Soy extraordinario");
        opcion.setGrupoEsperado("Somos un extraordinarios");
        Grupo grupo = new Grupo("Soy un extraordinario");

        grupo.agregarOpcionGrupo(opcion);

        assertEquals(0, grupo.cantidadOpcionesCorrectas());
    }

    @Test
    public void test02CreoGrupoConUnaOpcionCorrectaYVerificoQueDevuelvaBienCantidadCorrectas(){
        OpcionGrupal opcion1 = new OpcionGrupal("10");
        opcion1.setGrupoEsperado("5 * 2");
        OpcionGrupal opcion2 = new OpcionGrupal("20");
        opcion2.setGrupoEsperado("5 * 4");
        Grupo grupo = new Grupo("5 * 2");

        grupo.agregarOpcionGrupo(opcion1);
        grupo.agregarOpcionGrupo(opcion2);

        assertEquals(1, grupo.cantidadOpcionesCorrectas());
    }

    @Test
    public void test03CreoGrupoConDosOpcionCorrectaYVerificoQueDevuelvaBienCantidadCorrectas(){
        OpcionGrupal opcion1 = new OpcionGrupal("10");
        opcion1.setGrupoEsperado("5 * 2");
        OpcionGrupal opcion2 = new OpcionGrupal("20");
        opcion2.setGrupoEsperado("5 * 4");
        OpcionGrupal opcion3 = new OpcionGrupal("5 + 5");
        opcion3.setGrupoEsperado("5 * 2");
        OpcionGrupal opcion4 = new OpcionGrupal("5 * 5");
        opcion4.setGrupoEsperado("5 * 4");
        Grupo grupo = new Grupo("5 * 2");

        grupo.agregarOpcionGrupo(opcion1);
        grupo.agregarOpcionGrupo(opcion2);
        grupo.agregarOpcionGrupo(opcion3);
        grupo.agregarOpcionGrupo(opcion4);

        assertEquals(2, grupo.cantidadOpcionesCorrectas());
    }

    @Test
    public void test04CreoGrupoConTresOpcionCorrectaYVerificoQueDevuelvaBienCantidadCorrectas(){
        OpcionGrupal opcion1 = new OpcionGrupal("10");
        opcion1.setGrupoEsperado("5 * 2");
        OpcionGrupal opcion2 = new OpcionGrupal("20");
        opcion2.setGrupoEsperado("5 * 4");
        OpcionGrupal opcion3 = new OpcionGrupal("5 + 5");
        opcion3.setGrupoEsperado("5 * 2");
        OpcionGrupal opcion4 = new OpcionGrupal("2 + 2 + 2 + 2 + 2");
        opcion4.setGrupoEsperado("5 * 2");
        Grupo grupo = new Grupo("5 * 2");

        grupo.agregarOpcionGrupo(opcion1);
        grupo.agregarOpcionGrupo(opcion2);
        grupo.agregarOpcionGrupo(opcion3);
        grupo.agregarOpcionGrupo(opcion4);

        assertEquals(3, grupo.cantidadOpcionesCorrectas());
    }

    @Test
    public void test05CreoGrupoConCuatroOpcionCorrectaYVerificoQueDevuelvaBienCantidadCorrectas(){
        OpcionGrupal opcion1 = new OpcionGrupal("10");
        opcion1.setGrupoEsperado("5 * 2");
        OpcionGrupal opcion2 = new OpcionGrupal("7 + 3");
        opcion2.setGrupoEsperado("5 * 2");
        OpcionGrupal opcion3 = new OpcionGrupal("5 + 5");
        opcion3.setGrupoEsperado("5 * 2");
        OpcionGrupal opcion4 = new OpcionGrupal("2 + 2 + 2 + 2 + 2");
        opcion4.setGrupoEsperado("5 * 2");
        Grupo grupo = new Grupo("5 * 2");

        grupo.agregarOpcionGrupo(opcion1);
        grupo.agregarOpcionGrupo(opcion2);
        grupo.agregarOpcionGrupo(opcion3);
        grupo.agregarOpcionGrupo(opcion4);

        assertEquals(4, grupo.cantidadOpcionesCorrectas());
    }
}
