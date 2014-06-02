package poo.file;
import java.io.*;
import java.util.*;
public class NaturalMergeSort<T extends Serializable & Comparable<? super T>> {
	private ObjectFile<T> f, temp1, temp2;
	private String nomeFile;
	public NaturalMergeSort (String nomeFile) throws IOException {
		this.nomeFile=nomeFile;
		f=new ObjectFile<T> (nomeFile, ObjectFile.Modo.LETTURA);
		temp1=new ObjectFile<T> ("c:\\poo-file\\temp1", ObjectFile.Modo.SCRITTURA);
		temp2=new ObjectFile<T> ("c:\\poo-file\\temp2", ObjectFile.Modo.SCRITTURA);
	}//costruttore
	public void risolvi () throws IOException {
		int numSeg=0;
		do {
			distribuisci();
			temp1.close(); temp2.close(); f.close();
			f.open(ObjectFile.Modo.LETTURA);
			temp1.open(ObjectFile.Modo.LETTURA);
			temp2.open(ObjectFile.Modo.LETTURA);
			numSeg=ricombina();
			temp1.close(); temp2.close(); f.close();
			temp1.open(ObjectFile.Modo.SCRITTURA);
			temp2.open(ObjectFile.Modo.SCRITTURA);
		} while (numSeg>1);
		//rimozione file temporanei
		temp1.close(); temp2.close();
		File tf=new File ("c:\\poo-file\\temp1");
		tf.delete();
		tf=new File ("c:\\poo-file\\temp2");
		tf.delete();
	}//risolvi
	public void distribuisci () throws IOException {
		while (!f.eof()) {
			copiaSegmento(f, temp1);
			if (!f.eof())
				copiaSegmento(f, temp2);
		}
	}//distribuisci
	private int ricombina () throws IOException {
		int numSeg=0;
		while (!temp1.eof() && !temp2.eof()) {
			fondi2Segmenti ();
			numSeg++;
		}
		//gestione residui
		while (!temp1.eof()) {
			copiaSegmento (temp1, f);
			numSeg++;
		}
		while (!temp2.eof()) {
			copiaSegmento (temp2, f);
			numSeg++;
		}
		return numSeg;
	}//ricombina
	private void copiaSegmento (ObjectFile<T> da, ObjectFile<T> a) throws IOException {
		boolean fineSegmento=false;
		do {
			fineSegmento=copiaElemento (da,a);
		} while (!fineSegmento);
	}//copiaSegmento
	private void fondi2Segmenti () throws IOException {
		boolean fine1Seg=false, fine2Seg=false;
		while (!fine1Seg && !fine2Seg) {
			T x1=temp1.peek();
			T x2=temp2.peek();
			if (x1.compareTo(x2)<0) fine1Seg=copiaElemento (temp1, f);
			else fine2Seg=copiaElemento(temp2, f);
		}
		//gestione residui
		while (!fine1Seg) 
			fine1Seg=copiaElemento (temp1, f);
		while (!fine2Seg)
			fine2Seg=copiaElemento (temp2, f);
	}//fondi2Segmenti
	private boolean copiaElemento (ObjectFile<T> sorg, ObjectFile<T> dest) throws IOException {
		boolean fineSeg=false;
		T prec=sorg.peek();
		dest.put(prec);
		sorg.get();
		if (!sorg.eof()) fineSeg=sorg.peek().compareTo(prec)<0;
		else fineSeg=true;
		return fineSeg;
	}//copiaElemento
	public static void main (String [] args) throws IOException {
		System.out.println("Ordinamento esterno di un file di interi per fusione naturale");
		Scanner sc=new Scanner (System.in);
		System.out.println("Nome file: ");
		String nomeFile=sc.nextLine();
		ObjectFile<Integer> of=new ObjectFile<Integer> (nomeFile, ObjectFile.Modo.LETTURA);
		System.out.println("Contenuto iniziale di "+nomeFile);
		System.out.println(of);
		of.close();
		new NaturalMergeSort<Integer> (nomeFile).risolvi();
		of.open(ObjectFile.Modo.LETTURA);
		System.out.println("Contenuto iniziale di "+nomeFile);
		System.out.println(of);
	}//main
}//NaturalMergeSort class