package poo.util;
import java.util.*;

public interface Lista<T> extends Iterable<T> {
	int size();
	void clear();
	void addFirst(T elem);
	void addLast(T elem);
	T getFirts();
	T getLast();
	T removeFirst();
	T removeLast();
	boolean isEmpty();
	boolean isFull();
	void sort(Comparator<T> c);
	ListIterator<T> listIterator();
	ListIterator<T> listIterator(int start);
}//Lista
