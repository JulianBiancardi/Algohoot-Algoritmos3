package edu.fiuba.algo3.vista.Opciones;

import edu.fiuba.algo3.controlador.ControladorOpcionOrdenada;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.vista.ResourcesConstantsAlgohoot;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class VistaOpcionOrdenada extends AnchorPane {
    private Label posicionActual = new Label();
    private Label descripcionLabel = new Label();
    private Button botonEstado = new Button();

    public VistaOpcionOrdenada(OpcionOrdenada unaOpcion, Image imagen, ArrayList<OpcionOrdenada> opcionesElegidas, int cantidadOpciones){
        descripcionLabel.setText(unaOpcion.getDescripcion());
        descripcionLabel.setFont(Font.font("Montserrat", FontWeight.BOLD, 30));
        descripcionLabel.setStyle("-fx-effect: dropshadow( one-pass-box , black , 5 , 0.0 , 1 , 0 )");
        descripcionLabel.setTextFill(Color.WHITE);

        StackPane stackPane1 = new StackPane();
        Image estadoImagen = new Image(ResourcesConstantsAlgohoot.PREGUNTA_NO_SELECCIONADA);
        ImageView estadoImagenView = new ImageView(estadoImagen);
        estadoImagenView.setFitWidth(80);
        estadoImagenView.setFitHeight(80);
        botonEstado.setGraphic(estadoImagenView);
        botonEstado.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, Insets.EMPTY)));

        botonEstado.setOnAction(new ControladorOpcionOrdenada(opcionesElegidas, unaOpcion, posicionActual));

        posicionActual.setFont(Font.font("Montserrat", FontWeight.BOLD, 30));
        posicionActual.setTextFill(Color.WHITE);
        stackPane1.getChildren().addAll(botonEstado, posicionActual);

        //this.setBackground(new Background(new BackgroundFill(colorBoton,null, Insets.EMPTY)));
        this.setBackground(new Background(new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true))));


        AnchorPane.setLeftAnchor(descripcionLabel, 20.0);
        AnchorPane.setTopAnchor(descripcionLabel, 20.0);
        AnchorPane.setBottomAnchor(descripcionLabel, 20.0);
        AnchorPane.setLeftAnchor(stackPane1, 20.0);
        AnchorPane.setRightAnchor(stackPane1, 0.0);
        AnchorPane.setBottomAnchor(stackPane1, 20.0);
        this.getChildren().addAll(descripcionLabel, stackPane1);

        this.setMaxHeight(80);
    }

    public void resetLabel(){
        posicionActual.setText("");
    }
}
