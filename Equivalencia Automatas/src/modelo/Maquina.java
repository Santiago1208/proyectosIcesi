package modelo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

public class Maquina {

	// Constantes
	// ======================================================================================

	public final static String TIPO_MEALY = "Mealy";

	public final static String TIPO_MOORE = "Moore";

	// Atributos
	// ======================================================================================

	private HashSet<Estado> estados;

	private String tipoMaquina;

	private Estado estadoInicial;

	// Constructor
	// ======================================================================================

	/**
	 * Construye una máquina del tipo especificado.
	 * 
	 * @param tipoMaq
	 *            Es el tipo de máquina que se va a crear. Puede ser
	 *            Maquina.TIPO_MEALY o Maquina.TIPO_MOORE
	 */
	public Maquina(String tipoMaq) {
		tipoMaquina = tipoMaq;
		estados = new HashSet<>();
		estadoInicial = null;
	}

	// Servicios
	// ======================================================================================

	public String darTipoMaquina() {
		return tipoMaquina;
	}

	public Estado darEstadoInicial() {
		return estadoInicial;
	}

	public HashSet<Estado> darEstados() {
		return estados;
	}

	public void eliminarInalcanzables() {
		// TODO - implement Maquina.eliminarInalcanzables
		// throw new UnsupportedOperationException();
		String aux = estadoInicial.darNombre();
		Queue<Estado> cola = new ArrayDeque<>();
		cola.add(estadoInicial);
		while (!cola.isEmpty()) {
			Estado act = cola.poll();
			Iterator<Transicion> iterador = act.darTransicion().iterator();
			while (iterador.hasNext()) {
				Transicion nueva = iterador.next();
				cola.add(nueva.darEstadoLlegada());
				aux += nueva.darEstadoLlegada().darNombre();
			}
		}

		System.out.println(aux);

		Iterator<Estado> iteradorP = estados.iterator();
		while (iteradorP.hasNext()) {
			Estado nueva = iteradorP.next();
			System.out.println(nueva.darNombre());
			boolean loEncontro = false;
			for (int i = 0; i < aux.length() && !loEncontro; i++) {
			
				if( !nueva.darNombre().equals(aux.charAt(i)+"")){
					loEncontro =true;
					estados.remove(nueva);
				}
				
			}
			
		}

	}

	public void agregarEstado(String estado) throws Exception {
		try {
			Estado nuevoEstado = new Estado(estado);
			estados.add(nuevoEstado);
			if (estados.size() == 1) {
				estadoInicial = nuevoEstado;
			}
		} catch (Exception e) {
			throw new Exception("No se pudo agregar el estado " + estado + ".\n" + e.getMessage());
		}
	}

	/**
	 * Trae el estado con el nombre especificado.
	 * 
	 * @param nombre
	 *            Es el nombre del estado que se quiere recuperar.
	 * @return El estado con el nombre especificado.
	 */
	public Estado traerEstado(String nombre) {
		Estado buscado = null;
		Iterator<Estado> iterador = estados.iterator();
		while (iterador.hasNext()) {
			Estado actual = iterador.next();
			if (actual.darNombre().equals(nombre)) {
				buscado = actual;
			}
		}
		return buscado;
	}

}