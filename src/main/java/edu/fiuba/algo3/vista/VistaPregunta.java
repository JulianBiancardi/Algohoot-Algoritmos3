package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class VistaPregunta extends VBox{
    private final Integer startTime = 20;
    private Integer secondsPassed = startTime;
    private Timeline tiempo;
    Label contador = new Label(String.valueOf(startTime));

    public VistaPregunta(){

        StackPane stackPane1 = new StackPane();
        mostrarPregunta(stackPane1);

        Circle circle = new Circle(50,50,70,Color.valueOf("#844cbe"));
        contador.setTextFill(Color.WHITE);
        contador.setStyle("-fx-font-size: 54");
        StackPane stackPane2 = new StackPane(circle,contador);

        GridPane opcionesPregunta = new GridPane();
        mostrarOpciones(opcionesPregunta);

        this.setSpacing(10);
        this.getChildren().add(stackPane1);
        this.getChildren().add(stackPane2);
        this.getChildren().add(opcionesPregunta);
        this.setAlignment(Pos.TOP_CENTER);

        tiempo = new Timeline(new KeyFrame(Duration.seconds(1),e -> contar()));
        tiempo.setCycleCount(Timeline.INDEFINITE);
        tiempo.play();

    }

    public void contar(){
        if(secondsPassed > 0){
            secondsPassed--;
            contador.setText(String.valueOf(secondsPassed));
        }
        else tiempo.pause();
    }

    public void mostrarPregunta(StackPane stackPane){

        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.BLACK);
        rectangle.widthProperty().bind(stackPane.widthProperty());

        Label enunciadoPregunta = new Label("Enunciado de la Pregunta");
        enunciadoPregunta.setStyle("-fx-font-size: 22");

        stackPane.getChildren().addAll(rectangle,enunciadoPregunta);

    }

    public void mostrarOpciones(GridPane opcionesPregunta){

        opcionesPregunta.setMinSize(600,200);
        opcionesPregunta.setMaxSize(1200,400);
        opcionesPregunta.setAlignment(Pos.CENTER);
        opcionesPregunta.setHgap(5);
        opcionesPregunta.setVgap(5);

        Button opcion1 = new Button("Opcion1");
        opcion1.prefWidthProperty().bind(opcionesPregunta.widthProperty());
        opcion1.prefHeightProperty().bind(opcionesPregunta.heightProperty());
        Button opcion2 = new Button("Opcion2");
        opcion2.prefWidthProperty().bind(opcionesPregunta.widthProperty());
        opcion2.prefHeightProperty().bind(opcionesPregunta.heightProperty());
        Button opcion3 = new Button("Opcion3");
        opcion3.prefWidthProperty().bind(opcionesPregunta.widthProperty());
        opcion3.prefHeightProperty().bind(opcionesPregunta.heightProperty());
        Button opcion4 = new Button("Opcion4");
        opcion4.prefWidthProperty().bind(opcionesPregunta.widthProperty());
        opcion4.prefHeightProperty().bind(opcionesPregunta.heightProperty());

        opcionesPregunta.addRow(0,opcion1,opcion2);
        opcionesPregunta.addRow(1,opcion3,opcion4);
    }

}
