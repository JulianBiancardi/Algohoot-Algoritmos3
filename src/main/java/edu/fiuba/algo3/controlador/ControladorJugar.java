package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Exepciones.NombreVacioError;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.VoF;
import edu.fiuba.algo3.vista.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorJugar implements EventHandler<ActionEvent> {
    Stage stage;
    TextField nombreJugador;

    public ControladorJugar(Stage stagePrincipal, TextField nombreJugador) {
        this.stage = stagePrincipal;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) throws NombreVacioError {

        try{
            if(nombreJugador.getText().trim().isEmpty() || nombreJugador.getText().trim() == null)
                throw new NombreVacioError("El nombre no es correcto");

            VistaPrincipal vistaPregunta = new VistaPrincipal();
            //VoF pregunta = VoF.conModoClasico("2 + 2 =4?",true);


            MultipleChoice pregunta = MultipleChoice.conModoClasico("Paises de Latino America");
            pregunta.agregarOpcion("Argentina",true);
            pregunta.agregarOpcion("Roma",false);
            pregunta.agregarOpcion("Roma",false);
            pregunta.agregarOpcion("Roma",false);

            //pregunta.agregarOpcion("Ninguna es correcta",false);


            vistaPregunta.crearVistaMultipleChoice(stage,pregunta);
            Scene scenePregunta = new Scene(vistaPregunta);
            stage.setScene(scenePregunta);

        }catch (NombreVacioError error){

        }
    }
}
