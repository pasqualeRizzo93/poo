/**
 * 
 */
package poo.util;

import java.util.ListIterator;

/**
 * @author Desimone_f
 * 
 */
public class TestListaConcatenata {

    public static void main(String[] args) {
	ListaAstratta<Object> lista = new ListaConcatenata<Object>();

	lista.addFirst("Quinto");
	lista.addFirst("Quarto");
	lista.addFirst("Terzo");
	lista.addFirst("Secondo");
	lista.addFirst("Primo");
	lista.addLast("ultimo");

	ListIterator<Object> lit = lista.listIterator();

	while (lit.hasNext()) {
	    System.out.println(lit.next());
	    System.out.println("next index: " + lit.nextIndex());
	    System.out.println("previous index: " + lit.previousIndex());
	}

    }

}
