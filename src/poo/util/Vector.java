package poo.util;

public interface Vector<T> extends Iterable<T> {
	int size ();
	void clear ();
	void add (T elem);
	void add (int i, T elem);
	int indexOf (T elem);
	boolean contains (T elem);
	T get (int indice);
	T set (int indice, T elem);
	void remove (T elem);
	T remove (int indice);
	Vector<T> subVector (int da, int a);
	boolean isEmpty ();
	
}
