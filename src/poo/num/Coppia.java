package poo.num;

public class Coppia<T> {
	T primo;
	T secondo;

	public Coppia(T primo, T secondo) {
		this.primo = primo;
		this.secondo = secondo;
	}

	public T getPrimo() {
		return primo;
	}

	public T getSecondo() {
		return secondo;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof Coppia)) return false;
		if(o==this)return true;
		Coppia<T> c= (Coppia) o;
		if(c.getPrimo().equals(this.getPrimo()) && c.getSecondo().equals(this.getSecondo())) return true;
		return false;
	}//equals
	
	public int hashCode(){
		int mul=41;
		int h= primo.hashCode();
		h=h+secondo.hashCode()*mul;
		return h;
	}//hashCode
	
	public String toString(){
	return 	"[" + primo + secondo + "]";

	}//toString
}//Coppia
