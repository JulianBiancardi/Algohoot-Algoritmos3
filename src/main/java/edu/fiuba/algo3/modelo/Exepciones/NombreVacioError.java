package edu.fiuba.algo3.modelo.Exepciones;



public class NombreVacioError extends RuntimeException{

    public NombreVacioError(){

    }

    public NombreVacioError(String mensajeError){
        super(mensajeError);
    }
}
