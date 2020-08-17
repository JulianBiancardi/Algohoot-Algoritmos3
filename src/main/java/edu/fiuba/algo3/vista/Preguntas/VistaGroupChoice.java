package edu.fiuba.algo3.vista.Preguntas;

import edu.fiuba.algo3.modelo.Entidades.Jugador;
import edu.fiuba.algo3.modelo.Entidades.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Entidades.Respuestas.RespuestaGrupal;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionData;
import edu.fiuba.algo3.vista.Opciones.VistaOpcionGrupal;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.HashMap;

public class VistaGroupChoice extends VistaPregunta{
    private HashMap<Integer, VistaOpcionData> opcionesInfo = new HashMap<Integer,VistaOpcionData>();
    private ArrayList<OpcionGrupal> opcionesGrupoA = new ArrayList<>();
    private ArrayList<OpcionGrupal> opcionesGrupoB = new ArrayList<>();

    RespuestaGrupal respuesta;

    public VistaGroupChoice(GroupChoice pregunta, Jugador jugador){
        super(pregunta);

        respuesta = new RespuestaGrupal(jugador,pregunta);

        opcionesInfo.put(0,new VistaOpcionData(1,0, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonAzul.png"));
        opcionesInfo.put(1,new VistaOpcionData(1,1, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonRojo.png"));
        opcionesInfo.put(2,new VistaOpcionData(2,0, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonAmarillo.png"));
        opcionesInfo.put(3,new VistaOpcionData(2,1, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonVerde.png"));
        opcionesInfo.put(4,new VistaOpcionData(3,0, "File:src\\resources\\imagenes\\IMG_Botones\\IMG_BotonVioleta.png"));

        mostrarGrupos(pregunta);
        inicializarOpciones(pregunta);
    }

    private void mostrarGrupos(GroupChoice pregunta){
        Label Grupo1 = new Label("A: " + pregunta.nombreGrupo1());
        Grupo1.setAlignment(Pos.CENTER);
        Grupo1.setFont(Font.font("Core Mellow", FontWeight.BOLD,30));
        Grupo1.setTextFill(Color.WHITE);
        Grupo1.setStyle("-fx-background-color: #575757");
        Grupo1.setPrefSize(300,50);

        Label Grupo2 = new Label("B: " + pregunta.nombreGrupo2());
        Grupo2.setAlignment(Pos.CENTER);
        Grupo2.setFont(Font.font("Core Mellow", FontWeight.BOLD,30));
        Grupo2.setTextFill(Color.WHITE);
        Grupo2.setStyle("-fx-background-color: #575757");
        Grupo2.setPrefSize(300,50);

        this.addRow(0,Grupo1,Grupo2);
    }

    private void inicializarOpciones(GroupChoice pregunta){
        if (pregunta.cantidadOpciones() > opcionesInfo.size()) // lanzar exepcion, cantidad de opciones incorrectas
            return;

        for(int i = 0; (i < pregunta.cantidadOpciones() ); i++){
            VistaOpcionData dataActual = opcionesInfo.get(i);
            VistaOpcionGrupal vistaActual = new VistaOpcionGrupal(pregunta.obtenerOpcion(i),dataActual.getImagen(),opcionesGrupoA,opcionesGrupoB);

            this.add(vistaActual,dataActual.getColumna(),dataActual.getFila());
            vistaActual.prefWidthProperty().bind(this.widthProperty());
            vistaActual.prefHeightProperty().bind(this.heightProperty());
        }
    }

    public Respuesta getRespuesta(){
        return respuesta;
    }

    @Override
    public Respuesta completarRespuesta() {
        opcionesGrupoA.forEach(opcionGrupal -> respuesta.agregarOpcionGrupo1(opcionGrupal));
        opcionesGrupoB.forEach(opcionGrupal -> respuesta.agregarOpcionGrupo2(opcionGrupal));

        return respuesta;
    }
}
