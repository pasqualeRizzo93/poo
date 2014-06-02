package poo.util;

import java.util.*;

public class StackArray<T> extends StackAstratto<T>{
	private int size=0;
	private T[] array;
	@SuppressWarnings("unchecked")
	public StackArray( int n ){
		if( n<=0 ) throw new IllegalArgumentException();
		array=(T[]) new Object[n];
	}
	public void clear(){
		for( int i=0; i<size; ++i ) array[i]=null;
		size=0;
	}//clear
	@Override
	public void push( T x ){
		if( size==array.length ) throw new RuntimeException("Stack full!");
		array[size]=x;
		size++;
	}//push
	public T pop(){
		if( isEmpty() )
			throw new RuntimeException("Stack empty!");
		size--;
		T e= array[size]; array[size]=null;
		return e;
	}//pop
	@Override
	public int size(){ return size; }//size
	@Override
	public boolean isFull(){
		return size==array.length;
	}//isFull
	@Override
	public Iterator<T> iterator(){ return new StackIterator(); }
	private class StackIterator implements Iterator<T>{
		private int cor=size;
		private boolean rimuovibile=false;
		public boolean hasNext(){ 
			return cor>0; 
		}//hasNext
		public T next(){
			if( !hasNext() ) throw new NoSuchElementException();
			cor--;
			rimuovibile=true;
			return array[cor];
		}//next
		public void remove(){
			if( !rimuovibile ) throw new IllegalStateException();
			rimuovibile=false;
			for( int i=cor; i<size-1; ++i )
				array[i]=array[i+1];
			size--; array[size]=null;
		}//remove
	}//StackIterator
}//StackArray