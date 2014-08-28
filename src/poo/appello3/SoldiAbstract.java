package poo.appello3;

import java.util.*;

public abstract class SoldiAbstract implements Soldi {

	@Override
	public double totale() {
		double t = 0;
		for (Denaro d : this)
			t += d.getValore() * d.getQuantita();
		return t;
	}// totale

	@Override
	public abstract void add(Denaro d);

	@Override
	public abstract void add(Soldi s);

	@Override
	public Soldi sub(Soldi s1, Soldi s2) {
		double resto = s2.totale() - s1.totale();
		if (resto < 0)
			throw new IllegalArgumentException("ci von chiu sord!! :p");
		if (resto < 0.03)
			throw new IllegalStateException("Il resto non è valido");
		Soldi resto_obj = creaResto(resto, this);
		this.add(s2);
		return resto_obj;
	}// sub

	private Soldi creaResto(double importo, Soldi cassa) {
		
		Soldi resto = new SoldiLC();
		Iterator<Denaro> it = cassa.iterator();
		while (it.hasNext() && importo > 0) {
			Denaro corrente = it.next();
			int num_monete = (int) (importo / corrente.getValore());
			if (num_monete >= 1) {
				Denaro d = new Denaro(corrente.getValore(), num_monete);
				corrente.setQuantita(corrente.getQuantita() - num_monete);
				resto.add(d);
				float f = (float)(corrente.getValore()*num_monete);
				importo -= f;
				importo  = round(importo, 2);
			}

		}

		return resto;
	}//creaResto

	
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	
	
	@Override
	public int compareTo(Soldi s) {
		if (this.totale() == s.totale())
			return 0;
		if (this.totale() > s.totale())
			return -1;
		return -1;
	}// compareTo

	public boolean equals(Object o) {
		if (!(o instanceof Soldi))
			return false;
		if (o == this)
			return true;
		Soldi s = (Soldi) o;
		if (this.totale() == s.totale())
			return true;
		return false;

	}// equals

	public int hashCode() {
		int PRIMO = 31;
		int h = 0;
		for (Denaro d : this)
			h = h + PRIMO + d.hashCode();
		return h;
	}// hashCode

	public String toString() {
		StringBuilder sb = new StringBuilder(200);
		Iterator<Denaro> it = this.iterator();
		sb.append('[');
		while (it.hasNext()) {
			sb.append(it.next());
			if (it.hasNext())
				sb.append(" ,");
		}
		sb.append(']');
		return sb.toString();
	}// toString
}// SoldiAbstract

