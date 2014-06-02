package poo.agendina;
import java.util.*;

public class AgendinaLL extends AgendinaAstratta{
	private LinkedList<Nominativo> tabella=
		new LinkedList<Nominativo>();
	
	@Override
	public Iterator<Nominativo> iterator(){
		return tabella.iterator();
	}//iterator
	
	@Override
	public void svuota(){ tabella.clear(); }
	
	@Override
	public void aggiungi( Nominativo n ){
		//aggiunge n in ordine, evitando le omonimie
		//se n e' gia' presente, si sovrascrive
		ListIterator<Nominativo> lit=tabella.listIterator();
		boolean flag=false;
		while( lit.hasNext() && !flag ){
		      Nominativo x=lit.next();
		      if( x.equals(n) ){ lit.set(n); flag=true; }
		      else if( x.compareTo(n)>0 ){
		    	  lit.previous();
		    	  lit.add(n);
		    	  flag=true;
		      }
		}
		if( !flag ) lit.add(n);
	}//aggiungi
	
	@Override
	public int size(){ return tabella.size(); }
	
}//AgendinaLL