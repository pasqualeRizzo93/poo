package poo.util;

import java.util.*;

public class StackConcatenato<T> extends StackAstratto<T>{
	private static class Nodo<E>{
		E info;
		Nodo<E> next;
	}//Nodo
	private Nodo<T> testa=null;
	private int size;
	public void clear(){
		testa=null; size=0;
	}//clear
	@Override
	public void push( T x ){
		Nodo<T> n=new Nodo<T>();
		n.info=x; n.next=testa;
		testa=n; size++;
	}//push
	public T pop(){
		if( testa==null )
			throw new RuntimeException("Stack empty!");
		T e=testa.info;
		testa=testa.next;
		size--;
		return e;
	}//pop
	@Override
	public int size(){ return size; }
	public Iterator<T> iterator(){ return new StackIterator(); }
	private class StackIterator implements Iterator<T>{
		private Nodo<T> cor=null, pre=null;
		public boolean hasNext(){
			if( cor==null ) return testa!=null;
			return cor.next!=null;
		}//hasNext
		public T next(){
			if( !hasNext() ) 
				throw new NoSuchElementException();
			if( cor==null ) cor=testa;
			else{ pre=cor; cor=cor.next; }
			return cor.info;
		}//next
		public void remove(){
			if( cor==pre ) throw new IllegalStateException();
			if( cor==testa ) testa=testa.next;
			else pre.next=cor.next;
			cor=pre; size--;
		}//remove
	}//StackIterator
}//Stack