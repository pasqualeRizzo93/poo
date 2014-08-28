package poo.num;

public interface Numero extends Comparable<Numero>, Iterable<Cifra> {

	Numero somma(Numero n);
	Numero moltiplica(Numero n);
	boolean ePositivo();
	boolean eNegativo();
	void cambiaSegno();
}
