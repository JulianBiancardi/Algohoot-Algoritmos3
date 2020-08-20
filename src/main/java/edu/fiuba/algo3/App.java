package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.vista.VistaCargaJugadores;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;


public class App extends Application {
    private Juego juego;

    @Override
    public void start(Stage stagePrincipal) throws Exception{
        juego = new Juego();
        stagePrincipal.setTitle("algohoot!");
        stagePrincipal.getIcons().add(new Image("File:src\\resources\\imagenes\\IMG_algohoot_icono.png"));
        VistaCargaJugadores introVista = new VistaCargaJugadores(stagePrincipal, juego);
        stagePrincipal.setScene(new Scene(introVista));
        stagePrincipal.setFullScreen(true);
        stagePrincipal.setFullScreenExitHint("");
        stagePrincipal.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }
}