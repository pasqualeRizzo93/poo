package poo.util;

import java.util.*;

public class ListaConcatenata<T> extends ListaAstratta<T> {

    private static class Nodo<E> {
	E info;
	Nodo<E> next, prior;
    }

    private Nodo<T> testa, coda;

    public ListaConcatenata() {
	testa = null;
	coda = null;
    }// costruttore

    @Override
    public void addFirst(T elem) {
	Nodo<T> nuovo = new Nodo<T>();
	nuovo.info = elem;
	nuovo.next = testa;
	nuovo.prior = null;
	testa = nuovo;
	if (coda == null)
	    coda = nuovo;
	// ti eri scordato il piu importante. sotto commentato vedi quello che
	// avevi scritto tu

	// Nodo<T> nuovo = new Nodo<T>();
	// nuovo.info = elem;
	// nuovo.next = testa;
	// nuovo.prior = null;
    }// addFirst ??

    public void addLast(T elem) {

	Nodo<T> nuovo = new Nodo<T>();
	nuovo.info = elem;
	nuovo.next = null;
	coda.next = nuovo;
	nuovo.prior = coda;
	coda = nuovo;
	if (testa == null)
	    testa = nuovo;
	// non ho capito cosa avevi fatto. sotto commentato vedi quello che
	// avevi scritto tu
	// Nodo<T> nuovo = new Nodo<T>();
	// Nodo<T> current = testa.next;
	// nuovo.info = elem;
	// nuovo.next = null;
	// nuovo.prior = current;

    }// addLast ??

    @Override
    public ListIterator<T> listIterator() {
	return new IteratoreDiLista();
    }

    @Override
    public ListIterator<T> listIterator(int start) {
	return new IteratoreDiLista(start);
    }

    private class IteratoreDiLista implements ListIterator<T> {
	private Nodo<T> cur, pre, suc;
	private int verso; // 1 verso positivo in avanti , -1 verso negativo
			   // torno indietro
	private boolean rimuovibile = false;
	// ti serve ovviamente mantenere un indici
	private int indice;

	public IteratoreDiLista() {
	    cur = null;
	    pre = null;
	    suc = null;
	    verso = 1;
	    indice = 0;
	}// costruttore

	public IteratoreDiLista(int start) {
	    if (start < size())
		throw new IllegalArgumentException();
	    int c = 0;
	    while (hasNext() && c < start) {
		cur = cur.next;
		c++;
	    }
	    pre = null;
	    suc = null;

	}// 2° costruttore

	public boolean hasNext() {
	    if (cur == null)
		return testa != null;
	    return cur.next != null;
	}// hasNext

	public T next() {
	    if (!hasNext())
		throw new NoSuchElementException();
	    rimuovibile = true;
	    if (cur == null)
		cur = testa;
	    else
		cur = cur.next;
	    if (verso != 1)
		verso = 1;
	    indice++;
	    return cur.info;
	}// next

	public boolean hasPrevious() {
	    return cur.prior != null;
	}// hasPrevious

	public T previous() {
	    if (!hasPrevious())
		throw new NoSuchElementException();
	    rimuovibile = true;
	    suc = cur;
	    cur = cur.prior;
	    if (verso != -1)
		verso = -1;
	    indice--;
	    return cur.info;
	}// previous

	public void add(T elem) {
	    if (cur == null) {
		addFirst(elem);
		cur = testa;// ?non sono sicuro
	    } else {
		Nodo<T> nuovo = new Nodo<T>();
		nuovo.info = elem;
		nuovo.next = cur.next;
		nuovo.prior = cur;
	    }
	}// add

	public void remove() {
	    if (!rimuovibile)
		throw new IllegalStateException();
	    rimuovibile = false;
	    if (cur == testa) {
		removeFirst();
	    } else if (cur == coda) {
		removeLast();
	    } else {
		cur.prior.next = cur.next;
		// ovviamente mancava l'altro puntatore
		cur.next.prior = cur.prior;
		indice--;
	    }
	}// remove

	public void set(T elem) {
	    if (!rimuovibile)
		throw new IllegalStateException();
	    rimuovibile = false;
	    cur.info = elem;
	}// set

	public int nextIndex() {
	    return indice + 1;
	}// nextIndex()

	public int previousIndex() {
	    return indice - 1;
	}// previousIndex
    }// IteratoreDiLista ???????

}// ListaConcatenata
