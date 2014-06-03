package poo.util;

import java.util.*;

public class LinkedVector<T> extends VectorAstratto<T> {

	private LinkedList<T> list;

	public LinkedVector() {
		this.list = new LinkedList<T>();
	}

	@Override
	public Iterator<T> iterator() {
		return this.list.iterator();
	}

	@Override
	public void add(T elem) {

		list.add(elem);

	}

	@Override
	public Vector<T> subVector(int da, int a) {
		return null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(200);
		sb.append('[');
		ListIterator<T> lit = list.listIterator();
		while ( lit.hasNext()) {
			sb.append(lit.next());
		}
		sb.append(']');
		return sb.toString();
	}// toString

	public static void main(String[] args) {
		Vector<String> prova = new LinkedVector<String>();
		prova.add(" 1 ");
		prova.add(" 2 ");
		System.out.println(prova);
		prova.set(1, " set ");
		System.out.println(prova);
		prova.add(" 3 ");
		prova.add(" 4 ");
		prova.remove(" 4 ");
		prova.remove(1);
		prova.add(1, " conferma ");
		System.out.println(prova);
	}// main
}
