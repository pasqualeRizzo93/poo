package poo.appello_espr;

import java.util.*;

public class MemoriaConcatenata extends MemoriaAstratta {

	private static class Nodo<E> {
		E info;
		Nodo<E> next;
	}// Nodo

	private Nodo<Variabile> first = null, last = null;

	@Override
	public void add(Variabile v) {
		Nodo<Variabile> nuovo = new Nodo<Variabile>();
		nuovo.info = v;

		if (first == null || first.info.compareTo(v) >= 0) {
			nuovo.next = first;
			if (first == null)
				last = nuovo;
			first = nuovo;
		}// inserimento in testa
		else if (last.info.compareTo(v) <= 0) {
			nuovo.next = null;
			last.next = nuovo;
			last = nuovo;
		}// inserimento in coda
		else {// inserimento dopo il primo e prima dell ultimo
			Nodo<Variabile> cor = first.next, pre = first;
			while (cor != null && cor.info.compareTo(v) < 0) {
				pre = cor;
				cor = cor.next;
			}
			// inserimento di nuovo tra pre e cor
			nuovo.next = cor;
			pre.next = nuovo;
		}

	}// add

	@Override
	public void remove(Variabile v) {
		Nodo<Variabile> cor = first, pre = null;
		while (cor != null && cor.info.compareTo(v) < 0) {
			pre = cor;
			cor = cor.next;
		}
		if (cor != null && cor.info.equals(v)) {
			if (cor == first) {
				first = first.next;
				if (first == null)
					last = null;
			} else if (cor == last) {
				last = pre;
				last.next = null;
			} else {
				pre.next = cor.next;
			}
		}
	}// remove

	@Override
	public Iterator iterator() {
		return new Iteratore();
	}// iterator

	private class Iteratore implements Iterator {
		private Nodo<Variabile> cor = null, pre = null;

		public boolean hasNext() {
			if (cor == null)
				return first != null;
			return cor.next != null;
		}// hasNext

		public Variabile next() {
			if (!hasNext())
				throw new NoSuchElementException();
			if (cor == null)
				cor = first;
			else {
				pre = cor;
				cor = cor.next;
			}
			return cor.info;
		}//next
		
		public void remove(){
			if(pre==cor) throw new IllegalStateException();
			if(cor==first){
				first=first.next;
				if(first==null)last=null;
			}
			else if(cor==last){last=pre;last.next=null;}
			else{
				pre.next=cor.next;}
			cor=pre;
			}//remove
		}//Iteratore
	}//MemoriaConcatenata


