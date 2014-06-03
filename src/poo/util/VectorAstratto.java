package poo.util;

import java.util.*;

public abstract class VectorAstratto<T> implements Vector<T> {
	public int size() {
		int c = 0;
		for (Iterator<T> it = iterator(); it.hasNext(); it.next(), c++)
			;
		return c;
	}// size

	public int indexOf(T elem) {
		Iterator<T> it = iterator();
		int c = 0;
		while (it.hasNext()) {

			T current = it.next();
			if (current.equals(elem))
				return c;
			c++;
		}
		return -1;
	}// indexOf

	public void remove(T elem) {
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			T current = it.next();
			if (current.equals(elem))
				it.remove();
		}
	}// remove

	public T remove(int indice) {
		Iterator<T> it = iterator();
		int c = 0;
		while (it.hasNext() && c < indice) {
			T current = it.next();
			c++;
			if (c == indice) {
				it.remove();
				return current;
			}
		}
		return null;
	}// T remove

	public void clear() {
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			T current = it.next();
			current = null;
		}
	}// clear

	public boolean contains(T elem) {
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			T current = it.next();
			if (current.equals(elem)) {
				return true;
			}
		}
		return false;
	}// contains

	public T get(int indice) {
		Iterator<T> it = iterator();
		int c = 0;
		while (it.hasNext() && c < indice) {
			T current = it.next();
			c++;
			if (c == indice) {
				return current;
			}
		}
		return null;
	}// get

	public boolean isEmpty() {
		return !iterator().hasNext();
	}// isEmpty

	public void add(int indice, T elem) {
		Iterator<T> it = iterator();
		int c = 0;
		while (it.hasNext() && c < indice) {
			it.next();
			c++;
			if (c == indice) {
				add(elem);
			}
		}
	}

	public abstract void add(T elem);

	public T set(int indice, T elem) {
		Iterator<T> it = iterator();
		int c = 0;
		while (it.hasNext() && c < indice) {
			T current = it.next();
			c++;
			if (c == indice) {
				it.remove();
				add(indice, elem);
				return current;
			}
		}
		return null;
	}// set

	public abstract Vector<T> subVector(int da, int a);
}// VectorAstratto
