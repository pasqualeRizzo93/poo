package poo.razionali;
import poo.sortable.*;
import poo.util.*;
public class Razionale extends Sortable {
	public final int numeratore, denominatore; 
	private static int contatore;
	public Razionale (int n, int d) {
		if (d==0) {
			System.out.println("Il denominarore è nullo");
			System.exit(-1);
		}
		int x=Math.abs(n);
		int y=Math.abs(d);
		int z=mcd(x,y);
		x=n/z;
		y=d/z;
		if (y<0) {
			y*=-1;
			x*=-1;
		}
		this.numeratore=x;
		this.denominatore=y;
		contatore++;
	}//Razionale
	public Razionale (Razionale r) {
		this.numeratore=r.numeratore; 
		this.denominatore=r.denominatore;
	}//Razionale
	public int getNum () {return numeratore; }
	public int getDen () {return denominatore; }
	public static int getContatore() {return contatore; }
	private int mcd (int x, int y) { //calcolo del mcd secondo la regola di Euclide
		int r;
		do {
			r=x%y;
			if (r!=0) {x=y; y=r; }
		} while (r!=0);
		return y;
	}//mcd
	public Razionale add (Razionale r) {
		int cd=(this.denominatore*r.denominatore); //cd è il comun divisore 
		int n1=(cd/this.denominatore)*this.numeratore;
		int n2=(cd/this.denominatore)*this.numeratore;
		return new Razionale (n1+n2, cd);
	}//add
	public Razionale sub (Razionale r) { //sottrazione
		int cd=(this.denominatore*r.denominatore)/mcd(this.denominatore, r.denominatore);
		return new Razionale ((cd/this.denominatore)*this.numeratore-(cd/r.denominatore)*this.numeratore, cd);
	}//sub. Il metodo restituisce la coppia di numeri già ridotti in forma minima perché il tutto è definito nei costruttori
	public Razionale mul (Razionale r) { //multiple-moltiplicazione
		return new Razionale (this.numeratore*r.numeratore, this.denominatore*r.denominatore);
	}//mul
	public Razionale mul (int s) { //moltiplicazione per uno scalare
		return new Razionale (this.numeratore*s, this.denominatore);
	}//mul-scalare
	public Razionale div (Razionale r) {
		return new Razionale (this.numeratore*r.denominatore, this.denominatore*r.numeratore);
	}//div
	public String toString () {
		String s=""+this.numeratore;
		if (this.denominatore!=1) s=s+"/"+this.denominatore;
		return s;
	}//toString
	protected void finalize () {contatore--; } 
	@Override
	public int compareTo (Sortable z) {
		Razionale r=(Razionale) z;
		int d=Mat.mcm(this.denominatore, r.denominatore);
		int m1=(d/this.denominatore)*this.numeratore;
		int m2=(d/r.denominatore)*r.numeratore;
		return m1-m2;//questa operazione si può fare perché m1 e m2 sono interi
	}
}//Razionale-classe
