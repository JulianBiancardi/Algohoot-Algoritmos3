package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.vista.ConstantesAlgohoot;
import edu.fiuba.algo3.vista.VistaCargaJugadores;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    private Juego juego;

    @Override
    public void start(Stage stagePrincipal) throws Exception{
        juego = new Juego();
        VistaCargaJugadores introVista = new VistaCargaJugadores(stagePrincipal, juego);
        stagePrincipal.setTitle("algohoot!");
        stagePrincipal.getIcons().add(new Image(ConstantesAlgohoot.ICONO_ALGOHOOT));
        stagePrincipal.setScene(new Scene(introVista, ConstantesAlgohoot.MIN_WIDTH, ConstantesAlgohoot.MIN_HEIGHT));
        stagePrincipal.centerOnScreen();
        stagePrincipal.setResizable(false);
        stagePrincipal.show();
    }

    public static void main(String[] args){
        launch();
    }
}