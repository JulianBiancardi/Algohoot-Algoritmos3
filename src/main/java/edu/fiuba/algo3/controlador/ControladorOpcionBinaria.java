package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;

public class ControladorOpcionBinaria implements EventHandler<ActionEvent> {

    private ArrayList<OpcionBinaria> opciones;
    private OpcionBinaria opcionAsociada;
    ImageView imageView;
    private boolean estaSeleccionado = false;

    public ControladorOpcionBinaria (ArrayList<OpcionBinaria> opciones, OpcionBinaria opcionAsociada, ImageView imageView){
        this.opciones = opciones;
        this.opcionAsociada = opcionAsociada;
        this.imageView = imageView;
    }
    @Override
    public void handle(ActionEvent actionEvent){
        AudioClip sonido = new AudioClip(App.class.getResource("/KSHMR Percussion Low 06 (C#).wav").toExternalForm());
        sonido.play();

        Image estadoImagen;
        if(estaSeleccionado){
            opciones.remove(opcionAsociada);
            estadoImagen = new Image("File:src/resources/imagenes/IMG_Botones/IMG_OpcionBinariaNoSeleccionada.png");
            estaSeleccionado = false;
        }
        else {
            opciones.add(opcionAsociada);
            estadoImagen = new Image("File:src/resources/imagenes/IMG_Botones/IMG_OpcionBinariaSeleccionada.png");
            estaSeleccionado = true;
        }

        imageView.setImage(estadoImagen);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
    }
}
