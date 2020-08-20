package edu.fiuba.algo3.modelo.Entidades.Preguntas;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Entidades.Opciones.OpcionGrupal;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.ModosPreguntas.Clasico;
import edu.fiuba.algo3.modelo.Excepciones.PreguntaSuperaMaxOpcionesError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class GroupChoice extends Pregunta{
    private final ArrayList<OpcionGrupal> opcionesPregunta = new ArrayList<>();
    private final String nombreGrupo1;
    private final String nombreGrupo2;
    static final String nombre = "Group Choice";

    public GroupChoice(String enunciado, String nombreGrupo1, String nombreGrupo2){
        super(enunciado, new Clasico());
        this.nombreGrupo1 = nombreGrupo1;
        this.nombreGrupo2 = nombreGrupo2;
    }

    public String nombreGrupo1(){
        return nombreGrupo1;
    }

    public String nombreGrupo2(){
        return nombreGrupo2;
    }

    private void agregarOpcionAGrupo(OpcionGrupal opcion){
        if(cantidadOpciones() == 6)
            throw new PreguntaSuperaMaxOpcionesError();
        opcionesPregunta.add(opcion);
    }

    public int calcularCantidadOpcionesCorrectas(){
        return cantidadOpciones();
    }

    public void nuevaOpcionGrupo1(String descripcion){
        agregarOpcionAGrupo(new OpcionGrupal(descripcion, nombreGrupo1));
    }

    public void nuevaOpcionGrupo2(String descripcion){
        agregarOpcionAGrupo(new OpcionGrupal(descripcion, nombreGrupo2));
    }

    public OpcionGrupal obtenerOpcion(int posicion){
        return opcionesPregunta.get(posicion);
    }

    public int cantidadOpciones(){
        return opcionesPregunta.size();
    }

    @Override
    public String tipo(){
        return nombre;
    }

    //JSON
    public static GroupChoice recuperar(JsonObject jsonObjectMC) {

        String enunciadoPregunta = jsonObjectMC.get("Enunciado").getAsString();
        String nombreGrupo1 = jsonObjectMC.get("Grupo 1").getAsString();
        String nombreGrupo2 = jsonObjectMC.get("Grupo 2").getAsString();
        GroupChoice pregunta = new GroupChoice(enunciadoPregunta, nombreGrupo1, nombreGrupo2);

        JsonArray arrayOpciones = jsonObjectMC.getAsJsonArray("Opciones Grupo 1");
        for (JsonElement jsonOpcion : arrayOpciones) {
            OpcionGrupal opcion = OpcionGrupal.recuperar(jsonOpcion.getAsJsonObject(), nombreGrupo1);
            pregunta.agregarOpcionAGrupo(opcion);
        }

        arrayOpciones = jsonObjectMC.getAsJsonArray("Opciones Grupo 2");
        for (JsonElement jsonOpcion : arrayOpciones) {
            OpcionGrupal opcion = OpcionGrupal.recuperar(jsonOpcion.getAsJsonObject(), nombreGrupo2);
            pregunta.agregarOpcionAGrupo(opcion);
        }

        return pregunta;
    }

    public static GroupChoice recuperar(String archivo) throws IOException {
        String texto = Files.readString(Path.of(archivo));

        JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();

        return recuperar(jsonObject);
    }
}
