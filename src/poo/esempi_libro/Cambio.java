package poo.esempi_libro;
import java.util.*;
public class Cambio {
	public static void main (String [] args) {
		final double cambioEuroLire=1936.27;
		System.out.println("Cambio lire in euro: ");
		Scanner sc=new Scanner (System.in);
		System.out.print("Lire= ");
		int lire=sc.nextInt ();
		double euro=lire/cambioEuroLire;
		System.out.printf("%1.2f%n", euro);
	}
}
