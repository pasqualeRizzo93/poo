package poo.agendina;
import java.io.*;
import java.util.*;
public class AgendinaConcatenata extends AgendinaAstratta{
	private static class Nodo{
		Nominativo info;
		Nodo next;
	}//Nodo
	private Nodo testa;
	private int size=0;
	public int size(){ return size; }
	public void svuota(){ testa=null; size=0; }
	public void aggiungi( Nominativo n ){
		if( testa==null || testa.info.compareTo(n)>0 ){
			//casi 1 e 2: inserimento in testa
			Nodo nuovo=new Nodo();
			nuovo.info=n; nuovo.next=testa;
			testa=nuovo;
			size++; //conta questa aggiunta
		}
		else{//casi 3 e 4
    		//cerca posizione di inserimento
    		Nodo cor=testa, pre=null;
    		while( cor!=null && cor.info.compareTo(n)<0 ){
				pre=cor; cor=cor.next;
			}
    		if( cor!=null && cor.info.equals(n) ){//sovrascrivi			
    			cor.info=n;
			}
    		else{
    			//inserisci nuovo Nodo tra pre e cor
    			Nodo nuovo=new Nodo();
    			nuovo.info=n; nuovo.next=cor;
    			pre.next=nuovo;
    			size++; //conta questa aggiunta
    		}
		}
    }//aggiungi
	public void rimuovi( Nominativo n ){
    	Nodo cor=testa, pre=null;
    	while( cor!=null && cor.info.compareTo(n)<0 ){
			pre=cor; cor=cor.next;
		}
    	if( cor==null || cor.info.compareTo(n)>0 ) return;
    	if( cor==testa ) testa=testa.next;
    	else pre.next=cor.next;
		size--; //conta questa eliminazione
	}//rimuovi
	public Nominativo cerca( Nominativo n ){
    	Nodo cor=testa;
    	while( cor!=null && cor.info.compareTo(n)<0 ) cor=cor.next;
    	if( cor==null || cor.info.compareTo(n)>0 ) return null;
		return cor.info;
	}//cerca
	public Nominativo cerca( String prefisso, String telefono ){
    	Nodo cor=testa;
    	while( cor!=null  ){
			if( cor.info.getTelefono().equals(telefono) &&
				cor.info.getPrefisso().equals(prefisso) ) return cor.info;
			cor=cor.next;
		}
		return null;
	}//cerca
	public Iterator<Nominativo> iterator(){
		return new IteratoreConcatenato();
	}//iterator
	private class IteratoreConcatenato implements Iterator<Nominativo>{
		private Nodo current=null, previous=null;
		public boolean hasNext(){
			if( current==null ) return testa!=null;
			return current.next!=null;
		}//hasNext
		public Nominativo next(){
			if( !hasNext() ) 
				throw new NoSuchElementException();
			if( current==null ) 
				current=testa;
			else{
				previous=current;
				current=current.next;
			}
			Nominativo n=current.info;
			return n;
		}//next
		public void remove(){
			if(current==previous) 
				throw new IllegalStateException();
			if( current==testa ){
				testa=testa.next;
			}
			else{
				previous.next=current.next;
			}
			current=previous;
			size--;
		}//remove
	}//IteratoreConcatenato
}//AgendinaConcatenata