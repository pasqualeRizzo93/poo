package poo.geometria;
public class Sfera extends Disco implements FiguraSolida {
	public Sfera (double r) {
		super (r);
	}//costruttore
	public Sfera (double x, double y, double r) {
		super (x,y,r);
	}//costruttore 2
	public double perimetro () {
		throw new UnsupportedOperationException (); //disabilita il metodo
	}//perimetro
	public double area () {
		double r=this.getRaggio ();
		return (4*r*r*Math.PI);
	}//area
	public double arealaterale () {return area (); }
	public double volume () {
		double r=this.getRaggio ();
		return ((4*r*r*Math.PI)/3);//restituisce la divisione reale in quanto basta un solo membro fra numeratore e denominatore reale
	}//volume
	//da fare equals e toString
}
