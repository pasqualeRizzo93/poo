package poo.appello2;

import java.util.*;

public class ListaSet<T> extends ListaAstratta<T> {
	private Set<NominativoS> lst = new HashSet<NominativoS>();

	@Override
	public int size() {
		return lst.size();
	}

	@Override
	public void add(NominativoS n) {
		if (cerca(n) == null) {
			lst.add(n);
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
