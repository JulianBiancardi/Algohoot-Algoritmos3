package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class VistaPregunta extends VBox{
    private final Integer startTime = 20;
    private Integer secondsPassed = startTime;
    private Timeline tiempo;
    Label contador = new Label(String.valueOf(startTime));

    public VistaPregunta(){

        Rectangle rectangle = new Rectangle(1000,100,Color.WHITE);
        Label enunciadoPregunta = new Label("Enunciado de la Pregunta");
        enunciadoPregunta.setStyle("-fx-font-size: 22");
        StackPane stackPane1 = new StackPane(rectangle,enunciadoPregunta);

        Circle circle = new Circle(50,50,70,Color.valueOf("#844cbe"));
        contador.setTextFill(Color.WHITE);
        contador.setStyle("-fx-font-size: 54");
        StackPane stackPane2 = new StackPane(circle,contador);

        GridPane opcionesPregunta = new GridPane();
        opcionesPregunta.setAlignment(Pos.CENTER);
        opcionesPregunta.add(new Button("Opcion1"),0,0);
        opcionesPregunta.add(new Button("Opcion2"),0,1);
        opcionesPregunta.add(new Button("Opcion3"),1,0);
        opcionesPregunta.add(new Button("Opcion4"),1,1);

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

}
