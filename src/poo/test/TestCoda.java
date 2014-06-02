package poo.test;

import java.util.*;
import poo.util.*;
public class TestCoda {
	static Scanner sc=null;
	static Coda<String> coda=null; 
	static String LINEA_COMANDO="([Aa][\\s]+[a-zA-Z0-9]+|[Pp]|[Qq])";
	static void comandi(){
		System.out.println("Comandi ammessi: ");
		System.out.println("A)rrivo string INVIO");
		System.out.println("P)artenza INVIO");
		System.out.println("Q)uit INVIO");		
	}
	static boolean run(){
		System.out.print(">>");
		String linea=sc.nextLine();
		String s=null;
		if( !linea.matches(LINEA_COMANDO) ){
			System.out.println("Linea comando errata!");
			comandi();
			return false;
		}
		char c=Character.toLowerCase(linea.charAt(0));
		switch(c){
		case 'a': 
			int i=linea.lastIndexOf(' ');
			s=linea.substring(i+1);
			try{
				coda.put(s); 
				System.out.println("*"+s+"* entra in coda");
				System.out.println("Situazione attuale: "+coda);
			}catch( RuntimeException e ){
				System.out.println("Coda piena!");
			}
			break;
		case 'p':
			try{
				s=coda.get(); 
				System.out.println("*"+s+"* esce dalla coda");
				System.out.println("Situazione attuale: "+coda);
			}catch( RuntimeException e ){	
				System.out.println("Coda vuota!");		
			}
			break;
		case 'q':
			System.out.print("Situazione coda residua: "+coda);
			return true;
		}//switch
		return false;
	}//run
	public static void main( String[] args ){
		sc=new Scanner(System.in);
		coda=new BufferLimitato<String>(10);
		boolean uscita=false;
		comandi();
		do{	uscita=run(); }while( !uscita );
	}//main
}//TestCoda
