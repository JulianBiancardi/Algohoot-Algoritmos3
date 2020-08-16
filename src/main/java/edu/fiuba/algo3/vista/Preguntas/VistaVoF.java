package edu.fiuba.algo3.vista.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.VoF;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionBinaria;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionData;
import edu.fiuba.algo3.vista.Preguntas.VistaPregunta;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;


public class VistaVoF extends VistaPregunta {
    HashMap<Integer, VistaOpcionData> opcionesInfo = new HashMap<Integer,VistaOpcionData>();
    ArrayList<Opcion> opcionesElegidas = new ArrayList<>();
    //Respuesta respuesta = new Respuesta();

    public VistaVoF(VoF pregunta){
        super(pregunta);

        opcionesInfo.put(0,new VistaOpcionData(0,0, Color.valueOf("#e21b3c")));
        opcionesInfo.put(1,new VistaOpcionData(0,1, Color.valueOf("#1368ce")));

        inicializarOpciones(pregunta,opcionesElegidas);
    }

    public void inicializarOpciones(VoF pregunta, ArrayList<Opcion> opcionesElegidas){
        for(int i = 0; i < pregunta.cantidadOpciones(); i++){
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
