package poo.appello1;

public class Connessione<T> {// classe di oggetti immutabili

	private T origine, destinazione, percorso;

	private int lunghezza;

	public T getOrigine() {
		return origine;
	}

	public T getDestinazione() {
		return destinazione;
	}

	public T getPercorso() {
		return percorso;
	}

	public int getLunghezza() {
		return lunghezza;
	}

	public Connessione(T origine, T destinazione,T  percorso,
			int lunghezza) {

		this.origine = origine;
		this.destinazione = destinazione;
		this.percorso = percorso;

		this.lunghezza = lunghezza;

	}

	public String toString() {

		return "<<<" + origine + "," + destinazione + ">," + percorso + ">,"
				+ lunghezza + ">";

	}// toString

	public boolean equals(Object o) {

		if (!(o instanceof Connessione))
			return false;

		if (o == this)
			return true;

		Connessione c = (Connessione) o;

		return this.origine.equals(c.origine)
				&& this.destinazione.equals(c.destinazione);

	}// equals

	public int hashCode() {

		final int MULT = 43;

		int h = origine.hashCode();

		h = h * MULT + destinazione.hashCode();

		h = h * MULT + lunghezza;

		return h;

	}// hashCode

}// Connessione