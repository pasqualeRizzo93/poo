package poo.appelli;
import java.util.*;

public interface Lista<NominativoS> extends Iterable<NominativoS> {
int size();
void clear();
void add(NominativoS n);
NominativoS remove(NominativoS n);
NominativoS cerca(NominativoS n);
NominativoS cerca(int codice);
boolean isEmpty();
boolean isFull();
ListIterator<NominativoS> listIterator();
ListIterator<NominativoS> listIterator(int start);
void sort(Comparator<NominativoS> c);
void sort();
}//Lista
