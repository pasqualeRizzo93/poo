package poo.util;
import java.util.*;
public class EQ2 {
	public static void main (String [] args){
		System.out.println("Equazione di secondo grado");
		Scanner sc=new Scanner (System.in);
		System.out.println("a=");
		double a=sc.nextDouble();
		System.out.println("b=");
		double b=sc.nextDouble();
		System.out.println("c=");
		double c=sc.nextDouble();
		double d=b*b-4*a*c;
		if (d>=0) {
			if (d==0) {
				System.out.println("Radici reali e coincidenti");
				double x=-b/(2*a);
				System.out.printf("x1=x2=%1.2f\n", x);
			}
			else {//d>0
				double x1=(-b+Math.sqrt(d))/(2*a);
				double x2=(-b-Math.sqrt(d))/(2*a);
				System.out.printf("x1=%1.2f\n", x1);
				System.out.printf("x2=%1.2f\n", x2);
			}
		}
		else //d<0
			System.out.println("Non esistono radici reali!");
	}//main
}//classEQ2
