package poo.gestione_matrici;
import poo.util.Mat;
import java.util.*;
public class Matrice {
	public Matrice (double [][] M) {
		if (M.length!=M[0].length)
			throw new IllegalArgumentException ();
	}//costruttore
	public static double [] estraiRighe (double [] [] M, int i) {
		if (i<0 || i>M.length)
			throw new IndexOutOfBoundsException ();
		double [] riga=new double [M[0].length];
		for (int j=0; j<M[0].length; j++)
			riga [j]=M[i][j];
		return riga;
	}//estraiRighe
	public static double [] estraiColonne (double [] [] M, int j) {
		if (j<0 || j>M.length)
			throw new IndexOutOfBoundsException ();
		double [] colonna=new double [M.length];
		for (int i=0; i<M.length; i++)
			colonna [i]=M[i][j];
		return colonna;
	}//estraiColonna
	public static double [] estraiDiagonale (double [] [] M) {
		double [] diagonale=new double [M.length];
		for (int i=0; i<M.length; i++)
			diagonale [i]=M[i][i];
		return diagonale;
	}
	public static double [] [] trasposta (double [] [] M) {
		double [] [] matricetrasposta=new double [M[0].length] [M.length];
		for (int i=0; i<M.length; i++)
			for (int j=0; j<M[0].length; j++)
				matricetrasposta [j] [i]=M[i][j];
		return matricetrasposta;
	}//trasposta
	public static double sommaRighe (double [] [] M, int i) {
		if (i<0 || i>M.length)
			throw new IndexOutOfBoundsException ();
		double sommar=0;
		for (int j=0; j<M[0].length; j++) 
			sommar+=M[i][j];
		return sommar;
	}//sommaRighe
	public static double sommaColonne (double [][] M, int j) {
		if (j<0 || j>M[0].length)
			throw new IndexOutOfBoundsException ();
		double sommac=0;
		for (int i=0; i<M[0].length; i++)
			sommac+=M[i][j];
		return sommac;
	}//sommaColonne
	public static double sommaDiagonale (double [][] M) {
		double sommad=0;
		for (int i=0; i<M.length; i++)
			sommad+=M[i][i];
		return sommad;
	}//sommaDiagonale
	public static double [] [] prodottoPerScalare (double [] [] M, double k) {
		double [] [] matnuova=new double [M.length] [M[0].length];
		for (int i=0; i<M.length; i++)
			for (int j=0; j<M[0].length; j++)
				matnuova [i][j]=k*M[i][j];
		return matnuova;
	}//prodottoPerScalare
	public static double [] [] sommaMatrici (double [] [] M, double [] [] M1) {
		double [] [] matricesomma=new double [M.length] [M.length];
		for (int i=0; i<M.length; i++)
			for (int j=0; j<M.length; j++)
				matricesomma [i][j]=M[i][j]+M1[i][j];
		return matricesomma;
	}//sommaMatrici
	public static double [] [] differenzaMatrici (double [] [] M, double [] [] M1) {
		double [] [] matricedifferenza=new double [M.length] [M.length];
		for (int i=0; i<M.length; i++)
			for (int j=0; j<M.length; j++)
				matricedifferenza [i][j]=M[i][j]-M1[i][j];
		return matricedifferenza;
	}//differenzaMatrici
	public static double [] [] prodottoMatrici (double [] [] M, double [] [] M1) {
		if (M[0].length!=M1.length)
			throw new RuntimeException ("Matrici non compatibili");
		double [] [] matriceprodotto=new double [M.length] [M1[0].length];
		double [] riga;
		double [] colonna;
		for (int i=0; i<matriceprodotto.length; i++){
			riga=estraiRighe (M,i);
			for (int j=0; j<matriceprodotto[0].length; j++) {
				colonna=estraiColonne(M1,j);
				double somma=0;
				for (int k=0; k<riga.length; k++)
					somma+=(riga[k]*colonna[k]);
				matriceprodotto[i][j]=somma;
			}
		}
		return matriceprodotto;
	}//prodottoMatrici
	public static double determinante(double [][]M){
	 double a[][]=new double[M.length][M.length];
	 for (int i=0;i<M.length;i++)
		 for(int j=0;j<M.length;j++)
			 a[i][j]=M[i][j];
	 	int contaScambi=0;
		int n=a.length;
		for(int j=0;j<n;j++){
			if(Mat.sufficientementeProssimi(a[j][j], 0D)){//pivoting
				int p=j+1;
				for(;p<n;p++)
					if(!Mat.sufficientementeProssimi(a[p][j], 0D))break;
				if(p==n) return 0D;
				//scambia riga p con j
				double [] tmp=a[j]; a[j]=a[p]; a[p]=tmp;
				contaScambi++;
			}//pivoting
			//azzera elementi sulla colonna j,dalla riga(j+1)-esima all'ultima
			for (int i=j+1;i<n;i++){
				if(!Mat.sufficientementeProssimi(a[i][j], 0D)){
					double coeff= a[i][j]/a[j][j];
					//sottrai dalla riga i-esima la riga j-esima moltiplicata per il coefficiente
					for(int k=j;k<n;k++)
						a[i][k]-=a[j][k]*coeff;
					}
			}//for interno azzeramento
		}//for esterno su j
	    //il determinante si calcola facendo:(produttoria di elementi diagonali della matrice triangolare)*(-1)^scambi effettuati
		System.out.println();
		poo.util.Mat.stampaMatrice(a);
	   double prod=1;
	   for (int i=0;i<n; i++)
		    prod*=a[i][i];
	  if( contaScambi%2!=0 )//x � il contatore di scambi che viene fatto nel metodo triangolazione della classe Gauss se � pari essendo la base '-1' se lo eleviamo per un numero pari corrisponde a fare (-1*-1)
		  prod=prod*(-1);
	return prod;	   
	}//determinante
	public static double [] [] scambiaRighe (double [] [] M, double [] V, int i) {
		if (i<0 || i>M.length)throw new IndexOutOfBoundsException (); 
		for (int j=0; j<M.length; j++)
			M[i][j]=V[j];
		return M;
	}//scambiaRighe
	public static double [] [] scambiaColonne (double [][] M, double [] V, int j) {
		if (j<0 || j>M[0].length) throw new IndexOutOfBoundsException ();
		for (int i=0; i<M.length; i++)
			M[i][j]=V[i];
		return M;
	}//scambiaColonne
	public static boolean uguali (double [] [] M, double [] [] M1) {
		if (M.length!=M1.length || M[0].length!=M1[0].length) return false; 
		for (int i=0; i<M.length; i++)
			for (int j=0; j<M[0].length; j++)
				if (M[i][j]==M1[i][j])
					return true;
		return false;
	}//uguali
	public static boolean identit (double [][] M) {
		for (int i=0; i<M.length; i++)
			if (M[i][i]==1)
				return true;
		for (int i=1; i<M.length; i++)
			for (int j=0; j<M[0].length; j++)
				if (M[j][i]==0 && M[i][j]==0)
					return true;
		return false;
	}//identit
}//Matrice class