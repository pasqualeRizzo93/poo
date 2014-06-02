package poo.util;

import java.util.*;

public abstract class CodaAstratta<T> implements Coda<T>{
	public int size(){
		int c=0;
		for( Iterator<T> it=iterator(); it.hasNext(); it.next(), c++ );
		return c;
	}//size
	public void clear(){
		while( !isEmpty() ) this.get();
	}//clear
	public T peek(){
		if( isEmpty() )
			throw new RuntimeException("Coda vuota!");
		return iterator().next();
	}//peek
	public T get(){
		if( isEmpty() )
			throw new RuntimeException("Coda vuota!");
		Iterator<T> it=iterator();
		T e=it.next();
		it.remove();
		return e;
	}//get	
	public boolean isEmpty(){
		return !iterator().hasNext();
	}//isEmpty
	public boolean isFull(){
		return false;
	}//isFull
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
	public int hashCode(){
		int p=43, h=0;
		for( T e: this )
			h=h*p+e.hashCode();
		return h;	
	}//hashCode	
	public boolean equals( Object o ){
		if( !(o instanceof Coda) ) return false;
		if( o==this ) return true;
		Coda<T> s=(Coda)o;
		if( s.size()!=this.size() ) return false;
		Iterator<T> it1=this.iterator();
		Iterator<T> it2=s.iterator();
		while( it1.hasNext() ){
			T e1 = it1.next(), e2 = it2.next();
			if( !e1.equals(e2) ) return false;
		}//while
		return true;
	}//equals	
}//CodaAstratta
