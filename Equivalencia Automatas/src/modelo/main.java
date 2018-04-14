package modelo;

import java.util.Iterator;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Maquina estadito = new Maquina(Maquina.TIPO_MEALY);

		estadito.agregarEstado("A");
		estadito.agregarEstado("B");
		estadito.agregarEstado("C");
		estadito.agregarEstado("D");
		estadito.agregarEstado("E");

		Estado a = estadito.traerEstado("A");
		Estado b = estadito.traerEstado("B");
		Estado c = estadito.traerEstado("C");
		Estado d = estadito.traerEstado("D");
		Estado e = estadito.traerEstado("E");


		a.agregarTransiciones("1", "0", b);
		a.agregarTransiciones("1", "0", c);
		b.agregarTransiciones("1", "0", d);
		
		estadito.eliminarInalcanzables();
		
		Iterator<Estado> f = estadito.darEstados().iterator();
		while(f.hasNext()){
			Estado v = f.next();
			System.out.println(v.darNombre());
		}
	

		

	}

}
