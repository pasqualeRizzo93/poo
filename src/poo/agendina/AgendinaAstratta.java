package poo.agendina;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class AgendinaAstratta implements Agendina{
	
	public abstract void aggiungi( Nominativo n );
	public abstract Iterator<Nominativo> iterator();

	public int size(){
		int conta=0;
		for( Nominativo n: this ) conta++;
		return conta;
	}//size
		
	public void svuota(){
		Iterator<Nominativo> it=this.iterator();
		while( it.hasNext() ) {
			it.next(); it.remove();
		}
	}//svuota
	
	public void rimuovi( Nominativo n ){
		Iterator<Nominativo> it=this.iterator();
		while( it.hasNext() ) {
			Nominativo x=it.next();
			if( x.equals(n) ){ it.remove(); break; }
			if( x.compareTo(n)>0 ) break;
		}
	}//rimuovi

	public Nominativo cerca( Nominativo n ){
		for( Nominativo x: this ){
			if( x.equals(n) ) return x;
			if( x.compareTo(n)>0 ) break;
		}		
		return null;
	}//cerca

	public Nominativo cerca( String prefisso, String telefono ){
		for( Nominativo x: this )
			if( x.getPrefisso().equals(prefisso) &&
				x.getTelefono().equals(telefono) ) return x;
		return null;
	}//cerca

	public void salva(String nomeFile) throws IOException{
    	PrintWriter pw=new PrintWriter( new FileWriter(nomeFile));
		for( Nominativo n: this ) pw.println(n);
		pw.close();
	}//salva
	
	public void ripristina(String nomeFile)throws IOException{
		BufferedReader br=new BufferedReader( new FileReader(nomeFile) );
		String linea=null;
		StringTokenizer st=null;

		LinkedList<Nominativo> tmp=new LinkedList<Nominativo>();
		//tmp e' utile per far fronte a malformazioni del file
		boolean okLettura=true;
		for(;;){
			linea=br.readLine();
			if( linea==null ) break; //eof di br
			st=new StringTokenizer(linea," -");
			try{
				String cog=st.nextToken();
				String nom=st.nextToken();
				String pre=st.nextToken();
				String tel=st.nextToken();
				tmp.add( new Nominativo( cog, nom, pre, tel ) ); //aggiunge in coda
			}catch(Exception e){
				okLettura=false;
				break;
			}
		}
		br.close();
		if( okLettura ){ 
			this.svuota();
			for( Nominativo n: tmp ) this.aggiungi(n);
		}
		else 
			throw new IOException();
	}//ripristina
	
	public String toString(){
		StringBuilder sb=new StringBuilder(1000);
		for( Nominativo x: this ){
			sb.append( x );
			sb.append('\n');
		}
		return sb.toString();
	}//toString
	
}//AgendinaAstratta
