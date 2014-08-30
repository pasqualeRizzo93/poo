package poo.appello1;

import java.util.*;

public interface Rete<T,V> extends Iterable<T> {
	int numNodi();

	int numConnessioni();

	boolean esisteNodo(String u);

	boolean esisteConnessione(T c);

	boolean esisteConnessione(V u, V v, V z, int l);

	void insNodo(V u);

	void insConnessione(T c);

	void insConnessione(V u, V v, V z, int l);

	void rimuoviNodo(String u);

	void rimuoviConnessione(T c);

	void rimuoviConnessione(V u, V v, V z, int l);

	int gradoEntrata(V u);

	int gradoUscita(V u);

	Iterator<? extends T> adiacenti(T u);

	void clear();

}// Rete
