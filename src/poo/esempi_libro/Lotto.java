package poo.esempi_libro;
public class Lotto {
	public static void main (String... args) {
		int n=90;
		int k=5;
		long disposizioni=disposizioniSemplici(n,k);
		int permutazioni=fattoriale(k);
		long combinazioni=disposizioni/permutazioni;
		System.out.println("Probabilità di una cinquina "+"1/ "+combinazioni+"= "+1f/combinazioni);
	}//main
	static long disposizioniSemplici (int n, int k) {
		long disp=1;
		for (int h=n; h>=n-k+1; h--)
			disp*=h;
		return disp;
	}//disposizioniSemplici
	static int fattoriale (int n) {
		int fatt=1;
		for (int h=n; h>=2; h--)
			fatt*=h;
		return fatt;
	}//fattoriale
}//Lotto class
