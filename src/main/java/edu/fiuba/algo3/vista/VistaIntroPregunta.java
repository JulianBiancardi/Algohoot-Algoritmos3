package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VistaIntroPregunta extends BorderPane {
    Stage stage;
    Juego juego;
    ProgressBar progressBar = new ProgressBar(0);

    private Float seccondsPassed = 0.F;
    private final Float MaxTime =200F;
    private Timeline tiempo;

    public VistaIntroPregunta(Stage stage, Juego juego){
        this.stage = stage;
        this.juego = juego;
        this.setPrefSize(600,600);
        this.setStyle("-fx-background-color: #5133a5");

        Label enunciadoPregunta = new Label(juego.obtenerRondaActual().obtenerPregunta().getEnunciado());
        enunciadoPregunta.setFont(Font.font("Core Mellow", FontWeight.BOLD,80));
        enunciadoPregunta.setTextFill(Color.WHITE);

        Label tipoPregunta = new Label(juego.obtenerRondaActual().obtenerPregunta().getTipo() + ":");
        tipoPregunta.setFont(Font.font("Core Mellow", FontWeight.LIGHT,40));
        tipoPregunta.setTextFill(Color.WHITE);

        Label modoPregunta = new Label(juego.obtenerRondaActual().obtenerPregunta().getModo());
        modoPregunta.setFont(Font.font("Core Mellow", FontWeight.LIGHT,40));
        modoPregunta.setTextFill(Color.WHITE);

        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(tipoPregunta,modoPregunta);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(enunciadoPregunta,hBox);
        vBox.setAlignment(Pos.CENTER);

        progressBar.prefWidthProperty().bind(this.widthProperty());

        inicializarContador();

        this.setCenter(vBox);
        this.setBottom(progressBar);
    }

    private void inicializarContador(){
        tiempo = new Timeline(new KeyFrame(Duration.seconds(0.001), e -> contar()));
        tiempo.setCycleCount(Timeline.INDEFINITE);
        tiempo.play();
    }

    public void contar(){
        if(seccondsPassed < MaxTime){
            seccondsPassed++;
            progressBar.setProgress(seccondsPassed / MaxTime);
        }
        else {
            tiempo.pause();
            VistaPrincipal vistaPrincipal = new VistaPrincipal(stage,juego,juego.obtenerRondaActual().obtenerPregunta());
            stage.setScene(new Scene(vistaPrincipal));
            stage.setFullScreen(true);
        }
    }
}
