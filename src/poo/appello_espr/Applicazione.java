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
			BufferedReader br= new BufferedReader(new FileReader("/home/pasquale/workspace/poo/memoria.txt"));
			String linea=null;
			while((linea=br.readLine()) != null){
				StringTokenizer st= new StringTokenizer(linea,"=");
				String variabile= st.nextToken();
				int valore= Integer.parseInt(st.nextToken());
				Variabile v=new Variabile(variabile,valore);
				lista.add(v);
				System.out.println(v);
			}
		}else if(comando.equalsIgnoreCase("SAVE")){
			PrintWriter pw=new PrintWriter(new FileWriter("/home/pasquale/workspace/poo/memoria.txt"));
			for(Object o: lista){
				Variabile v=(Variabile) o;
				pw.println(v);
			}
			pw.close();
			
		}else if(comando=="."){
			System.exit(-1);
		}
		else{
			String nome_variabile=stc.nextToken();
			String espressione=stc.nextToken();
			int x=0;
			int y=0;
			for(int i=0;i<espressione.length();i++){
				Character c=espressione.charAt(i);
				if(c!='+' || c!='-' || c!='/' || c!='*' || c!= '%'){
					 y=Character.getNumericValue(c);
				}else if(c=='+'){
					x+=y;
				}else if(c=='-'){
					 x-=y;
				}else if(c=='/'){
					 x/=y;
				}else if(c=='*'){
			         x*=y;
				}else if(c=='%'){
					 x%=y;
				}
				
			}
			Variabile v=new Variabile(nome_variabile,x);
			System.out.println(v);
		}
			
		}

	}

}
