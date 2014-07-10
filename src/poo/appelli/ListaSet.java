package poo.appelli;

import java.util.*;


public class ListaSet<T> extends ListaAstratta<T> {
	private Set<NominativoS> lst = new HashSet<NominativoS>();
	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(NominativoS n) {
		if (cerca(n) == null) {
			lst.add(n);
			size++;
		}
		lst.remove(n);
		lst.add(n);
	}// add

	@Override
	public void sort(Comparator<NominativoS> c) {
		LinkedList<NominativoS> list = new LinkedList<NominativoS>(lst);
		Collections.sort(list, c);

	}

	@Override
	public void sort() {
		LinkedList<NominativoS> list = new LinkedList<NominativoS>(lst);
		Collections.sort(list);

	}

}
