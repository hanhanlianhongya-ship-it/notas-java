package pio.daw.data;

import java.util.List;

abstract class AulaABC {
	List<AlumnoABC> alumnos;

	public AulaABC(List<AlumnoABC> alumnos) {
		this.alumnos = alumnos;
	}

	public List<AlumnoABC> getAlumnos() {
		return this.alumnos;
	}

	public abstract AlumnoABC getAlumno(String nombre);

	public abstract AlumnoABC getBestAlumno();

	public abstract AlumnoABC getWorstAlumno();

}
