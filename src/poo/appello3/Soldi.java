package poo.appello3;

public interface Soldi extends Comparable<Soldi>, Iterable<Denaro> {
	double totale();
	void add(Denaro d);
	void add(Soldi s);
	Soldi sub(Soldi s1, Soldi s2);

}
