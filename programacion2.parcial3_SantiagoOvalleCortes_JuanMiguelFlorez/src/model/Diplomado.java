package model;

import java.util.ArrayList;
import java.util.List;

import Exceptions.EstudianteException;


public class Diplomado {
    private String nombre;
    private int cupo;
    private List<Estudiante> listaEstudiantes= new ArrayList<>();


    public Diplomado(String nombre, int cupo) {
		super();
		this.nombre = nombre;
		this.cupo = cupo;
	}
    public Diplomado(){
    }


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public List<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	@Override
	public String toString() {
		return "Diplomado [nombre=" + nombre + ", cupo=" + cupo + ", listaEstudiantes=" + listaEstudiantes + "]";
	} 
    
    
    /**
	 *  Metodo que sirve para verificar si un estudiante ya esta registrado en 
     * el diplomado en base a su identificacion
	 * @param identificacion
	 * @return
	 */

    public boolean verificarEstudiante(String identificacion){
        boolean verificado= false;
    
            for (Estudiante estudianteAux : listaEstudiantes) {
                if(estudianteAux.getIdentificación().equals(identificacion)){
                    verificado= true;
                }
            }
        return verificado;
    }
    	/**
	 * Obtiene un estudiante en base a su identificacion, si no existe retorna null
	 * @param identificacion
	 * @return
	 */
    public Estudiante obtenerEstudiante(String identificacion){
        Estudiante estudianteObtenido= null;
        for (Estudiante estudianteAux : listaEstudiantes) {
            if(estudianteAux.getIdentificación().equals(identificacion)){
                estudianteObtenido= estudianteAux;
            }
        }
        return estudianteObtenido;
    }

    	/**
	 * Este metodo primero verfica si no existe ningun estudiante con la misma identificacion,
     * si ya esta registrado lanza la excepcion, si no lo añade a la lista
	 * @param nuevoEstudiante
	 * @return
	 */
    public boolean agregarEstudiante(Estudiante nuevoEstudiante) throws EstudianteException{
        boolean agregado= false;
        if (verificarEstudiante(nuevoEstudiante.getIdentificación())) {
            throw new EstudianteException("El estudiante ya se encuentra registrado");
        }else{
            agregado= true;
            listaEstudiantes.add(nuevoEstudiante);
        }
        
        return agregado;
    }
    /**
	 * Este metodo primero obtiene el estudiante en base a identificacion
     * Si el estudiante existe llama al metodo de promedio de la clase estudiante
	 * @param identificacion
	 * @return
	 */
    public float promedioEstudiante(String identificacion) throws EstudianteException{
        float promedio= 0;
        Estudiante estudianteObtenido= obtenerEstudiante(identificacion);
        if(estudianteObtenido==null){
            throw new EstudianteException(" El estudiante con la identificación " + identificacion+ " no existe");
        }else{
            promedio= estudianteObtenido.promedioNotas();
        }
        return promedio;
    }
    /**
    *Este metodo recorre la lista de estudiantes y obtiene el promedio de cada uno y lo va 
    *sumando a la variable de promedio
    */
    public float promedioTotalEstudiantes(){
        float promedio=0;
        for (Estudiante estudianteAux : listaEstudiantes) {
            promedio+= estudianteAux.promedioNotas();
        }
        promedio= promedio/listaEstudiantes.size();
        return promedio;
    }
    /**
    * Este metodo primero recorre la lista de estudiantes y en el estudiante en cuestion de ese momento, 
    * le calcula el promedio, el cual se compara con el que de momento es mayor, si este promedio parcial
    * es mayor, este tomara el valor de promedio mayor
    * Y lo mismo con el nombre;
    *
    */
    public String estudianteConMayorPromedio(){
        String nombreMayor= "";
        String nombreParcial="";
        float promedioMayor= 0;
        float promedioParcial=0;

        for (Estudiante estudianteAux: listaEstudiantes ){
            promedioParcial= estudianteAux.promedioNotas();
            nombreParcial = estudianteAux.getNombre();
            
            if(promedioParcial > promedioMayor){
                promedioMayor= promedioParcial;
                nombreMayor= nombreParcial;
            }
        }
        return nombreMayor;

    }




}
