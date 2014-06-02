package poo.util;

class Pair<T> {
	private T primo;
	private T secondo;
	public Pair (T primo, T secondo) {
		this.primo=primo;
		this.secondo=secondo;
	}
	public T getPrimo () {return primo; }
	public T getSecondo () {return secondo; }
	public void setPrimo (T primo) { this.primo=primo; }
	public void setSecondo (T secondo) {this.secondo=secondo; }
	public String toString () { return ""+primo+" "+secondo; }
}//Pair class
