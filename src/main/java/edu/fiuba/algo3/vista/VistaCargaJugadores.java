package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorAcercaDe;
import edu.fiuba.algo3.controlador.ControladorJugar;
import edu.fiuba.algo3.controlador.ControladorSalir;
import edu.fiuba.algo3.modelo.Entidades.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;

public class VistaCargaJugadores extends StackPane {

    public VistaCargaJugadores(Stage stagePrincipal, Juego juego){
        this.getStylesheets().add(ConstantesAlgohoot.HOJA_CARGA_JUGADORES);
        this.getStyleClass().add("fondoLogin");

        ImageView logoView = new ImageView(ConstantesAlgohoot.LOGO_ALGOHOOT);
        logoView.setFitHeight(100);
        logoView.setFitWidth(350);
        this.getChildren().addAll(logoView);

        Media sound = new Media(ConstantesAlgohoot.URL_SOUND_START);
        MediaPlayer soundPlayer = new MediaPlayer(sound);
        soundPlayer.setOnEndOfMedia(new Runnable() {
            public void run(){
                soundPlayer.seek(Duration.ZERO);
            }
        });
        soundPlayer.play();

        // Menú superior: ingreso nombre jugadores, notificación y botones (entrar y salir)
        Label notificacionMensaje = new Label();
        notificacionMensaje.getStyleClass().add("notificacionMensaje");

        TextField NombreJugador = new TextField();
        NombreJugador.setPromptText("Nombre jugador 1");
        NombreJugador.getStyleClass().add("ingresoNombreJugadores");

        TextField NombreJugador2 = new TextField();
        NombreJugador2.setPromptText("Nombre jugador 2");
        NombreJugador2.getStyleClass().add("ingresoNombreJugadores");

        Button botonEntrar = new Button("Comenzar");
        botonEntrar.getStyleClass().addAll("botonesLogin");
        botonEntrar.setOnAction(event -> {
            soundPlayer.stop();
            new ControladorJugar(stagePrincipal, List.of(NombreJugador, NombreJugador2), juego, notificacionMensaje).handle(event);
        });

        Button botonSalir = new Button("Salir");

        botonSalir.getStyleClass().add("botonesLogin");
        botonSalir.setOnAction(new ControladorSalir());

        VBox opcionesMenu = new VBox(5, NombreJugador, NombreJugador2, botonEntrar, botonSalir);
        opcionesMenu.setMaxSize(200, 200);
        opcionesMenu.setAlignment(Pos.CENTER);

        // Menú inferior: Botones de reglas y acerca de
        Button botonReglas = new Button("Reglas");
        botonReglas.getStyleClass().add("botonesInferiores");

        Button botonAcercaDe = new Button("Acerca de");
        botonAcercaDe.getStyleClass().add("botonesInferiores");
        botonAcercaDe.setOnAction(new ControladorAcercaDe());

        Label barritaSeparadora = new Label("|");
        barritaSeparadora.getStyleClass().add("barritaSeparadora");

        // Union de menús
        HBox menuInferior = new HBox(1, botonReglas, barritaSeparadora, botonAcercaDe);
        menuInferior.setAlignment(Pos.TOP_CENTER);

        VBox menuSuperior = new VBox(25, logoView, opcionesMenu);
        menuSuperior.setMaxSize(200, 200);
        menuSuperior.setAlignment(Pos.CENTER);

        VBox menuSuperiorConInferior = new VBox(10, menuSuperior, menuInferior, notificacionMensaje);
        menuSuperiorConInferior.setMaxSize(200, 200);
        menuSuperiorConInferior.setAlignment(Pos.CENTER);

        this.getChildren().addAll(menuSuperiorConInferior);
    }
}
