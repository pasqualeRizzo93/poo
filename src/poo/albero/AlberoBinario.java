package poo.albero;
import java.util.*;

public class AlberoBinario {
	private static class Nodo<E> {
	E info;
	Nodo<E> figlioS, figlioD;
	}
	
private Nodo<String> radice = null;

public void build(String s) {
	StringTokenizer st = new StringTokenizer(s,"#");
	String parola;
	while(st.hasMoreTokens()) {
		
		parola = st.nextToken();
		this.add(radice, parola);
	}
}

private void add(Nodo<String> n,String parola) {
	if(n == null) {
		n.info = parola;
	} else {
		if(n.figlioS  == null) {
			this.add(n.figlioS, parola);
		} else if(n.figlioD == null) {
			this.add(n.figlioD, parola);
		} else if(n.figlioS != null && n.figlioD!= null) {
			this.add(n.figlioS, parola);
		}
	}
}

public String preOrder() {
	String risultato = preOrder(radice);
	return risultato;
}

private String preOrder(Nodo<String> radice){
	String risultato = "";
	if(radice!= null){
		risultato = radice.info+"#";
		preOrder(radice.figlioS);
		preOrder(radice.figlioD);
	}
	return risultato;
}

}
