package poo.gestione_matrici;
import java.util.*;
import poo.util.Mat;
public class testMatrice {
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.print("Inserire l'ordine della matrice: ");
		int ordine=sc.nextInt ();
		System.out.println();
		System.out.println("Inserire gli elementi della matrice.");
		double [][] M=Mat.leggi(ordine, ordine);
		System.out.print("Inserire la riga da estrarre: ");
		int i=sc.nextInt ();
		double [] riga=Matrice.estraiRighe(M, i);
		System.out.print("Inserire la colonna da estrarre: ");
		int j=sc.nextInt ();
		double [] colonna=Matrice.estraiColonne(M, j);
		System.out.println();
		System.out.println("La diagonale della matrice passata: ");
		double [] diagonale=Matrice.estraiDiagonale(M);
		System.out.println();
		System.out.println("La matrice trasposta della matrice passata è: ");
		double [] [] trasposta=Matrice.trasposta(M);
		System.out.println(trasposta);
		System.out.println();
		System.out.print("Inserire la riga di cui si vuole sapere la somma: ");
		int x=sc.nextInt ();
		System.out.print("La somma della riga "+x+"è: ");
		double sommarighe=Matrice.sommaRighe(M, x);
		System.out.println(sommarighe);
		System.out.println();
		System.out.print("Inserire la colonna di cui si vuole sapere la somma: ");
		int y=sc.nextInt ();
		double sommacolonne=Matrice.sommaColonne(M, y);
		System.out.println(sommacolonne);
		System.out.println();
		System.out.print("La somma degli elementi della diagonale è: ");
		double sommadiagonale=Matrice.sommaDiagonale(M);
		System.out.println(sommadiagonale);
		System.out.println();
		System.out.print("Inserire un numero da moltiplicare la matrice: ");
		double k=sc.nextDouble ();
		double [] [] M1=Matrice.prodottoPerScalare(M, k);
		System.out.println(M1);
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
