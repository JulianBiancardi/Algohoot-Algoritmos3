package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Entidades.Juego;
import edu.fiuba.algo3.vista.ResourcesConstantsAlgohoot;
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
        stagePrincipal.getIcons().add(new Image(ResourcesConstantsAlgohoot.ICONO_ALGOHOOT));
        stagePrincipal.setScene(new Scene(introVista));
        stagePrincipal.setFullScreen(true);
        stagePrincipal.setFullScreenExitHint("");
        stagePrincipal.show();
    }

    public static void main(String[] args){
        launch();
    }
}