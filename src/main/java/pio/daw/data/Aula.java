package pio.daw.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import pio.daw.stats.Estadistica;
import pio.daw.stats.EstadisticaBasica;
import pio.daw.stats.Graficable;


public class Aula extends AulaABC implements EstadisticaBasica, Graficable {
    
    /**
     * Lee un archivo csv con los alumnos y sus notas y devuelve un objeto de tipo
     * Aula ya creado.
     * @param path Ruta al archivo csv
     * @return Aula con los alumnos y sus notas.
     */
    public static Aula fromFile(Path path){
        List<AlumnoABC> alumnos = new ArrayList<>();
        try{ 
            //// Otra Manera
            // String line = null;
            // while( (line = reader.readLine()) != null){
            //     alumnos.add(Alumno.fromLine(line));
            // }
            for(String line : Files.readAllLines(path)){
                alumnos.add(Alumno.fromLine(line));
            }
        } catch (IOException e) {
            System.err.printf("ERROR: Cannot read file: %f\n", path);
            System.exit(1);
        }
        return new Aula(alumnos);
    }

    private Aula(List<AlumnoABC> alumnos) {
		super(alumnos);
	}

    public AlumnoABC getAlumno(String nombre){
        for(AlumnoABC a : this.getAlumnos()){
            if(a.getNombre().equals(nombre)){
                return a;
            }
        }
        return null;
    }

	public AlumnoABC getBestAlumno(){
        AlumnoABC mejorAlumno = null;
        Double bestMedia = 0.;
        for(AlumnoABC a : this.getAlumnos()){
            Double media = Estadistica.media(a.getNotas());
            if (media > bestMedia){
                mejorAlumno = a;
                bestMedia = media;
            }
        }
        return mejorAlumno;
    }

	public AlumnoABC getWorstAlumno(){
        AlumnoABC worstAlumno = null;
        Double worstMedia = 10.;
        for(AlumnoABC a : this.getAlumnos()){
            Double media = Estadistica.media(a.getNotas());
            if (media < worstMedia){
                worstAlumno = a;
                worstMedia = media;
            }
        }
        return worstAlumno;
    }

    private List<Double> getAllNotes(){
        List<Double> notas = new ArrayList<>();
        for(AlumnoABC a : this.getAlumnos()){
            notas.addAll(a.getNotas());
        }
        return notas;
    }

	public Double getMedia(){
        return Estadistica.media(this.getAllNotes());
    }

	public Double getMax(){
        return Estadistica.max(this.getAllNotes());
    }

	public Double getMin(){
        return Estadistica.min(this.getAllNotes());
    }

	public Double getVar(){
        return Estadistica.var(this.getAllNotes());
    }

    public void printAulaStats(){
        AlumnoABC bestAlumno = this.getBestAlumno();
        AlumnoABC wostAlumno = this.getWorstAlumno();
        System.out.printf("%-18s -> %s: %.2f\n", "Mejor Alumno", bestAlumno.getNombre(), Estadistica.media(bestAlumno.getNotas()));
        System.out.printf("%-18s -> %s: %.2f\n", "Peor Alumno" ,wostAlumno.getNombre(), Estadistica.media(wostAlumno.getNotas()));
        System.out.printf("%-18s -> %.2f\n", "Media de la clase", this.getMedia());
        System.out.printf("%-18s -> %.2f\n", "Máximo de la clase", this.getMedia());
        System.out.printf("%-18s -> %.2f\n", "Media de la clase", this.getMedia());
        System.out.printf("%-18s -> %.2f\n", "Media de la clase", this.getMedia());
    }

    public void printBarPlot(){
        //TODO
    }

}

