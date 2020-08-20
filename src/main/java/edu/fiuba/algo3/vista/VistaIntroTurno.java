package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
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

    private Float seccondsPassed = 0.F;
    private final Float MaxTime = 2500F;
    private Timeline tiempo;

    public VistaIntroTurno(Stage stage, Juego juego){
        this.stage = stage;
        this.juego = juego;
        this.setPrefSize(600,600);
        this.setStyle("-fx-background-color: #5133a5");

        Label label = new Label("Turno de:  ");
        label.setFont(Font.font("Core Mellow", FontWeight.BOLD,50));
        label.setTextFill(Color.WHITE);

        Label jugadorResponde = new Label(juego.turnoDe().nombre());
        jugadorResponde.setStyle("-fx-background-color: #25076b;"
                                + "-fx-background-radius: 5px");
        jugadorResponde.setFont(Font.font("Core Mellow", FontWeight.BOLD,50));
        jugadorResponde.setTextFill(Color.WHITE);
        jugadorResponde.setPadding(new Insets(5,30,5,30));

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(label,jugadorResponde);

        inicializarContador();
        this.setCenter(hBox);
    }

    private void inicializarContador(){
        tiempo = new Timeline(new KeyFrame(Duration.seconds(0.001), e -> contar()));
        tiempo.setCycleCount(Timeline.INDEFINITE);
        tiempo.play();
    }

    public void contar(){
        if(seccondsPassed < MaxTime)
            seccondsPassed++;
        else {
            tiempo.pause();
            VistaPrincipal vistaPrincipal = new VistaPrincipal(stage,juego,juego.obtenerRondaActual().obtenerPregunta());
            stage.getScene().setRoot(vistaPrincipal);
            stage.setFullScreen(true);
        }
    }
}
