package poo.eratostene;
import java.util.*;
public abstract class CrivelloAstratto implements Crivello {
	public int size () {
		Iterator<Integer> it=this.iterator ();
		int c=0;
		for (int x : this)
			c++;
		return c;
	}//size
	public String toString () {
		StringBuilder sb=new StringBuilder (200);
		int c=0;
		for (int x : this) {
			sb.append(String.format("%11d", x));
			c++;
			if (c%10==0)
				sb.append('\n');
		}
		return sb.toString();
	}//toString
	public int hashCode () {
		final int MOLT=41;
		int h=0;
		for (Integer x : this)
			h=h*MOLT+x.hashCode();
		return h;
	}//hashCode
	public boolean equals (Object o){
		if (!(o instanceof Crivello)) return false;
		if (o==this) return true;
		Crivello c= (Crivello)o;
		Iterator<Integer> i1= this.iterator();
		Iterator<Integer> i2= c.iterator();
		while (i1.hasNext()){
		int x1=i1.next();
		int x2=i2.next();
		if (x1 != x2) return false;
		}//while
		return true;
		}//equals
}//CrivelloAstratto class
