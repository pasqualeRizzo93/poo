package poo.appello2;

import java.util.*;

public class ListaMap<T> extends ListaAstratta<T> {
	private Map<NominativoS, NominativoS> map = new HashMap<NominativoS, NominativoS>();


	@Override
	public int size() {
		return map.size();
	}// size

	@Override
	public void add(NominativoS n) {
		map.put(n, n);
		
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
