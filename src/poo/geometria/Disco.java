package poo.geometria;

import poo.util.Mat;

public class Disco extends Punto {
	public double raggio;
	public Disco (double raggio) {
		super();
		if (raggio<=0) throw new IllegalArgumentException ();
		this.raggio=raggio;
	}//costruttore
	public Disco (double x, double y, double raggio) {
		super (x,y);
		if (raggio<=0) throw new IllegalArgumentException ();
		this.raggio=raggio;
	}
	public Disco (Punto p, double raggio) {
		super(p.getX(), p.getY());
		if (raggio<=0) throw new IllegalArgumentException ();
		this.raggio=raggio;
	}
	public Disco (Disco d) {
		super (d.getX(), d.getY());
		this.raggio=d.raggio;
	}
	public double getRaggio () {return raggio; }
	public double area () {return raggio*raggio*Math.PI; }
	public double perimetro () {return 2*raggio*Math.PI; }
	@Override
	public boolean equals (Object x) {
		if (!(x instanceof Disco)) return false;
		if (x==this) return true;
		Disco d=(Disco)x;//operazione di casting
		return super.equals(d)&& Mat.sufficientementeProssimi(this.raggio, d.raggio);
	}
	public String toString () {
		return super.toString()+" raggio= "+raggio;
	}
}
//fare il main