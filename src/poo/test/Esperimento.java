package poo.test;
import javax.crypto.Mac;

import poo.giochi.Monetina;

public class Esperimento {
	public static void main (String [] args) {
		Monetina m1=new Monetina();
		Monetina m2=new Monetina();
		int cf1=0;
		int cf2=0;
		cf1=(m1.getFaccia()==Monetina.testa)?
				cf1+1:0;
		if (cf1<3)
			System.out.println("Vince la 2° monetina");
		else if (cf2<3) System.out.println("Vince la 1° monetina");
		else System.out.println("Parità");
	}//main
}//Esperimento
