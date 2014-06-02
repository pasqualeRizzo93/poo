package poo.agendina;
import java.util.*;

public class AgendinaMap extends AgendinaAstratta{
	private Map<Nominativo,Nominativo> tabella=new TreeMap<Nominativo,Nominativo>();
	
	@Override
	public int size(){ return tabella.size(); }
	
	@Override
	public void svuota(){ tabella.clear(); }
    
	@Override
	public void aggiungi( Nominativo n ){
		tabella.put(n, n);
	}//aggiungi
	
	@Override
	public void rimuovi( Nominativo n ){
		tabella.remove( n );
	}//rimuovi
	
	@Override
	public Nominativo cerca( Nominativo n ){
		return tabella.get( n );
	}//cerca
	
	@Override
	public Iterator<Nominativo> iterator(){
		return tabella.values().iterator();
	}//iterator
	
}//AgendinaMap