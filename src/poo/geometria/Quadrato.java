package poo.geometria;
import poo.figure.*;
import poo.util.Mat;
public class Quadrato extends Figura{
	public Quadrato (double base) {
		super(base);
	}//costruttore
	public Quadrato (Quadrato q) {
		super(getDimensione());
	}//costruttore
	public double getLato () {return getDimensione(); }
	public double getDiagonale () {return getDimensione()*Math.sqrt(2); }
	public double perimetro () {return getDimensione()*4; }
	public double area () {
		double l=getDimensione();
		return l*l;
	}//area
	public String toString () {
		return "Quadrato: lato= "+getDimensione();
	}//toString
	public boolean equals (Object x) {
		if (!(x instanceof Quadrato)) return false;
		if (x==this) return true;
		Quadrato q=(Quadrato) x;
		return Mat.sufficientementeProssimi(q.getLato(), this.getLato());
	}//equals
}
