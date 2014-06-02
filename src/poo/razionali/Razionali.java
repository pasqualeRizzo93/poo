package poo.razionali;
import poo.util.*;
public class Razionali {
	private int num, den;
	public Razionale x (int n, int d) {
		if (d==0) {System.out.println("Denominatore nullo!"); System.exit(-1); }
		int x=Math.abs(n);
		int y=Math.abs(d);
		if (x!=0) {
			int cd=Mat.mcd(x,y);
			n=x/cd; 
			d=y/cd;
		}
		if (d<0) {
			d=d*(-1);
			n=n*(-1);
		}
		this.num=n;
		this.den=d;
		return new Razionale(n,d);
	}//Razionale
}
