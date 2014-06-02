package poo.figure;
import poo.util.Mat;
public class Cerchio extends Figura {
	public double raggio;
	public Cerchio (double raggio) {
		super (raggio);//controlla che il raggio sia maggiore di 0
	}
	public double getRaggio () {return raggio; }
	@Override
	public double perimetro() {return 2*Math.PI*getDimensione(); }
	@Override
	public double area () {double r=getDimensione(); return r*r*Math.PI; }
	//mancano i metodi equals e toString
}
