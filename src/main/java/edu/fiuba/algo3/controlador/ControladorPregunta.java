package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.VistaPregunta;

public class ControladorPregunta {

    VistaPregunta vista;
    Pregunta pregunta;

    public ControladorPregunta(VistaPregunta vista, Pregunta unaPregunta){
        this.vista = vista;
        this.pregunta = unaPregunta;
    }
}
