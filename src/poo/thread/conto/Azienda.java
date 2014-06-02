package poo.thread.conto;

public class Azienda {
	public static void main( String [] args ){
		ContoBancario cb=new ContoBancarioMJ( "52/7733/44", 1000 );
		Prelevante p1=new Prelevante( 1, cb, 10000, 2000, 1000, 500 );
		Prelevante p2=new Prelevante( 2, cb, 5000, 1000, 800, 100 );
		Prelevante p3=new Prelevante( 3, cb, 20000, 5000, 10000, 2000 );
		Depositante d1=new Depositante( 1, cb, 10000, 5000, 1000, 500 );
		Depositante d2=new Depositante( 2, cb, 8000, 1000, 2000, 1000 );
		p1.start(); p2.start(); p3.start();
		d1.start(); d2.start();
	}//main
}//Azienda
