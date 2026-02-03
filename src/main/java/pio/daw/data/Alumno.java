package pio.daw.data;

import java.util.List;

public class Alumno extends AlumnoABC {

    //TODO
	public static Alumno fromLine(String line){

        return new Alumno(null, null);
    }

    public Alumno(String nombre, List<Double> notas){
        super(nombre, notas);
    }
    
}
