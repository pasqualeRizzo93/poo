package poo.file;
import java.io.*;
import java.util.*;
/**
 * 
 * Crea un file di interi a partire da una successione
 * letta da tastiera. Una linea vuota termina
 *
 */
public class CreaObjectFile{
	public static void main( String []args )throws IOException {
		Scanner s=new Scanner( System.in );
		System.out.print("nome file da creare=");
		String nome=s.nextLine();
		ObjectFile<Integer> of=
			new ObjectFile<Integer>( nome, ObjectFile.Modo.SCRITTURA );
		System.out.println("Fornisci una serie di interi uno per linea. Solo INVIO termina");
		for(;;){
			System.out.print("int>");
			String input=s.nextLine();
			if( input.length()==0 ) break;
			of.put( Integer.parseInt(input) );
		}
		of.close();
		ObjectFile<Integer> in=new ObjectFile<Integer>( nome, ObjectFile.Modo.LETTURA );
		System.out.println();
		System.out.println("Contenuto del file");
		System.out.println( in );
	}//main
}//Crea