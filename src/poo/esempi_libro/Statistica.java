package poo.esempi_libro;
import java.util.Scanner;
import poo.util.*;

public class Statistica {
	private Vector<Integer> v;
	public Statistica(Vector<Integer> v){
		this.v=new ArrayVector<Integer>(v.size());
		for( int i=0; i<v.size(); i++ ) this.v.add(v.get(i));
	}
	public double media(){
		double m=0;
		for( int i=0; i<v.size(); i++ )
			m+=v.get(i);
		return m/v.size();
	}
	public int max(){
		int m=0;
		for( int i=0; i<v.size(); i++ ){
			int voto=v.get(i);
			if( voto>m ) m=voto;
		}
		return m;
	}
	public int min(){
		int m=31;
		for( int i=0; i<v.size(); i++ ){
			int voto=v.get(i);
			if( voto<m ) m=voto;
		}
		return m;
	}
	public int moda(){
		int fmax=0, f=0, vmoda=0;
		for( int i=0; i<v.size(); i++ ){
			if( fmax>v.size()/2 ) break;
			int voto=v.get(i); f=1;
			for( int j=i+1; j<v.size(); j++ )
				if( v.get(j)==voto ) f++;
			if( f>fmax ){ fmax=f; vmoda=voto; }
		}
		return vmoda;
	}
	public double deviazioneStandard(){
		double med=media(), varianza=0;
		for( int i=0; i<v.size(); i++ ){
			int voto=v.get(i);
			varianza=varianza+(voto-med)*(voto-med);
		}
		varianza=varianza/v.size();
		return Math.sqrt(varianza);
	}
	public String toString(){
		StringBuilder sb=new StringBuilder(100);
		sb.append(String.format("%15s%10.2f%n","voto medio=",media()));
		sb.append(String.format("%15s%10d%n","voto max=",max()));
		sb.append(String.format("%15s%10d%n","voto min=",min()));
		sb.append(String.format("%15s%10d%n","voto moda=",moda()));
		sb.append(String.format("%15s%10.2f%n","sqm=",deviazioneStandard()));
		return sb.toString();
	}

	public static void main( String[] args ){
		System.out.println("Fornisci una sequenza di voti tra 18 e 30. Un voto errato termina.");
		Vector<Integer> v=new ArrayVector<Integer>();
		Scanner sc=new Scanner( System.in );
		do{
			int voto=sc.nextInt();
			if( voto<18 || voto>30 ) break;
			v.add(voto);
		}while(true);
		Statistica s=new Statistica(v);
		System.out.println(s);
	}
}//Statistica
