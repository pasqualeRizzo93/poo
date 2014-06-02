package poo.util;

import java.util.Scanner;

public final class Mat {
	private static double epsilon=1.0E-14;
	private Mat () {}
	public static void setEpsilon (double eps) {epsilon=eps; }
	public static double getEpsilon () {return epsilon; }
	public static boolean sufficientementeProssimi (double x, double y) {
		return Math.abs (x-y)<=epsilon;
	}//sufficientementeProssimi
	public static int mcd(int x, int y) {
		if (x<=0 || y<=0) throw new IllegalArgumentException ();
		int r=0;
		do {
			r=x%y;
			if (r!=0) {x=y; y=r; }
		} while (r!=0);
		return y;
	}//mcd
	public static int mcm (int x, int y) {
		if (x<=0 || y<=0) throw new IllegalArgumentException ();
		return (x*y)/mcd(x,y);
	}//mcm
	public static void stampaRiga(double riga[]){
		System.out.println("Viene presentata la riga estratta");
		System.out.println();
		for(int i=0;i<riga.length;i++){
			System.out.print(riga[i]);
			if(i<riga.length-1) System.out.print(", ");
			else System.out.print(".");
		}
	}
	public static void stampaColonna (double [] colonna) {
		System.out.println("La colonna estratta è la seguente: ");
		System.out.println();
		for (int i=0; i<colonna.length; i++) {
			System.out.print(colonna[i]);
			if (i<colonna.length-1)
				System.out.print(", ");
			else System.out.print(".");
		}
	}//stampaColonna
	public static void stampaMatrice (double [] [] M) {
		System.out.println("La matrice presentata è la seguente: ");
		System.out.println();
		for (int i=0; i<M.length; i++)
			for (int j=0; j<M[0].length; j++)
				System.out.println(M[i][j]);				
	}
	public static double [][] leggi (int r, int c) {
		Scanner sc=new Scanner (System.in);
		double [] [] M=new double [r][c];
		for (int i=0; i<M.length; i++)
			for (int j=0; j<M[0].length; j++){
				System.out.println("Inserire l'elemento della matrice nella posizione ["+i+", "+j+"]");
				M[i][j]=sc.nextDouble ();
			}
		return M;
	}//leggi
}//Mat
