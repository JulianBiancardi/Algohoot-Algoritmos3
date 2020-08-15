package edu.fiuba.algo3.vista.Opciones;

import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class VistaOpcionBinaria extends AnchorPane {
    ToggleButton botonEstado = new ToggleButton();
    Opcion opcionAsociada;

    public VistaOpcionBinaria(Opcion unaOpcion, Color colorBoton, ArrayList<Opcion> opcionesElegidas){
        opcionAsociada = unaOpcion;

        Label descripcionLabel = new Label();
        descripcionLabel.setText(unaOpcion.getDescripcion());
        descripcionLabel.setFont(Font.font("Montserrat", FontWeight.BOLD,30));
        descripcionLabel.setStyle("-fx-effect: dropshadow( one-pass-box , black , 5 , 0.0 , 1 , 0 )");
        descripcionLabel.setTextFill(Color.WHITE);
        descripcionLabel.setAlignment(Pos.CENTER_LEFT);

        Image estadoImagen = new Image("File:src\\resources\\imagenes\\IMG_OpcionBinariaNoSeleccionada.png");
        ImageView estadoImagenView = new ImageView(estadoImagen);
        estadoImagenView.setFitWidth(80);
        estadoImagenView.setFitHeight(80);
        botonEstado.setGraphic(estadoImagenView);
        botonEstado.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null,Insets.EMPTY)));
        botonEstado.setOnAction(e -> botonPulsado(opcionesElegidas));

        this.setBackground(new Background(new BackgroundFill(colorBoton,null, Insets.EMPTY)));

        this.getChildren().addAll(descripcionLabel,botonEstado);
        AnchorPane.setLeftAnchor(descripcionLabel,10.0);
        AnchorPane.setTopAnchor(descripcionLabel,10.0);
        AnchorPane.setBottomAnchor(descripcionLabel,10.0);

        AnchorPane.setRightAnchor(botonEstado,10.0);
        AnchorPane.setTopAnchor(botonEstado,10.0);
        AnchorPane.setBottomAnchor(botonEstado,10.0);
    }

    private void botonPulsado(ArrayList<Opcion> opcionesElegidas){
        Image estadoImagen;
        if(botonEstado.isSelected()){
            estadoImagen = new Image("File:src\\resources\\imagenes\\IMG_OpcionBinariaSeleccionada.png");
            opcionesElegidas.add(opcionAsociada);
        }
        else{
            estadoImagen = new Image("File:src\\resources\\imagenes\\IMG_OpcionBinariaNoSeleccionada.png");
            opcionesElegidas.remove(opcionAsociada);
        }

        ImageView estadoImagenView = new ImageView(estadoImagen);
        estadoImagenView.setFitWidth(80);
        estadoImagenView.setFitHeight(80);
        botonEstado.setGraphic(estadoImagenView);
    }
}
