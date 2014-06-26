package poo.esempi_libro;
import java.util.*;
public class Cambio2 {
	private double valutaEuroDollari=1.30;
	private double valutaEuroLire=1936.27;
	private double valutaEuroSterline=0.8484;
	private double valutaDollariSterline=0.6521;
	public static final int euroDollari=0, euroLire=1, euroSterline=2, dollariSterline=3;
	public double get (int cosa) {
		switch (cosa) {
		case euroDollari: return valutaEuroDollari;
		case euroLire: return valutaEuroLire;
		case euroSterline: return valutaEuroSterline;
		case dollariSterline: return valutaDollariSterline;
		default: return -1;
		}
	}//get
	
	public static void main (String [] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("Questo � un programma convertitore di moneta.");
		System.out.println("Per il cambio euro-dollari usare premere il tasto 1;");
		System.out.println("per il cambio euro-lire premere 2;");
		System.out.println("per il cambio euro-sterline premere 3;");
		System.out.println("per il cambio dollari-sterline premere 4.");
		for (;;) {
			System.out.print('>');
			String linea =sc.nextLine ();
			if (linea.equals(".")) 
				break;
			StringTokenizer st=new StringTokenizer (linea, "�$�", true);
			int risultato=valutaCambio(st);
			System.out.println(risultato);
		}		
		System.out.println("Grazie per aver usato il nostro programma!");
	}//main
	static int valutaCambio (StringTokenizer st) {
		int cambio=valutaMoneta (st);
		int iniziale=0;
		while (st.hasMoreTokens()) {
			char op=st.nextToken ().charAt(0);
			iniziale=valutaMoneta(st);
			switch (op) {
//			case ('�') :iniziale/=cambio; break;
			case ('$') :iniziale/=cambio; break;
		
			default: return -1; 
			}//switch
		}//while
		return iniziale;
	}//valutaCambio
	static int valutaMoneta (StringTokenizer st) {
		String tk=st.nextToken ();
		if (tk.equals("("))
			return valutaCambio (st);
		else 
			return Integer.parseInt(tk);
	}
}
