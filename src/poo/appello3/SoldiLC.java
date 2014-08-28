package poo.appello3;

import java.util.*;

public class SoldiLC extends SoldiAbstract {

	private static class Nodo<E> {
		E info;
		Nodo<E> next;
	}// Nodo

	private Nodo<Denaro> testa = null, coda = null;

	@Override
	public Iterator<Denaro> iterator() {

		return new MioIteratore();
	}// iterator

	@Override
	public void add(Denaro d) {
		Nodo<Denaro> nuovo = new Nodo<Denaro>();
		nuovo.info = d;

		if (testa == null || testa.info.compareTo(d) >= 0) {
			nuovo.next = testa;
			if (testa == null)
				coda = nuovo;
			testa = nuovo;
		}// inserimento in testa
		else if (coda.info.compareTo(d) <= 0) {
			nuovo.next = null;
			coda.next = nuovo;
			coda = nuovo;
		}// inserimento in coda
		else {// inserimento dopo il primo e prima dell ultimo
			Nodo<Denaro> cor = testa.next, pre = testa;
			while (cor != null && cor.info.compareTo(d) < 0) {
				pre = cor;
				cor = cor.next;
			}
			// inserimento di nuovo tra pre e cor
			nuovo.next = cor;
			pre.next = nuovo;
		}

	}// add(Denaro)

	@Override
	public void add(Soldi s) {
		for (Denaro d : s)
			this.add(d);

	}// add(Soldi)

	private class MioIteratore implements Iterator<Denaro> {

		Nodo<Denaro> cor = null, pre = null;

		@Override
		public boolean hasNext() {
			if (cor == null)
				return testa != null;
			return cor.next != null;
		}// hashNext

		@Override
		public Denaro next() {
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

}// SoldiLC
