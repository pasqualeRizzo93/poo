package poo.geometria;

import poo.util.Mat;

public class Triangolo {
	private Punto p1, p2, p3;
	private double a, b, c; 
	public Triangolo (Punto p1, Punto p2, Punto p3) {
		a=p1.distanza(p2);
		b=p2.distanza(p3);
		c=p3.distanza(p1);
		if (a>=b+c || b>=a+c || c>=a+b) {
			System.out.println("Non è un triangolo"); 
			System.exit(-1);
		}
		this.p1=new Punto (p1);
		this.p2=new Punto (p2);
		this.p3=new Punto (p3);
	}//Triangolo1
	public Triangolo (Triangolo t) {
		this.p1=t.p1;
		this.p2=t.p2;
		this.p3=t.p3;
		this.a=t.a;// this.b=b; this.c=c;
	}//Triangolo2
	public double getA () {return a; }
	public double getB () {return b; }
	public double getC () {return c; }
	public Punto getP1 () {return p1; }
	public Punto getP2 () {return p2; }
	public Punto getP3 () {return p3; }
	public double perimetro () {return a+b+c; }
	public double area () { double s=(a+b+c)/2; return Math.sqrt(s*(s-a)*(s-b)*(s-c)); }
	public String toString () {return ""+p1+" "+p2+" "+p3; }
	public boolean equals (Object x) {
		if (!(x instanceof Triangolo)) return false;
		if (x==this) return true;
		Triangolo t=(Triangolo) x;
		return Mat.sufficientementeProssimi(t.a, this.a) && Mat.sufficientementeProssimi(t.b, this.b) && Mat.sufficientementeProssimi(t.c, this.c); 
	}
}//Triangolo
