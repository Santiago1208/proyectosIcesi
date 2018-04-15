package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<String> estadosM1 = new ArrayList<>();
		estadosM1.add("A");
		estadosM1.add("B");
		estadosM1.add("C");
		estadosM1.add("D");
		estadosM1.add("E");
		estadosM1.add("F");
		estadosM1.add("G");

		String[][] transicionesM1 = new String[][] { 
			
			new String[] { "0, B", "0, C" }, 
			new String[] { "0, D", "0, E" },
			new String[] { "0, F", "1, A" }, 
			new String[] { "1, B", "0, B" }, 
			new String[] { "0, A", "1, E" },
			new String[] { "1, F", "1, E" },
			new String[] { "1, F", "1, E" }};
			
			

		String[] inputsM1 = new String[] { "0", "1" };

		List<String> estadosM2 = new ArrayList<>();
		estadosM2.add("A");
		estadosM2.add("B");
		estadosM2.add("C");
		estadosM2.add("D");
		estadosM2.add("E");
		estadosM2.add("F");

		String[][] transicionesM2 = new String[][] { 
			new String[] { "0, B", "0, C" }, 
			new String[] { "0, D", "0, E" },
			new String[] { "0, F", "1, A" }, 
			new String[] { "1, B", "0, B" }, 
			new String[] { "0, A", "1, E" },
			new String[] { "1, F", "1, E" },
			new String[] { "1, F", "1, E" }};

		String[] inputsM2 = new String[] { "0", "1" };

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

		ProgramaEquivalencia pro = new ProgramaEquivalencia();

		pro.inicializarMaquinas(estadosM1, transicionesM1, inputsM1, estadosM2, transicionesM2, inputsM2,
				Maquina.TIPO_MEALY);

		Iterator<Estado> v = pro.darMaquinaA().darEstados().iterator();

		while (v.hasNext()) {
			Estado bnv = v.next();
			System.out.println(bnv.darNombre() + "M1");
		}

		pro.darMaquinaA().eliminarInalcanzables();

		System.out.println("Eliminando");

		Iterator<Estado> r = pro.darMaquinaA().darEstados().iterator();

		while (r.hasNext()) {
			Estado bnv = r.next();
			System.out.println(bnv.darNombre() + "eliminandp");
		}

		
		

		 pro.renombraEstados(pro.darMaquinaA(), pro.darMaquinaB());
		
			System.out.println("renombrando");
		 
		 v = pro.darMaquinaB().darEstados().iterator();
		 while(v.hasNext()){
		 Estado bnv = v.next();
		 System.out.println(bnv.darNombre());
		 }
		 
		 
		//
		// v = pro.darMaquinaB().darEstados().iterator();
		// while(v.hasNext()){
		// Estado bnv = v.next();
		// System.out.println(bnv.darNombre());
		// }

	}

}
