package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import java.util.ArrayList;

public class Ronda {
    private final Pregunta pregunta;
    private final ArrayList<Respuesta> respuestas = new ArrayList<>();

    public Ronda(Pregunta pregunta){
        this.pregunta = pregunta;
    }

    public Pregunta obtenerPregunta (){
        return pregunta;
    }

    public void agregarRespuesta(Respuesta respuesta){
        respuestas.add(respuesta);
    }

    public void evaluarPregunta(){
        pregunta.evaluarRespuestas(respuestas);
    }
}
