package modelo;

import java.util.Iterator;
import java.util.List;

public class ProgramaEquivalencia implements IAutomata {

	// Atributos
	// ======================================================================================

	private Maquina m1;

	private Maquina m2;
	
	private int hashCodeEstados;
	
	private int hashCodeTransiciones;
	// Constructor
	// ======================================================================================

	public ProgramaEquivalencia() {
		m1 = new Maquina("");
		m2 = new Maquina("");
		hashCodeEstados = 0;
		hashCodeTransiciones = 0;
	}

	// Servicios
	// ======================================================================================

	public Maquina darMaquinaA() {
		return m1;
	}

	public Maquina darMaquinaB() {
		return m2;
	}

	/**
	 * 
	 * @param estadosM1
	 * @param transicionesM1
	 * @param estadosM2
	 * @param transicionesM2
	 * @throws Exception
	 */
	public void inicializarMaquinas(List<String> estadosM1, String[][] transicionesM1, List<String> inputsM1,
			List<String> estadosM2, String[][] transicionesM2, List<String> inputsM2, String tipoMaquina) throws Exception {
		if (estadosM1.size() != transicionesM1.length) {
			throw new IllegalArgumentException("Error de inicializaci�n: El n�mero de filas de la tabla de transici�n debe ser igual a la cantidad de estados en la m�quina 1.");
		}
		if (estadosM2.size() != transicionesM2.length) {
			throw new IllegalArgumentException("Error de inicializaci�n: El n�mero de filas de la tabla de transici�n debe ser igual a la cantidad de estados en la m�quina 2.");
		}
		if (tipoMaquina.equals(Maquina.TIPO_MEALY)) {
			if (inputsM1.size() != transicionesM1[0].length) {
				throw new IllegalArgumentException("Error de inicializaci�n: El n�mero de columnas de la tabla de transici�n debe ser igual a la cantidad de s�mbolos de entrada en la m�quina 1.");
			}
			if (inputsM2.size() != transicionesM2[0].length) {
				throw new IllegalArgumentException("Error de inicializaci�n: El n�mero de columnas de la tabla de transici�n debe ser igual a la cantidad de s�mbolos de entrada en la m�quina 2.");
			}
			m1 = inicializarTipoMealy(estadosM1, transicionesM1, inputsM1);
			m2 = inicializarTipoMealy(estadosM2, transicionesM2, inputsM2);
		} else if (tipoMaquina.equals(Maquina.TIPO_MOORE)) {
			inicializarTipoMoore(estadosM1, transicionesM1, inputsM1, m1);
			inicializarTipoMoore(estadosM2, transicionesM2, inputsM2, m2);
		}
	}

	private Maquina inicializarTipoMealy(List<String> estadosM, String[][] transicionesM, List<String> inputsM)
			throws Exception {
		Maquina m = new Maquina(Maquina.TIPO_MEALY);

		// Inicializaci�n de estados
		for (int i = 0; i < estadosM.size(); i++) {
			String estado = estadosM.get(i);
			m.agregarEstado(estado, hashCodeEstados);
			hashCodeEstados++;
		}
		for (int i = 0; i < estadosM.size(); i++) {
			String estado = estadosM.get(i);
			Estado eI = m.traerEstado(estado);
			for (int j = 0; j < transicionesM[0].length; j++) {
				// Recuperamos la entrada
				String in = inputsM.get(j);
				// Dividimos la transici�n dada de la forma Estado, salida
				String[] split = transicionesM[i][j].split(", ");
				// Recuperamos el estado de llegada
				String estadoLlegada = split[0];
				Estado eL = m.traerEstado(estadoLlegada);
				// Recuperamos la salida
				String out = split[1];
				eI.agregarTransiciones(in, out, eL, hashCodeTransiciones);
				hashCodeTransiciones++;
			}
		}
		return m;

	}

	private void inicializarTipoMoore(List<String> estadosM, String[][] transicionesM, List<String> inputsM, Maquina m) {
	
	}

	public void renombrarEstados() throws NullPointerException{
		if (m1 == null || m2 == null) {
			throw new NullPointerException("Error de renombramiento: Una de las m�quinas no est� inicializada");
		}
		Iterator<Estado> iterator = m1.darEstados().iterator();

		while (iterator.hasNext()) {
			Estado ref = iterator.next();
			Iterator<Estado> iteratorConflictuado = m2.darEstados().iterator();
			while (iteratorConflictuado.hasNext()) {
				Estado conflictuado = iteratorConflictuado.next();
				if (conflictuado.equals(ref)) {
					m2.renombraEstados(conflictuado.darNombre());
				}
			}
		}
	}

	public boolean sonEquivalentes() {
		// TODO - implement ProgramaEquivalencia.sonEquivalentes
		throw new UnsupportedOperationException();
	}

	public Maquina sumaDirecta() throws Exception{
		Maquina maquinaTotal = new Maquina(m1.darTipoMaquina());
		try {
			renombrarEstados();
			maquinaTotal = m1.sumarMaquina(m2);
		} catch (NullPointerException e) {
			throw new NullPointerException("Error de Suma Directa: " + e.getMessage());
		} catch (IllegalArgumentException f) {
			throw new IllegalArgumentException("Error de Suma Directa: " + f.getMessage());
		}
		return maquinaTotal;
	}

	private Maquina particionamiento() {
		// TODO - implement ProgramaEquivalencia.particionamiento
		
		
		
		
		
		
		
		
		
		
		
		throw new UnsupportedOperationException();
	}

}