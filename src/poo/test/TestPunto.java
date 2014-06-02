package poo.test;
import java.util.*;

import poo.geometria.Punto;
public class TestPunto {
	public static void main (String [] args) {
		Punto p0=new Punto ();
		Punto p1=new Punto (2,3);
		Punto p2=new Punto (p1);
		p2.Sposta(7,5);
		double d=p1.distanza(p2);
		System.out.println("p2<"+p2.getX()+","+p2.getY()+">");
	}//main
}