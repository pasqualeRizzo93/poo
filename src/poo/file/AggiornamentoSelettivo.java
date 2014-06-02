package poo.file;
import java.io.*;
import java.util.*;
public class AggiornamentoSelettivo {
	public static void main (String [] args) throws IOException {
		Scanner sc=new Scanner (System.in);
		System.out.println("Nome File: ");
		String nomeFile=sc.nextLine();
		System.out.println("Intero da inserire");
		int x=sc.nextInt();
		visualizza (nomeFile);
		inserisci(nomeFile, x);
		visualizza(nomeFile);
	}//main
	static void visualizza (String nomeFile) throws IOException {
		//apertura file in lettura
		DataInputStream dis=new DataInputStream (new FileInputStream (nomeFile));
		for (;;) {
			int x=0;
			try {
				x=dis.readInt();
				System.out.println(x);
			} catch (EOFException e) { break; }
		}
		dis.close();
	}//visualizza
	static void inserisci (String nomeFile, int x) throws IOException {
		DataInputStream dis=new DataInputStream (new FileInputStream(nomeFile));
		DataOutputStream dos=new DataOutputStream (new FileOutputStream("tmp"));
		int y=0;
		boolean flag=false;
		for (;;) {
			try {
				y=dis.readInt();
				if (y>x) {
					flag=true;
					break;
				}
				dos.writeInt (y);
			} catch (EOFException e) {break; }
		}
		if (flag) {
			dos.writeInt(y);
			for(;;) {
				try {
					y=dis.readInt ();
					dos.writeInt(y);
				} catch (EOFException e) {break; } //questo break ha efficacia sul for interno
			}
		}
		dis.close(); 
		dos.close();
		File f=new File ("nome");
		f.delete();
		File ff=new File ("tmp");
		ff.renameTo(f);
	}//inserisci
}//AggiornamentoSelettivo class
