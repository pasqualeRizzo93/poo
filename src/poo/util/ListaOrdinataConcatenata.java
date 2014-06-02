package poo.util;

import java.util.*;

public class ListaOrdinataConcatenata<T extends Comparable<? super T>> 
             extends CollezioneOrdinataAstratta<T> {

	private static class Nodo<E>{
		E info;
		Nodo<E> next;
	}//Nodo
	
	private Nodo<T> first=null, last=null;
	private int size=0;
	
	public int size(){ return size; }
	
	private class Iteratore implements Iterator<T>{
		private Nodo<T> cor=null, pre=null;
		//cor o e' null o punta all'ultimo nodo GIA' visitato
		public boolean hasNext(){
			if( cor==null ){
				return first!=null;
			}
			return cor.next!=null;
		}//hasNext
		public T next(){
			if( !hasNext() ) 
				throw new NoSuchElementException();
			if( cor==null ) cor=first;
			else{
				pre=cor;
				cor=cor.next;;
			}
			return cor.info;
		}//next
		public void remove(){
			if( pre==cor ) 
				throw new IllegalStateException();
			if( cor==first ){
				first=first.next;
				if( first==null ) last=null;
			}
			else if( cor==last ){
				last=pre;
				last.next=null;
			}
			else{
				pre.next=cor.next;
			}
			size--;
			cor=pre; //arretra cor
		}//remove
	}//Iteratore	
	
	public void add( T elem ){
		Nodo<T> nuovo=new Nodo<T>();
		nuovo.info=elem;
		if( first==null || first.info.compareTo(elem)>=0 ){
			nuovo.next=first;
			if( first==null ) last=nuovo;
			first=nuovo;
		}
		else if( last.info.compareTo(elem)<=0 ){
			nuovo.next=null;
			last.next=nuovo;
			last=nuovo;
		}
		else{//inserimento dopo il primo e prima dell'ultimo
			Nodo<T> cor=first.next, pre=first;
			while( cor!=null && cor.info.compareTo(elem)<0 ){
				pre=cor;
				cor=cor.next;
			}
			//inserimento di nuovo tra pre e cor
			nuovo.next=cor;
			pre.next=nuovo;
		}
		size++;
	}//add
	public void remove( T elem ){
		Nodo<T> cor=first, pre=null;
		while( cor!=null && cor.info.compareTo(elem)<0 ){
			pre=cor;
			cor=cor.next;
		}
		if( cor!=null && cor.info.equals(elem) ){
			if( cor==first ){
				first=first.next;
				if( first==null ) last=null;
			}
			else if( cor==last ){
				last=pre;
				last.next=null;
			}
			else{
				pre.next=cor.next;
			}
			size--;
		}
	}//remove
	
	public Iterator<T> iterator(){
		return new Iteratore();
	}//iterator

	
	public static void main( String[] args ){
		CollezioneOrdinata<String> ls=new ListaOrdinataConcatenata<String>();
		ls.add("zaino"); 
		ls.add("camicia"); 
		ls.add("maglione");
		ls.add("pioggia"); 
		ls.add("soprabito");
		ls.add("ombrello");
		ls.add("scarponi");
		System.out.println("Situazione iniziale: "+ls);
		Iterator<String> li=ls.iterator();
		while( li.hasNext() ){
			System.out.println("Situazione attuale: "+ls);
			String s=li.next();
			if( s.equals("scarponi") ){
				li.remove();
			}
		}
		System.out.println("Situazione attuale: "+ls);
	}
}//ListaOrdinataConcatenata

