package poo.agendina;
import java.io.IOException;
import java.util.Iterator;

import poo.util.*;

public class AgendinaVector implements Agendina{
	private Vector<Nominativo> tabella;
	public AgendinaVector(){
		this(100);
	}
	public AgendinaVector( int n ){
		if( n<=0 ) throw new IllegalArgumentException();
		tabella=new ArrayVector<Nominativo>(n);
	}
	
	@Override
	public int size(){ return tabella.size(); }
	
	@Override
	public void svuota(){ tabella.clear(); }
	
	@Override
    public void aggiungi( Nominativo n ){
		int i=Array.ricercaBinaria( tabella, n ); 
		if( i>=0 ){ tabella.set(i,n); return; }
		i=0;
		while( i<tabella.size() ){
			Nominativo x=(Nominativo)tabella.get(i);
			if( x.compareTo(n)>0 ) break;
			i++;
		}
		tabella.add(i,n); //inserisce n in posizione i
	}//aggiungi
	
	@Override
	public void rimuovi( Nominativo n ){
		int i=Array.ricercaBinaria( tabella, n ); 
		if( i<0 ) return;
		tabella.remove(i);
	}//rimuovi
	
	@Override
	public Nominativo cerca( Nominativo n ){
		int i=Array.ricercaBinaria( tabella, n ); 
		if( i<0 ) return null;
		return tabella.get(i);
	}//cerca
	@Override
	public Iterator<Nominativo> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Nominativo cerca(String prefisso, String telefono) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salva(String nomeFile) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ripristina(String nomeFile) throws IOException {
		// TODO Auto-generated method stub
		
	}
	


	
}//AgendinaVector