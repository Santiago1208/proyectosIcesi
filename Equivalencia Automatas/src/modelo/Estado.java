package modelo;

import java.util.HashSet;
import java.util.Iterator;


public class Estado {

	// Atributos
	// ======================================================================================
	
	private HashSet<Transicion> transiciones;
	
	private String nombre;
	
	private boolean visitado;
	
	private int hashCode;

	// Constructor
	// ======================================================================================
	
	/**
	 * Construye un estado con el nombre pasado por parámetro. Por defecto no tiene
	 * transiciones.
	 * @param nombre Es el nombre que tendrá el estado.
	 */
	public Estado(String nombre, int hashCode) {
		this.nombre = nombre.toUpperCase().trim();
		visitado = false;
		transiciones = new HashSet<>(10);
		this.hashCode = hashCode; 
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
	
	

	public void agregarTransiciones(String input, String oput, Estado estadoDestino, int hashCode) {
		try {
			Transicion nueva = new Transicion(input, oput, estadoDestino, hashCode);
			transiciones.add(nueva);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	
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

	public boolean isVisitado() {
		return visitado;
	}
	@Override
	public String toString() {
		String estado = "";
		estado = nombre;
		Iterator<Transicion> iterator = transiciones.iterator();
		while (iterator.hasNext()) {
			Transicion transicionActual = iterator.next();
			estado += transicionActual.toString() + " ";
		}
		return estado;
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}

}