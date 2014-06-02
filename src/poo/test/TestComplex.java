package poo.test;
import poo.esempi_libro.Complex;
import java.util.*;
public class TestComplex {
	public static void main (String [] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("Inserisci la parte reale e immaginaria del primo numero: ");
		double re1=sc.nextDouble();
		double im1=sc.nextDouble();
		Complex c1=new Complex (re1, im1);
		System.out.println("Inserisci la parte reale e immaginaria del secondo numero: ");
		double re2=sc.nextDouble();
		double im2=sc.nextDouble();
		Complex c2=new Complex (re2, im2);
		System.out.println("somma= "+c1.add(c2));
		System.out.println("differenza= "+c1.sub(c2));
		System.out.println("modulo= "+c1.modulo());
		System.out.println("prodotto= "+c1.mul(c2));
		System.out.println("coniugato= "+c1.coniugato());
		System.out.println("prodotto per reale= "+c1.mul(5));
	}
}
