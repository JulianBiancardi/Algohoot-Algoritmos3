package edu.fiuba.algo3.vista.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionBinaria;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionData;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class VistaMultipleChoice extends VistaPregunta {
    HashMap<Integer, VistaOpcionData> opcionesInfo = new HashMap<Integer,VistaOpcionData>();
    ArrayList<OpcionBinaria> opcionesElegidas = new ArrayList<>();

    public VistaMultipleChoice(MultipleChoice pregunta){
        super(pregunta);

        opcionesInfo.put(0,new VistaOpcionData(0,0, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonAzul.png"));
        opcionesInfo.put(1,new VistaOpcionData(0,1, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonRojo.png"));
        opcionesInfo.put(2,new VistaOpcionData(1,0, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonAmarillo.png"));
        opcionesInfo.put(3,new VistaOpcionData(1,1, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonVerde.png"));
        opcionesInfo.put(4,new VistaOpcionData(2,0, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonVioleta.png"));


        inicializarOpciones(pregunta,opcionesElegidas);
    }

    private void inicializarOpciones(MultipleChoice pregunta, ArrayList<OpcionBinaria> opcionesElegidas){
        if (pregunta.cantidadOpciones() > opcionesInfo.size()) // lanzar exepcion, cantidad de opciones incorrectas
            return;

        for(int i = 0; (i < pregunta.cantidadOpciones()); i++){
            VistaOpcionData dataActual = opcionesInfo.get(i);
            VistaOpcionBinaria vistaActual = new VistaOpcionBinaria(pregunta.obtenerOpcion(i),dataActual.getImagen(),opcionesElegidas);

            this.add(vistaActual,dataActual.getColumna(),dataActual.getFila());
            vistaActual.prefWidthProperty().bind(this.widthProperty());
            vistaActual.prefHeightProperty().bind(this.heightProperty());
        }
    }

    @Override
    public Respuesta obtenerRespuesta(Jugador jugador) {
        Respuesta respuesta = new Respuesta(jugador,preguntaAsociada);
        opcionesElegidas.forEach(respuesta::agregarOpcion);
        return respuesta;
    }
}
