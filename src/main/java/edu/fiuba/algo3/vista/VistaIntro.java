package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VistaIntro {

    StackPane layoutPrincipal = new StackPane();
    Scene sceneIntro = new Scene(layoutPrincipal);

    public VistaIntro(){
        ImageView fondoView = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\BackGround.png");
        ImageView logoView = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\KahootLogo.png");
        logoView.setFitHeight(100);
        logoView.setFitWidth(200);

        TextField NombreJugador = new TextField();
        NombreJugador.setPromptText("Nombre");
        NombreJugador.setFocusTraversable(false);
        NombreJugador.setAlignment(Pos.CENTER);

        Button botonEntrar = new Button("Entrar");
        botonEntrar.setMaxWidth(Double.MAX_VALUE);

        Button botonSalir = new Button("Salir");
        botonSalir.setMaxWidth(Double.MAX_VALUE);

        VBox opcionesMenu = new VBox(5,logoView,NombreJugador,botonEntrar,botonSalir);
        opcionesMenu.setMaxSize(20,20);
        opcionesMenu.setAlignment(Pos.TOP_CENTER);

        layoutPrincipal.getChildren().add(fondoView);
        layoutPrincipal.getChildren().add(opcionesMenu);
        layoutPrincipal.setAlignment(opcionesMenu,Pos.CENTER);

    }

    public Scene getScene(){
        return sceneIntro;
    }
}
