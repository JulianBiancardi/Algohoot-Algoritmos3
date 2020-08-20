package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Excepciones.NombreVacioError;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;

public class ControladorOpcionOrdenada implements EventHandler<ActionEvent> {

    private ArrayList <OpcionOrdenada> opciones;
    private OpcionOrdenada opcionAsociada;
    private Label posicionActual;

    public ControladorOpcionOrdenada (ArrayList<OpcionOrdenada> opciones, OpcionOrdenada opcionAsociada, Label posicionActual){
        this.opciones = opciones;
        this.opcionAsociada = opcionAsociada;
        this.posicionActual = posicionActual;
    }
    @Override
    public void handle(ActionEvent actionEvent){
        AudioClip sonido = new AudioClip(App.class.getResource("/KSHMR Percussion Low 06 (C#).wav").toExternalForm());
        sonido.play();

        if(!opciones.contains(opcionAsociada)) {
            opciones.add(opcionAsociada);
            posicionActual.setText(String.valueOf(opciones.size()));
        }
    }
}
