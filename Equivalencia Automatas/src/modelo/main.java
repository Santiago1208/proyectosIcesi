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
		estadito.agregarEstado("F");
		estadito.agregarEstado("G");
		estadito.agregarEstado("H");
		estadito.agregarEstado("I");

		Estado a = estadito.traerEstado("A");
		Estado b = estadito.traerEstado("B");
		Estado c = estadito.traerEstado("C");
		Estado d = estadito.traerEstado("D");
		Estado f = estadito.traerEstado("F");
		Estado e = estadito.traerEstado("E");
		Estado h = estadito.traerEstado("H");


		a.agregarTransiciones("1", "0", b);
		a.agregarTransiciones("1", "0", c);
		b.agregarTransiciones("1", "0", d);
		d.agregarTransiciones("1", "0", e);
		c.agregarTransiciones("1", "0", f);
		h.agregarTransiciones("3", "e", a);
		
		
		estadito.eliminarInalcanzables();
		
		Iterator<Estado> v = estadito.darEstados().iterator();
		while(v.hasNext()){
			Estado bnv = v.next();
			System.out.println(bnv.darNombre());
		}
	

		

	}

}
