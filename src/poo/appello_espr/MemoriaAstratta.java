package poo.appello_espr;

import java.util.Iterator;

public abstract class MemoriaAstratta implements Memoria {

	@Override
	public int size() {
		int c = 0;
		for (Object v : this)
			c++;
		return c;
	}// size

	@Override
	public abstract void add(Variabile v);

	@Override
	public boolean contains(Variabile v) {
		for (Object var : this) {
			Variabile v1=(Variabile) var;
			if (v.equals(v1))
				return true;
			if (v.compareTo(v1) > 0)
				return false;
		}
		return false;
	}// contains

	@Override
	public Variabile get(Variabile v) {
		for (Object var : this) {
			Variabile v1=(Variabile) var;
			if (v.equals(v1))
				return v1;
			if (v.compareTo(v1) > 0)
				return null;
		}
		return null;
	}// get

	@Override
	public void remove(Variabile v) {
		Iterator it = this.iterator();
		while (it.hasNext()) {
			Variabile tmp = (Variabile)it.next();
			if (tmp.equals(v))
				it.remove();
			break;
		}

	}// remove

	@Override
	public void clear() {
		Iterator it = this.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}

	}// clear

	@Override
	public boolean isEmpty() {
		Iterator it = this.iterator();
		return !it.hasNext();
	}// isEmpty

	@Override
	public boolean isFull() {
		return false;
	}// isFull

	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (!(o instanceof Variabile))
			return false;
		if (o == this)
			return true;
		Memoria m = (Memoria) o;
		if (m.size() != this.size())
			return false;
		Iterator it1 = this.iterator();
		Iterator it2 = m.iterator();
		while (it1.hasNext()) {
			Variabile v1 = (Variabile) it1.next();
			Variabile v2 = (Variabile) it2.next();
			if (!v1.equals(v2))
				return false;
		}// while
		return true;
	}// equals

	public String toString() {
		StringBuilder sb = new StringBuilder(200);
		Iterator it = this.iterator();
		sb.append('[');
		while (it.hasNext()) {
			sb.append(it.next());
			if (it.hasNext())
				sb.append(" ,");
		}
		sb.append(']');
		return sb.toString();
	}// toString

	public int hashCode() {
		final int MUL = 43;
		int h = 0;
		for (Object v : this) {
			Variabile vo = (Variabile) v;
			h = h + MUL + vo.hashCode();
		}
		return h;
	}// hashCode

}// MemoriaAstratta
