package poo.banca;

public class GestioneConti {
	private ContoBancario [] clientela;
	private int size; //serve ad indicare la dimensione effettiva dell'array e punta al primo elemento che trova libero
	public GestioneConti(int n) {
		if (n<=0) throw new IllegalArgumentException ();
		clientela=new ContoBancario [n];
	}
	public int size () {return size; }
	public void aggiungiConto (ContoBancario c) {
		if (size==clientela.length){
			ContoBancario []cl=new ContoBancario [clientela.length*2];
			System.arraycopy(clientela, 0, cl, 0, size);
			//i parametri: il 1° indica l'array, 2° indica l'indice di partenza, 3° indica dove collocare i nuovi elementi, il 4° indica la posizione da cui partire nel nuovo array e il 5° indica gli elementi
			clientela=cl;
		}
		clientela [size]=c;
		size ++;
	}//aggiungi Conto
	public void rimuoviConto (String numero) {
		ContoBancario cb=new ContoBancario (numero, size);
		for (int i=0; i<size; i++) {
			if (clientela[i].equals(cb)) 
				for (int j=i+1; j<size-1; j++) {
					clientela [j-1]=clientela [j];
					clientela [j]=null;
				}
			size --;
			return;
		}
	}//rimuovi conto
	public ContoBancario cerca (String numero) {
		ContoBancario cb=new ContoBancario (numero,size);
		for (int i=0; i<size; i++)
			if (clientela [i].equals(cb))
				return clientela[i];
		return null;
	}//cerca
	@Override 
	public String toString () {
		String s="";
		for (int i=0; i<size; i++)
			s+=clientela [i]+"\n";
		return s;
	}//toString
}//Gestione Conti
