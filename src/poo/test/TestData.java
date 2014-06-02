package poo.test;
import poo.calendario.Data;
public class TestData {
	public static void main (String [] args) {
		Data oggi=new Data();
		System.out.println("Oggi è: "+oggi+";");
		Data domani=oggi.giornoDopo();
		System.out.println("domani sarà "+domani+";");
		Data ieri=oggi.giornoPrima ();
		System.out.println("ieri era "+ieri+";");
		System.out.println("quest'anno è bisestile? "+Data.bisestile(2013));
	}
}