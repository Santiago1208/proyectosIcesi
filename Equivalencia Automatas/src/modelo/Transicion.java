package modelo;
public class Transicion {
	
	// Atributos
	// ======================================================================================
	
	private Estado estadoLlegada;
	
	private String input;
	
	private String output;
	
	// Constructor
	// ======================================================================================
	
	/**
	 * 
	 * @param in
	 * @param out
	 * @param estLlegada
	 */
	public Transicion(String in, String out, Estado estLlegada) {
		input = in;
		output = out;
		estadoLlegada = estLlegada;
	}
	
	// Servicios
	// ======================================================================================

	public String darInput() {
		return input;
	}

	public String darOutput() {
		return output;
	}

	public Estado darEstadoLlegada() {
		return estadoLlegada;
	}
	
	@Override
	public boolean equals(Object obj) {
		Transicion otraTransicion = (Transicion) obj;
		boolean equals = false;
		if (input.equals(otraTransicion.input) && output.equals(otraTransicion.output) && estadoLlegada.equals(otraTransicion.estadoLlegada)) {
			equals = true;
		}
		return equals;
	}

}