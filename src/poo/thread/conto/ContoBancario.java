package poo.thread.conto;

public interface ContoBancario{
	public void deposito( double quanto );
	public void prelievo( double quanto );
	public double saldo();
	public String conto();
}//ContoBancario
