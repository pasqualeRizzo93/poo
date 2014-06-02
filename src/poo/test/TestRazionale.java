package poo.test;
import poo.razionali.Razionale;
import poo.sortable.Sortable;
public class TestRazionale {
	public static void main (String [] args) {
		Razionale r1=new Razionale (3,7);
		Razionale r2=new Razionale (5,7);
		r1.getContatore();
		Razionale.getContatore ();
		System.out.println("Numeri razionali: "+Razionale.getContatore());
		Razionale [] w={new Razionale(5,7), new Razionale(4,8), new Razionale(3,9)};
		Sortable.sort(w);
		for (int i=0; i<w.length; i++)
			System.out.print(w[i]+", ");
		System.out.println();
	}
}
