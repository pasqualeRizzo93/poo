package poo.num;

import java.util.*;
import java.io.*;

public class Applicazione {
	public static void main(String[] args) throws IOException {
		Numero u= new NumeroLista();
		u.add(new Cifra(2));
		u.add(new Cifra(3));
		u.add(new Cifra(1));
		System.out.println(u);
		String linea = null;
		Numero s=new NumeroLista();
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
				s=s.somma(it.next());

			}
		} else {
			throw new IOException();

		}
		System.out.println(s);

	}

}
