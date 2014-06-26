package poo.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class ListaAstratta<T> implements Lista<T> {

    @Override
    public Iterator<T> iterator() {

	return null;
    }

    @Override
    public int size() {
	int c = 0;
	for (T e : this)
	    c++;
	return c;
    }// size

    @Override
    public void clear() {
	ListIterator<T> lit = this.listIterator();
	while (lit.hasNext()) {
	    lit.next();
	    lit.remove();
	}
    }// clear

    @Override
    public void addFirst(T elem) {

    }

    @Override
    public void addLast(T elem) {

    }

    @Override
    public T getFirts() {
	ListIterator<T> lit = this.listIterator();
	if (lit.hasNext())
	    return lit.next();
	return null;
    }// getFirst

    @Override
    public T getLast() {
	ListIterator<T> lit = this.listIterator();
	while (lit.hasNext()) {
	    lit.next();
	}
	if (!lit.hasNext()) {
	    return lit.previous();
	} else {
	    return null;
	}
    }// getLast

    @Override
    public T removeFirst() {
	ListIterator<T> lit = this.listIterator();
	T elem;
	if (lit.hasNext()) {
	    elem = lit.next();
	    lit.remove();
	    return elem;
	} else {
	    return null;
	}
    }// removeFirst

    @Override
    public T removeLast() {
	ListIterator<T> lit = this.listIterator();
	T elem;
	while (lit.hasNext()) {
	    lit.next();
	}
	if (!lit.hasNext()) {
	    elem = lit.previous();
	    lit.remove();
	    return elem;
	} else {
	    return null;
	}
    }// removeLast

    @Override
    public boolean isEmpty() {
	return !listIterator().hasNext();
    }

    @Override
    public boolean isFull() {
	return false;
    }

    @Override
    public void sort(Comparator<T> c) {

    }

    @Override
    public ListIterator<T> listIterator(int start) {

	return null;
    }

}
