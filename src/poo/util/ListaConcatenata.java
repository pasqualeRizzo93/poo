package poo.util;

import java.util.*;

public class ListaConcatenata<T> extends ListaAstratta<T> {

	private static class Nodo<E> {
		E info;
		Nodo<E> next, prior;
	}

	private Nodo<T> testa, coda;

	public ListaConcatenata() {
		testa = null;
		coda = null;
	}// costruttore

	@Override
	public void addFirst(T elem) {
		Nodo<T> nuovo = new Nodo<T>();
		nuovo.info = elem;
		nuovo.next = testa;
		nuovo.prior = null;
	}// addFirst ??

	public void addLast(T elem) {
		Nodo<T> nuovo = new Nodo<T>();
		Nodo<T> current = testa.next;
		nuovo.info = elem;
		nuovo.next = null;
		nuovo.prior = current;
	}// addLast ??

	@Override
	public ListIterator<T> listIterator() {
		return new IteratoreDiLista();
	}

	@Override
	public ListIterator<T> listIterator(int start) {
		return new IteratoreDiLista(start);
	}

	private class IteratoreDiLista implements ListIterator<T> {
		private Nodo<T> cur, pre, suc;
		private boolean rimuovibile = false;

		public IteratoreDiLista() {
			cur = null;
			pre = null;
			suc = null;
		}// costruttore

		public IteratoreDiLista(int start) {
			if (start < size())
				throw new IllegalArgumentException();
			int c = 0;
			while (hasNext() && c < start) {
				cur = cur.next;
				c++;
			}
			pre = null;
			suc = null;

		}// 2° costruttore

		public boolean hasNext() {
			if (cur == null)
				return testa != null;
			return cur.next != null;
		}//hasNext
		
		public T next(){
			if(!hasNext()) throw new NoSuchElementException();
			rimuovibile=true;
			if(cur==null)cur=testa;
			else cur=cur.next;
			return cur.info;
		}//next
		public boolean hasPrevious(){
			return cur.prior!=null;
		}//hasPrevious
		
		public T previous(){
			if(!hasPrevious()) throw new NoSuchElementException();
			rimuovibile=true;
			suc=cur;
			cur=cur.prior;
			return cur.info;
		}//previous
		
		public void add(T elem){
			if(cur==null){
				addFirst(elem);
			cur=testa;//?non sono sicuro
			}else{
		    Nodo<T> nuovo=new Nodo<T>();
		   nuovo.info=elem;nuovo.next=cur.next;
		   nuovo.prior=cur;
			}
		}//add
		public void remove(){
			if(!rimuovibile)throw new IllegalStateException();
			rimuovibile=false;
			if(cur==testa){
				removeFirst();
			}else if(cur==coda){
				removeLast();
			}else{
				cur.prior.next=cur.next;
				
			}//non penso sia completo
		}//remove
		public void set(T elem){
			if(!rimuovibile)throw new IllegalStateException();
			rimuovibile=false;
			cur.info=elem;
		}//set
		public int nextIndex(){
			return -1;//non so bene come muovermi
		}//nextIndex()
		public int previousIndex(){
			return -1;//non so bene come muovermi
		}//previousIndex
	}//IteratoreDiLista ???????

}//ListaConcatenata
