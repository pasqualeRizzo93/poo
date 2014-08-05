package poo.appello1;

import java.util.*;

public interface Rete<String> extends Iterable<String> {
	int numNodi();

	int numConnessioni();

	boolean esisteNodo(String u);

	boolean esisteConnessione(Connessione c);

	boolean esisteConnessione(String u, String v, String z, int l);

	void insNodo(String u);

	void insConnessione(Connessione c);

	void insConnessione(String u, String v, String z, int l);

	void rimuoviNodo(String u);

	void rimuoviConnessione(Connessione c);

	void rimuoviConnessione(String u, String v, String z, int l);

	int gradoEntrata(String u);

	int gradoUscita(String u);

	Iterator<? extends Connessione> adiacenti(String u);

	void clear();

}// Rete
