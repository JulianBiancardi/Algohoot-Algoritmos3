package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorEnviar;
import edu.fiuba.algo3.controlador.ControladorMultiplicadorDoble;
import edu.fiuba.algo3.controlador.ControladorMultiplicadorTriple;
import edu.fiuba.algo3.controlador.ControladorOpcionGrupal;
import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.*;
import edu.fiuba.algo3.vista.Preguntas.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
    //ArrayList<Opcion> opcionesElegidas = new ArrayList<>();

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
        /*
        Button multiplicadorDoble = new Button("Multiplicador Doble");
        multiplicadorDoble.setOnAction(new ControladorMultiplicadorDoble(juego.turnoDe()));

        Button multiplicadorTriple = new Button("Multiplicador Triple");
        multiplicadorTriple.setOnAction(new ControladorMultiplicadorTriple(juego.turnoDe()));

        HBox hBox = new HBox();
        hBox.getChildren().addAll(stackPane,multiplicadorDoble,multiplicadorTriple);
        hBox.setAlignment(Pos.CENTER);
        */
        this.setCenter(stackPane);
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
            vistaPregunta = new VistaVoF((VoF) pregunta);
        } else if(pregunta instanceof MultipleChoice){
            vistaPregunta = new VistaMultipleChoice((MultipleChoice) pregunta);
        } else if(pregunta instanceof OrderedChoice) {
            vistaPregunta = new VistaOrderedChoice((OrderedChoice) pregunta);
        } else if(pregunta instanceof GroupChoice){
            vistaPregunta = new VistaGroupChoice((GroupChoice) pregunta);
        }
        else return; //Agregar exepcion de pregunta no reconocida
    }
}