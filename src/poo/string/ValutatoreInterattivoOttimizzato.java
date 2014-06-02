package poo.string;
import java.util.*;
public class ValutatoreInterattivoOttimizzato {
	@SuppressWarnings("resource")
	public static void main (String [] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("Questo è un valutatore di espressioni. Sono ammessi i seguenti operandi: + - * /; per terminare il programma inserire un punto.");
		System.out.println("Per rispettare l'ordine delle operazioni sono ammesse sotto-espressioni con l'introduzione di parentesi tonde.");
		System.out.println("Vengono ignorati eventuali errori se le espressioni sono scritte in modo scorretto.");
		for (;;) {
			System.out.print('>');
			String linea =sc.nextLine ();
			if (linea.equals(".")) // si può scrivere anche come: if (linea.charAt(0)=='.')
				break;
			StringTokenizer st=new StringTokenizer (linea, "+-*/()", true); //con l'aggiunta di questo terzo parametro mi ritorna anche il terminatore
			int ris=valutaEspressione(st);
			System.out.println(ris);
		}
		System.out.println("Grazie per aver usato il nostro programma.");
	}//main
	static int valutaOperando (StringTokenizer st) {
		String tk=st.nextToken ();
		if (tk.equals("(")) {
			System.out.println("parentesi eseguita!");
			return valutaEspressione (st);
		}
		else 
			return Integer.parseInt(tk);
	}//valutaOperando
	static int valutaEspressione (StringTokenizer st) {
		int esito=valutaOperando (st);
		while (st.hasMoreTokens()) {
			char op=st.nextToken ().charAt(0);
			if (op==')') return esito;
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
}//class ValutatoreInterattivoOttimizzato