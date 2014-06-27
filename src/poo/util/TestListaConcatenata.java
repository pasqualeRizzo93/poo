/**
 * 
 */
package poo.util;

import java.util.Comparator;
import java.util.ListIterator;

/**
 * @author Desimone_f
 * 
 */
public class TestListaConcatenata {

    public static void main(String[] args) {
	ListaAstratta<String> lista = new ListaConcatenata<String>();

	lista.addFirst("A");
	lista.addFirst("B");
	lista.addFirst("C");
	lista.addFirst("G");
	lista.addFirst("D");
	lista.addLast("F");

	ListIterator<String> lit = lista.listIterator();
	System.out.print("lista non ordinata [ ");
	while (lit.hasNext()) {
	    System.out.print(lit.next());
	    if(lit.hasNext()) System.out.print(", ");
//	    System.out.println("next index: " + lit.nextIndex());
//	    System.out.println("previous index: " + lit.previousIndex());
	}
	System.out.println("]");
	
	
	lista.sort(new Comparator<String>() {
	    
	    @Override
	    public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	    }
	});
	
	lit = lista.listIterator();
	System.out.print("lista ordinata [ ");
	while (lit.hasNext()) {
	    System.out.print(lit.next());
	    if(lit.hasNext()) System.out.print(", ");
	}
	System.out.println("]");
	
	
    }

}
