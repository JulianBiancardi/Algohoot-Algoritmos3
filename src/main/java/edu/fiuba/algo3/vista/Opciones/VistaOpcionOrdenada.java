package edu.fiuba.algo3.vista.Opciones;

import edu.fiuba.algo3.controlador.ControladorOpcionOrdenada;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionOrdenada;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class VistaOpcionOrdenada extends StackPane{
    private Label posicionActual = new Label();
    private Label descripcionLabel = new Label();
    private Button botonEstado = new Button();

    public VistaOpcionOrdenada(OpcionOrdenada unaOpcion, Image imagen, ArrayList<OpcionOrdenada> opcionesElegidas,int cantidadOpciones){
        ImageView fondoView = new ImageView(imagen);
        fondoView.fitHeightProperty().bind(this.heightProperty());
        fondoView.fitWidthProperty().bind(this.widthProperty());

        descripcionLabel.setText(unaOpcion.getDescripcion());
        descripcionLabel.setFont(Font.font("Montserrat", FontWeight.BOLD,30));
        descripcionLabel.setStyle("-fx-effect: dropshadow( one-pass-box , black , 5 , 0.0 , 1 , 0 )");
        descripcionLabel.setTextFill(Color.WHITE);

        StackPane stackPane1 = new StackPane();
        Image estadoImagen = new Image("File:src\\resources\\imagenes\\IMG_OpcionBinariaNoSeleccionada.png");
        ImageView estadoImagenView = new ImageView(estadoImagen);
        estadoImagenView.setFitWidth(80);
        estadoImagenView.setFitHeight(80);
        botonEstado.setGraphic(estadoImagenView);
        botonEstado.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null, Insets.EMPTY)));

        botonEstado.setOnAction(new ControladorOpcionOrdenada(opcionesElegidas, unaOpcion, posicionActual));

        posicionActual.setFont(Font.font("Montserrat", FontWeight.BOLD,30));
        posicionActual.setTextFill(Color.WHITE);
        stackPane1.getChildren().addAll(botonEstado,posicionActual);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(descripcionLabel,stackPane1);
        hBox.setAlignment(Pos.CENTER_RIGHT);

        this.setMaxHeight(80);
        this.getChildren().addAll(fondoView,hBox);
    }

    public void resetLabel() {
        posicionActual.setText("");
    }
}
