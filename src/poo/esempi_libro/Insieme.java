package poo.esempi_libro;
public interface Insieme<T> extends Iterable<T>{
	int size();
	boolean eVuoto();
	boolean aggiungi (T elem);//aggiunge l'elemento all'insieme e ritorna true se la struttura cambia
	boolean rimuovi (T elem);
	boolean appartiene (T elem);
	void svuota();
	Insieme<T> unione (Insieme<T> altro);
	Insieme<T> differenza (Insieme<T> altro);
	Insieme<T> differenzaSimmetrica (Insieme<T> altro);
	Insieme<T> intersezione (Insieme<T> altro);
	T get (T elem);
}//Insieme interface