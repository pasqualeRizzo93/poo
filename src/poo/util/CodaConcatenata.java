package poo.util;

import java.util.*;

public class CodaConcatenata<T> extends CodaAstratta<T>{
	private static class Nodo<E>{
		E info;
		Nodo<E> next;
	}//Nodo
	private Nodo<T> inizio=null, fine=null;
	private int size=0;
	
	public int size(){ return size; }
	
	public void clear(){
		inizio=null; fine=null;
	}//clear
	
	public void put( T e ){
		Nodo<T> nuovo=new Nodo<T>();
		nuovo.info=e;
		nuovo.next=null;
		if( fine==null ) inizio=nuovo;
		else fine.next=nuovo;
		fine=nuovo;
		size++;
	}//put
	
	public T get(){
		if( isEmpty() )
			throw new RuntimeException("Coda vuota!");
		T e=inizio.info;
		inizio=inizio.next;
		if( inizio==null ) fine=null;
		size--;
		return e;
	}//get
	
	public Iterator<T> iterator(){
		return new Iteratore();
	}//iterator
	
	private class Iteratore implements Iterator<T>{
		private Nodo<T> pre=null, cor=null;
		public boolean hasNext(){
			if( cor==null ) return inizio!=null;
			return cor.next!=null;
		}//hasNext
		public T next(){
			if( !hasNext() )
				throw new NoSuchElementException();
			if( cor==null ) cor=inizio;
			else{ pre=cor; cor=cor.next; }
			return cor.info;
		}//next
		public void remove(){
			if( cor==pre )
				throw new IllegalStateException();
			if( cor==inizio ){
				inizio=inizio.next;
				if( inizio==null ) fine=null;
			}
			else if( cor==fine ){
				fine=pre; fine.next=null;
			}
			else{
				pre.next=cor.next;
			}
			cor=pre; //arretra cor
			size--;
		}//remove
	}//Iterator
	
	public static void main( String []args ){
		Coda<Integer> bb=new CodaConcatenata<Integer>();
		bb.put(1); bb.put(2); bb.put(3); bb.put(4); bb.put(5);
		System.out.println(bb);
		System.out.println("get="+bb.get());
		System.out.println("get="+bb.get());
		bb.put(6); bb.put(7);
		System.out.println(bb);
		Iterator<Integer> it=bb.iterator();
		while( it.hasNext() ){
			int x=it.next();
			if( x==4 ){ it.remove(); break; }
		}
		System.out.println("Dopo rimozione di 4 dall'iteratore : size="+bb.size());
		System.out.println(bb);
	}//demo	
	
}//CodaConcatenata
