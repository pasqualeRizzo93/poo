package poo.test;
import poo.geometria.*;
public class TestTriangolo1 {
	public static void main(String[] args) {
		Punto pa=new Punto (3,3);
		Punto pb=new Punto (0,-3);
		Punto pc=new Punto (-3,0);
		Triangolo t1=new Triangolo (pa, pb, pc);
	}
}
