package poo.banca;
public class ContoBancario {
	private String numero;
	private double bilancio;
	public ContoBancario() {
		this.numero=numero;
	}
	public ContoBancario (String numero, double bilancio) {
		this.numero=numero; 
		this.bilancio=bilancio;
	}
	public double saldo () {return bilancio; }
	public void deposita (double quanto) {
		if (quanto <=0) 
			throw new IllegalArgumentException ();
		bilancio+=quanto;
	}//deposita
	public boolean preleva (double quanto) {
		if (quanto<=0)
			throw new IllegalArgumentException ();
		if (quanto>bilancio) 
			return false;
		bilancio-=quanto;
		return true;
	}//preleva
	public String toString () {
		return (numero+" €"+String.format("%1.2f", bilancio));
	}//toString
	public String conto () {return numero; }
}//ContoBancario
