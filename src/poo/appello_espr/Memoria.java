package poo.appello_espr;

public interface Memoria extends Iterable {
int size();
void add(Variabile v);
boolean contains(Variabile v);
Variabile get(Variabile v); 
void remove(Variabile v);
void clear();
boolean isEmpty();
boolean isFull();
}
