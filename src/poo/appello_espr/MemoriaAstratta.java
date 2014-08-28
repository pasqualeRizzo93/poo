package poo.appello_espr;

import java.util.Iterator;

public abstract class MemoriaAstratta<T> implements Memoria<T> {

	@Override
	public int size() {
		int c = 0;
		for (Variabile v : this)
			c++;
		return c;
	}// size

	@Override
	public abstract void add(Variabile v);

	@Override
	public boolean contains(Variabile v) {
		for (Variabile var : this) {
			if (v.equals(var))
				return true;
			if (v.compareTo(var) > 0)
				return false;
		}
		return false;
	}// contains

	@Override
	public Variabile get(Variabile v) {
		for (Variabile var : this) {
			if (v.equals(var))
				return var;
			if (v.compareTo(var) > 0)
				return null;
		}
		return null;
	}// get

	@Override
	public void remove(Variabile v) {
		Iterator<Variabile> it = this.iterator();
		while (it.hasNext()) {
			Variabile tmp = it.next();
			if (tmp.equals(v))
				it.remove();
			break;
		}

	}// remove

	@Override
	public void clear() {
		Iterator<Variabile> it = this.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}

	}//clear

	@Override
	public boolean isEmpty() {
		Iterator<Variabile> it=this.iterator();
		return !it.hasNext();
	}//isEmpty

	@Override
	public boolean isFull() {
		return false;
	}//isFull
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object o){
		if(!(o instanceof Variabile)) return false;
		if(o==this) return true;
		Memoria<T> m=(Memoria) o;
		if(m.size()!=this.size())return false;
		Iterator<Variabile> it1=this.iterator();
		Iterator<Variabile> it2=m.iterator();
		while(it1.hasNext()){
			Variabile v1=it1.next(); Variabile v2=it2.next();
			if(!v1.equals(v2)) return false;
		}//while
		return true;
	}//equals
	
	public String toString(){
		StringBuilder sb=new StringBuilder(200);
		Iterator<Variabile>it=this.iterator();
		sb.append('[');
		while(it.hasNext()){
			sb.append(it.next());
			if(it.hasNext())sb.append(" ,");
		}
		sb.append(']');
		return sb.toString();
	}//toString
	
	public int hashCode(){
		final int MUL=43; int h=0;
		for(Variabile v: this)h=h+MUL+v.hashCode();
		return h;
	}//hashCode

}//MemoriaAstratta
