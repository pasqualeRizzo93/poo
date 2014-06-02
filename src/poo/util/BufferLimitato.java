package poo.util;

import java.util.*;
public class BufferLimitato<T> extends CodaAstratta<T>{
	private T[] buffer;
	private int in, out, size;
	//in e' la posizione di inserimento
	//out e' la posizione di estrazione
	//size e' il numero effettivo di elementi nel buffer
	@SuppressWarnings("unchecked")
	public BufferLimitato(int n){
		if( n<=0 ) throw new IllegalArgumentException();
		buffer=(T[]) new Object[n];
		in=0; out=0; size=0;
	}
	public void clear(){
		for( int i=out; i!=in; i=(i+1)%buffer.length )
			buffer[i]=null;
		in=0; out=0; size=0;
	}//clear
	public int size(){ return size; }//size
	public boolean isFull(){
		return size==buffer.length;
	}//isFull	
	public void put( T e ){
		if( size==buffer.length )
			throw new RuntimeException("Buffer full!");
		buffer[in]=e;
		in=(in+1)%buffer.length;
		size++;
	}//put
	public T get(){
		if( size==0 )
			throw new RuntimeException("Buffer empty!");
		T e=buffer[out];
		out=(out+1)%buffer.length;
		size--;
		return e;
	}//get

	public Iterator<T> iterator(){
		return new Iteratore();
	}//iterator
	
	private class Iteratore implements Iterator<T>{
		private int cursor=-1;
		private boolean rimuovibile=false;
		public boolean hasNext(){
			if( cursor==-1 ) return size>0;
			return (cursor+1)%buffer.length != in;
		}//hasNext
		public T next(){
			if( !hasNext() )
				throw new NoSuchElementException();
			if( cursor==-1 ) cursor=out;
			else cursor=(cursor+1)%buffer.length;
			rimuovibile=true;
			return buffer[cursor];
		}//next
		public void remove(){
			if( !rimuovibile ) throw new IllegalStateException();
			int j=(cursor+1)%buffer.length;
			while( j!=in ){
				buffer[(j-1+buffer.length)%buffer.length]=buffer[j];
				j=(j+1)%buffer.length;
			}
			rimuovibile=false;
			size--; 
			in=(in-1+buffer.length)%buffer.length;
			buffer[in]=null; //svuota nuovo slot di indice in
			cursor=(cursor-1+buffer.length)%buffer.length; //arretra cursor
		}//remove
	}//Iterator
	
	public static void main( String []args ){
		BufferLimitato<Integer> bb=new BufferLimitato<Integer>(5);
		bb.put(1); bb.put(2); bb.put(3); bb.put(4); bb.put(5);
		System.out.println("size="+bb.size()+" "+bb);

		System.out.println("get="+bb.get());
		System.out.println("get="+bb.get());
		bb.put(6); bb.put(7);
		System.out.println(bb);
		Iterator<Integer> it=bb.iterator();
		while( it.hasNext() ){
			int x=it.next();
			if( x==3 ){ it.remove(); break; }
		}
		System.out.println("Dopo rimozione di 3 dall'iteratore : size="+bb.size());
		System.out.println(bb);
		//bb.clear();
		it=bb.iterator();
		while( it.hasNext() ){
			System.out.println("Rimozione in ciclo di "+it.next());
			it.remove();
		}
		System.out.println(bb+ " size="+bb.size());

	}
}//BufferLimitato

