package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Opciones.Grupo;
import edu.fiuba.algo3.modelo.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrupoTest {

    @Test
    public void test01CreoGrupoConUnaIncorrectaYVerificoQueDevuelvaBienCantidadCorrectas(){
        OpcionGrupal opcion = new OpcionGrupal("Soy grupal");
        opcion.setGrupoEsperado("Somos un Grupo");
        Grupo grupo = new Grupo("Soy un Grupo");

        grupo.agregarOpcionGrupo(opcion);

        assertEquals(0, grupo.cantidadOpcionesCorrectas());
    }

    @Test
    public void test02CreoGrupoConUnaOpcionCorrectaYVerificoQueDevuelvaBienCantidadCorrectas(){
        OpcionGrupal opcion1 = new OpcionGrupal("Soy correcta");
        opcion1.setGrupoEsperado("5 * 2 = 10");
        OpcionGrupal opcion2 = new OpcionGrupal("Soy incorrecta");
        opcion2.setGrupoEsperado("5 * 2 = 20");
        Grupo grupo = new Grupo("5 * 2 = 10");

        grupo.agregarOpcionGrupo(opcion1);
        grupo.agregarOpcionGrupo(opcion2);

        assertEquals(1, grupo.cantidadOpcionesCorrectas());
    }

    @Test
    public void test03CreoGrupoConDosOpcionCorrectaYVerificoQueDevuelvaBienCantidadCorrectas(){
        OpcionGrupal opcion1 = new OpcionGrupal("Soy correcta");
        opcion1.setGrupoEsperado("5 * 2 = 10");
        OpcionGrupal opcion2 = new OpcionGrupal("Soy incorrecta");
        opcion2.setGrupoEsperado("5 * 2 = 20");
        OpcionGrupal opcion3 = new OpcionGrupal("Soy correcta");
        opcion3.setGrupoEsperado("5 * 2 = 10");
        OpcionGrupal opcion4 = new OpcionGrupal("Soy incorrecta");
        opcion4.setGrupoEsperado("5 * 2 = 20");
        Grupo grupo = new Grupo("5 * 2 = 10");

        grupo.agregarOpcionGrupo(opcion1);
        grupo.agregarOpcionGrupo(opcion2);
        grupo.agregarOpcionGrupo(opcion3);
        grupo.agregarOpcionGrupo(opcion4);

        assertEquals(2, grupo.cantidadOpcionesCorrectas());
    }

    @Test
    public void test04CreoGrupoConTresOpcionCorrectaYVerificoQueDevuelvaBienCantidadCorrectas(){
        OpcionGrupal opcion1 = new OpcionGrupal("Soy correcta");
        opcion1.setGrupoEsperado("5 * 2 = 10");
        OpcionGrupal opcion2 = new OpcionGrupal("Soy correcta");
        opcion2.setGrupoEsperado("5 * 2 = 10");
        OpcionGrupal opcion3 = new OpcionGrupal("Soy correcta");
        opcion3.setGrupoEsperado("5 * 2 = 10");
        OpcionGrupal opcion4 = new OpcionGrupal("Soy incorrecta");
        opcion4.setGrupoEsperado("5 * 2 = 20");
        Grupo grupo = new Grupo("5 * 2 = 10");

        grupo.agregarOpcionGrupo(opcion1);
        grupo.agregarOpcionGrupo(opcion2);
        grupo.agregarOpcionGrupo(opcion3);
        grupo.agregarOpcionGrupo(opcion4);

        assertEquals(3, grupo.cantidadOpcionesCorrectas());
    }

    @Test
    public void test05CreoGrupoConCuatroOpcionCorrectaYVerificoQueDevuelvaBienCantidadCorrectas(){
        OpcionGrupal opcion1 = new OpcionGrupal("Soy correcta");
        opcion1.setGrupoEsperado("5 * 2 = 10");
        OpcionGrupal opcion2 = new OpcionGrupal("Soy correcta");
        opcion2.setGrupoEsperado("5 * 2 = 10");
        OpcionGrupal opcion3 = new OpcionGrupal("Soy correcta");
        opcion3.setGrupoEsperado("5 * 2 = 10");
        OpcionGrupal opcion4 = new OpcionGrupal("Soy correcta");
        opcion4.setGrupoEsperado("5 * 2 = 10");
        Grupo grupo = new Grupo("5 * 2 = 10");

        grupo.agregarOpcionGrupo(opcion1);
        grupo.agregarOpcionGrupo(opcion2);
        grupo.agregarOpcionGrupo(opcion3);
        grupo.agregarOpcionGrupo(opcion4);

        assertEquals(4, grupo.cantidadOpcionesCorrectas());
    }

}
