package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
			List<String> estadosM2, String[][] transicionesM2, List<String> inputsM2, String tipoMaquina)
			throws Exception {
		if (estadosM1.size() != transicionesM1.length) {
			throw new IllegalArgumentException(
					"Error de inicialización: El número de filas de la tabla de transición debe ser igual a la cantidad de estados en la máquina 1.");
		}
		if (estadosM2.size() != transicionesM2.length) {
			throw new IllegalArgumentException(
					"Error de inicialización: El número de filas de la tabla de transición debe ser igual a la cantidad de estados en la máquina 2.");
		}
		if (tipoMaquina.equals(Maquina.TIPO_MEALY)) {
			if (inputsM1.size() != transicionesM1[0].length) {
				throw new IllegalArgumentException(
						"Error de inicialización: El número de columnas de la tabla de transición debe ser igual a la cantidad de símbolos de entrada en la máquina 1.");
			}
			if (inputsM2.size() != transicionesM2[0].length) {
				throw new IllegalArgumentException(
						"Error de inicialización: El número de columnas de la tabla de transición debe ser igual a la cantidad de símbolos de entrada en la máquina 2.");
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

		// Inicialización de estados
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
				// Dividimos la transición dada de la forma Estado, salida
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

	private void inicializarTipoMoore(List<String> estadosM, String[][] transicionesM, List<String> inputsM,
			Maquina m) {

	}

	public void renombrarEstados() throws NullPointerException {
		if (m1 == null || m2 == null) {
			throw new NullPointerException("Error de renombramiento: Una de las máquinas no está inicializada");
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

	public Maquina sumaDirecta() throws Exception {
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

	public Maquina particionamiento() throws Exception {
		// TODO - implement ProgramaEquivalencia.particionamiento

		Maquina machinetotal = sumaDirecta();
		HashSet<Estado> estadosTotales = machinetotal.darEstados();

		Estado machinesAux[] = new Estado[estadosTotales.size()];
		estadosTotales.toArray(machinesAux);

		ArrayList<Estado> b = new ArrayList<>();
		for (int i = 0; i < machinesAux.length; i++) {
			b.add(machinesAux[i]);
		}

		agrupamiento(b);
		return machinetotal;

	}

	// Estado machinesEstados[] = new Estado[estadosTotales.size()];
	// estadosTotales.toArray(machinesEstados);

	// for(int i=0;i<machinesEstados.length-1;i++){
	//
	// for(int j=0;j<machinesEstados.length-1;j++){
	//
	// }
	//
	// }

	private HashSet agrupamiento(ArrayList<Estado> machinesEstados) {

		System.out.println(machinesEstados.toString());
		String e = "";
		HashSet<HashSet<Estado>> r = new HashSet<>();

		String[][] intputs = new String[machinesEstados.size()][2];

		for (int i = 0; i < intputs.length; i++) {
			Estado a = machinesEstados.get(i);
			Iterator<Transicion> tra = machinesEstados.get(i).darTransicion().iterator();
			for (int j = 0; j < intputs[0].length; j++) {
				String ki = "";

				Transicion l = tra.next();
				ki = l.darOutput();
				intputs[i][j] = ki;
			}

		}

		for (int x = 0; x < intputs.length; x++) {
			
			for (int y = 0; y < intputs[x].length; y++) {
				
			}
			System.out.println("|");
		}

		return r;
	}
}