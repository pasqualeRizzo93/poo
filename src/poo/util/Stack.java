package poo.util;

public interface Stack<T> extends Iterable<T>{
	public int size();
	public void clear();
	public void push(T elem);
	public T pop();
	public T top();
	public boolean isEmpty();
	public boolean isFull();
}//Stack