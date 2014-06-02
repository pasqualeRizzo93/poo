package poo.thread.conto;

public class Prelevante extends Thread{
	private int id;
	private ContoBancario cb;
	private int delayMax, delayMin;
	private double pMax, pMin;
	public Prelevante( int id, ContoBancario cb, 
			           int delayMax, int delayMin, 
			           double pMax, double pMin ){
		this.id=id; this.cb=cb;
		this.delayMax=delayMax; this.delayMin=delayMin;
		this.pMax=pMax; this.pMin=pMin;
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
			double ammontare=Math.random()*(pMax-pMin)+pMin;
			cb.prelievo( ammontare );
			System.out.println("Prelevante #"+id+" ha prelevato "+String.format("%1.2f", ammontare));
		}
	}//run
}//Prelevante
