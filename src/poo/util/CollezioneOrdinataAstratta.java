package poo.util;

import java.util.*;

public abstract class 
CollezioneOrdinataAstratta<T extends Comparable<? super T>> 
implements CollezioneOrdinata<T>{
	public int size(){
		int c=0;
		for(T e: this) c++;
		return c;
	}//size
	public void clear(){
		Iterator<T> i=this.iterator();
		while( i.hasNext() ) {
			i.next();
			i.remove();
		}		
	}//clear
	public boolean contains( T elem ){
		for(T e: this){
			if( e.equals(elem) ) return true;
			if( e.compareTo(elem)>0 ) return false;
		}
		return false;
	}//contains
	public boolean isEmpty(){
		return !iterator().hasNext();
	}//isEmpty
	public boolean isFull(){
		return false;	
	}//isFull
	public T get( T elem ){
		for( T x: this ){
			if( x.equals(elem) ) return x;
			if( x.compareTo(elem)>0 ) return null;
		}
		return null;
	}//get
	public abstract void add( T elem );
	public void remove( T elem ){
		Iterator<T> it=this.iterator();
		while( it.hasNext() ){
			T e=it.next();
			if( e.equals( elem ) ){
				it.remove();
				break;
			}
		}
	}//remove
	@SuppressWarnings("unchecked")
	public boolean equals( Object o ){
		if( !(o instanceof CollezioneOrdinata) ) return false;
		if( o==this ) return true;
		CollezioneOrdinata<T> s=(CollezioneOrdinata<T>)o;
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
		int p=43;
		int h=0;
		for( T e: this )
			h=h*p+e.hashCode();
		return h;	
	}//hashCode	
	public String toString(){
		StringBuilder sb=new StringBuilder(200);
		sb.append('[');
		Iterator<T> it=iterator();
		while( it.hasNext() ){
			sb.append( it.next() );
			if( it.hasNext() ) sb.append(',');
		}
		sb.append(']');
		return sb.toString();
	}//toString
}//CollezioneOrdinataAstratta
