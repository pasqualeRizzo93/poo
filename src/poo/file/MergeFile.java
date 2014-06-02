package poo.file;
import java.util.*;
import java.io.*;
public class MergeFile {
	public static void main( String... args) throws IOException{
		System.out.println("Fusione ordinata di due file di interi f1 ed f2 in un file f3");
		Scanner sc=new Scanner( System.in );
		System.out.print("nome esterno di f1 = ");
		String nomeF1=sc.nextLine();
		System.out.print("nome esterno di f2 = ");
		String nomeF2=sc.nextLine();
		System.out.print("nome esterno file fusione f3 = ");
		String nomeF3=sc.nextLine();
		
		ObjectFile<Integer> f1=new ObjectFile<Integer>( nomeF1, ObjectFile.Modo.LETTURA );
		System.out.println("Contenuto di f1:");
		System.out.println( f1 );
		ObjectFile<Integer> f2=new ObjectFile<Integer>( nomeF2, ObjectFile.Modo.LETTURA );
		System.out.println("Contenuto di f2:");
		System.out.println( f2 );
		ObjectFile<Integer> f3=new ObjectFile<Integer>( nomeF3, ObjectFile.Modo.SCRITTURA );
		
		int x1, x2;
		while( !f1.eof() && !f2.eof() ){
			x1=f1.peek(); x2=f2.peek();
			if( x1<x2 ){ //minimo proviene da f1
				f3.put( x1 ); f1.get();
			}
			else{ //minimo proviene da f2
				f3.put( x2 ); f2.get();
			}
		}
		
		//gestione residuo su f1
		while( !f1.eof() ){
			f3.put( f1.peek() ); f1.get();
		}
		//gestione residuo su f2
		while( !f2.eof() ){
			f3.put( f2.peek() ); f2.get();
		}
		f1.close(); f2.close(); f3.close();
		
		System.out.println("Contenuto di f3:");
		System.out.println( f3 );
		
	}//main
}//MergeFile
