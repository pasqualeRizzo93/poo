package poo.appelli;

import java.util.*;

public class ListaMap<T> extends ListaAstratta<T> {
	private Map<NominativoS, NominativoS> map = new HashMap<NominativoS, NominativoS>();
	private int size;

	@Override
	public int size() {
		return size;
	}// size

	@Override
	public void add(NominativoS n) {
		map.put(n, n);
		size++;
	}// add

	@Override
	public void sort(Comparator<NominativoS> c) {
		LinkedList<NominativoS> list = new LinkedList<NominativoS>(map.values());
		Collections.sort(list, c);

	}//sort(Comparator)

	@Override
	public void sort() {
		LinkedList<NominativoS> list = new LinkedList<NominativoS>(map.values());
		Collections.sort(list);
	}//sort()

}//ListaMap
