package edu.fiuba.algo3.modelo.Entidades;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.stage.Stage;

public class Ronda {
    private Pregunta pregunta;

    public Ronda (Pregunta pregunta){
        this.pregunta = pregunta;
    }

    public Pregunta obtenerPregunta (){
        return pregunta;
    }
}
