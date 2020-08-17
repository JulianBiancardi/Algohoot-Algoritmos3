package edu.fiuba.algo3.vista.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.VoF;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionBinaria;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionData;
import edu.fiuba.algo3.vista.Preguntas.VistaPregunta;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;


public class VistaVoF extends VistaPregunta {
    HashMap<Integer, VistaOpcionData> opcionesInfo = new HashMap<Integer,VistaOpcionData>();
    ArrayList<OpcionBinaria> opcionesElegidas = new ArrayList<>();
    Respuesta respuesta;

    public VistaVoF(VoF pregunta,Jugador jugador){
        super(pregunta);

        respuesta = new Respuesta(jugador,pregunta);

        opcionesInfo.put(0,new VistaOpcionData(0,0, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonAzul.png"));
        opcionesInfo.put(1,new VistaOpcionData(0,1, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonRojo.png"));

        inicializarOpciones(pregunta,opcionesElegidas);
    }

    public void inicializarOpciones(VoF pregunta, ArrayList<OpcionBinaria> opcionesElegidas){
        for(int i = 0; i < pregunta.cantidadOpciones(); i++){
            VistaOpcionData dataActual = opcionesInfo.get(i);
            VistaOpcionBinaria vistaActual = new VistaOpcionBinaria(pregunta.obtenerOpcion(i), dataActual.getImagen(),opcionesElegidas);

            this.add(vistaActual,dataActual.getColumna(),dataActual.getFila());
            vistaActual.prefWidthProperty().bind(this.widthProperty());
            vistaActual.prefHeightProperty().bind(this.heightProperty());
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
