package poo.agendina;
import java.util.*;
public class AgendinaInsieme extends AgendinaAstratta {
	private Set<Nominativo> tabella=new TreeSet<Nominativo>();
	
	public void aggiungi( Nominativo n ){
		tabella.remove( n );
		tabella.add( n );
	}//aggiungi
	
	public Iterator<Nominativo> iterator(){
		return tabella.iterator();
	}//iterator
	
	public Nominativo cerca( Nominativo n ){
		if( tabella.contains(n) ){
			for( Nominativo x: this )
				if( x.equals(n) ) return x;
		}
		return null;
	}//cerca
	
	@Override
	public void rimuovi( Nominativo n ){
		tabella.remove(n);
	}//rimuovi
	
}//AgendinaInsieme
