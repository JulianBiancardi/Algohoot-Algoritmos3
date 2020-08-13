package edu.fiuba.algo3.vista.Opciones;

import edu.fiuba.algo3.controlador.ControladorOpcion;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaOpcion extends Button {
    Label descripcionLabel = new Label();

    public VistaOpcion(Opcion unaOpcion, Color colorBoton){
        descripcionLabel.setText(unaOpcion.getDescripcion());

        descripcionLabel.setFont(Font.font("Montserrat", FontWeight.BOLD,25));
        descripcionLabel.setStyle("-fx-effect: dropshadow( one-pass-box , black , 5 , 0.0 , 1 , 0 )");
        descripcionLabel.setTextFill(Color.WHITE);

        this.setGraphic(descripcionLabel);
        this.setOnAction(e -> System.out.println("Me tocaron"));
        this.setBackground(new Background(new BackgroundFill(colorBoton,null, Insets.EMPTY)));
        this.setOnAction(new ControladorOpcion(unaOpcion));
    }
}
