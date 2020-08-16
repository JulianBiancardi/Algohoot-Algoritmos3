package edu.fiuba.algo3.vista.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionBinaria;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionData;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class VistaMultipleChoice extends VistaPregunta {
    HashMap<Integer, VistaOpcionData> opcionesInfo = new HashMap<Integer,VistaOpcionData>();
    ArrayList<Opcion> opcionesElegidas = new ArrayList<>();

    public VistaMultipleChoice(MultipleChoice pregunta){
        super(pregunta);

        opcionesInfo.put(0,new VistaOpcionData(0,0, Color.valueOf("#e21b3c")));
        opcionesInfo.put(1,new VistaOpcionData(0,1, Color.valueOf("#1368ce")));
        opcionesInfo.put(2,new VistaOpcionData(1,0, Color.valueOf("#d89e00")));
        opcionesInfo.put(3,new VistaOpcionData(1,1, Color.valueOf("#26890c")));
        opcionesInfo.put(4,new VistaOpcionData(2,0, Color.valueOf("#864cbf")));

        inicializarOpciones(pregunta,opcionesElegidas);
    }

    private void inicializarOpciones(MultipleChoice pregunta, ArrayList<Opcion> opcionesElegidas){
        if (pregunta.cantidadOpciones() > opcionesInfo.size()) // lanzar exepcion, cantidad de opciones incorrectas
            return;

        for(int i = 0; (i < pregunta.cantidadOpciones()); i++){
            Opcion opcionActual = pregunta.obtenerOpcion(i);
            VistaOpcionData dataActual = opcionesInfo.get(i);
            VistaOpcionBinaria vistaActual = new VistaOpcionBinaria(opcionActual,dataActual.getColor(),opcionesElegidas);

            this.add(vistaActual,dataActual.getColumna(),dataActual.getFila());
            vistaActual.prefWidthProperty().bind(this.widthProperty());
            vistaActual.prefHeightProperty().bind(this.heightProperty());
        }
    }

    @Override
    public Respuesta obtenerRespuesta(Jugador jugador) {
        Respuesta respuesta = new Respuesta(jugador,preguntaAsociada);
        opcionesElegidas.forEach(opcion -> respuesta.agregarOpcion(opcion));
        return respuesta;
    }
}
