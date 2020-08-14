package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class VistaIntro extends BorderPane {

    VBox vBoxPrincipal = new VBox();

    public VistaIntro(){
        Image fondoImagen = new Image("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\BackGround.png");
        this.setBackground(new Background(new BackgroundImage(
                fondoImagen,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,true,true)
                )));

        ImageView logoImagen = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\KahootLogo.png");
        logoImagen.setFitWidth(220);
        logoImagen.setFitHeight(120);

        HBox hBoxJugadores = new HBox();
        ImageView jugadoresImagen = new ImageView("File:src\\main\\java\\edu\\fiuba\\algo3\\vista\\imagenes\\IMG_Jugadores.png");
        jugadoresImagen.setFitHeight(90);
        jugadoresImagen.setFitWidth(160);

        Button botonCantidadJugadores = new Button(" + 1");

        hBoxJugadores.setAlignment(Pos.CENTER);
        hBoxJugadores.getChildren().addAll(jugadoresImagen,botonCantidadJugadores);

        vBoxPrincipal.setAlignment(Pos.TOP_CENTER);
        vBoxPrincipal.setSpacing(10);
        vBoxPrincipal.getChildren().addAll(logoImagen,hBoxJugadores);

        this.setCenter(vBoxPrincipal);
    }
}
