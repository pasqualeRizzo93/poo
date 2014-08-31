package poo.num;

import java.util.*;

public class NumeroLista extends NumeroAstratto {

	private class Nodo<E>{
		E info;
		Nodo<E>next;
	}//Nodo
	
	Nodo<Cifra> testa,coda;
	
	public NumeroLista(){
		testa=null; coda=null;
	}//costruttore
	
	@Override
	protected NumeroLista create() {
		return new NumeroLista();
	}

	@Override
	public void cambiaSegno() {
		Cifra c=new Cifra(-(coda.info.getCifra()));
		coda.info=c;

	}
	
	@Override
	public Iterator<Cifra> iterator() {

		return new MioIteratore();
	}// iterator

	@Override
	public void add(Cifra d) {
		Nodo<Cifra> nuovo=new Nodo<Cifra>();
		nuovo.info=d;
		nuovo.next=null;
		if( coda==null ) testa=nuovo;
		else coda.next=nuovo;
		coda=nuovo;
	}//add


	private class MioIteratore implements Iterator<Cifra> {

		Nodo<Cifra> cor = null, pre = null;

		@Override
		public boolean hasNext() {
			if (cor == null)
				return testa != null;
			return cor.next != null;
		}// hashNext

		@Override
		public Cifra next() {
			if (!hasNext())
				throw new NoSuchElementException();
			if (cor == null) {
				cor = testa;
			} else {
				pre = cor;
				cor = cor.next;
			}
			return cor.info;
		}// next

		@Override
		public void remove() {
			if (cor == pre)
				throw new IllegalStateException();
			if (cor == testa) {
				testa = testa.next;
				if (testa == null)
					coda = null;
			} else if (cor == coda) {
				coda = pre;
				coda.next = null;
			} else {
				pre.next = cor.next;
			}
				cor = pre;
			
		}// remove

	}


	}

