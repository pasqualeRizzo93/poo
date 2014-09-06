package poo.appello_espr;
import java.util.*;
import java.io.*;

public class Applicazione {

	public static void main(String[] args) throws IOException {
		Memoria lista= new MemoriaConcatenata();
		Scanner sc= new Scanner(System.in);
		boolean stop=false;
		while(!stop){
			System.out.println("Dammi l espressione");
			String comando=sc.next();
			StringTokenizer stc= new StringTokenizer(comando,"=");
		if(comando.equalsIgnoreCase("LOAD")){
			System.out.println("inizio il caricamento delle varibili da file");
			BufferedReader br= new BufferedReader(new FileReader("memoria.txt"));
			String linea=null;
			while((linea=br.readLine()) != null){
				StringTokenizer st= new StringTokenizer(linea,"=");
				String variabile= st.nextToken();
				int valore= Integer.parseInt(st.nextToken());
				Variabile v=new Variabile(variabile,valore);
				lista.add(v);
				System.out.println("Caricata : "+v);
			}
			System.out.println("caricamento varibili concluso con successo");
		}else if(comando.equalsIgnoreCase("SAVE")){
			PrintWriter pw=new PrintWriter(new FileWriter("memoria.txt"));
			for(Object o: lista){
				Variabile v=(Variabile) o;
				pw.println(v);
			}
			pw.close();
			
		}else if(comando.equalsIgnoreCase("EXIT")){
			System.out.println("bye");
			System.exit(0);
		}else{
			String nome_variabile=stc.nextToken();
			String espressione=stc.nextToken();
			Variabile v=new Variabile(nome_variabile,valutaEspressione(espressione));
			lista.add(v);
			System.out.println("salvata la variabile: " + v);
		}
			
		}

	}
	
	/**
	 * 
	 * ATTENZIONE DA COMPLETARE !
	 * 
	 * Ho impostato il ragionamento, ma ho lasciato volontariamente incompleto il metodo.
	 * Per esercizio prova anzitutto a capire quali casi non riesce a gestire e seguendo il ragionamento 
	 * prova a completare il lavoro. Un piccolo suggerimento: se usi la ricorsione bene puoi risolvere tutto velocemente.
	 * 
	 * @param exp l'espressione che deve essere valutata 
	 * @return il risultato dell'espressione.
	 * @throws IllegalArgumentException quando non e' possibile calcolare l'espressione che viene passata come argomento per le seguenti ragioni <br />
	 * <ul>
	 * 	<li> Utilizza una variabile non definita in precedenza </li>
	 * 	<li> Si sta cercando di fare una divisione per zero</li>
	 * </ul>
	 */
	private static int valutaEspressione ( String exp ) throws IllegalArgumentException{
		int result = 0;
		int i = 0;
		  if(exp.contains("+"))
		  {
			i = exp.lastIndexOf("+");
			result=valutaEspressione(exp.substring(0, i))+valutaEspressione(exp.substring(i+1, exp.length()));
		  } else if(exp.contains("-"))
		  {
			i = exp.lastIndexOf("-");
		    result=valutaEspressione(exp.substring(0, i))-valutaEspressione(exp.substring(i+1, exp.length()));
		  } else if(exp.contains("/"))
		  {
			  i = exp.lastIndexOf("/");
			  if(exp.substring(i+1, exp.length()).contains("0")) throw new IllegalArgumentException("non si puo dividere per 0!");
		    result=valutaEspressione(exp.substring(0, i))/valutaEspressione(exp.substring(i+1, exp.length()));
		  } else if(exp.contains("*"))
		  {
			  i = exp.lastIndexOf("*");
		    result=valutaEspressione(exp.substring(0, i))*valutaEspressione(exp.substring(i+1, exp.length()));
		  } else{
			  result = Integer.parseInt(exp);
		  }
		return result;
	}

}
