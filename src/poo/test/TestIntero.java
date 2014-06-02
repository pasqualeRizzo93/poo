package poo.test;
import poo.sortable.*;
public class TestIntero {
	public static void main (String [] args) {
		Intero [] v=new Intero [10];
		for (int i=0; i<v.length; i++) 
			v[i]=new Intero (v.length-i);
		Sortable.sort(v);
		for (int i=0; i<v.length; i++)
			System.out.print(v[i]+", ");
		System.out.println();
	}
}
