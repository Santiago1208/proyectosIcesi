package modelo;

import java.util.HashSet;
import java.util.Iterator;

public class Estado {
 
	// Atributos
	// ======================================================================================
	
	private HashSet<Transicion> transiciones;
	
	private String nombre;
	
	private boolean visitado;

	// Constructor
	// ======================================================================================
	
	/**
	 * Construye un estado con el nombre pasado por parámetro. Por defecto no tiene
	 * transiciones.
	 * @param nombre Es el nombre que tendrá el estado.
	 */
	public Estado(String nombre) {
		this.nombre = nombre.toUpperCase().trim();
		visitado = false;
		transiciones = new HashSet<>(10);
	}
	
	// Servicios
	// ======================================================================================

	public String darNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nuevoNombre
	 */
	public void modificarNombre(String nuevoNombre) {
		nombre = nuevoNombre;
	}

	public boolean fueVisitado() {
		return visitado;
	}
	
	

	public void agregarTransiciones(String input, String oput, Estado estadoDestino) {
		
		try {
			Transicion nueva = new Transicion(input, oput, estadoDestino);
			transiciones.add(nueva);
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
	}
	
	
	
	

	/**
	 * 
	 * @param visitado
	 */
	public void modificarVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	
	public HashSet<Transicion> darTransicion(){
		return transiciones;
	}
	
	@Override
	public boolean equals(Object obj) {
		Estado otroEstado = (Estado) obj;
		boolean equals = false;
		if (nombre.equals(otroEstado.nombre)) {
			equals = true;
		}
		return equals;
	}

}