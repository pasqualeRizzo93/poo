package poo.util;
import java.util.*;
public class Sommatoria {
	public static void main (String [] args){
		Scanner sc=new Scanner (System.in);
		System.out.println("n=");
		int n=sc.nextInt();
		int s=0;
		for (int i=0; i<=n; ++i)
			s+=i;
		System.out.println("somma="+s);
	}
}
