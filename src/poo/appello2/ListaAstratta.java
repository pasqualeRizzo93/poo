package poo.appello2;

import java.io.*;
import java.util.*;

public abstract class ListaAstratta<T> implements Lista<NominativoS> {
	private int size;

	@Override
	public Iterator<NominativoS> iterator() {
		return iterator();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		ListIterator<NominativoS> lit = this.listIterator();
		while (lit.hasNext()) {
			lit.next();
			lit.remove();
		}
	}// clear

	@Override
	public abstract void add(NominativoS n);

	@Override
	public NominativoS remove(NominativoS n) {
		ListIterator<NominativoS> lit = this.listIterator();
		NominativoS tmp = null;
		while (lit.hasNext()) {
			tmp = lit.next();
			if (tmp.equals(n)) {
				lit.remove();
				break;
			}
		}
		size--;
		return tmp;
	}// remove

	@Override
	public NominativoS cerca(NominativoS n) {
		ListIterator<NominativoS> lit = this.listIterator();
		NominativoS tmp = null;
		while (lit.hasNext()) {
			tmp = lit.next();
			if (tmp.equals(n))
				return tmp;
		}
		return null;
	}// cerca(Nominativo)

	@Override
	public NominativoS cerca(int codice) {
		ListIterator<NominativoS> lit = this.listIterator();
		NominativoS tmp = null;
		while (lit.hasNext()) {
			tmp = lit.next();
			if (tmp.getCodice() == codice)
				return tmp;
		}
		return null;
	}// cerca(codice)

	@Override
	public boolean isEmpty() {
		ListIterator<NominativoS> lit = this.listIterator();
		return !lit.hasNext();
	}// isEmpty

	@Override
	public boolean isFull() {
		return false;
	}// isFull

	@Override
	public ListIterator<NominativoS> listIterator() {
		return this.listIterator();
	}

	@Override
	public ListIterator<NominativoS> listIterator(int start) {
		return this.listIterator(start);
	}

	@Override
	public abstract void sort(Comparator<NominativoS> c);

	@Override
	public abstract void sort();

	public boolean equals(Object o) {
		if (!(o instanceof Lista))
			return false;
		if (o == this)
			return true;
		Lista<NominativoS> n = (Lista) o;
		if (n.size() != this.size())
			return false;
		Iterator<NominativoS> it1 = this.iterator();
		Iterator<NominativoS> it2 = n.iterator();
		while (it1.hasNext()) {
			NominativoS n1 = it1.next(), n2 = it2.next();
			if (!n1.equals(n2))
				return false;
		}// while
		return true;
	}// equals

	public int hashCode() {
		int PRIMO = 41, h = 0;
		for (NominativoS n : this)
			h = h * PRIMO + n.hashCode();
		return h;
	}// hashCode()

	public String toString() {
		StringBuilder sb = new StringBuilder(200);
		sb.append('[');
		Iterator<NominativoS> it = iterator();
		while (it.hasNext()) {
			sb.append(it.next());
			if (it.hasNext())
				sb.append(',');
		}// while
		sb.append(']');
		return sb.toString();
	}// toString

	public void ripristina(String nomeFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(nomeFile));
		String linea = null;
		StringTokenizer st = null;
		LinkedList<NominativoS> tmp = new LinkedList<NominativoS>();
		boolean okLettura = true;
		for (;;) {
			linea = br.readLine();
			if (linea == null)
				break;
			st = new StringTokenizer(linea, "= ");
			try {
				String nome = st.nextToken();
				String cognome = st.nextToken();
				int codice = Integer.parseInt(st.nextToken());
				tmp.add(new NominativoS(nome, cognome, codice));
			} catch (Exception e) {
				okLettura = false;
				System.out.println("File inconsistente!");
				break;

			}
		}
		br.close();
		if (okLettura) {
			this.clear();
			for (NominativoS n : tmp)
				this.add(n);
		} else
			throw new IOException();
	}// ripristina

	public void salva(String nomeFile) throws IOException {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				nomeFile)));
		for (NominativoS n : this)
			pw.println(n);
		pw.close();
	}// salva
}// ListaAstratta
