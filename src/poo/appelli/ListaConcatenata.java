package poo.appelli;

import java.util.*;

public class ListaConcatenata<T> extends ListaAstratta<T> {

	private static class Nodo<E> {
		E info;
		Nodo<E> next;
	}

	private Nodo<NominativoS> testa;

	public ListaConcatenata() {
		testa = null;
	}// costruttore

	@Override
	public void add(NominativoS n) {
		Nodo<NominativoS> nuovo = new Nodo<NominativoS>();
		nuovo.info = n;
		nuovo.next = testa;
		testa = nuovo;
	}// add

	@Override
	public void sort(Comparator<NominativoS> c) {
		Nodo<NominativoS> n1, n2, tmp = new Nodo<NominativoS>();
		for (n1 = testa; n1.next != null; n1 = n1.next) {
			boolean scambi = false;
			for (n2 = testa; n2.next != null; n2 = n2.next) {
				if (c.compare(n2.info, n2.next.info) > 0) {
					tmp.info = n2.info;
					n2.info = n2.next.info;
					n2.next.info = tmp.info;
					scambi = true;
				}
			}
			if (!scambi)
				break;
		}
	}// sort(Comparator)

	@Override
	public void sort() {
		Nodo<NominativoS> n1, n2, tmp = new Nodo<NominativoS>();
		for (n1 = testa; n1.next != null; n1 = n1.next) {
			boolean scambi = false;
			for (n2 = testa; n2.next != null; n2 = n2.next) {
				if (n2.info.compareTo(n2.next.info) > 0) {
					tmp.info = n2.info;
					n2.info = n2.next.info;
					n2.next.info = tmp.info;
					scambi = true;
				}
			}
			if (!scambi)
				break;
		}
	}// sort()

	@Override
	public Iterator<NominativoS> iterator() {
		return new MioIteratore();
	}// iterator

	private class MioIteratore implements Iterator<NominativoS> {
		private Nodo<NominativoS> cur;

		public MioIteratore() {
			cur = null;
		}// costruttore

		public boolean hasNext() {
			if (cur == null)
				return testa != null;
			return cur.next != null;
		}// hasNext

		public NominativoS next() {
			if (!hasNext())
				throw new NoSuchElementException();
			if (cur == null)
				cur = testa;
			cur = cur.next;
			return cur.info;
		}

		public void remove() {
			cur.next=cur.next.next;
			//però non sono sicuro
		}
	}// MioIteratore
}// ListaConcatenata
