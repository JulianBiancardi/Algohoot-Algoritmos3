package edu.fiuba.algo3.vista.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.VoF;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.vista.ConstantesAlgohoot;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionBinaria;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionData;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;

public class VistaVoF extends VistaPregunta {
    HashMap<Integer, VistaOpcionData> opcionesInfo = new HashMap<Integer, VistaOpcionData>();
    ArrayList<OpcionBinaria> opcionesElegidas = new ArrayList<>();
    Respuesta respuesta;

    public VistaVoF(VoF pregunta, Jugador jugador){
        super(pregunta);
        respuesta = new Respuesta(jugador, pregunta);

        opcionesInfo.put(0, new VistaOpcionData(0, 0, ConstantesAlgohoot.BOTON_AZUL));
        opcionesInfo.put(1, new VistaOpcionData(0, 1, ConstantesAlgohoot.BOTON_ROJO));

        inicializarOpciones(pregunta, opcionesElegidas);
    }

    public void inicializarOpciones(VoF pregunta, ArrayList<OpcionBinaria> opcionesElegidas){
        for (int i = 0; i < pregunta.cantidadOpciones(); i++) {
            VistaOpcionData dataActual = opcionesInfo.get(i);

            Image img = this.obtenerImagenPara2Opciones(dataActual.getImagen().getUrl());

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
