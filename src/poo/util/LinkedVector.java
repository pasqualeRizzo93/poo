package poo.util;

import java.util.*;

public class LinkedVector<T> extends VectorAstratto<T> {

	private LinkedList<T> list;
	public LinkedVector(){
		this.list=new LinkedList<T>();
	}
	@Override
	public Iterator<T> iterator() {
		return this.list.iterator();
	}

	@Override
	public void add(int indice, T elem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(T elem) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<T> subVector(int da, int a) {
		// TODO Auto-generated method stub
		return null;
	}

}
