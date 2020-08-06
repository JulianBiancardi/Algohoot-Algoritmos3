package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.VistaIntro;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application{

    @Override
    public void start(Stage stagePrincipal) throws Exception{
        stagePrincipal.setTitle("AlgoHoot");

        VistaIntro introVista = new VistaIntro(stagePrincipal);

        stagePrincipal.setScene(new Scene(introVista));
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }
}