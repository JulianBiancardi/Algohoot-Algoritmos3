package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.vista.ResourcesConstantsAlgohoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ControladorOpcionBinaria implements EventHandler<ActionEvent> {

    private ArrayList<OpcionBinaria> opciones;
    private OpcionBinaria opcionAsociada;
    ImageView imageView;
    private boolean estaSeleccionado = false;

    public ControladorOpcionBinaria(ArrayList<OpcionBinaria> opciones, OpcionBinaria opcionAsociada, ImageView imageView){
        this.opciones = opciones;
        this.opcionAsociada = opcionAsociada;
        this.imageView = imageView;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Image estadoImagen;
        if(estaSeleccionado){
            opciones.remove(opcionAsociada);
            estadoImagen = new Image(ResourcesConstantsAlgohoot.PREGUNTA_NO_SELECCIONADA);
            estaSeleccionado = false;
        } else {
            opciones.add(opcionAsociada);
            estadoImagen = new Image(ResourcesConstantsAlgohoot.PREGUNTA_SELECCIONADA);
            estaSeleccionado = true;
        }

        imageView.setImage(estadoImagen);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
    }
}
