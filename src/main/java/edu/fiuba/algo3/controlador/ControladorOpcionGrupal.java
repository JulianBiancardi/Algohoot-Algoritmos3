package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionGrupal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class ControladorOpcionGrupal implements EventHandler<ActionEvent> {

    private ArrayList<OpcionGrupal> opcionesGrupoA;
    private ArrayList<OpcionGrupal> opcionesGrupoB;

    private OpcionGrupal opcionGrupal;

    private Label grupoActual;

    public ControladorOpcionGrupal(ArrayList<OpcionGrupal> opcionesGrupoA, ArrayList<OpcionGrupal> opcionesGrupoB, OpcionGrupal opcionAsociada, Label grupoActual){
        this.opcionesGrupoA = opcionesGrupoA;
        this.opcionesGrupoB = opcionesGrupoB;
        this.opcionGrupal = opcionAsociada;
        this.grupoActual = grupoActual;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        if(grupoActual.getText().equals("") || grupoActual.getText().equals("B")){
            grupoActual.setText("A");
            opcionesGrupoB.remove(opcionGrupal);
            opcionesGrupoA.add(opcionGrupal);
        } else{
            grupoActual.setText("B");
            opcionesGrupoA.remove(opcionGrupal);
            opcionesGrupoB.add(opcionGrupal);
        }
    }
}
