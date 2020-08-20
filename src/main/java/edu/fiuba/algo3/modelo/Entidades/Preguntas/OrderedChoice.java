package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Excepciones.PreguntaSuperaMaxOpcionesError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    private final ArrayList<OpcionOrdenada> opcionesPregunta = new ArrayList<>();
    static final String nombre = "Ordered Choice";

    public OrderedChoice(String unEnunciado) {
        super(unEnunciado, new Clasico());
    }

    private void agregarOpcion(OpcionOrdenada opcion){
        opcionesPregunta.add(opcion);
    }

    public void nuevaOpcion(String descripcion){
        if(cantidadOpciones() == 5)
            throw new PreguntaSuperaMaxOpcionesError();
        agregarOpcion(new OpcionOrdenada(descripcion, cantidadOpciones()));
    }

    public OpcionOrdenada obtenerOpcion(int posicion){
        return opcionesPregunta.get(posicion);
    }

    @Override
    public int cantidadOpciones() {
        return opcionesPregunta.size();
    }

    @Override
    public int calcularCantidadOpcionesCorrectas(){ return opcionesPregunta.size(); }

    @Override
    public String tipo(){
        return nombre;
    }

    //JSON
    public static OrderedChoice recuperar(JsonObject jsonObjectMC) {

        String enunciadoPregunta = jsonObjectMC.get("Enunciado").getAsString();
        OrderedChoice pregunta = new OrderedChoice(enunciadoPregunta);

        JsonArray arrayOpciones = jsonObjectMC.getAsJsonArray("Opciones");
        for (JsonElement jsonOpcion : arrayOpciones) {
            OpcionOrdenada opcion = OpcionOrdenada.recuperar(jsonOpcion.getAsJsonObject(), pregunta.cantidadOpciones());
            pregunta.agregarOpcion(opcion);
        }

        return pregunta;
    }

    public static OrderedChoice recuperar(String archivo) throws IOException {
        String texto = Files.readString(Path.of(archivo));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return recuperar(jsonObject);
    }
}

