package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.Preguntas.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LectorPreguntasTest {
    LectorPreguntas lector;
    ArrayList<Pregunta> preguntas;

    @BeforeEach
    void setUp() throws IOException {
        lector = new LectorPreguntas();
        preguntas = lector.leerPreguntas();
    }

    @Test
    public void test01LeoDelJSONVerificoQueLeyoBienVoF(){
        assertEquals("Verdadero o Falso", (preguntas.get(0)).tipo());
        assertEquals("GitHub fue creado en 2007", (preguntas.get(0)).enunciado());
        assertEquals("Penalidad", (preguntas.get(0)).modo());

        assertEquals("Verdadero o Falso", (preguntas.get(3)).tipo());
        assertEquals("China es el país mas poblado del mundo", (preguntas.get(3)).enunciado());
        assertEquals("Clasico", (preguntas.get(3)).modo());
    }

    @Test
    public void test02LeoDelJSONVerificoQueLeyoBienMultipleChoice(){
        assertEquals("Multiple Choice", (preguntas.get(4)).tipo());
        assertEquals("Capitales de Provincias Argentinas", (preguntas.get(4)).enunciado());
        assertEquals("PuntajeParcial", (preguntas.get(4)).modo());

        assertEquals("Multiple Choice", (preguntas.get(7)).tipo());
        assertEquals("A que hecho histórico corresponde el Día D", (preguntas.get(7)).enunciado());
        assertEquals("Clasico", (preguntas.get(7)).modo());

        assertEquals("Multiple Choice", (preguntas.get(10)).tipo());
        assertEquals("El que no hace palmas...", (preguntas.get(10)).enunciado());
        assertEquals("Penalidad", (preguntas.get(10)).modo());
    }

    @Test
    public void test03LeoDelJSONVerificoQueLeyoBienOrderedChoice(){
        assertEquals("Ordered Choice", (preguntas.get(13)).tipo());
        assertEquals("Ordenar en orden cronológico los siguientes hechos", (preguntas.get(13)).enunciado());
        assertEquals("Clasico", (preguntas.get(13)).modo());

        assertEquals("Ordenar en orden cronológico la fundación de las siguientes empresas", (preguntas.get(14)).enunciado());
        assertEquals("Ordenar en orden cronológico la fundación las siguientes compañias", (preguntas.get(15)).enunciado());
    }

    @Test
    public void test04LeoDelJSONVerificoQueLeyoBienGroupChoice(){
        assertEquals("Group Choice", (preguntas.get(16)).tipo());
        assertEquals("Separar por escudos", (preguntas.get(16)).enunciado());
        assertEquals("Clasico", (preguntas.get(16)).modo());

        assertEquals("Separar por tipo de paises", (preguntas.get(17)).enunciado());
        assertEquals("Separar por colores de bandera", (preguntas.get(18)).enunciado());
        assertEquals("Separar por contiente", (preguntas.get(19)).enunciado());
    }
}
