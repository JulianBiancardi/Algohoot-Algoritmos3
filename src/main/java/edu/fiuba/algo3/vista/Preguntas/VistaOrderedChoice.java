package edu.fiuba.algo3.vista.Preguntas;

import edu.fiuba.algo3.controlador.ControladorReset;
import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.RespuestaOrdenada;
import edu.fiuba.algo3.vista.ConstantesAlgohoot;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionData;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionOrdenada;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.HashMap;

public class VistaOrderedChoice extends VistaPregunta {

    private HashMap<Integer, VistaOpcionData> opcionesInfo = new HashMap<Integer, VistaOpcionData>();
    private ArrayList<OpcionOrdenada> opcionesElegidas = new ArrayList<>();
    private ArrayList<VistaOpcionOrdenada> vistasOpcionesOrdenadas = new ArrayList<>();

    RespuestaOrdenada respuesta;

    public VistaOrderedChoice(OrderedChoice pregunta, Jugador jugador){
        super(pregunta);

        respuesta = new RespuestaOrdenada(jugador, pregunta);

        opcionesInfo.put(0, new VistaOpcionData(1, 0, ConstantesAlgohoot.BOTON_AZUL));
        opcionesInfo.put(1, new VistaOpcionData(1, 1, ConstantesAlgohoot.BOTON_ROJO));
        opcionesInfo.put(2, new VistaOpcionData(2, 0, ConstantesAlgohoot.BOTON_AMARILLO));
        opcionesInfo.put(3, new VistaOpcionData(2, 1, ConstantesAlgohoot.BOTON_VERDE));
        opcionesInfo.put(4, new VistaOpcionData(3, 0, ConstantesAlgohoot.BOTON_VIOLETA));

        inicializarBotonReset();

        inicializarOpciones(pregunta, opcionesElegidas);
    }


    private void inicializarBotonReset(){
        Button botonReset = new Button("Reiniciar selección");
        botonReset.getStylesheets().add(ConstantesAlgohoot.HOJA_BOTONES_GENERALES);
        botonReset.getStyleClass().add("botonResetOrderedChoise");
        botonReset.setOnAction(new ControladorReset(opcionesElegidas, vistasOpcionesOrdenadas));

        HBox seccionA = new HBox(botonReset);
        seccionA.setAlignment(Pos.CENTER_RIGHT);
        seccionA.setPadding(new Insets(7, -34, 0, 10));
        if(preguntaAsociada.cantidadOpciones() == 2)
            this.add(seccionA, 0, 2);
        else if(preguntaAsociada.cantidadOpciones() == 3 || preguntaAsociada.cantidadOpciones() == 4)
            this.add(seccionA, 0, 3);
        else
            this.add(seccionA, 0, 4);

    }

    private void inicializarOpciones(OrderedChoice pregunta, ArrayList<OpcionOrdenada> opcionesElegidas){
        for (int i = 0; i < pregunta.cantidadOpciones(); i++) {
            Opcion opcionActual = pregunta.obtenerOpcion(i);
            VistaOpcionData dataActual = opcionesInfo.get(i);

            Image img = this.obtenerImagenPara2Opciones(dataActual.getImagen().getUrl());

            if(pregunta.cantidadOpciones() > 2 && pregunta.cantidadOpciones() < 5)
                img = this.obtenerImagenPara3o4Opciones(dataActual.getImagen().getUrl());
            else if(pregunta.cantidadOpciones() > 4)
                img = this.obtenerImagenPara5o6Opciones(dataActual.getImagen().getUrl());

            VistaOpcionOrdenada vistaActual = new VistaOpcionOrdenada((OpcionOrdenada) opcionActual, img, opcionesElegidas, pregunta.cantidadOpciones());
            vistasOpcionesOrdenadas.add(vistaActual);
            this.add(vistaActual, dataActual.getColumna(), dataActual.getFila());
        }
    }

    public Respuesta getRespuesta(){
        return respuesta;
    }

    @Override
    public Respuesta completarRespuesta(){
        opcionesElegidas.forEach(opcion -> respuesta.agregarOpcion(opcion));
        return respuesta;
    }
}
