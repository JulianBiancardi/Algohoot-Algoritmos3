package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
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

public class VistaIntroTurno extends BorderPane {
    Stage stage;
    Juego juego;
    ProgressBar progressBar = new ProgressBar(0);

    private Float seccondsPassed = 0.F;
    private final Float MaxTime = 2000F;
    private Timeline tiempo;

    public VistaIntroTurno(Stage stage, Juego juego){
        this.stage = stage;
        this.juego = juego;
        this.setPrefSize(600,600);
        this.setStyle("-fx-background-color: #5133a5");

        Label jugador = new Label("Turno de:  " + juego.turnoDe().nombre());
        jugador.setFont(Font.font("Core Mellow", FontWeight.BOLD,80));
        jugador.setTextFill(Color.WHITE);

        progressBar.prefWidthProperty().bind(this.widthProperty());

        inicializarContador();

        this.setCenter(jugador);
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
            stage.getScene().setRoot(vistaPrincipal);
            stage.setFullScreen(true);
        }
    }
}
