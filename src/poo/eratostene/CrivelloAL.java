package poo.eratostene;
import java.util.*;
public class CrivelloAL extends CrivelloAstratto {
	private List<Integer> crivello= new ArrayList<Integer>();
	private List<Integer> primi= new ArrayList<Integer>();
	private int N;
	public CrivelloAL (int N) {
		if (N<2) throw new IllegalArgumentException ();
		for (int i=2; i<N; i++) {
			crivello.add(i);
			this.N=N;
		}
	}//costruttore
	public void filtra() {
		while (!crivello.isEmpty()) {
			int p=crivello.iterator().next();
			primi.add(p);
			for (int m=p; m<N; m+=p)
				if (crivello.contains(m))
					crivello.remove(m);
		}
	}//filtra
	public Iterator<Integer> iterator() {
		return primi.iterator();
	}
	public static void main (String[] args) {
		int n=10;
		Crivello cr=new CrivelloAL(n);
		cr.filtra();
		System.out.println("I numeri primi fra 2 e "+n);
		System.out.println();
		System.out.println(cr);
	}//main
}
