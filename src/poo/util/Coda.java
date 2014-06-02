package poo.util;

public interface Coda<T> extends Iterable<T>{
	public int size();
	public void clear();
	public void put( T elem );
	public T get();
	public T peek();
	public boolean isEmpty();
	public boolean isFull();
}//Coda
