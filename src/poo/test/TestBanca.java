package poo.test;
import poo.banca.*;
public class TestBanca {
	public static void main(String [] args) {
		ContoBancario cb=new ContoBancario("51/2233/44", 5000);
		ContoConFido cf=new ContoConFido("52/3327/72", 10000, 5000);
		cb=cf;
		ContoConFido c2;
		if (cb instanceof ContoConFido) { //interrogazione del tipo
			c2=(ContoConFido)cb; //casting
			c2.setFido(15000);
			c2.deposita(20000);
			c2.preleva(390000);
			System.out.println("Il saldo è: "+c2.saldo()+";");
			System.out.println("Lo scoperto è: "+c2.getScoperto()+";");
			System.out.println("Il fido è: "+c2.getFido ()+";");
		}
		ContoBancario clientela []=new ContoBancario [10];
		clientela[0]=new ContoBancario ("51/237", 1000);
		clientela[1]=new ContoConFido ("52/324", 10000, 1500);
		clientela[2]=new ContoConFido ("52/553", 50000, 12000);
		clientela[3]=new ContoBancario ("51/245", 5000);
		clientela[4]=new ContoBancario ("51/243", 20000);
		clientela[5]=new ContoConFido ("52/789", 20000, 4000);
		clientela[6]=new ContoBancario ("51/533", 2300);
		clientela[7]=new ContoBancario ("51/654", 2344);
		clientela[8]=new ContoConFido ("52/754", 23000, 2000);
		clientela[9]=new ContoConFido ("52/549", 100000, 20000);
		for (int i=0; i<clientela.length-1; i++)
			System.out.println("Il conto Bancario in posizione: "+i+" è: "+clientela[i]);
	}

}
