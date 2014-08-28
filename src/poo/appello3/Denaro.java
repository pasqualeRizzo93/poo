package poo.appello3;

import java.util.*;


public class Denaro implements Comparable<Denaro> {

	private double valore;
	private int quantita;

	public Denaro(double valore, int quantita) {
		if (!TaglioMoneta.valida(valore))
			throw new IllegalArgumentException(
					"il valore inserito non e' valido");
		this.valore = valore;
		this.quantita = quantita;
	}// costruttore

	public double getValore() {
		return this.valore;
	}// getValore

	public int getQuantita() {
		return this.quantita;
	}// getQuantita

	public int setQuantita(int quantita) {
		return this.quantita = quantita;
	}// setQuantita

	public boolean equals(Object o) {
		if (!(o instanceof Denaro))
			return false;
		if (o == this)
			return true;
		Denaro d = (Denaro) o;
		if (d.valore == this.valore && d.quantita == this.quantita)
			return true;
		return false;
	}// equals

	public String toString() {
		return  valore + " " + quantita;
	}// toString

	public int hashCode() {
		final int MUL = 31;

		int h = (int) valore;
		
		h = MUL * quantita;
		
		return h;

	}//hashCode()

	@Override
	public int compareTo(Denaro d) {
        if(this.valore==d.valore)return 0;
        if(this.valore<d.valore)return 1;
        		return -1;
	}//compareTo

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double val;
		int quantita;
		System.out.println("Inserisci il valore : ");
		val = sc.nextDouble();
		System.out.println("inserisci la quantita : ");
		quantita = sc.nextInt();

		Denaro d = new Denaro(val, quantita);

		System.out.println("oggetto creato ;-)");
		System.out.println(d);

	}
}
