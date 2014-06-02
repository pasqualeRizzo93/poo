package poo.sortable;
public class Intero extends Sortable {
	int x;
	public Intero (int x) {this.x=x; }
	public int getValue () {return x; }
	public String toString () {return ""+x; }
	@Override
	public int compareTo (Sortable s) {
		Intero i=(Intero) s;//se s non venisse castizzato ad intero, darebbe errore
		return this.x-i.x;
	}
}
//questa classe permette di oggettificare degli interi
