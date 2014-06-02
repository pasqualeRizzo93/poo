package poo.esempi_libro;
public class Complex {
	private double re;
	private double im;
	public Complex (double re, double im) {
		if(im==0) { 
			System.out.println("Parte immaginaria nulla.");
			System.exit(-1);
		}
		this.re=re;
		this.im=im;
	}//Costruttore
	public Complex (Complex c) {
		this.re=c.re;
		this.im=c.im;
	}//Costruttore copia
	public double getRe () {return re; }
	public double getIm () {return im; }
	public double modulo () {
		return Math.sqrt(re*(re*re+im*im)+im*(re*re+im*im));
	}//modulo
	public Complex coniugato () { return new Complex(re, -im);}
	public Complex add (Complex c) { return new Complex (re+c.re, im+c.im);	}
	public Complex sub (Complex c) { return new Complex (re-c.re, im-c.im); }
	public Complex mul (Complex c) { return new Complex ((re*c.re)-(im*c.im), (im*c.re)+(re*c.im)); }
	public Complex mul (double a)  { return new Complex (a*re, a*im); }
	public boolean equals (Object x) {
		if(!(x instanceof Complex)) return false;
		Complex c1=(Complex) x;
		if(c1==this) return true;
		return false;
	}//equals
	public String toString () {
		StringBuilder sb=new StringBuilder (200);
		sb.append(re);
		sb.append(",");
		sb.append(im);
		return sb.toString();
	}//toString
	public int hashCode () {
		int MOL=41;
		int h=0;
		return h*MOL+this.hashCode();
	}//hashCode
}
