package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pruebas {
	
	// ==========================================
	// Maquina 1
	// ==========================================
	static List<String> estadosM1;
	static String[][] transicionesM1;
	static List<String> inputsM1;
	
	// Usado en Moore solamente.
	static List<String> outputsM1;
	
	// ==========================================
	// Maquina 2
	// ==========================================
	static List<String> estadosM2;
	static String[][] transicionesM2;
	static List<String> inputsM2;
	
	// Usado en Moore solamente.
	static List<String> outputsM2;

	public static void main(String[] args) throws Exception {
		
		
		mealySetUpCaso2();
		
//		List<String> estadosM1 = new ArrayList<>();
//		estadosM1.add("A");
//		estadosM1.add("B");
//		estadosM1.add("C");
//		estadosM1.add("D");
//		estadosM1.add("E");
//		estadosM1.add("F");
//		estadosM1.add("G");
//
//		String[][] transicionesM1 = new String[][] { 
//			
//			new String[] { "B, 0", "A, 0" }, 
//			new String[] { "A, 0", "C, 1" },
//			new String[] { "D, 1", "A, 0" }, 
//			new String[] { "F, 1", "E, 0" },
//			new String[] { "A, 0", "E, 1" },
//			new String[] { "F, 1", "G, 1" },
//			new String[] { "F, 0", "E, 1" }
//			};
//			
//		List<String> inputsM1 = new ArrayList<>();
//		inputsM1.add("0");
//		inputsM1.add("1");
//
//		List<String> estadosM2 = new ArrayList<>();
//		estadosM2.add("A");
//		estadosM2.add("B");
//		estadosM2.add("C");
//		estadosM2.add("D");
//		estadosM2.add("E");
//		estadosM2.add("F");
//		estadosM2.add("G");
//		estadosM2.add("H");
//
//		String[][] transicionesM2 = new String[][] { 
//			new String[] { "E, 0", "D, 0" }, 
//			new String[] { "D, 0", "F, 1" },
//			new String[] { "F, 1", "D, 0" }, 
//			new String[] { "E, 0", "H, 1" }, 
//			new String[] { "D, 1", "G, 0" },
//			new String[] { "F, 1", "E, 1" },
//			new String[] { "F, 1", "E, 0" },
//			new String[] { "H, 0", "G, 1" }
//			};
//
//		List<String> inputsM2 = new ArrayList<>();
//		inputsM2.add("0");
//		inputsM2.add("1");

		ProgramaEquivalencia pro = new ProgramaEquivalencia();
		
		// Prueba de Inicialización
		// ===============================================================================================
		pro.inicializarMaquinas(estadosM1, transicionesM1, inputsM1, estadosM2, transicionesM2, inputsM2, Maquina.TIPO_MEALY);
		System.out.println("Maquinas Inicializadas");
		System.out.println("====================================================");
		System.out.print(pro.darMaquinaA().toString());
		System.out.println("Estado Inicial: " + pro.darMaquinaA().darEstadoInicial().darNombre());
		System.out.print(pro.darMaquinaB().toString());
		System.out.println("Estado Inicial: " + pro.darMaquinaB().darEstadoInicial().darNombre());
		
		// Prueba de Estados Alcanzables
		// ===============================================================================================
		System.out.println("====================================================");
		System.out.println("Estados Alcanzables Maquina 1");
		System.out.println("====================================================");
		pro.darMaquinaA().eliminarInalcanzables();
		System.out.print(pro.darMaquinaA().toString());
		System.out.println("Estado Inicial: " + pro.darMaquinaA().darEstadoInicial().darNombre());
		
		System.out.println("====================================================");
		System.out.println("Estados Alcanzables Maquina 2");
		System.out.println("====================================================");
		pro.darMaquinaB().eliminarInalcanzables();
		System.out.print(pro.darMaquinaB().toString());
		System.out.println("Estado Inicial: " + pro.darMaquinaB().darEstadoInicial().darNombre());
		
		// Prueba de Renombramiento
		// ===============================================================================================
		System.out.println("====================================================");
		System.out.println("Prueba de Renombramiento");
		System.out.println("====================================================");
		pro.renombrarEstados();
		System.out.print(pro.darMaquinaA().toString());
		System.out.println("Estado Inicial: " + pro.darMaquinaA().darEstadoInicial().darNombre());
		System.out.print(pro.darMaquinaB().toString());
		System.out.println("Estado Inicial: " + pro.darMaquinaB().darEstadoInicial().darNombre());
		 
		// Prueba de Suma Directa
		// ===============================================================================================
		System.out.println("====================================================");
		System.out.println("Prueba de Suma Directa");
		System.out.println("====================================================");
		Maquina maquinaTotal = pro.sumaDirecta();
		System.out.println(maquinaTotal.toString());

	}
	
	/**
	 * Este es el caso construido por Bernal y modificado levemente por Santiago.
	 */
	static void mealySetUpCaso1() {
		estadosM1 = new ArrayList<>();
		estadosM1.add("A");
		estadosM1.add("B");
		estadosM1.add("C");
		estadosM1.add("D");
		estadosM1.add("E");
		estadosM1.add("F");
		estadosM1.add("G");

		transicionesM1 = new String[][] { 
			
			new String[] { "B, 0", "A, 0" }, 
			new String[] { "A, 0", "C, 1" },
			new String[] { "D, 1", "A, 0" }, 
			new String[] { "F, 1", "E, 0" },
			new String[] { "A, 0", "E, 1" },
			new String[] { "F, 1", "G, 1" },
			new String[] { "F, 0", "E, 1" }
			};
			
		inputsM1 = new ArrayList<>();
		inputsM1.add("0");
		inputsM1.add("1");

		estadosM2 = new ArrayList<>();
		estadosM2.add("A");
		estadosM2.add("B");
		estadosM2.add("C");
		estadosM2.add("D");
		estadosM2.add("E");
		estadosM2.add("F");
		estadosM2.add("G");
		estadosM2.add("H");

		transicionesM2 = new String[][] { 
			new String[] { "E, 0", "D, 0" }, 
			new String[] { "D, 0", "F, 1" },
			new String[] { "F, 1", "D, 0" }, 
			new String[] { "E, 0", "H, 1" }, 
			new String[] { "D, 1", "G, 0" },
			new String[] { "F, 1", "E, 1" },
			new String[] { "F, 1", "E, 0" },
			new String[] { "H, 0", "G, 1" }
			};

		inputsM2 = new ArrayList<>();
		inputsM2.add("0");
		inputsM2.add("1");
	}
	
	/**
	 * Este es el caso del ejemplo de la diapositiva de la sesión 5.
	 */
	static void mealySetUpCaso2() {
		estadosM1 = new ArrayList<>();
		estadosM1.add("A");
		estadosM1.add("B");
		estadosM1.add("C");

		transicionesM1 = new String[][] { 
			
			new String[] { "B, 0", "A, 0" }, 
			new String[] { "A, 0", "C, 1" },
			new String[] { "C, 1", "A, 0" },
			};
			
		inputsM1 = new ArrayList<>();
		inputsM1.add("0");
		inputsM1.add("1");

		estadosM2 = new ArrayList<>();
		estadosM2.add("D");
		estadosM2.add("E");
		estadosM2.add("F");
		estadosM2.add("G");
		estadosM2.add("H");

		transicionesM2 = new String[][] { 
			new String[] { "E, 0", "D, 0" }, 
			new String[] { "D, 0", "F, 1" },
			new String[] { "F, 1", "D, 0" }, 
			new String[] { "E, 0", "H, 1" }, 
			new String[] { "D, 1", "G, 0" },
			};

		inputsM2 = new ArrayList<>();
		inputsM2.add("0");
		inputsM2.add("1");
	}
	
	static void mooreSetUpCaso1() {
		estadosM1 = new ArrayList<>();
		estadosM1.add("A");
		estadosM1.add("B");
		estadosM1.add("C");
		estadosM1.add("D");
		estadosM1.add("E");
		estadosM1.add("F");
		estadosM1.add("G");
		estadosM1.add("H");
		estadosM1.add("I");
		estadosM1.add("J");
		estadosM1.add("K");

		transicionesM1 = new String[][] { 
			new String[] { "B", "A" }, 
			new String[] { "C", "D" },
			new String[] { "E", "C" }, 
			new String[] { "F", "B" },
			new String[] { "G", "E" },
			new String[] { "H", "F" },
			new String[] { "I", "G" },
			new String[] { "J", "H" },
			new String[] { "A", "K" },
			new String[] { "K", "J" },
			new String[] { "A", "K" }
			};
			
		inputsM1 = new ArrayList<>();
		inputsM1.add("0");
		inputsM1.add("1");
		
		outputsM1 = new ArrayList<>();
		outputsM1.add("0");
		outputsM1.add("0");
		outputsM1.add("0");
		outputsM1.add("0");
		outputsM1.add("0");
		outputsM1.add("0");
		outputsM1.add("0");
		outputsM1.add("0");
		outputsM1.add("1");
		outputsM1.add("0");
		outputsM1.add("1");
		
		estadosM2 = new ArrayList<>();
		estadosM2.add("A");
		estadosM2.add("B");
		estadosM2.add("C");
		estadosM2.add("D");
		estadosM2.add("E");
		estadosM2.add("F");
		estadosM2.add("G");
		estadosM2.add("H");

		transicionesM2 = new String[][] { 
			new String[] { "E, 0", "D, 0" }, 
			new String[] { "D, 0", "F, 1" },
			new String[] { "F, 1", "D, 0" }, 
			new String[] { "E, 0", "H, 1" }, 
			new String[] { "D, 1", "G, 0" },
			new String[] { "F, 1", "E, 1" },
			new String[] { "F, 1", "E, 0" },
			new String[] { "H, 0", "G, 1" }
			};

		inputsM2 = new ArrayList<>();
		inputsM2.add("0");
		inputsM2.add("1");
		
		
	}
	
	
	/**
	 * Es código comentado
	 */
	static void codigoComentado() {
		// Maquina estadito = new Maquina(Maquina.TIPO_MEALY);
				//
				//
				// estadito.agregarEstado("A");
				// estadito.agregarEstado("B");
				// estadito.agregarEstado("C");
				// estadito.agregarEstado("D");
				// estadito.agregarEstado("E");
				// estadito.agregarEstado("F");
				// estadito.agregarEstado("G");
				// estadito.agregarEstado("H");
				// estadito.agregarEstado("I");
				//
				// Estado a = estadito.traerEstado("A");
				// Estado b = estadito.traerEstado("B");
				// Estado c = estadito.traerEstado("C");
				// Estado d = estadito.traerEstado("D");
				// Estado f = estadito.traerEstado("F");
				// Estado e = estadito.traerEstado("E");
				// Estado h = estadito.traerEstado("H");
				//
				//
				// a.agregarTransiciones("1", "0", b);
				// a.agregarTransiciones("1", "0", c);
				// b.agregarTransiciones("1", "0", d);
				// d.agregarTransiciones("1", "0", e);
				// c.agregarTransiciones("1", "0", f);
				// h.agregarTransiciones("3", "1", a);
				//
				//
				// estadito.eliminarInalcanzables();
				//
				// Iterator<Estado> v = estadito.darEstados().iterator();
				// while(v.hasNext()){
				// Estado bnv = v.next();
				// System.out.println(bnv.darNombre());
				// }
	}
	
}
