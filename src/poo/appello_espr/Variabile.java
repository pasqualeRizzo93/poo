package poo.appello_espr;

public class Variabile implements Comparable<Variabile> {
	private String variabile;
	private int valore;

	public Variabile(String variabile, int valore) {
		this.variabile = variabile;
		this.valore = valore;
	}// Costruttore

	public String getVariabile() {
		return this.variabile;
	}// getVariabile

	public int getValore() {
		return this.valore;
	}// getValore

	public String toString() {
		return variabile + "=" + valore;
	}// toString

	public boolean equals(Object o) {
		if (!(o instanceof Variabile))
			return false;
		if (o == this)
			return true;
		Variabile c = (Variabile) o;
		return this.variabile.equals(c.variabile) && this.valore == c.valore;
	}// equals

	public int hashCode() {
		final int MULT = 43;
		int h = variabile.hashCode();
		h = h * MULT + valore;
		return h;
	}// hashCode

	public int compareTo(Variabile patate) {
		if (this.equals(patate))
			return 0;
		if (this.valore < patate.valore)
			return -1;
		return +1;
	}//compareTo

}
