package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorEnviar;
import edu.fiuba.algo3.controlador.ControladorExclusividad;
import edu.fiuba.algo3.controlador.ControladorMultiplicadorDoble;
import edu.fiuba.algo3.controlador.ControladorMultiplicadorTriple;
import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.*;
import edu.fiuba.algo3.vista.Opciones.VistaEnunciado;
import edu.fiuba.algo3.vista.Preguntas.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VistaPrincipal extends StackPane {
    private final Juego juego;

    private final Integer startTime = 50;
    private Integer secondsPassed = startTime;
    private Timeline tiempo;
    private final Label contadorLabel = new Label(String.valueOf(startTime));

    private VistaPregunta vistaPregunta;
    private VBox enunciadoYTurnoJugador;
    private final StackPane contadorStackPane = new StackPane();
    private final Button botonEnviar = new Button();
    private final HBox bonificaciones = new HBox();

    public VistaPrincipal(Stage stage, Juego juego, Pregunta pregunta){
        this.juego = juego;

        actualizarOpcionesSegunPregunta(pregunta);
        actualizarEnunciadoYTurnoJugador(pregunta);
        actualizarContador();
        actualizarBeneficios();
        actualizarBotonEnviar(stage, juego, tiempo);

        VBox menuSuperior = new VBox(10, enunciadoYTurnoJugador, contadorStackPane);
        menuSuperior.setPadding(new Insets(5, 0, 0, 0));
        menuSuperior.setAlignment(Pos.TOP_CENTER);

        VBox menuInferior = new VBox(bonificaciones, botonEnviar, vistaPregunta);
        menuInferior.setAlignment(Pos.BOTTOM_CENTER);

        this.getChildren().addAll(menuSuperior, menuInferior);
        this.setAlignment(Pos.CENTER);
    }

    public void contar(){
        if(secondsPassed > 0){
            secondsPassed--;
            contadorLabel.setText(String.valueOf(secondsPassed));
        } else {
            tiempo.pause();
            botonEnviar.fire();
        }
    }

    private void actualizarBeneficios(){
        String estiloBoton = "-fx-background-radius: 5px;"
                             + "-fx-background-color: #D5D5D5;"
                             + "-fx-font-size: 12;"
                             + "-fx-padding: 5px;";

        if(juego.obtenerRondaActual().obtenerPregunta().aceptaMultiplicador()){
            if(juego.turnoDe().tieneMultiplicadorDoble()){
                Button multiplicadorDoble = new Button("Activar Multiplicador Doble");
                multiplicadorDoble.setStyle(estiloBoton);
                multiplicadorDoble.setOnAction(new ControladorMultiplicadorDoble(juego.turnoDe(), vistaPregunta, multiplicadorDoble));
                bonificaciones.getChildren().addAll(multiplicadorDoble);
                if(juego.turnoDe().tieneMultiplicadorTriple()){
                    Button multiplicadorTriple = new Button("Activar Multiplicador Triple");
                    multiplicadorTriple.setStyle(estiloBoton);
                    multiplicadorTriple.setOnAction(new ControladorMultiplicadorTriple(juego.turnoDe(), vistaPregunta, multiplicadorTriple));
                    bonificaciones.getChildren().addAll(multiplicadorTriple);
                }
            }
        } else if(juego.turnoDe().cantidadExclusividadRestante() != 0){
            Button exclusivad = new Button("Activar Exclusividad (x" + juego.turnoDe().cantidadExclusividadRestante() + ")");
            exclusivad.setOnAction(new ControladorExclusividad(juego.turnoDe(), vistaPregunta, exclusivad));
            exclusivad.setStyle(estiloBoton);
            bonificaciones.getChildren().addAll(exclusivad);
        }

        bonificaciones.setAlignment(Pos.CENTER);
        bonificaciones.setPadding(new Insets(0, 0, 10, 0));
        bonificaciones.setSpacing(10);
    }

    private void actualizarEnunciadoYTurnoJugador(Pregunta pregunta){
        String enunciado = pregunta.getEnunciado();
        Button enunciadoPregunta = new Button(enunciado);
        enunciadoPregunta.getStylesheets().add(ConstantesAlgohoot.HOJA_BOTONES_GENERALES);
        enunciadoPregunta.getStyleClass().add("enunciadoPregunta");
        enunciadoPregunta.setMouseTransparent(true);

        if(enunciado.length() >= ConstantesAlgohoot.MAX_CARACTERES_ENUNCIADO_SUPERA_PANTALLA){
            enunciado = VistaEnunciado.obtenerStringResponsive(enunciado);
            enunciadoPregunta.setText(enunciado);
            enunciadoPregunta.getStyleClass().add("enunciadoPreguntaResponsive");
        }

        Label turnoJugador = new Label(juego.turnoDe().nombre());
        turnoJugador.setAlignment(Pos.CENTER);
        turnoJugador.setFont(Font.font("Core Mellow", FontWeight.BOLD, 30));
        turnoJugador.setTextFill(Color.WHITE);
        turnoJugador.setStyle("-fx-background-color: #575757");
        turnoJugador.setPrefSize(300, 50);

        VBox vBox = new VBox(5, enunciadoPregunta, turnoJugador);
        vBox.setAlignment(Pos.CENTER);

        this.enunciadoYTurnoJugador = vBox;
    }

    private void actualizarContador(){
        Circle circle = new Circle(40, Color.valueOf("#844cbe"));
        contadorLabel.setTextFill(Color.WHITE);
        contadorLabel.setFont(Font.font("Core Mellow", FontWeight.BOLD, 40));
        contadorStackPane.getChildren().addAll(circle, contadorLabel);

        tiempo = new Timeline(new KeyFrame(Duration.seconds(1), e -> contar()));
        tiempo.setCycleCount(Timeline.INDEFINITE);
        tiempo.play();

        contadorStackPane.setAlignment(Pos.CENTER);
    }

    public void actualizarBotonEnviar(Stage stage, Juego juego, Timeline tiempo){
        botonEnviar.setPrefSize(100, 50);
        botonEnviar.setStyle("-fx-background-color: #26890c");

        Label label = new Label("Enviar");
        label.setFont(Font.font("Montserrat", FontWeight.BOLD, 25));
        label.setTextFill(Color.WHITE);
        botonEnviar.setGraphic(label);

        ControladorEnviar enviarRespuesta = new ControladorEnviar(stage, juego, tiempo, vistaPregunta);
        botonEnviar.setOnAction(enviarRespuesta);
    }

    public void actualizarOpcionesSegunPregunta(Pregunta pregunta){
        if(pregunta instanceof VoF)
            vistaPregunta = new VistaVoF((VoF) pregunta, juego.turnoDe());
        else if(pregunta instanceof MultipleChoice)
            vistaPregunta = new VistaMultipleChoice((MultipleChoice) pregunta, juego.turnoDe());
        else if(pregunta instanceof OrderedChoice)
            vistaPregunta = new VistaOrderedChoice((OrderedChoice) pregunta, juego.turnoDe());
        else if(pregunta instanceof GroupChoice)
            vistaPregunta = new VistaGroupChoice((GroupChoice) pregunta, juego.turnoDe());
    }
}