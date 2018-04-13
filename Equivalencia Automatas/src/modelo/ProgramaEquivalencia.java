package modelo;

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
	public void inicializarMaquinas(List<String> estadosM1, String[] transicionesM1, String[] inputsM1, List<String> estadosM2, String[] transicionesM2, String[] inputsM2, String tipoMaquina) throws Exception {
		if (tipoMaquina.equals(Maquina.TIPO_MEALY)) {
			inicializarTipoMealy(estadosM1, transicionesM1, inputsM1, m1);
			inicializarTipoMealy(estadosM2, transicionesM2, inputsM2, m2);
		}else if (tipoMaquina.equals(Maquina.TIPO_MOORE)) {
			inicializarTipoMoore(estadosM1, transicionesM1, estadosM2, transicionesM2);
		}
	}
	
	private void inicializarTipoMealy(List<String> estadosM, String[] transicionesM, String[] inputsM, Maquina m) throws Exception {
		m = new Maquina(Maquina.TIPO_MEALY);
		
		// Inicializaci�n de estados
		for (int i = 0; i < estadosM.size(); i++) {
			String estado = estadosM.get(i);
			Estado nuevoEstado = new Estado(estado);
			for (int j = 0; j < transicionesM.length; j++) {
				String in = inputsM[j];
				String out = "" + transicionesM[j].charAt(2);
				String estadoLlegada = "" + transicionesM[j].charAt(0);
				Transicion nuevaTransicion = new Transicion(in, out, null);
			}
		}
		
	}
	
	private void inicializarTipoMoore(List<String> estadosM1, String[] transicionesM1, List<String> estadosM2, String[] transicionesM2) {
		
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