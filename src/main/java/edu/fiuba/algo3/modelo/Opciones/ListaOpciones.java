package edu.fiuba.algo3.modelo.Opciones;

import java.util.ArrayList;

public class ListaOpciones {
    ArrayList<Opcion> opciones = new ArrayList<Opcion>();
    private int cantidadIncorrectas;
    private int cantidadCorrectas;

    public ListaOpciones() {
        cantidadCorrectas = 0;
        cantidadIncorrectas = 0;
    }

    public void agregarOpcion(Opcion opcion) {
        opciones.add(opcion);
        if(opcion.esCorrecta())
            cantidadCorrectas++;
        else
            cantidadIncorrectas++;
    }

    public Opcion obtener(int posicion) {
        /*EXCEPCION if (posicion < 0 || posicion > opciones.size())*/
        return opciones.get(posicion);
    }

    public int cantidadOpcionesCorrectas() {
        return cantidadCorrectas;
    }

    public int cantidadOpcionesIncorrectas() {
        return cantidadIncorrectas;
    }

    public int obtenerCantidadOpciones() {
        return opciones.size();
    }
}