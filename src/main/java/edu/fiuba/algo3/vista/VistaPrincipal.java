package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorEnviar;

import edu.fiuba.algo3.controlador.ControladorExclusividad;
import edu.fiuba.algo3.controlador.ControladorMultiplicadorDoble;
import edu.fiuba.algo3.controlador.ControladorMultiplicadorTriple;
import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.*;
import edu.fiuba.algo3.vista.Preguntas.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class VistaPrincipal extends BorderPane{
    private Juego juego;
    VistaPregunta vistaPregunta;

    private final Integer startTime = 50;
    private Integer secondsPassed = startTime;
    private Timeline tiempo;
    Label contador = new Label(String.valueOf(startTime));

    Button botonEnviar = new Button();
    VBox vBox = new VBox();

    public VistaPrincipal(Stage stage, Juego juego, Pregunta pregunta){
        this.juego = juego;

        crearVistaPregunta(pregunta);
        mostrarEnunciadoPregunta(pregunta);
        mostrarContador();
        inicializarBotonEnviar(stage,juego,tiempo);

        vBox.getChildren().addAll(botonEnviar,vistaPregunta);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
        this.setBottom(vBox);
    }

    public void contar(){
        if(secondsPassed > 0){
            secondsPassed--;
            contador.setText(String.valueOf(secondsPassed));
        }
        else {
            tiempo.pause();
            botonEnviar.fire();
        }
    }


    private void mostrarEnunciadoPregunta(Pregunta pregunta) {

        StackPane stackPane = new StackPane();

        ImageView fondoPregunta = new ImageView("File:src\\resources\\imagenes\\fondoPregunta.png");
        fondoPregunta.fitWidthProperty().bind(this.widthProperty());

        Label enunciadoPregunta = new Label(pregunta.getEnunciado());
        enunciadoPregunta.setFont(Font.font("Core Mellow", FontWeight.BOLD,55));

        stackPane.getChildren().addAll(fondoPregunta,enunciadoPregunta);

        Label jugadorResponde = new Label(juego.turnoDe().nombre());
        jugadorResponde.setAlignment(Pos.CENTER);
        jugadorResponde.setFont(Font.font("Core Mellow", FontWeight.BOLD,30));
        jugadorResponde.setTextFill(Color.WHITE);
        jugadorResponde.setStyle("-fx-background-color: #575757");
        jugadorResponde.setPrefSize(300,50);

        VBox vBox = new VBox(stackPane,jugadorResponde);
        vBox.setAlignment(Pos.CENTER);

        this.setTop(vBox);
    }

    private void mostrarContador(){
        StackPane stackPane = new StackPane();
        Circle circle = new Circle(100,Color.valueOf("#844cbe"));
        contador.setTextFill(Color.WHITE);
        contador.setFont(Font.font("Core Mellow", FontWeight.BOLD,80));
        stackPane.getChildren().addAll(circle,contador);

        tiempo = new Timeline(new KeyFrame(Duration.seconds(1),e -> contar()));
        tiempo.setCycleCount(Timeline.INDEFINITE);
        tiempo.play();

        VBox bonificacions = new VBox();
        bonificacions.setAlignment(Pos.CENTER);

        if(juego.obtenerRondaActual().obtenerPregunta().aceptaMultiplicador()) {
            if(juego.turnoDe().tieneMultiplicadorDoble()) {
                Button multiplicadorDoble = new Button("Usar multiplicador doble");
                multiplicadorDoble.setOnAction(new ControladorMultiplicadorDoble(juego.turnoDe(), vistaPregunta, multiplicadorDoble));
                multiplicadorDoble.setPrefSize(150, 50);
                multiplicadorDoble.setBackground(new Background(new BackgroundFill(Color.valueOf("#D5D5D5"), null, Insets.EMPTY)));

                bonificacions.getChildren().addAll(multiplicadorDoble);
            }
            if(juego.turnoDe().tieneMultiplicadorTriple()) {
                Button multiplicadorTriple = new Button("Usar multiplicador triple");
                multiplicadorTriple.setOnAction(new ControladorMultiplicadorTriple(juego.turnoDe(), vistaPregunta, multiplicadorTriple));
                multiplicadorTriple.setPrefSize(150, 50);
                multiplicadorTriple.setBackground(new Background(new BackgroundFill(Color.valueOf("#D5D5D5"), null, Insets.EMPTY)));
                bonificacions.getChildren().addAll(multiplicadorTriple);
            }
        }
        else if (juego.turnoDe().tieneExclusividad()){
            Button exclusivad = new Button("Usar exclusividad");
            exclusivad.setOnAction(new ControladorExclusividad(juego.turnoDe(), vistaPregunta, exclusivad));
            exclusivad.setPrefSize(150, 50);
            exclusivad.setBackground(new Background(new BackgroundFill(Color.valueOf("#D5D5D5"), null, Insets.EMPTY)));

            bonificacions.getChildren().addAll(exclusivad);
        }

        HBox hBox = new HBox();
        hBox.getChildren().addAll(stackPane,bonificacions);
        hBox.setAlignment(Pos.CENTER);

        this.setCenter(hBox);
    }

    public void inicializarBotonEnviar(Stage stage, Juego juego, Timeline tiempo){
        botonEnviar.setPrefSize(150,80);
        botonEnviar.setStyle("-fx-background-color: #26890c");

        Label label = new Label("Enviar");
        label.setFont(Font.font("Montserrat", FontWeight.BOLD,25));
        label.setTextFill(Color.WHITE);
        botonEnviar.setGraphic(label);

        ControladorEnviar enviarRespuesta = new ControladorEnviar(stage,juego,tiempo,vistaPregunta);
        botonEnviar.setOnAction(enviarRespuesta);
    }

    public void crearVistaPregunta(Pregunta pregunta){
        if(pregunta instanceof VoF){
            vistaPregunta = new VistaVoF((VoF) pregunta,juego.turnoDe());
        } else if(pregunta instanceof MultipleChoice){
            vistaPregunta = new VistaMultipleChoice((MultipleChoice) pregunta,juego.turnoDe());
        } else if(pregunta instanceof OrderedChoice) {
            vistaPregunta = new VistaOrderedChoice((OrderedChoice) pregunta,juego.turnoDe());
        } else if(pregunta instanceof GroupChoice){
            vistaPregunta = new VistaGroupChoice((GroupChoice) pregunta,juego.turnoDe());
        }
        else return; //Agregar exepcion de pregunta no reconocida
    }
}