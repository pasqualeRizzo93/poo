package poo.esempi_libro;
import java.util.*; 
public class Palindroma {
	public static void main (String [] args) {
		System.out.println("Questo programma stabilisce se una parola è palindroma o meno. Una parola è palindroma quando si legge allo stesso modo da sinistra a destra e viceversa.");
		Scanner sc=new Scanner (System.in);
		System.out.println("Inserire una parola");
		String s=sc.nextLine();
		Scanner sl=new Scanner (s);//scanner aperto sulla linea
		sl.useDelimiter("[^A-Za-z]+");				
	}
}
