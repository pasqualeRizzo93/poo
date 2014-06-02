package poo.geometria;
import poo.util.*;
public class Punto {
	private double x, y;
	public Punto () { x=0; y=0; }
	public Punto (double vx, double vy) {x=vx; y=vy; }
	public Punto (Punto p) {x=p.x; y=p.y; }
	public double getX () {return x; }
	public double getY () {return y; }
	public void Sposta (double nuovax, double nuovay) {x=nuovax; y=nuovay; }
	public double distanza (Punto p) {return Math.sqrt((p.x)*(p.x)+(p.y)*(p.y)); }
	public String toString () { return "<"+x+","+y+">"; }
	@Override 
	public boolean equals(Object x) {
		if (!(x instanceof  Punto)) return false; // questo fa anche il test nel caso in cui x è null, in questo caso ritorna falso
		if (x==this) return true; // se x punta allo stesso oggetto
		Punto p= (Punto) x;
		if (Mat.sufficientementeProssimi(this.x, p.x)&&Mat.sufficientementeProssimi(this.x, p.x) ) return true;
		return false;
	}//equals
}