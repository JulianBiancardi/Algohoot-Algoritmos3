package edu.fiuba.algo3.vista.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.vista.ConstantesAlgohoot;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionBinaria;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionData;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;

public class VistaMultipleChoice extends VistaPregunta {
    HashMap<Integer, VistaOpcionData> opcionesInfo = new HashMap<Integer, VistaOpcionData>();
    ArrayList<OpcionBinaria> opcionesElegidas = new ArrayList<>();

    Respuesta respuesta;

    public VistaMultipleChoice(MultipleChoice pregunta, Jugador jugador){
        super(pregunta);

        respuesta = new Respuesta(jugador, pregunta);

        opcionesInfo.put(0, new VistaOpcionData(0, 0, ConstantesAlgohoot.BOTON_ROJO));
        opcionesInfo.put(1, new VistaOpcionData(0, 1, ConstantesAlgohoot.BOTON_AZUL));
        opcionesInfo.put(2, new VistaOpcionData(1, 0, ConstantesAlgohoot.BOTON_AMARILLO));
        opcionesInfo.put(3, new VistaOpcionData(1, 1, ConstantesAlgohoot.BOTON_VERDE));
        opcionesInfo.put(4, new VistaOpcionData(2, 0, ConstantesAlgohoot.BOTON_VIOLETA));

        inicializarOpciones(pregunta, opcionesElegidas);
    }

    private void inicializarOpciones(MultipleChoice pregunta, ArrayList<OpcionBinaria> opcionesElegidas){
        for (int i = 0; (i < pregunta.cantidadOpciones()); i++) {
            VistaOpcionData dataActual = opcionesInfo.get(i);
            Image img = this.obtenerImagenPara2Opciones(dataActual.getImagen().getUrl());

            if(pregunta.cantidadOpciones() > 2 && pregunta.cantidadOpciones() < 5)
                img = this.obtenerImagenPara3o4Opciones(dataActual.getImagen().getUrl());
            else if(pregunta.cantidadOpciones() > 4)
                img = this.obtenerImagenPara5o6Opciones(dataActual.getImagen().getUrl());

            VistaOpcionBinaria vistaActual = new VistaOpcionBinaria(pregunta.obtenerOpcion(i), img, opcionesElegidas);
            this.add(vistaActual, dataActual.getColumna(), dataActual.getFila());
        }
    }

    public Respuesta getRespuesta(){
        return respuesta;
    }

    @Override
    public Respuesta completarRespuesta(){
        opcionesElegidas.forEach(respuesta::agregarOpcion);
        return respuesta;
    }
}
