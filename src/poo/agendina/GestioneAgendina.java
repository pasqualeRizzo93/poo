package poo.agendina;
import java.util.*;
import java.io.*;

public class GestioneAgendina{
	//ambiente globale
	static Agendina agenda;
	static String linea;
	static StringTokenizer st;
	static Scanner sc;
	
	public static void main( String []args ) throws IOException{
		System.out.println("Programma Agendina Telefonica");
		System.out.println();
		System.out.println("Scegli tra: 0-AgendinaAL 1-AgendinaLL 2-AgendinaSet 3-AgendinaMap 4-AgendinaVector");
		sc=new Scanner( System.in );
		int tipo=0, capacita=0;
		do{
			tipo=sc.nextInt();
			if( tipo<0 || tipo>4 )
				System.out.print("Cosa ? Digitare un numero da 0 a 4 ");
		}while(tipo<0 || tipo>4);
		if( tipo==0 || tipo==4 ){
			System.out.print("Capacita' = ");
			capacita=sc.nextInt();
		}
		switch(tipo){
			case 0: 
				agenda=new AgendinaAL(capacita); break;
			case 1: 
				agenda=new AgendinaLL(); break;
			case 2: 
				agenda=new AgendinaSet(); break;
			case 3: 
				agenda=new AgendinaMap(); break;
			default:
				agenda=new AgendinaVector(capacita);
		}
		
		sc.nextLine(); //salta fine linea
		comandi();
		ciclo: for(;;){
			System.out.print(">");
			linea=sc.nextLine();
			st=new StringTokenizer(linea, " ");
			char comando=(st.nextToken().toUpperCase()).charAt(0);
			switch( comando ){
				case 'Q': quit(); break ciclo;
				case 'A': aggiungiNominativo(); break;
				case 'R': rimuoviNominativo(); break;
				case 'T': ricercaTelefono(); break;
				case 'P': ricercaPersona(); break;
				case 'Z': azzera(); break;
				case 'E': mostraElenco(); break;
				case 'S': salva(); break;
				case 'C': carica(); break;
				default: errore();
			}
		}//for
		System.out.println("Bye.");
	}//main
	
	static void aggiungiNominativo(){
		try{
			String cog=st.nextToken().toUpperCase();
			String nom=st.nextToken().toUpperCase();
			String pre=st.nextToken();
			String tel=st.nextToken();
			Nominativo n=new Nominativo( cog, nom, pre, tel );
			agenda.aggiungi( n );
		}catch( Exception e ){
			System.out.println("Dati incompleti!");
		}
	}//aggiugiNominativo
	
	static void rimuoviNominativo(){
		try{
			String cog=st.nextToken().toUpperCase();
			String nom=st.nextToken().toUpperCase();
			agenda.rimuovi( new Nominativo(cog, nom, "", "") );
		}catch( Exception e ){
			System.out.println("Dati incompleti!");
		}
	}//rimuoviNominativo
	
	static void azzera(){
		agenda.svuota();
	}//azzera
	
	static void ricercaTelefono(){
		try{
			String cog=st.nextToken().toUpperCase();
			String nom=st.nextToken().toUpperCase();
			Nominativo n=agenda.cerca( new Nominativo(cog, nom, "", "") );
			if( n==null ) 
				System.out.println("Nominativo inesistente!");
			else 
				System.out.println(n.getPrefisso()+"-"+n.getTelefono());		
		}catch( Exception e ){
			System.out.println("Dati incompleti!");
		}
	}//ricercaTelefono
	
	static void ricercaPersona(){
		try{
			String pre=st.nextToken();
			String tel=st.nextToken();
			Nominativo n=agenda.cerca( pre, tel );
			if( n==null ) 
				System.out.println("Nominativo inesistente!");
			else 
				System.out.println(n.getCognome()+" "+n.getNome());			
		}catch( Exception e ){
			System.out.println("Dati incompleti!");
		}
	}//ricercaPersona
	
	static void mostraElenco(){
		System.out.println( agenda );
	}//mostraElenco
	
	static void salva() throws IOException{
		String nomeFile=null;
		try{
        	nomeFile=st.nextToken();
		}catch( Exception e ){
			System.out.println("Dati incompleti!");
			return;
		}
		agenda.salva( nomeFile );
	}//salva
	
	static void carica() throws IOException{
		String nomeFile=null;
		try{
        	nomeFile=st.nextToken();
		}catch( Exception e ){
			System.out.println("Dati incompleti!");
			return;
		}
		File f=new File( nomeFile );
		if( !f.exists() ){
			System.out.println("File inesistente!");
			return;
		}		
		try{
			agenda.ripristina( nomeFile );
		}catch(IOException e){
			System.out.println("Nessuna apertura!");
		}
	}//carica
	
	static void comandi(){
		System.out.println();
		System.out.println("Comandi ammessi e relativi parametri:");
		System.out.println("A(ggiungi  cog  nom  pre  tel");
		System.out.println("R(imuovi  cog  nom");
		System.out.println("Z(azzera");
		System.out.println("T(elefono  cog  nom");
		System.out.println("P(persona  pre  tel");
		System.out.println("E(lenco");
		System.out.println("S(alva  nomefile");
		System.out.println("C(arica  nomefile");
		System.out.println("Q(uit");
		System.out.println();
	}//comandi
	
	static void errore(){
		System.out.println("Comando sconosciuto!");
		comandi();
	}//errore
	
	static void quit() throws IOException{
		System.out.print("Vuoi salvare il contenuto dell'agenda prima di terminare(y/n)?");
		String yesno=sc.nextLine();
		if( yesno.toLowerCase().equals("y") ){
			System.out.print("nome file=");
			String nomeFile=sc.nextLine();
			try{
				agenda.salva( nomeFile );
			}catch( IOException ioe ){
				System.out.println("Errore salvataggio!");
			}
		}
	}//quit
	
}//GestioneAgendina
