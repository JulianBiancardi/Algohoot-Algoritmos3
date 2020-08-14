package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorJugar;
import edu.fiuba.algo3.controlador.ControladorSalir;
import edu.fiuba.algo3.modelo.Entidades.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class VistaCargaJugadores extends StackPane{

    private Juego juego;

    public VistaCargaJugadores(Stage stagePrincipal, Juego juego){
        this.juego = juego;

        this.setPrefSize(600, 600);

        ImageView logoView = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\KahootLogo.png");
        logoView.setFitHeight(100);
        logoView.setFitWidth(200);

        TextField NombreJugador = new TextField();
        NombreJugador.setPromptText("Nombre Jugador 1");
        NombreJugador.setFocusTraversable(false);
        NombreJugador.setAlignment(Pos.CENTER);

        TextField NombreJugador2 = new TextField();
        NombreJugador2.setPromptText("Nombre Jugador 2");
        NombreJugador2.setFocusTraversable(false);
        NombreJugador2.setAlignment(Pos.CENTER);

        Button botonEntrar = new Button("Entrar");
        botonEntrar.setOnAction(new ControladorJugar(stagePrincipal,NombreJugador,NombreJugador2,juego));

        Button botonSalir = new Button("Salir");
        botonSalir.setOnAction(new ControladorSalir());

        VBox opcionesMenu = new VBox(5,logoView,NombreJugador,NombreJugador2,botonEntrar,botonSalir);
        opcionesMenu.setMaxSize(200,200);
        opcionesMenu.setAlignment(Pos.CENTER);
        botonEntrar.prefWidthProperty().bind(opcionesMenu.widthProperty());
        botonSalir.prefWidthProperty().bind(opcionesMenu.widthProperty());

        Image fondoImagen = new Image("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\BackGround.png");
        this.setBackground(new Background(new BackgroundImage(
                fondoImagen,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,true,true)
        )));

        this.getChildren().addAll(opcionesMenu);
    }

    public void mostarErrorNombre(){
        System.out.println("error de nombre");
    }
}
