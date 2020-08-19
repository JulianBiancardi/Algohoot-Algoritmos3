package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.vista.Opciones.VistaEnunciado;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
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
    private final Float MaxTime = 1000F;
    private Timeline tiempo;

    public VistaIntroPregunta(Stage stage, Juego juego){
        this.stage = stage;
        this.juego = juego;
        this.setPrefSize(ConstantesAlgohoot.MIN_WIDTH, ConstantesAlgohoot.MIN_HEIGHT);
        this.setStyle("-fx-background-color: #5133a5");

        String enunciado = juego.obtenerRondaActual().obtenerPregunta().getEnunciado();

        Label enunciadoPregunta = new Label(enunciado);
        enunciadoPregunta.setFont(Font.font("Core Mellow", FontWeight.BOLD, 35));
        enunciadoPregunta.setTextFill(Color.WHITE);

        if(enunciado.length() >= ConstantesAlgohoot.MAX_CARACTERES_ENUNCIADO_SUPERA_PANTALLA){
            enunciado = VistaEnunciado.obtenerStringResponsive(enunciado);
            enunciadoPregunta.setText(enunciado);
            enunciadoPregunta.setFont(Font.font("Core Mellow", FontWeight.BOLD, 25));
        }
        enunciadoPregunta.setAlignment(Pos.CENTER);
        progressBar.prefWidthProperty().bind(this.widthProperty());

        inicializarContador();

        this.setCenter(enunciadoPregunta);
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
        } else {
            tiempo.pause();
            VistaPrincipal vistaPrincipal = new VistaPrincipal(stage, juego, juego.obtenerRondaActual().obtenerPregunta());
            stage.setScene(new Scene(vistaPrincipal, ConstantesAlgohoot.MIN_WIDTH, ConstantesAlgohoot.MIN_HEIGHT));
            stage.centerOnScreen();
            stage.setResizable(false);
        }
    }
}
