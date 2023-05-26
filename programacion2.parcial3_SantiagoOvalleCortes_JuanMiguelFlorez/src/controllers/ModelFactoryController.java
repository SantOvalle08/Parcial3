package controllers;

import java.util.List;

import Exceptions.EstudianteException;
import model.Diplomado;
import model.Estudiante;
import model.TipoGenero;

public class ModelFactoryController {
	
	Diplomado diplomado = null; 
	
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquí al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// Metodo para obtener la instancia de la clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		System.out.println("invocación clase singleton");
		inicializarDatos();
	}
	
	
	
	public boolean crearEstudiante(String nombre, String identificacion, TipoGenero genero, List<Float> listaNotas) throws EstudianteException {
		Estudiante estudiante = new Estudiante (nombre, genero, identificacion, listaNotas);
		return diplomado.agregarEstudiante(estudiante);
	}
	
	
	public float promedioEstudiante(String identificacion) throws EstudianteException {
		return diplomado.promedioEstudiante(identificacion);
	}
	
	
	
	
	private void inicializarDatos() {
		
		diplomado = new Diplomado();
		
	}
	
}
