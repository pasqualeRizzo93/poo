package poo.geometria;

import poo.util.Mat;

public class Cilindro extends Disco implements FiguraSolida {
	private double altezza;
	public Cilindro (double r, double h) {
		super (r);
		if (h<0) throw new IllegalArgumentException ();
		this.altezza=h;
	}//costruttore
	public double perimetro () {
		throw new UnsupportedOperationException ();
	}//perimentro
	public double getAltezza () { return altezza; }
	public double arealaterale () {
		double p=super.perimetro ();
		return p*altezza;
	}//arealaterale
	public double area () {
		return (super.area()*2+arealaterale());
	}//area-areatotale
	public double areabase () {
		return (super.area());
	}//areabase
	public double volume () {
		return (super.area()*altezza);
	}//volume
	public String toString () {return "Cilindro: altezza= "+altezza+", raggio= "+getRaggio(); }
	public boolean equals (Object x) {
		if (!(x instanceof Cilindro)) return false;
		if (x==this) return true;
		Cilindro c=(Cilindro) x;
		return Mat.sufficientementeProssimi(c.altezza, this.altezza) && Mat.sufficientementeProssimi(c.raggio, this.raggio); 
	}
}//Cilindro class
