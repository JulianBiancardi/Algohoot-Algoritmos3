package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionOrdenada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ControladorReset implements EventHandler<ActionEvent>{

    private ArrayList<OpcionOrdenada> opcionesElegidas;
    private ArrayList<VistaOpcionOrdenada> vistaOpcionOrdenadas;

    public ControladorReset(ArrayList<OpcionOrdenada> opcionesElegidas, ArrayList<VistaOpcionOrdenada> vistaOpcionOrdenadas){
        this.opcionesElegidas = opcionesElegidas;
        this.vistaOpcionOrdenadas = vistaOpcionOrdenadas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        opcionesElegidas.clear();
        //opcionesElegidas.forEach(opcion -> respuesta.agregarOpcion(opcion));
        vistaOpcionOrdenadas.forEach(vistaOpcionOrdenada -> vistaOpcionOrdenada.resetLabel());
    }
}
