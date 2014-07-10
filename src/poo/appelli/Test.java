/**
 * 
 */
package poo.appelli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author DeSimone_F
 *
 */
public class Test {

    private static final String LEGGI = "leggi";
    private static final String SORT = "ordina";
    private static final String STAMPA = "stampa";
    private static final String ADD = "aggiungi";
    private static final String SALVA = "salva";
    private static final String STOP = "stop";
    private static final String SIZE = "size";
    
    public static void main(String[] args) throws Exception{
	
	Lista<NominativoS> lista = new ListaConcatenata<NominativoS>();
	boolean stop = false;
	while(!stop){
	
	    System.out.println("Inserisci un comando (i comandi ammessi sono: \"leggi\" , \"ordina\" , \"stampa\",  \"aggiungi\" , \"salva\" , \"stop\" ), \"size\" ) :");
	    Scanner sc = new Scanner(System.in);
	    String comando = sc.next();

	    if (comando.equals(LEGGI)) {
		// fai la lettura del file dal disco e popoli la lista
		BufferedReader br = new BufferedReader(new FileReader(new File(Paths.get("nominativi.txt").toAbsolutePath().toString())));
		String linea = "";

		while ((linea = br.readLine()) != null) {
		    System.out.println("analizzo la linea : " + linea);
		    StringTokenizer st = new StringTokenizer(linea," ,=");
		    st.nextToken();
		    String nome = st.nextToken();
		    System.out.println("nome : "+nome);
		    String cognome = st.nextToken();
		    System.out.println("cognome : "+cognome);
		    st.nextToken();
		    int codice = Integer.parseInt(st.nextToken("="));
		    System.out.println("codice : "+codice);
		    NominativoS nom = new NominativoS(nome, cognome, codice);
		    lista.add(nom);
		}
		
		System.out.println("ho letto dal file "+lista.size()+" nominativi");
	    } else if (comando.equals(SORT)) {
		System.out.println("riordino la lista");
		lista.sort();
		System.out.println("fatto !");
	    } else if (comando.equals(STAMPA)) {
		System.out.print("[");
		for (NominativoS nominativoS : lista) {
		    System.out.print(nominativoS.toString());
		    System.out.print(",");
		}
		System.out.print("]");
		System.out.println();
	    } else if (comando.equals(ADD)) {
		System.out.println("inserisci il nome della persona");
		String nome = sc.next();
		System.out.println("inserisci il cognome della persona");
		String cognome = sc.next();
		System.out.println("inserisci il codice della persona");
		int codice = sc.nextInt();
		NominativoS nom = new NominativoS(nome, cognome, codice);
		lista.add(nom);
		System.out.println("nominativo aggiunto correttamente");
	    } else if (comando.equals(SALVA)) {
		
		File fileOutput = new File(Paths.get("nominativi_saved.txt").toAbsolutePath().toString());
		if(!fileOutput.exists())fileOutput.createNewFile();
		PrintWriter print = new PrintWriter(fileOutput);
		for (NominativoS nominativoS : lista) {
		    print.print(nominativoS.toString());
		    print.println("");
		}
		// chiudi il gas e vieni via
		print.flush();
		print.close();
		
		System.out.println("File Salvato correttamente");
		
	    }else if (comando.equals(STOP)) {
		System.out.println("grazie per avermi usato , bye !");
		stop = true;
	    } else if (comando.equals(SIZE)) {
		System.out.println("la size corrente e' : "+lista.size());
	    } else {
	    System.out.println("Comando non riconosciuto");
	}
	}
	
	
	

    }
}
