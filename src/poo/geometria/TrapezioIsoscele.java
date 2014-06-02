package poo.geometria;
import poo.figure.*;
import poo.util.Mat;
public class TrapezioIsoscele extends Figura {
	protected double latoA;
	protected double latoB;//base minore
	protected double latoC;//il latoD, non dichiarato viene dalla super-classe invocando getDimensione. Lo stesso è la base maggiore
	protected double altezza;
	public TrapezioIsoscele (double a, double b, double c, double d) {
		super(d);
		if (a<=0 && b<=0 && c<=0) throw new IllegalArgumentException ();
		this.latoA=a;
		this.latoB=b;
		this.latoC=c;
		this.altezza=altezza;
	}//costruttore
	public TrapezioIsoscele (TrapezioIsoscele t) {
		super(getDimensione());
		this.latoA=latoA;
		this.latoB=latoB;
		this.latoC=latoC;
		this.altezza=altezza;
	}//costruttore
	public double getLatoA () {return latoA; }
	public double getLatoB () {return latoB; }
	public double getLatoC () {return latoC; }
	public double getLatoD () {return getDimensione(); }
	public double perimetro () {return getDimensione()+latoA+latoB+latoC; }
	public double area () {return ((getDimensione()+latoB)/2)*altezza; }
	public String toString () {return "Trapezio Isoscele: base maggiore= "+getDimensione()+", base minore= "+latoB+", lati obliqui= "+latoA+" e "+latoC+"."; }
	public boolean equals (Object x) {
		if (!(x instanceof TrapezioIsoscele)) return true;
		if (x==this) return true;
		TrapezioIsoscele t=(TrapezioIsoscele) x;
		return Mat.sufficientementeProssimi(t.latoA, this.latoA) && Mat.sufficientementeProssimi(t.latoB, this.latoB) && Mat.sufficientementeProssimi(t.latoC, this.latoC) && Mat.sufficientementeProssimi(t.getDimensione(), this.getDimensione()) && Mat.sufficientementeProssimi(t.altezza, this.altezza);  
	}
}
