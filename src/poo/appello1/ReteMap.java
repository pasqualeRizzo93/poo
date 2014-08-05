package poo.appello1;

import java.util.*;
import java.io.*;

public class ReteMap<T> extends ReteAstratta<T> {

	private Map<String, LinkedList<Connessione>> rete = new HashMap<String, LinkedList<Connessione>>();

	private class IteratoreRete implements Iterator<String> {
		private Iterator<String> it = rete.keySet().iterator();
		private String u = null;

		public boolean hasNext() {
			return it.hasNext();
		}

		public String next() {
			return u = it.next();
		}

		public void remove() {
			it.remove();
			Set<String> chiavi = rete.keySet();
			Iterator<String> it = chiavi.iterator();
			while (it.hasNext()) {
				String v = it.next();
				Iterator<? extends Connessione> adiacenti = rete.get(v)
						.iterator();
				while (adiacenti.hasNext()) {
					Connessione c = adiacenti.next();
					if (c.getDestinazione().equals(u)) {
						adiacenti.remove();
						break;
					}
				}
			}
		}
	}// IteratoreRete

	@Override
	public Iterator<? extends Connessione> adiacenti(String u) {
		if (!rete.containsKey(u))
			throw new IllegalArgumentException();
		return rete.get(u).iterator();
	}// adiacenti

	@Override
	public Iterator<String> iterator() {
		return new IteratoreRete();
	}// iterator

	public boolean esisteNodo(String u) {
		return rete.containsKey(u);
	}// esisteNodo

	public int numNodi() {
		return rete.size();
	}// numNodi

	@Override
	public void insNodo(String u) {
		if (esisteNodo(u))
			throw new RuntimeException("Nodo gia presente durante insNodo");
		rete.put(u, new LinkedList<Connessione>());

	}// insNodo

	@Override
	public void insConnessione(Connessione c) {
		if (!rete.containsKey(c.getOrigine())
				|| !rete.containsKey(c.getDestinazione())) {
			throw new RuntimeException(
					"Nodo(i) non esistente(i) durante insArco");
		}
		LinkedList<Connessione> cd = rete.get(c.getOrigine());
		cd.addAll(cd);
	}// insConnessione

	public void rimuoviNodo(String u) {
		rete.remove(u);
		Set<String> chiavi = rete.keySet();
		Iterator<String> it = chiavi.iterator();
		while (it.hasNext()) {
			String v = it.next();
			Iterator<Connessione> adiacenti = rete.get(v).iterator();
			while (adiacenti.hasNext()) {
				Connessione c = adiacenti.next();
				if (c.getDestinazione().equals(u)) {
					adiacenti.remove();
					break;
				}
			}
		}
	}// rimuoviNodo

	public void rimuoviConnessione(Connessione c) {
		String u = c.getOrigine();
		if (rete.containsKey(u)) {
			LinkedList<Connessione> cd = rete.get(u);
			Iterator<Connessione> adiacenti = cd.iterator();
			while (adiacenti.hasNext()) {
				Connessione cr = adiacenti.next();
				if (cr.equals(c)) {
					adiacenti.remove();
					break;
				}

			}
		}
	}// rimuoviConnessione

	public void clear() {
		rete.clear();
	}// clear

	public int lunghezzaPercorso(Map<String, LinkedList<Connessione>> rete,
			Connessione target) {
		if (!rete.containsKey(target.getOrigine()))
			return -1;
		int lungTotale = 0;
		String nodo = target.getOrigine();
		String destinazione = target.getDestinazione();
		String percorso = target.getPercorso();
		boolean flag = false;
		for (;;) {
			LinkedList<Connessione> lc = rete.get(nodo);
			boolean miglioramentoPossibile = false;
			for (Connessione c : lc) {
				if (c.getPercorso().equals(percorso)) {
					if (c.getDestinazione().equals(destinazione)) {
						flag = true;
						lungTotale += c.getLunghezza();
						break;
					} else {
						nodo = c.getDestinazione();
						lungTotale += c.getLunghezza();
						miglioramentoPossibile = true;
					}
				}
			}
			if (!miglioramentoPossibile)
				break;
		}
		if (!flag)
			return -1;
		return lungTotale;

	}// lunghezzaPercorso

	public void memorizza(Map<String, LinkedList<Connessione>> rete,
			String nomeFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(nomeFile));
		String linea = null;
		StringTokenizer st = null;
		boolean okLettura = true;
		String origine = null, destinazione, percorso;
		int lunghezza;
		LinkedList<Connessione> tmp = new LinkedList<Connessione>();
		for (;;) {
			linea = br.readLine();
			if (linea == null)
				break;
			st = new StringTokenizer(linea, " ");
			try {
				origine = st.nextToken();
				destinazione = st.nextToken();
				percorso = st.nextToken();
				lunghezza = Integer.parseInt(st.nextToken());
				Connessione nuova = new Connessione(origine, destinazione,
						percorso, lunghezza);
				tmp.add(nuova);
			} catch (Exception e) {
				okLettura = false;
				break;
			}
		}
		br.close();
		if (okLettura) {
			for (Connessione n : tmp)
				rete.put(origine, tmp);
		} else
			throw new IOException();
	}// memorizza
}// ReteMap
