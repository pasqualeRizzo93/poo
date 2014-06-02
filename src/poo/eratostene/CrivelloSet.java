package poo.eratostene;
import java.util.*; 
public class CrivelloSet extends CrivelloAstratto {
	private Set<Integer> crivello=new LinkedHashSet<Integer>();
	private Set<Integer> primi=new LinkedHashSet<Integer>();
	private int N;
	public CrivelloSet (int N) {
		if (N<2) throw new IllegalArgumentException ();
		for (int i=2; i<N; i++) {
			crivello.add(i);
			this.N=N;
		}
	}
	public void filtra () {
		while (!crivello.isEmpty()) {
			int p=crivello.iterator().next();//1°fase
			primi.add(p);
			for (int m=p; m<N; m+=p)
				if (crivello.contains(m))
					crivello.remove(m);//2°fase
		}
	}//filtra
	public Iterator<Integer> iterator () {
		return primi.iterator();
	}//iterator
	public static void main (String... args) {
		int N=10000;
		Crivello cr=new CrivelloSet (N);
		cr.filtra();
		System.out.println("I numeri primi fra 2 e "+N+" sono: "+cr.size());
		System.out.println();
		System.out.println(cr);
	}//main
}//CrivelloSet class
