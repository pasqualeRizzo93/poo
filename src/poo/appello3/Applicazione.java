package poo.appello3;

import java.io.*;
import java.util.*;

public class Applicazione {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Soldi cassa = new SoldiLC();
		BufferedReader br = new BufferedReader(new FileReader("/home/pasquale/workspace/poo/fcassa.txt"));
		String linea = null;
		StringTokenizer st = null;
		LinkedList<Denaro> tmp = new LinkedList<Denaro>();
		boolean okLettura = true;
		for (;;) {
			linea = br.readLine();
			if (linea == null)
				break;
			st = new StringTokenizer(linea, " ");
			try {
				double valore = Double.parseDouble(st.nextToken());
				int quantita = Integer.parseInt(st.nextToken());
				tmp.add(new Denaro(valore, quantita));
			} catch (Exception e) {
				okLettura = false;
				break;
			}
		}
		br.close();
		if (okLettura) {
			for (Denaro d : tmp)
				cassa.add(d);
		} else{
			throw new IOException();}
		System.out.println("Quant te dar?");
		Denaro d1= new Denaro(sc.nextDouble() , 1);
		System.out.println("Te i sord");
		Denaro d2= new Denaro(sc.nextDouble() , 1);
		Soldi s1=new SoldiLC();
		Soldi s2=new SoldiLC();
		s1.add(d1);s2.add(d2);
		System.out.println(cassa.sub(s1, s2));
		
	
	}// main

}// Applicazione
