package poo.num;

public class Cifra implements Comparable<Cifra> {

	private int cifra;

	public Cifra(int cifra) {
		if (cifra < 0 || cifra > 9) {
			throw new IllegalArgumentException(
					"la cifra deve essere compresa tra 0 e 9");
		}
		this.cifra = cifra;
	}// costruttore

	public int getCifra() {
		return this.cifra;
	}// getCifra
	
	public void setCifra(int cifra){
		this.cifra=cifra;
	}//setCifra

	public Coppia<Cifra> somma(Cifra c) {
		Coppia<Cifra> coppia;
		int somma=this.getCifra()+c.getCifra();
		Cifra primo;
		Cifra secondo;
		
		if(somma<=9){
			primo = null;
			secondo = new Cifra(somma);
		}else{
			primo = new Cifra(somma/10);
			secondo = new Cifra(somma%10);
		}
		coppia = new Coppia<Cifra>(primo, secondo);
		return coppia;
	}// somma

	public Coppia<Cifra> moltiplica(Cifra c) {
		Coppia<Cifra> coppia;
		int somma=this.getCifra()*c.getCifra();
		Cifra primo;
		Cifra secondo;
		
		if(somma<=9){
			primo = null;
			secondo = new Cifra(somma);
		}else{
			primo = new Cifra(somma/10);
			secondo = new Cifra(somma%10);
		}
		coppia = new Coppia<Cifra>(primo, secondo);
		return coppia;
	}// moltiplica

	@Override
	public int compareTo(Cifra c) {
		if (c.equals(this))
			return 0;
		if (c.getCifra() > this.getCifra())
			return -1;
		return 1;
	}// compareTo

	public int hashCode() {
		int mul = 31;
		int h = cifra;
		h = h * mul;
		;
		return h;
	}// hashCode

	public String toString() {

		return "" + cifra + "";

	}// toString

	public boolean equals(Object o) {
		if (!(o instanceof Cifra))
			return false;
		if (o == this)
			return true;
		Cifra c = (Cifra) o;
		if (c.getCifra() == this.getCifra())
			return true;
		return false;
	}// equals

	public static void main(String[] args) {
		Cifra c1 = new Cifra(9);
		Cifra c2 = new Cifra(2);
		System.out.println(c1.somma(c2));
		System.out.println(c1.moltiplica(c2));

	}// main
}// Cifra
