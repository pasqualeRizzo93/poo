package poo.appello1;

import java.io.IOException;
import java.util.*;

import poo.appello2.Lista;
import poo.appello2.NominativoS;

public abstract class ReteAstratta<T> implements Rete<Connessione> {

	@Override
	public int size() {
		int c = 0;
		Iterator<Connessione> it = this.iterator();
		while (it.hasNext()) {
			it.next();
			c++;
		}
		return c;

	}//

	@Override
	public void clear() {
		Iterator<Connessione> it = this.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}

	}// clear

	@Override
	public Connessione cerca(Connessione c) {
		Iterator<Connessione> it = this.iterator();
		Connessione tmp = null;
		while (it.hasNext()) {
			tmp = it.next();
			if (tmp.equals(c))
				return tmp;
		}
		return null;
	}//cerca

	@Override
	public boolean isEmpty() {
		Iterator<Connessione> it=this.iterator();
		return !it.hasNext();
	}//isEmpty

	@Override
	public boolean isFull() {
			return false;
	}//isFull

	@Override
	public Iterator<Connessione> iterator() {

		return iterator();
	}

	@Override
	public abstract void add(Connessione c);

	@Override
	public int lunghezzaPercorso(Map<String, LinkedList<Connessione>> rete,Connessione target) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void memorizza(Map<String, LinkedList<Connessione>> rete,
			String nomeFile) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Connessione remove(Connessione c) {
		Iterator<Connessione> it = this.iterator();
		Connessione tmp = null;
		while (it.hasNext()) {
			tmp = it.next();
			if (tmp.equals(c)) {
				it.remove();
				break;
			}
		}
		return tmp;
	}
	public boolean equals(Object o) {
		if (!(o instanceof Rete))
			return false;
		if (o == this)
			return true;
		Rete<Connessione> n = (Rete) o;
		if (n.size() != this.size())
			return false;
		Iterator<Connessione> it1 = this.iterator();
		Iterator<Connessione> it2 = n.iterator();
		while (it1.hasNext()) {
			Connessione n1 = it1.next(), n2 = it2.next();
			if (!n1.equals(n2))
				return false;
		}// while
		return true;
	}// equals
	public int hashCode() {
		int PRIMO = 41, h = 0;
		for (Connessione n : this)
			h = h * PRIMO + n.hashCode();
		return h;
	}//hashCode
	public String toString() {
		StringBuffer sb = new StringBuffer(200);
		sb.append('[');
		Iterator<Connessione> it = iterator();
		while (it.hasNext()) {
			sb.append(it.next());
			if (it.hasNext())
				sb.append(',');
		}// while
		sb.append(']');
		return sb.toString();
	}// toString
}//ReteAstratta
