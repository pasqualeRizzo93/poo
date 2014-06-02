package poo.agendina;
import java.util.*;

public class AgendinaSet extends AgendinaAstratta{
	private Set<Nominativo> tabella=new TreeSet<Nominativo>();
	
	@Override
	public int size(){ return tabella.size(); }
	
	@Override
	public void svuota(){
		tabella.clear();
	}//clear
	
	@Override
    public void aggiungi( Nominativo n ){
		tabella.remove(n);
		tabella.add(n);
	}//aggiungi
	
	@Override
	public void rimuovi( Nominativo n ){
		tabella.remove( n );
	}//rimuovi
	
	@Override
	public Nominativo cerca( Nominativo n ){
		if( tabella.contains(n) ){
			Iterator<Nominativo> i=tabella.iterator();
			while( i.hasNext() ){
				Nominativo q=i.next();
				if( q.equals(n) ) return q;
			}
		}
		return null;
	}//cerca
	
	@Override
	public Iterator<Nominativo> iterator(){
		return tabella.iterator();
	}//iterator
	
}//AgendinaSet