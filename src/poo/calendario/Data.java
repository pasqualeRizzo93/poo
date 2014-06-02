package poo.calendario;
import java.util.GregorianCalendar;
public class Data {
	private int g, m, a;
	public Data (int g, int m, int a) {
		if (g<1 || g>durata(m,a) || m<1 || m>12 || a<0){
			System.out.println("Data scorretta");
			System.exit(-1);
		}
		this.g=g; 
		this.m=m; 
		this.a=a;
	}//Data
	public Data () {
		GregorianCalendar gc=new GregorianCalendar ();
		this.g=gc.get(GregorianCalendar.DAY_OF_MONTH);
		this.m=gc.get(GregorianCalendar.MONTH)+1;
		this.a=gc.get(GregorianCalendar.YEAR);
	}//Data
	public String toString () {
		return ""+g+"/"+m+"/"+a;
	}//toString
	public static boolean bisestile (int a) {
		boolean bisestile = false;
		if (a<0) { System.out.println("Anno negativo");
			System.exit(-1); }
		if (a%4!=0) return false;
		if (a%100==0 && a%400!=0) bisestile=false;
		bisestile=true;
		return bisestile;
	}//bisestile
	public static int durata (int m, int a) {
		if (m<1 || m>12 || a<0) { System.out.println("Data scorretta"); System.exit(-1); }
		switch (m) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
		case 2: if (bisestile (a)) return 29;
		else return 28;
		default: return 30;
		}
	} //durata
	public Data giornoDopo () {
		int gg, mm, aa;
		if (g==durata(m,a)) {
			gg=1;
			if (m==12) {mm=1; aa=a+1; }
			else {mm=m+1; aa=a; }
		}
		else {gg=g+1; mm=m; aa=a; }
		return new Data (gg,mm,aa);
	}
	public Data giornoPrima () {
		if(g==1 && m==1 && a==0)
			throw new RuntimeException ("Prima data");
		int g=this.g, m=this.m, a=this.a;
		if (this.g==1) {
			if (this.m>1) m=this.m-1;
			else {m=12; a=this.a-1; }
			g=durata(m,a);
		}
		else g=this.g-1;
		return new Data (g,m,a);
	}
}//Data

