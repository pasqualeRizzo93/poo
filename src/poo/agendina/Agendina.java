package poo.agendina;
import java.io.*;
/**
 * Tipo di dato astratto che descrive un'agendina telefonica.
 * Gli elementi sono ti tipo Nominativo. Non si ammettono le
 * omonimie. L'agendina e' supposta mantenuta ordinata
 * per cognome crescente e a parita' di cognome per nome crescente.
 * @author Libero Nigro
 */
public interface Agendina extends Iterable<Nominativo>{
	
	/**
	 * Restituisce il numero di nominativi dell'agenda.
	 * @return il numero di nominativi in agenda.
	 */
	public int size();
	
	/**
	 * Svuota il contenuto dell'agendina.
	 */
	public void svuota();
	
	/**
	 * Aggiunge un nominativo all'agenda. Non si ammettono
	 * le omonimie. L'aggiunta avviene in ordine alfabetico crescente
	 * del cognome ed a parita' di cognome in ordine alfabetico del nome.
	 * @param n il nominativo da aggiungere
	 */
	public void aggiungi( Nominativo n );
	
	/**
	 * Rimuove un nominativo dall'agenda.
	 * @param n il nominativo da rimuovere dall'agenda.
	 */
	public void rimuovi( Nominativo n );
	
	/**
	 * Cerca un nominativo uguale ad n.
	 * @param n il nominativo da cercare, significativo solo per nome e cognome.
	 * @return il nominativo dell'agenda uguale ad n o null se n non e' in agenda.
	 */
	public Nominativo cerca( Nominativo n );
	
	/**
	 * Cerca un nominativo nell'agenda, di assegnato prefisso e numero di telefono.
	 * @param prefisso 
	 * @param telefono
	 * @return il nominativo trovato o null
	 */
	public Nominativo cerca( String prefisso, String telefono );
	
	/**
	 * Salva il contenuto dell'agenda su file.
	 * @param nomeFile il nome esterno del file per il salvataggio.
	 * @throws IOException 
	 */
	public void salva(String nomeFile) throws IOException;
	
	/**
	 * Ripristina il contenuto dell'agenda, a partire da un file.
	 * @param nomeFile il nome esterno del file da cui attingere.
	 * @throws IOException es. se il file non esiste
	 */
	public void ripristina(String nomeFile) throws IOException;
	
}//Agendina