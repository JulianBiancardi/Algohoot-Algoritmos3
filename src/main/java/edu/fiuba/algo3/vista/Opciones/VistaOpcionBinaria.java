package edu.fiuba.algo3.vista.Opciones;

import edu.fiuba.algo3.controlador.ControladorOpcion;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaOpcionBinaria extends AnchorPane {
    Label descripcionLabel = new Label();
    ToggleButton botonEstado = new ToggleButton();

    public VistaOpcionBinaria(Opcion unaOpcion, Color colorBoton){

        descripcionLabel.setText(unaOpcion.getDescripcion());
        descripcionLabel.setFont(Font.font("Montserrat", FontWeight.BOLD,30));
        descripcionLabel.setStyle("-fx-effect: dropshadow( one-pass-box , black , 5 , 0.0 , 1 , 0 )");
        descripcionLabel.setTextFill(Color.WHITE);

        Image estadoImagen = new Image("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\IMG_OpcionBinariaNoSeleccionada.png");
        ImageView estadoImagenView = new ImageView(estadoImagen);
        estadoImagenView.setFitWidth(80);
        estadoImagenView.setFitHeight(80);
        botonEstado.setGraphic(estadoImagenView);
        botonEstado.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null,Insets.EMPTY)));
        botonEstado.setOnAction(e -> botonPulsado());

        this.setBackground(new Background(new BackgroundFill(colorBoton,null, Insets.EMPTY)));

        AnchorPane.setLeftAnchor(descripcionLabel,20.0);
        AnchorPane.setTopAnchor(descripcionLabel,20.0);
        AnchorPane.setRightAnchor(botonEstado,0.0);
        this.getChildren().addAll(descripcionLabel,botonEstado);
    }

    private void botonPulsado(){
        Image estadoImagen;
        if(botonEstado.isSelected())
            estadoImagen = new Image("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\IMG_OpcionBinariaSeleccionada.png");
        else
            estadoImagen = new Image("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\IMG_OpcionBinariaNoSeleccionada.png");

        ImageView estadoImagenView = new ImageView(estadoImagen);
        estadoImagenView.setFitWidth(80);
        estadoImagenView.setFitHeight(80);
        botonEstado.setGraphic(estadoImagenView);
    }
}
