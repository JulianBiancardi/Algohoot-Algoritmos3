package edu.fiuba.algo3.modelo.Opciones;

import java.util.ArrayList;

public class ListaOpciones {
    ArrayList<Opcion> opciones = new ArrayList<Opcion>();

    public void agregarOpcion(Opcion opcion) { opciones.add(opcion); }

    public Opcion obtener(int posicion) {
        if(posicion < 0 || posicion > cantidadOpciones()) {
            //Excepcion
        }

        return opciones.get(posicion);
    }

    public int cantidadOpciones(){
        return opciones.size();
    }

    public int cantidadOpcionesCorrectas() {
        int contador = 0;
        for (Opcion opcionElegida : opciones) {
            if(opcionElegida.esCorrecta())
                contador++;
        }
        return contador;
    }

    public int cantidadOpcionesIncorrectas() {
        int contador = 0;
        for (Opcion opcionElegida : opciones) {
            if(!(opcionElegida.esCorrecta()))
                contador++;
        }
        return contador;
    }
}
