package pio.daw.data;

import java.io.File;
import java.util.List;

import pio.daw.stats.EstadisticaBasica;
import pio.daw.stats.Graficable;

public class Aula extends AulaABC implements EstadisticaBasica, Graficable {
    
    public static Aula fromFile(File file){
        //TODO
        return null;
    }

    public Aula(List<AlumnoABC> alumnos) {
		super(alumnos);
	}

    public AlumnoABC getAlumno(String nombre){
        //TODO
        return null;
    }

	public AlumnoABC getBestAlumno(){
        //TODO
        return null;
    }

	public AlumnoABC getWorstAlumno(){
        //TODO
        return null;
    }

	public Double getMedia(){
        //TODO
        return null;
    }

	public Double getMax(){
        //TODO
        return null;
    }

	public Double getMin(){
        //TODO
        return null;
    }

	public Double getVar(){
        //TODO
        return null;
    }

    public void printBarPlot(){
        //TODO
    }

}

