package edu.fiuba.algo3.vista;

import javafx.css.Size;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class VistaPregunta {
    VBox layoutPrincipal = new VBox();
    Scene scenePregunta = new Scene(layoutPrincipal);

    public VistaPregunta(){

        Rectangle rectangle = new Rectangle(1000,100,Color.WHITE);
        Label enunciadoPregunta = new Label("Enunciado de la Pregunta");
        enunciadoPregunta.setStyle("-fx-font-size: 22");
        StackPane stackPane1 = new StackPane(rectangle,enunciadoPregunta);

        Circle circle = new Circle(50,50,70,Color.valueOf("#844cbe"));
        Label contador = new Label("99");
        contador.setTextFill(Color.WHITE);
        contador.setStyle("-fx-font-size: 34");
        StackPane stackPane2 = new StackPane(circle,contador);


        GridPane opcionesPregunta = new GridPane();
        opcionesPregunta.setAlignment(Pos.CENTER);
        opcionesPregunta.add(new Button("Opcion1"),0,0);
        opcionesPregunta.add(new Button("Opcion2"),0,1);
        opcionesPregunta.add(new Button("Opcion3"),1,0);
        opcionesPregunta.add(new Button("Opcion4"),1,1);

        layoutPrincipal.setSpacing(10);
        layoutPrincipal.getChildren().add(stackPane1);
        layoutPrincipal.getChildren().add(stackPane2);
        layoutPrincipal.getChildren().add(opcionesPregunta);
        layoutPrincipal.setAlignment(Pos.TOP_CENTER);

    }

    public Scene getScene(){
        return scenePregunta;
    }

}
