package poo.esempi_libro;
import java.util.*;
import poo.util.Vector;
import poo.util.*;
public class InsiemeVector<T> extends InsiemeAstratto<T> {
	
	private Vector<T> insieme;
	private int size=0;
	public InsiemeVector () {this(100);}
	
	public InsiemeVector (int n) {
		if(n<=0) throw new IllegalArgumentException();
		insieme=new ArrayVector<T> (n);
	}
		
	@Override 
    public int size () {return insieme.size();}

	@Override
	public void svuota () {insieme.clear();}
	
    public boolean aggiungi (T elem) {
		if(appartiene(elem)) return false;
		size++;
		insieme.add(elem);
		return true;
	}
	public Iterator<T> iterator() {return new Iteratore();}
	
	private class Iteratore implements Iterator<T> {
		private int i=size;
		private T elem;
		private boolean rimuovibile=true;
		public boolean hasNext () {
			return i>0;
		}
		public T next () {
			if (!hasNext()) throw new NoSuchElementException();
			i--;
			rimuovibile=true;
			return insieme.get(i);
		}
		public void remove () {
			if (!rimuovibile) throw new IllegalArgumentException();
			rimuovibile=true;
			size--;
			insieme.remove(elem);
		}
	}
	
}