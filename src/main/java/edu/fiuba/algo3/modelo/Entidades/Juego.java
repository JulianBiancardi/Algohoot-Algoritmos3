package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.OrderedChoice;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Entidades.Preguntas.VoF;
import edu.fiuba.algo3.vista.VistaPrincipal;
import edu.fiuba.algo3.vista.VistaPuntos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

public class Juego {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<Ronda> rondas = new ArrayList<>();
    private SistemaTurnos sistemaTurnos = new SistemaTurnos();
    //private Iterator<Ronda> iteradorRonda;
    private int iteradorRonda;

    public Juego (){

        //Creo un par de preguntas para testear el sistema de turnos del juego
        MultipleChoice pregunta = MultipleChoice.conModoPenalidad("Paises de América Latina");
        pregunta.nuevaOpcion("Argentina", true);
        pregunta.nuevaOpcion("China", false);
        pregunta.nuevaOpcion("Egipto", false);
        pregunta.nuevaOpcion("Rusia", false);
        agregarRonda(pregunta);

        VoF vof = VoF.conModoPenalidad("La guitarra tiene 6 cuerdas",true);
        agregarRonda(vof);

        /*
        OrderedChoice orderedChoice = new OrderedChoice("Ordenar de menor a mayor");
        orderedChoice.nuevaOpcion("1");
        orderedChoice.nuevaOpcion("2");
        orderedChoice.nuevaOpcion("3");
        orderedChoice.nuevaOpcion("4");
        agregarRonda(orderedChoice);*/

        iteradorRonda = 0 ;

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
        //iteradorRonda = rondas.iterator();
    }

    public int cantidadRondas(){
        return rondas.size();
    }

    public void siguienteRonda(){

        //rondaActual = iteradorRonda.next();
        iteradorRonda++;
    }

    public boolean hayRondaSiguiente(){
        return (iteradorRonda != rondas.size()-1);
    }

    public boolean terminoRonda(){
        return (sistemaTurnos.terminoRonda());
    }

    public void siguienteTurno(){
        sistemaTurnos.siguienteTurno();
    }

    public Jugador turnoDe(){
        return sistemaTurnos.obtenerTurno();
    }

    public Ronda obtenerRondaActual() {
        return rondas.get(iteradorRonda);
    }

    public void evaluarRespuestas() {
        obtenerRondaActual().evaluarPregunta();
    }

    public ArrayList<Jugador> obtenerJugadores() {
        return jugadores;
    }
}
