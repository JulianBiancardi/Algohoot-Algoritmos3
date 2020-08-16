package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.vista.VistaCargaJugadores;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {
    private Juego juego;

    @Override
    public void start(Stage stagePrincipal) throws Exception{
        juego = new Juego();

        stagePrincipal.setTitle("AlgoHoot");

        VistaCargaJugadores introVista = new VistaCargaJugadores(stagePrincipal, juego);
        stagePrincipal.setScene(new Scene(introVista));
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }
}