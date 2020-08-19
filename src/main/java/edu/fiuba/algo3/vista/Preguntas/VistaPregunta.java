package edu.fiuba.algo3.vista.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public abstract class VistaPregunta extends GridPane {
    protected Pregunta preguntaAsociada;

    public VistaPregunta(Pregunta pregunta){
        this.setVgap(5);
        this.setPadding(new Insets(15, 15, 15, 15));
        preguntaAsociada = pregunta;
    }

    public abstract Respuesta getRespuesta();

    public abstract Respuesta completarRespuesta();

    /* FIXME:

    Lo mejor seria recibir la scene/stage asi tenes referencia al contador y enunciado pregunta
    modificarias el tamaño con un Insets..  o SetSize... o lo que sea
        por que digo esto ? porque:

  -   con 2 opts se ve  la pantalla muy vacia
  -   con 3 o 4 ops se ve la pantalla medio pelo
  -   con 5 o 6 opts es hermoso */

    protected Image obtenerImagenPara2Opciones(String url){
        this.setAlignment(Pos.CENTER);
        this.setHgap(5);
        this.setPadding(new Insets(15, 15, 17, 15));
        return new Image(url, 380, 90, false, false);
    }

    protected Image obtenerImagenPara3o4Opciones(String url){
        this.setAlignment(Pos.CENTER);
        this.setHgap(-55);
        this.setPadding(new Insets(15, 15, 36, 15));
        return new Image(url, 350, 70, false, false);
    }

    protected Image obtenerImagenPara5o6Opciones(String url){
        this.setAlignment(Pos.CENTER);
        this.setHgap(-55);
        this.setPadding(new Insets(15, 15, 15, 15));
        return new Image(url, 350, 70, false, false);
    }

}
