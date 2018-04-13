package modelo;

import java.util.List;

public interface IAutomata {

	/**
	 * 
	 * @param estadosM1
	 * @param transicionesM1
	 * @param estadosM2
	 * @param transicionesM2
	 * @throws Exception 
	 */
	public void inicializarMaquinas(List<String> estadosM1, String[] transicionesM1, String[] inputsM1, List<String> estadosM2, String[] transicionesM2, String[] inputsM2, String tipoMaquina) throws Exception;

	public boolean sonEquivalentes();

}