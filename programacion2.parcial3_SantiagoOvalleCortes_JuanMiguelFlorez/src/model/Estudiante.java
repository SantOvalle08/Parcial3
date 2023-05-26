package model;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private TipoGenero genero;
    private String identificación;
    private List<Float> listaNotas= new ArrayList<>();

	public Estudiante(String nombre, TipoGenero genero, String identificación) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.identificación = identificación;

	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoGenero getGenero() {
		return genero;
	}
	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}
	public String getIdentificación() {
		return identificación;
	}
	public void setIdentificación(String identificación) {
		this.identificación = identificación;
	}
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", genero=" + genero + ", identificación=" + identificación + "]";
	}
    
	
	public Estudiante(String nombre, TipoGenero genero, String identificación, List<Float> listaNotas) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.identificación = identificación;
		this.listaNotas = listaNotas;
	}
	
	
	public float promedioNotas(){
		float promedio= 0;
		for (Float notaAux : listaNotas) {
			promedio+=notaAux;
		}
		promedio= promedio/ listaNotas.size();
		return promedio;
	}


}
