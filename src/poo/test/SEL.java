package poo.test;
import java.util.*;
import poo.sistema.*; 
public class SEL {
	public static void main (String [] args) {
		Scanner sc=new Scanner (System.in);
		System.out.print("Dimensione del sistema= ");
		int n=sc.nextInt ();
		if(n<=0) throw new RuntimeException ("Dimensione non positiva");
		System.out.println("Fornisci ora "+n+"*"+n+" elementi della matrice del sistema: ");
		double [] [] a=new double [n][n];
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++) {
				System.out.print("a["+i+", "+j+"]= ");
				a[i][j]=sc.nextDouble ();
			}
		double y []=new double [n];
		System.out.println("Fornisci ora "+n+" termini noti: ");
		for (int i=0; i<n; i++)
			y[i]=sc.nextDouble ();
		Sistema s=new Gauss (a,y);
		System.out.println("Sistema iniziale: ");
		System.out.println(s);
		double [] x = null;
		try {
			s.risolvi ();
		}catch (SistemaSingolare e) {
			System.out.println("Sistema Singolare.");
			System.exit (-1);
		}
		System.out.println("Sistema singolare.");
		System.out.println(s);
		System.out.println("Soluzione: ");
		for (int i=0; i<n; i++)
			System.out.printf("x["+i+"]=1.2f\n", x[i]);
	}
}
