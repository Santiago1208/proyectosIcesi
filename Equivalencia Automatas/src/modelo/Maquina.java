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

	public void eliminarInalcanzables() throws Exception {
		ArrayList<Estado> alcanzables = exploradorEstados();
		estados.removeAll(estados);
		agregarEstado(alcanzables);
	}

	public ArrayList<Estado> exploradorEstados() {
		ArrayList<Estado> estadosx = new ArrayList<>();
		Queue<Estado> cola = new ArrayDeque<>();
		cola.add(estadoInicial);
		while (!cola.isEmpty()) {
			Estado act = cola.poll();
			act.modificarVisitado(true);
			estadosx.add(act);
			Iterator<Transicion> iterador = act.darTransicion().iterator();
			while (iterador.hasNext()) {
				Transicion nueva = iterador.next();
				if(!nueva.darEstadoLlegada().fueVisitado()) {
					cola.add(nueva.darEstadoLlegada());
				}
			}
		}
		return estadosx;
	}

	public void renombraEstados(String name) {
		Estado x = traerEstado(name);
		x.modificarNombre(name + "'");
	}

	

	public void agregarEstado(String estado, int hashCode) throws Exception {
		try {
			Estado nuevoEstado = new Estado(estado, hashCode);
			estados.add(nuevoEstado);
			if (estados.size() == 1) {
				estadoInicial = nuevoEstado;
			}
		} catch (Exception e) {
			throw new Exception("No se pudo agregar el estado " + estado + ".\n" + e.getMessage());
		}
	}

	private void agregarEstado(ArrayList<Estado> estado) throws Exception {
		try {
			estados.add(estadoInicial);
			for (int i = 0; i < estado.size(); i++) {
				estados.add(estado.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void agregarEstado(Estado estado) throws IllegalArgumentException{
		try {
			estados.add(estado);
		}catch (Exception e) {
			throw new IllegalArgumentException("Error de adición de estados: la máquina no puede tener dos estados repetidos");
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
	
	/**
	 * Método que se encarga de sumar dos máquinas. Las máquinas deben ser del mismo tipo.
	 * @param otraMaquina Es la otra máquina que se quiere sumar esta máquina.
	 * @return Una máquina que representa la unión de las dos máquinas.
	 * @throws Exception 
	 */
	public Maquina sumarMaquina(Maquina otraMaquina) throws Exception{
		if (otraMaquina == null) {
			throw new IllegalArgumentException("Error de suma: No se puede sumar la máquina con una máquina null.");
		} else if (!tipoMaquina.equals(otraMaquina.tipoMaquina)) {
			throw new IllegalArgumentException("Error de suma: Las máquinas deben ser del mismo tipo");
		}
		Maquina maquinaTotal = new Maquina(tipoMaquina);
		Iterator<Estado> iterador = estados.iterator();
		while(iterador.hasNext()) {
			Estado estadoActual = iterador.next();
			maquinaTotal.agregarEstado(estadoActual);
		}
		Iterator<Estado> iterador2 = otraMaquina.darEstados().iterator();
		while (iterador2.hasNext()) {
			Estado estadoActual = iterador2.next();
			maquinaTotal.agregarEstado(estadoActual);
		}
		return maquinaTotal;
	}
	
	@Override
	public String toString() {
		String maquina = "";
		Iterator<Estado> iterador = estados.iterator();
		while (iterador.hasNext()) {
			Estado estadoActual = iterador.next();
			maquina += estadoActual.toString() + "\n";
		}
		return maquina;
	}

}