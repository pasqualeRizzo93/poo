package poo.test;
import poo.calendario.Data;
public class TestData {
	public static void main (String [] args) {
		Data oggi=new Data();
		System.out.println("Oggi �: "+oggi+";");
		Data domani=oggi.giornoDopo();
		System.out.println("domani sar� "+domani+";");
		Data ieri=oggi.giornoPrima ();
		System.out.println("ieri era "+ieri+";");
		System.out.println("quest'anno � bisestile? "+Data.bisestile(2013));
	}
}