package edu.fiuba.algo3.modelo.Entidades;

import edu.fiuba.algo3.modelo.Entidades.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Excepciones.MultiplicadorYaUtilizadoError;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observador;

import java.util.ArrayList;

public class Jugador implements Observable {
    private final String nombre;
    private int puntajeJugador = 0;
    private final Multiplicador multiplicadorDoble = Multiplicador.crearMultiplicadorDoble();
    private final Multiplicador multiplicadorTriple = Multiplicador.crearMultiplicadorTriple();
    private final ArrayList<Multiplicador> multiplicadoresRestantes = new ArrayList<>();
    ArrayList<Observador> observadores = new ArrayList<>();
    private int exclusividadesRestantes = 2;

    public Jugador(String nombre){
        this.nombre = nombre;
        multiplicadoresRestantes.add(multiplicadorDoble);
        multiplicadoresRestantes.add(multiplicadorTriple);
    }

    public void modificarPuntos(int puntaje){
        puntajeJugador = puntajeJugador + puntaje;
        notificarObservadores();
    }

    public void activarMultiplicadorDoble(Respuesta respuesta){
        activarMultiplicador(respuesta, multiplicadorDoble);
    }

    public void activarMultiplicadorTriple(Respuesta respuesta){
        activarMultiplicador(respuesta, multiplicadorTriple);
    }

    private void activarMultiplicador(Respuesta respuesta, Multiplicador multiplicador){
        if(!multiplicadoresRestantes.contains(multiplicador)){
            throw new MultiplicadorYaUtilizadoError();
        }
        respuesta.activarMultiplicador(multiplicador);
        multiplicadoresRestantes.remove(multiplicador);
    }

    public void activarExclusividad(Respuesta respuesta){
        if(exclusividadesRestantes > 0){
            exclusividadesRestantes--;
            respuesta.activarExclusividad();
        }
    }

    public String nombre(){
        return nombre;
    }

    public int puntos(){
        return puntajeJugador;
    }

    // Observable para la app

    @Override
    public void agregarObservador(Observador unObservador){
        observadores.add(unObservador);
    }

    @Override
    public void notificarObservadores(){
        observadores.stream().forEach(observador -> observador.actualizar());
    }
}