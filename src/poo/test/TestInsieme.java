package poo.test;
import poo.esempi_libro.*;
public class TestInsieme {
	public static void main (String [] args) {
		InsiemeVector<Integer> i=new InsiemeVector<Integer> (5);
		i.aggiungi(1); i.aggiungi(2);i.aggiungi(3);i.aggiungi(4);i.aggiungi(5);i.aggiungi(6);
		System.out.println("Primo insieme");
		System.out.println(i);
		System.out.println();
		InsiemeVector<Integer> i2=new InsiemeVector<Integer> (5);
		i2.aggiungi(1);i2.aggiungi(6);i2.aggiungi(7);i2.aggiungi(8);i2.aggiungi(9);
		System.out.println("Secondo insieme");
		System.out.println(i2);
		System.out.println();
		Insieme<Integer> unione=i.unione(i2);
		System.out.println("Insieme unione");
		System.out.println(unione);
		System.out.println();
		Insieme<Integer> intersezione=i.intersezione(i2);
		System.out.println("Intersezione");
		System.out.println(intersezione);
		System.out.println();
		Insieme<Integer> diffSimm=i.differenzaSimmetrica(i2);
		System.out.println("Differenza simmetrica");
		System.out.println(diffSimm);
		System.out.println();
	}
}
