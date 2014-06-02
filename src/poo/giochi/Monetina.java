package poo.giochi;
public class Monetina {
	public static final int testa=0, croce=1;
	private int faccia;
	public Monetina() { lancia (); }
	public void lancia () { 
		double r=Math.random();
		if (r<0.5) faccia=testa;
		else faccia=croce;
	}//lancia
	public int getFaccia () {return faccia; }
	public String toString () { return ""+faccia; }
}//Monetina
