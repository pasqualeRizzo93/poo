package poo.thread.conto;

public class Depositante extends Thread{
	private int id;
	private ContoBancario cb;
	private int delayMax, delayMin;
	private double dMax, dMin;
	public Depositante( int id, ContoBancario cb, 
			            int delayMax, int delayMin,
			            double dMax, double dMin ){
		this.id=id; this.cb=cb;
		this.delayMax=delayMax; this.delayMin=delayMin;
		this.dMax=dMax; this.dMin=dMin;
	}
	private void delay() throws InterruptedException{
		try{
			Thread.sleep( (int)(Math.random()*(delayMax-delayMin)+delayMin) );
		}catch( InterruptedException e ){
			throw e;
		}
	}//delay
	public void run(){
		while( true ){
			try{
				delay();
			}catch( InterruptedException e ){}
			double ammontare=Math.random()*(dMax-dMin)+dMin;
			cb.deposito( ammontare );
			System.out.println("Depositante #"+id+" ha depositato "+String.format("%1.2f", ammontare));
		}
	}//run
}//Depositante
