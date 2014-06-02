package poo.thread.conto;
import java.util.*;

public class ContoBancarioMJ implements ContoBancario{

	private class Item{
		private Thread thread;
		private double quanto;
		public Item( Thread thread, double quanto ){
			this.thread=thread; this.quanto=quanto;
		}
		public Thread getThread(){ return thread; }
		public double getQuanto(){ return quanto; }
	}//Item
	
	private String numero;
	private double bilancio=0;
	private LinkedList<Item> attesa=new LinkedList<Item>();
	private Object lock = new Object();
	
	public ContoBancarioMJ( String numero, double bilancio ){
		if( bilancio<0 ) throw new IllegalArgumentException();		
		this.bilancio=bilancio; this.numero=numero;
	}
	
	private boolean prelevanteDeveAttendere( double quanto ){
		if( quanto>bilancio || attesa.getFirst().getThread()!=Thread.currentThread() )
			return true;
		return false;
	}//prelevanteDeveAttendere
	
	public void deposito( double quanto ){
		if( quanto<=0 ) throw new IllegalArgumentException();
		synchronized(lock){
			bilancio=bilancio+quanto;
			System.out.println("Dopo deposito di "+String.format("%1.2f",quanto)+
				" bilancio="+String.format("%1.2f", bilancio) );
			if( attesa.size()>0 && attesa.getFirst().getQuanto()<=bilancio )
				lock.notifyAll();
		}
	}//deposito
	
	public void prelievo( double quanto ){
		if( quanto<=0 ) throw new IllegalArgumentException();
		synchronized(lock){
			attesa.add( new Item( Thread.currentThread(), quanto ) );
			while( prelevanteDeveAttendere( quanto ) ){
				try{
					lock.wait();
				}catch( InterruptedException e ){}
			}
			attesa.removeFirst();
			bilancio=bilancio-quanto;
			System.out.println("Dopo prelievo di "+String.format("%1.2f",quanto)+
				" bilancio="+String.format("%1.2f", bilancio) );
			if( attesa.size()>0 && attesa.getFirst().getQuanto()<=bilancio )
				lock.notifyAll();
		}
	}//prelievo
	
	public double saldo(){ 
		synchronized( lock ){
			return bilancio; 
		}
	}//saldo
	
	public String conto(){
		synchronized(lock){
			return numero;
		}
	}//conto
	
}//ContoBancarioMJ
