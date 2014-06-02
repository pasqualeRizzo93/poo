package poo.figure;

public abstract class Figura {
	private static double dimensione;
	public Figura (double dim) {
		if (dim<0) throw new IllegalArgumentException ();
		this.dimensione=dim;
	}
	protected static double getDimensione () {return dimensione; }
	public abstract double perimetro();
	public abstract double area();
}
