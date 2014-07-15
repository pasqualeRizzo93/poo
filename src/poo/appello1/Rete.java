package poo.appello1;

import java.util.*;
import java.io.*;

public interface Rete<Connessione> extends Iterable<Connessione> {
	int size();

	Connessione remove(Connessione c);

	void clear();

	Connessione cerca(Connessione c);

	boolean isEmpty();

	boolean isFull();

	Iterator<Connessione> iterator();

	void add(Connessione c);

	int lunghezzaPercorso(Map<String, LinkedList<Connessione>> rete,
			Connessione target);

	void memorizza(Map<String, LinkedList<Connessione>> rete, String nomeFile)
			throws IOException;

}// Rete
