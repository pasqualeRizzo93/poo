package poo.num;

import java.util.*;

public class NumeroLista extends NumeroAstratto {

	private class Nodo<E>{
		E info;
		Nodo<E>next;
	}//Nodo
	
	Nodo<Cifra> testa,coda;
	
	@Override
	public Numero somma(Numero n) {
        Numero somma=null;
        Iterator<Cifra> it1 = this.iterator();
        Iterator<Cifra> it2 = n.iterator();
        
		return somma;
	}

	@Override
	public Numero moltiplica(Numero n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cambiaSegno() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Iterator<Cifra> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
