package poo.banca;
public class ContoConFido extends ContoBancario {
	private double scoperto, fido;
	public ContoConFido (String numero, double bilancio, double fido) {
		super (numero, bilancio); //si usa super x invocare un costruttore della super-classe
		if (fido<0)
			throw new IllegalArgumentException ();
		this.fido=fido;
	}
	public double getFido() {return fido; }
	public double getScoperto () {return scoperto; }
	public void setFido (double nuovoFido) {
		if (nuovoFido<0)
			throw new IllegalArgumentException ();
		this.fido=nuovoFido;
	}//setFido
	@Override //ridefinizione di un metodo di ContoBancario
	public void deposita (double quanto) {
		if (quanto<0)
			throw new IllegalArgumentException ();
		if (quanto<=scoperto)
			scoperto-=quanto;
		else {
			double residuo=quanto-scoperto;
			scoperto=0;
			super.deposita(residuo);
		}
	}//deposita
	@Override
	public boolean preleva (double quanto) {
		if (quanto<0) 
			throw new IllegalArgumentException ();
		if (quanto<=saldo()) {
			super.preleva(quanto);
			return true;
		}
		if (quanto<=saldo()+fido-scoperto) { //massimo prelevabile
			double residuo=saldo();
			super.preleva(residuo);
			scoperto+=quanto-residuo;
			return true;
		}
		return false;
	}//preleva
	public String toString () {
		return(super.toString()+" fido=€ "+String.format("%1.2f", fido)+" scoperto=€ "+String.format("%1.2f",fido)+" scoperto=€ "+String.format("%1.2f", scoperto));
	}//toString
}//ContoConFido