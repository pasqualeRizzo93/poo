package poo.util;

import java.util.*;

public abstract class StackAstratto<T> implements Stack<T>{
	public int size(){
		int c=0;
		for( Iterator<T> it=iterator();  it.hasNext(); it.next(), c++ );
		return c;
	}//size
	public void clear(){
		while( !this.isEmpty() ) this.pop();
	}//clear
	public T top(){
		Iterator<T> it=iterator();
		if( !it.hasNext() ) 
			throw new RuntimeException("Stack vuoto!");
		T elem=it.next();
		return elem;
	}//top
	public T pop(){
		Iterator<T> it=iterator();
		if( !it.hasNext() ) 
			throw new RuntimeException("Stack vuoto!");
		T elem=it.next();
		it.remove();
		return elem;
	}//pop	
	public boolean isEmpty(){
		return !iterator().hasNext();
	}//isEmpty
	public boolean isFull(){ return false; }
	public String toString(){
		StringBuffer sb=new StringBuffer(100);
		sb.append('[');
		Iterator<T> it=iterator();
		while( it.hasNext() ){
			sb.append( it.next() );
			if( it.hasNext() ) sb.append(',');
		}
		sb.append(']');
		return sb.toString();
	}//toString
	@SuppressWarnings("unchecked")
	public boolean equals( Object o ){
		if( !(o instanceof Stack) ) return false;
		if( o==this ) return true;
		Stack<T> s=(Stack)o;
		if( s.size()!=this.size() ) return false;
		Iterator<T> it1=this.iterator();
		Iterator<T> it2=s.iterator();
		while( it1.hasNext() ){
			T e1 = it1.next();
			T e2 = it2.next();
			if( !e1.equals(e2) ) return false;
		}//while
		return true;
	}//equals	
	public int hashCode(){
		int p=43, h=0;
		for( T e: this )
			h=h*p+e.hashCode();
		return h;	
	}//hashCode
}//StackAstratto