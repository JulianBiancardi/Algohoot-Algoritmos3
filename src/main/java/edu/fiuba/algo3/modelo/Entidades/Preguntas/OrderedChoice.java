package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionBinaria;
import edu.fiuba.algo3.modelo.Excepciones.ChoiceTieneMaxCincoOpcionesError;

import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Excepciones.OrderedTieneMaxCincoOpcionesError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    private final ArrayList<OpcionOrdenada> opcionesPregunta = new ArrayList<>();

    public OrderedChoice(String unEnunciado) {
        super(unEnunciado, new Clasico());
    }

    private void agregarOpcion(OpcionOrdenada opcion){
        opcionesPregunta.add(opcion);
    }

    public void nuevaOpcion(String descripcion){
        if(cantidadOpciones() == 5)
            throw new OrderedTieneMaxCincoOpcionesError();
        agregarOpcion(new OpcionOrdenada(descripcion, cantidadOpciones()));
    }

    public int calcularCantidadOpcionesCorrectas(){ return opcionesPregunta.size(); }

    public OpcionOrdenada obtenerOpcion(int posicion){
        return (OpcionOrdenada) opcionesPregunta.get(posicion);
    }

    public int cantidadOpciones() {
        return opcionesPregunta.size();
    }

    //JSON
    public static OrderedChoice recuperar(JsonObject jsonObjectMC) {

        String enunciadoPregunta = jsonObjectMC.get("Enunciado").getAsString();
        OrderedChoice pregunta = new OrderedChoice(enunciadoPregunta);

        JsonArray arrayOpciones = jsonObjectMC.getAsJsonArray("Opciones");
        for (JsonElement jsonOpcion : arrayOpciones) {
            OpcionOrdenada opcion = OpcionOrdenada.recuperar(jsonOpcion.getAsJsonObject());
            pregunta.agregarOpcion(opcion);
        }

        return pregunta;
    }

    public static OrderedChoice recuperar(String archivo) throws IOException {
        String texto = Files.readString(Path.of(archivo));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return recuperar(jsonObject);
    }

    public void crearVista(Stage stage, VistaPrincipal vistaPrincipal){
        //vistaPrincipal.crearVistaMultipleChoice(stage,this);
    }
}

