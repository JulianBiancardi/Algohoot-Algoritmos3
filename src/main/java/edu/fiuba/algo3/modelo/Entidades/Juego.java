package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.VoF;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaPuntos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Juego {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<Ronda> rondas = new ArrayList<>();
    private SistemaTurnos sistemaTurnos = new SistemaTurnos();

    public Juego (){

        //Creo un par de preguntas para testear el sistema de turnos del juego
        MultipleChoice pregunta = MultipleChoice.conModoPuntajeParcial("Paises de América Latina");
        pregunta.agregarOpcion("Argentina", true);
        pregunta.agregarOpcion("China", false);
        pregunta.agregarOpcion("Egipto", false);
        pregunta.agregarOpcion("Rusia", false);
        agregarRonda(pregunta);

        VoF vof = VoF.conModoClasico("La guitarra tiene 6 cuerdas",true);
        agregarRonda(vof);

        pregunta = MultipleChoice.conModoPuntajeParcial("Cual fue la mejor frase del Pache?");
        pregunta.agregarOpcion("Aplicar Beneficio", true);
        pregunta.agregarOpcion("Correctamente Estricta", true);
        pregunta.agregarOpcion("Messi", true);
        pregunta.agregarOpcion("Exclusividad esta Potente", true);
        pregunta.agregarOpcion("Me voy a tomar algo..",true);
        agregarRonda(pregunta);
    }

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
        sistemaTurnos.agregarJugador(jugador);
    }

    public int cantidadJugadores(){
        return jugadores.size();
    }

    public void agregarRonda(Pregunta pregunta) {
        rondas.add(new Ronda(pregunta));
    }

    public int cantidadRondas(){
        return rondas.size();
    }

    public Ronda obtenerRonda (){
        Ronda ronda = rondas.get(rondas.size() - 1);
        return ronda;
    }

    public void eliminarRonda(){
        rondas.remove(rondas.size() - 1);
    }

    public boolean hayRondasDisponibles(){
        return (rondas.size() != 0);
    }

    public void siguienteTurno(Stage stage){
        sistemaTurnos.siguienteTurno();
        if(sistemaTurnos.terminoRonda())
            siguienteRonda(stage);
        else{
            crearVistaRonda(stage);
        }
    }

    public void crearVistaRonda(Stage stage){
        VistaPrincipal vistaPregunta = new VistaPrincipal(this);
        obtenerRonda().mostrarRonda(stage,vistaPregunta);
        Scene nuevaPregunta = new Scene(vistaPregunta);
        stage.setScene(nuevaPregunta);
    }

    public void siguienteRonda(Stage stage){
        eliminarRonda();
        if(hayRondasDisponibles()){
            crearVistaRonda(stage);
        }
        else{
            Scene scenePuntos = new Scene(new VistaPuntos(jugadores),600,600);
            stage.setScene(scenePuntos);
        }
    }

    public Jugador turnoDe(){
        return sistemaTurnos.obtenerTurno();
    }

    //No contemplo caso empate
    public Jugador obtenerGanador(){
        Jugador jugadorAux = jugadores.get(0);
        for (Jugador jugador : jugadores) {
            if(jugador.puntos() > jugadorAux.puntos())
                jugadorAux = jugador;
        }
        return jugadorAux;
    }

}
