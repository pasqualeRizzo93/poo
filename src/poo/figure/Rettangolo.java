package poo.figure;
import poo.figure.*; 
import poo.util.Mat;
public class Rettangolo extends Figura {
	protected double altezza;
	public Rettangolo (double base, double altezza) {
		super(base);
		if (altezza<=0) throw new IllegalArgumentException ();
		this.altezza=altezza;
	}//costruttore
	public Rettangolo (Rettangolo R) {
		super (getDimensione());
		this.altezza=altezza;
	}//Costruttore
	public double getBase (){return getDimensione(); }
	public double getAltezza (){return altezza; }
	public double perimetro () {return 2*getDimensione()+2*altezza; }
	public double area () {return getDimensione()*altezza; }
	public String toString () {return "Rettangolo: base= "+getDimensione()+", altezza= "+altezza+"."; }
	public boolean equals (Object x) {
		if (!(x instanceof Rettangolo)) return false;
		if (x==this) return true;
		Rettangolo r=(Rettangolo) x;
		return Mat.sufficientementeProssimi(r.getDimensione(), this.getDimensione()) && Mat.sufficientementeProssimi(r.getAltezza(), this.altezza);
	}//equals
}//Rettangolo class
