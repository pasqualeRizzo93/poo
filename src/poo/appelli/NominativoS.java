package poo.appelli;

public final class NominativoS implements Comparable<NominativoS> {
	private String nome,cognome;
	private int codice;

	public NominativoS(String nome, String cognome, int codice) {
		if(codice<0)throw new IllegalArgumentException();
		this.codice=codice;
		this.nome = nome;
		this.cognome = cognome;
	}// costruttore
    
	public int getCodice(){
		return codice;
	}
	public String getNome() {
		return nome;
	}// getNome

	public String getCognome() {
		return cognome;
	}// getCognome

	public boolean equals(Object o) {
		if (!(o instanceof NominativoS))
			return false;
		if (o == this)
			return true;
		NominativoS n = (NominativoS) o;
		return this.cognome.equals(n.cognome) && this.nome.equals(n.nome);
	}// equals

	public int compareTo(NominativoS n) {
		if (this.cognome.compareTo(n.cognome) < 0
				|| this.cognome.equals(n.cognome)
				&& this.nome.compareTo(n.nome) < 0)
			return -1;
		if (this.equals(n))
			return 0;
		return +1;
	}// compareTo

	public int hashCode() {
		int PRIMO = 31;
		int h1 = cognome.hashCode();
		int h2 = nome.hashCode();
		return h1 * PRIMO + h2;
	}// hashCode

	public String toString() {
		return cognome + " " + nome;
	}// toString
}// Nominativo
