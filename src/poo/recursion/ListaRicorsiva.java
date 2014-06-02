package poo.recursion;

public class ListaRicorsiva<T extends Comparable<? super T>>{
	private static class Lista<E> {
		E info;
		Lista<E> next;
	}
	private Lista<T> lr=null;
	public int size () {
		return size(lr);
	}//size public
	private int size (Lista<T> lr) {
		if(lr==null) return 0;
		return 1+size(lr.next);
	}//size private
	public int contains (T e) {
		return contains(lr,e);
	}//contains public
	private int contains (Lista<T> lr, T e) {
		if (lr==null) return 0;
		if (lr.info.equals(e)) return 1+contains(lr.next,e);
		return contains(lr.next, e);
	}//contains private
	public void clear () {
		lr=null;
	}//clear
	public void add (T e) {
		lr=add(lr, e);
	}//add public
	private Lista<T> add (Lista<T> lr, T e) {
		if (lr==null) {
			lr=new Lista<T> ();
			lr.info=e;
			lr.next=null;
			return lr;
		}
		if (lr.next==null) { 
			Lista<T> nuovo=new Lista<T> ();
			nuovo.info=e;
			nuovo.next=null;
			return nuovo;
		}
		return add(lr.next, e);
	}//add private
	public void removeAll (T e) {
		lr=removeAll(lr, e);
	}//removeAll public
	private Lista <T> removeAll (Lista<T> lr, T e) {
		if (lr==null) return lr;
		if(lr.info.equals(e)) lr=lr.next;
		return removeAll(lr.next, e);
	}//removeAll private
}//ListaRicorsiva class
