package modelo;

import java.util.Iterator;
import java.util.List;

public class ProgramaEquivalencia implements IAutomata {

	// Atributos
	// ======================================================================================

	private Maquina m1;

	private Maquina m2;

	// Constructor
	// ======================================================================================

	public ProgramaEquivalencia() {

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
	public void inicializarMaquinas(List<String> estadosM1, String[][] transicionesM1, String[] inputsM1,
			List<String> estadosM2, String[][] transicionesM2, String[] inputsM2, String tipoMaquina) throws Exception {
		if (tipoMaquina.equals(Maquina.TIPO_MEALY)) {
			m1 = inicializarTipoMealy(estadosM1, transicionesM1, inputsM1);
			m2 = inicializarTipoMealy(estadosM2, transicionesM2, inputsM2);
		} else if (tipoMaquina.equals(Maquina.TIPO_MOORE)) {
			inicializarTipoMoore(estadosM1, transicionesM1, inputsM1, m1);
			inicializarTipoMoore(estadosM2, transicionesM2, inputsM2, m2);
		}
	}

	private Maquina inicializarTipoMealy(List<String> estadosM, String[][] transicionesM, String[] inputsM)
			throws Exception {
		Maquina m = new Maquina(Maquina.TIPO_MEALY);

		// Inicialización de estados
		for (int i = 0; i < estadosM.size(); i++) {
			String estado = estadosM.get(i);
			m.agregarEstado(estado);
		}
		for (int i = 0; i < estadosM.size(); i++) {
			String estado = estadosM.get(i);
			Estado eI = m.traerEstado(estado);
			for (int j = 0; j < transicionesM[0].length; j++) {
				// Recuperamos la entrada
				String in = inputsM[j];
				// Dividimos la transición dada de la forma Estado, salida
				String[] split = transicionesM[i][j].split(", ");
				// Recuperamos el estado de llegada
				String estadoLlegada = split[1];
				Estado eL = m.traerEstado(estadoLlegada);
				// Recuperamos la salida
				String out = split[0];
				eI.agregarTransiciones(in, out, eL);
			}
		}
		return m;

	}

	private void inicializarTipoMoore(List<String> estadosM, String[][] transicionesM, String[] inputsM, Maquina m) {

	}

	public void renombraEstados(Maquina referencia, Maquina conflitada) {

		Iterator<Estado> iterator = referencia.darEstados().iterator();
		

		while (iterator.hasNext()) {
			Estado ref = iterator.next();
			Iterator<Estado> iteratorConflictuado = conflitada.darEstados().iterator();
			while (iteratorConflictuado.hasNext()) {
				Estado conflictuado = iteratorConflictuado.next();
				if (conflictuado.equals(ref)) {
					conflitada.renombraEstados(conflictuado.darNombre());
				}

			}
		}

	}

	public boolean sonEquivalentes() {
		// TODO - implement ProgramaEquivalencia.sonEquivalentes
		throw new UnsupportedOperationException();
	}

	private Maquina sumaDirecta() {
		// TODO - implement ProgramaEquivalencia.sumaDirecta
		throw new UnsupportedOperationException();
	}

	private Maquina particionamiento() {
		// TODO - implement ProgramaEquivalencia.particionamiento
		throw new UnsupportedOperationException();
	}

}