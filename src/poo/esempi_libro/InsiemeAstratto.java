package poo.esempi_libro;
import java.util.*; 
public abstract class InsiemeAstratto<T> implements Insieme<T> { 
	public int size () {
		int conta=0;
		for (Object x:this)
			conta++;
		return conta;
	}
	public boolean eVuoto() {
		return !iterator().hasNext();
	}
	public abstract Iterator<T> iterator();
	public abstract boolean aggiungi(T elem);
	public void svuota(){
		Iterator<T> it=this.iterator();
		while( it.hasNext() ) {
			it.next(); it.remove();
		}
	}//svuota
	public boolean appartiene (T elem) {
		Iterator<T> it=this.iterator();
		for(Object x:this)
			if(x.equals(elem)) 
				return true;
		return false;
	}
	public boolean equals (Object x) {
		if(!(x instanceof Insieme))
			return false;
		if(x==this) 
			return true;
		Insieme<T> w=(Insieme)x;
		if(this.size()!=w.size()) 
			return false;
		Iterator<T> it=this.iterator();
		Iterator<T> it1=w.iterator();
		while(it.hasNext()) {
			Object t=it.next();
			for(Object y:this)
				if(t.equals(y))
					break;
			return false;
		}
		return true;
	}
	public int hashCode () {
		final int MOLT=43;
		int h=0;
		Iterator<T> it=this.iterator();
		for (Object x:this)
			h=h*MOLT+x.hashCode();
		return h;
	}
	public String toString () {
		StringBuilder st=new StringBuilder (200);
		st.append("[");
		Iterator<T> it=this.iterator();
		while (it.hasNext()) {
			T x=it.next(); st.append (x);
			if (it.hasNext()) st.append (", ");
		}
		st.append(']');
		return st.toString();
	}
	public T get (T elem) {
		Iterator<T> it=this.iterator();
		for (T x:this)
			if (x.equals(elem)) 
				return x;
		return null;
	}
	public Insieme<T> unione (Insieme<T> altro) {
		Insieme<T> unione=this;
		for (Object y:altro)
			unione.aggiungi((T)y);
		return unione;
	}
	public Insieme<T> intersezione (Insieme<T> altro) {
		Insieme<T> intersezione=this;
		Iterator<T> it=this.iterator();
		Iterator<T> it1=altro.iterator();
		while (it.hasNext()) {
			T x=it.next();
			while (it1.hasNext()) {
				T y=it1.next();
				if (x.equals(y))
					intersezione.rimuovi(x);
			}
		}
		return intersezione;
	}
	public Insieme<T> differenza (Insieme<T> altro) {
		Insieme<T> differenza=altro;
		Insieme<T> tmp=intersezione(altro);
		for (T x:differenza)
			for  (Object y:tmp)
				if (x.equals(y))
					differenza.rimuovi(x);
		return differenza;
	}
	public Insieme<T> differenzaSimmetrica (Insieme<T> altro) {
		Insieme<T> diffSimm=unione(altro);
		Insieme<T> intersezione=intersezione(altro);
		for (Object x:diffSimm)
			for (Object y:intersezione)
				if(x.equals(y))
					diffSimm.rimuovi((T)y);
		return diffSimm;
	}
	public boolean rimuovi (T elem) {
		Iterator<T> it=this.iterator();
		for(Object x:this)
			if(x.equals(elem)) {
				it.remove();
				return true;
			}
		return false;
	}
}