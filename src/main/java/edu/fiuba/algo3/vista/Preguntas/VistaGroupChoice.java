package edu.fiuba.algo3.vista.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.RespuestaGrupal;
import edu.fiuba.algo3.vista.ConstantesAlgohoot;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionData;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionGrupal;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.HashMap;

public class VistaGroupChoice extends VistaPregunta {
    private HashMap<Integer, VistaOpcionData> opcionesInfo = new HashMap<Integer, VistaOpcionData>();
    private ArrayList<OpcionGrupal> opcionesGrupoA = new ArrayList<>();
    private ArrayList<OpcionGrupal> opcionesGrupoB = new ArrayList<>();

    RespuestaGrupal respuesta;

    public VistaGroupChoice(GroupChoice pregunta, Jugador jugador){
        super(pregunta);

        respuesta = new RespuestaGrupal(jugador, pregunta);

        opcionesInfo.put(0, new VistaOpcionData(1, 0, ConstantesAlgohoot.BOTON_AZUL));
        opcionesInfo.put(1, new VistaOpcionData(1, 1, ConstantesAlgohoot.BOTON_ROJO));
        opcionesInfo.put(2, new VistaOpcionData(2, 0, ConstantesAlgohoot.BOTON_AMARILLO));
        opcionesInfo.put(3, new VistaOpcionData(2, 1, ConstantesAlgohoot.BOTON_VERDE));
        opcionesInfo.put(4, new VistaOpcionData(3, 0, ConstantesAlgohoot.BOTON_VIOLETA));
        opcionesInfo.put(5, new VistaOpcionData(3, 1, ConstantesAlgohoot.BOTON_BLANCO));

        mostrarGrupos(pregunta);
        inicializarOpciones(pregunta);
    }

    private void mostrarGrupos(GroupChoice pregunta){
        Label grupoA = new Label(
                "Grupo A: " + pregunta.nombreGrupo1());
        grupoA.getStylesheets().add(ConstantesAlgohoot.HOJA_BOTONES_GENERALES);
        grupoA.getStyleClass().add("botonInformacionGroupChoise");

        Label grupoB = new Label(
                "Grupo B: " + pregunta.nombreGrupo2());
        grupoB.getStylesheets().add(ConstantesAlgohoot.HOJA_BOTONES_GENERALES);
        grupoB.getStyleClass().add("botonInformacionGroupChoise");

        HBox seccionA = new HBox(grupoA);
        HBox seccionB = new HBox(grupoB);
        seccionA.setAlignment(Pos.CENTER);
        seccionB.setAlignment(Pos.CENTER);
        if(pregunta.cantidadOpciones() == 2){
            this.add(seccionA, 0, 2);
            this.add(seccionB, 1, 2);
        } else if(pregunta.cantidadOpciones() == 3 || pregunta.cantidadOpciones() == 4){
            this.add(seccionA, 0, 3);
            this.add(seccionB, 1, 3);
        } else {
            this.add(seccionA, 0, 4);
            this.add(seccionB, 1, 4);
        }
    }


    private void inicializarOpciones(GroupChoice pregunta){
        for (int i = 0; (i < pregunta.cantidadOpciones()); i++) {
            VistaOpcionData dataActual = opcionesInfo.get(i);
            Image img = this.obtenerImagenPara2Opciones(dataActual.getImagen().getUrl());

            if(pregunta.cantidadOpciones() > 2 && pregunta.cantidadOpciones() < 5)
                img = this.obtenerImagenPara3o4Opciones(dataActual.getImagen().getUrl());
            else if(pregunta.cantidadOpciones() > 4)
                img = this.obtenerImagenPara5o6Opciones(dataActual.getImagen().getUrl());

            VistaOpcionGrupal vistaActual = new VistaOpcionGrupal(pregunta.obtenerOpcion(i), img, opcionesGrupoA, opcionesGrupoB);
            this.add(vistaActual, dataActual.getColumna(), dataActual.getFila());
        }
    }

    public Respuesta getRespuesta(){
        return respuesta;
    }

    @Override
    public Respuesta completarRespuesta(){
        opcionesGrupoA.forEach(opcionGrupal -> respuesta.agregarOpcionGrupo1(opcionGrupal));
        opcionesGrupoB.forEach(opcionGrupal -> respuesta.agregarOpcionGrupo2(opcionGrupal));

        return respuesta;
    }
}
