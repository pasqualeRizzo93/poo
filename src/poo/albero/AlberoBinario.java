package poo.albero;
import java.util.*;

public class AlberoBinario {
	private static class Nodo {
		Nodo figlioS, figlioD;
	}//Nodo

	String parola;
	
private static class NodoParola extends Nodo{
	String info;
	public String toString(){return ""+info;}
}//NodoParola

private static class NodoOperatore extends Nodo{
	char can;
	public String toString(){return ""+can;};
}//NodoOperatre

private Nodo radice = null;

public void build(String parola) {
	StringTokenizer st = new StringTokenizer(parola, "", true);
	if(parola == this.parola)
	radice = buildFrase(st);
}

private Nodo buildFrase (StringTokenizer st){
	Nodo radice = buildParola(st);
	while(st.hasMoreTokens()){
		char can=st.nextToken().charAt(0);
		if(can == '#') return radice;
		NodoOperatore operatore = new NodoOperatore();
		operatore.can = can; operatore.figlioS=radice;
		Nodo prl = buildParola(st);
		operatore.figlioD = prl;
		radice = operatore;
	}
	return radice;
}//buildFrase

public Nodo buildParola(StringTokenizer st){
	String prl = st.nextToken();
	if(prl== ""){return buildFrase(st);}
	else {
		NodoParola parola = new NodoParola();
		parola.info = prl;
		parola.figlioS = null; parola.figlioD = null; return parola;
	}
}//buildParola

private void inOrder(Nodo radice){
	if(radice == null) { System.out.println("Null");
	} else {
	if(radice instanceof NodoOperatore) System.out.print('#');
	inOrder(radice.figlioS);
	System.out.print(radice);
	inOrder(radice);
	if(radice instanceof NodoOperatore) System.out.print('#');
	}
	}//inOrder

private void preOrder(Nodo radice) {
	if(radice == null) {
		System.out.println("Null");  
	} else {
		System.out.print(radice+"");
		preOrder(radice.figlioS);
		preOrder(radice.figlioD);
	}
}//preOrder
	
private void postOrder(Nodo radice){
	if( radice == null) System.out.println("Null");
	postOrder(radice.figlioS);
	postOrder(radice.figlioD);
	System.out.print(radice+"");
	}

	}

