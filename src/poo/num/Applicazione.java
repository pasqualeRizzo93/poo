package poo.num;

import java.util.*;
import java.io.*;

public class Applicazione {
	public static void main(String[] args) throws IOException {
		String linea = null;
		Numero somma=new NumeroLista();
		BufferedReader br = new BufferedReader(new FileReader(
				"/home/pasquale/workspace/poo/numero.txt"));
		Scanner sc = new Scanner(System.in);
		LinkedList<Numero> memoria=new LinkedList<Numero>();
	
		boolean okLettura = true;
		for (;;) {
			Numero tmp = new NumeroLista();
			linea = br.readLine();
			if (linea == null)
				break;
			try {
				for (int i = 0; i < linea.length(); i++) {
				   Character c1= linea.charAt(i);
				   int cifra=Character.getNumericValue(c1);
					Cifra c = new Cifra(cifra);
					tmp.add(c);
				}
				memoria.add(tmp);
			} catch (Exception e) {
				okLettura = false;
				break;
			}
		}
		br.close();
		if (okLettura) {
			Iterator<Numero> it = memoria.iterator();
			while (it.hasNext()) {
				somma=somma.somma(it.next());

			}
		} else {
			throw new IOException();

		}
		System.out.println(somma);

	}

}
