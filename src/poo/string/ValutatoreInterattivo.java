package poo.string;
import java.util.*;
public class ValutatoreInterattivo {
	public static void main (String [] args) {
		Scanner sc=new Scanner (System.in);
		for (;;) {
			System.out.print('>');
			String linea =sc.nextLine ();
			if (linea.equals(".")) // si può scrivere anche come: if (linea.charAt(0)=='.')
				break;
			StringTokenizer st=new StringTokenizer (linea, "+-*/", true); //con l'aggiunta di questo terzo parametro mi ritorna anche il terminatore
			int ris=valutaEspressione(st);
			System.out.println(ris);
		}
		System.out.println("Grazie per aver usato il nostro programma.");
	}//main
	static int valutaOperando (StringTokenizer st) {
		String tk=st.nextToken ();
		return Integer.parseInt(tk);
	}
	static int valutaEspressione (StringTokenizer st) {
		int esito=valutaOperando(st);
		while (st.hasMoreTokens()) {
			char op=st.nextToken().charAt(0);
			int opnd=valutaOperando(st);
			switch (op) {
			case ('+') :esito +=opnd; break;
			case ('-') :esito-=opnd; break;
			case ('*') :esito*=opnd; break;
			default:esito/=opnd; 
			}//switch
		}//while
		return esito;
	}//valutaEspressione
}//class ValutatoreInterattivo
