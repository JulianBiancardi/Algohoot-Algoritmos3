package edu.fiuba.algo3.vista.Opciones;

import edu.fiuba.algo3.controlador.ControladorOpcion;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaOpcion extends Button {
    Label descripcionLabel = new Label();

    public VistaOpcion(Opcion unaOpcion, Color colorBoton){
        this.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();

        descripcionLabel.setText(unaOpcion.getDescripcion());
        descripcionLabel.setFont(Font.font("Montserrat", FontWeight.BOLD,25));
        descripcionLabel.setStyle("-fx-effect: dropshadow( one-pass-box , black , 5 , 0.0 , 1 , 0 )");
        descripcionLabel.setTextFill(Color.WHITE);

        Image estadoImagen = new Image("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\IMG_OpcionBinariaNoSeleccionada.png");
        ImageView estadoImagenView = new ImageView(estadoImagen);
        estadoImagenView.setFitWidth(60);
        estadoImagenView.setFitHeight(60);

        hBox.getChildren().addAll(descripcionLabel,estadoImagenView);
        hBox.setSpacing(100);

        this.setGraphic(hBox);
        this.setOnAction(e -> System.out.println("Me tocaron"));
        this.setBackground(new Background(new BackgroundFill(colorBoton,null, Insets.EMPTY)));
        this.setOnAction(new ControladorOpcion(unaOpcion));

    }
}
