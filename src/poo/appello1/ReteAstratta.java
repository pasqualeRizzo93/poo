package poo.appello1;

import java.util.*;

public abstract class ReteAstratta<T> implements Rete<String> {

	@Override
	public int numNodi() {
		int n = 0;
		for (String u : this)
			n++;
		return n;
	}// numNodi

	@Override
	public int numConnessioni() {
		int na = 0;
		for (String u : this) {
			Iterator<? extends Connessione> it = this.adiacenti(u);
			while (it.hasNext()) {
				it.next();
				na++;
			}
		}
		return na;
	}// numConnessioni

	@Override
	public boolean esisteNodo(String u) {
		for (String v : this)
			if (v.equals(u))
				return true;
		return false;
	}// esisteNodo

	@Override
	public boolean esisteConnessione(Connessione c) {
		String u = c.getOrigine();
		if (esisteNodo(u)) {
			Iterator<? extends Connessione> it = this.adiacenti(u);
			while (it.hasNext()) {
				Connessione co = it.next();
				if (co.equals(c)) {
					return true;
				}
			}
		}
		return false;
	}// esisteConnessione

	@Override
	public boolean esisteConnessione(String u, String v, String z, int l) {
		return esisteConnessione(new Connessione(u, v, z, l));
	}// esisteConnessione

	@Override
	public abstract void insNodo(String u);

	@Override
	public abstract void insConnessione(Connessione c);

	@Override
	public void insConnessione(String u, String v, String z, int l) {
		insConnessione(new Connessione(u, v, z, l));

	}// insConnessione

	@Override
	public void rimuoviNodo(String u) {
		Iterator<String> it = this.iterator();
		while (it.hasNext()) {
			String v = it.next();
			if (v.equals(u)) {
				it.remove();
				break;
			}
		}
	}// rimuoviNodo

	@Override
	public void rimuoviConnessione(Connessione c) {
		String u = c.getOrigine();
		if (esisteNodo(u)) {
			Iterator<? extends Connessione> it = this.adiacenti(u);
			while (it.hasNext()) {
				Connessione co = it.next();
				if (co.equals(c)) {
					it.remove();
					break;
				}
			}
		}
	}// rimuoviConnessione

	@Override
	public void rimuoviConnessione(String u, String v, String z, int l) {
		rimuoviConnessione(new Connessione(u, v, z, l));

	}// rimuoviConnessione

	@Override
	public int gradoEntrata(String u) {
		int gE = 0;
		if (esisteNodo(u)) {
			for (String v : this) {
				Iterator<? extends Connessione> it = adiacenti(v);
				while (it.hasNext()) {
					Connessione c = it.next();
					if (c.getDestinazione().equals(u)) {
						gE++;
						break;
					}
				}
			}
		}
		return gE;
	}// gradoEntrata

	@Override
	public int gradoUscita(String u) {
		int gU = 0;
		if (esisteNodo(u)) {
			Iterator<? extends Connessione> it = adiacenti(u);
			while (it.hasNext()) {
				it.next();
				gU++;
			}
		}
		return gU;
	}// gradoUscita

	@Override
	public void clear() {
		Iterator<String> it = this.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}// clear

	private boolean equals(ReteAstratta<T> r1, ReteAstratta<T> r2, String u) {
		Iterator<? extends Connessione> it = r1.adiacenti(u);
		while (it.hasNext()) {
			Connessione c1 = it.next();
			if (!r2.esisteConnessione(c1))
				return false;
			Iterator<? extends Connessione> it2 = r2.adiacenti(u);
			while (it2.hasNext()) {
				Connessione c2 = it2.next();
				if (c1.equals(c2) && !(c1.getLunghezza() == c2.getLunghezza())
						&& c1.getPercorso().equals(c2.getPercorso()))
					return false;
			}
		}
		Iterator<? extends Connessione> it2 = r2.adiacenti(u);
		while (it2.hasNext()) {
			Connessione c2 = it2.next();
			if (!r1.esisteConnessione(c2))
				return false;
			it = r1.adiacenti(u);
			while (it.hasNext()) {
				Connessione c1 = it.next();
				if (c1.equals(c2) && !(c1.getLunghezza() == c2.getLunghezza())
						&& c1.getPercorso().equals(c2.getPercorso()))
					return false;
			}
		}
		return true;
	}// equals
    
	@SuppressWarnings("unchecked")
	public boolean equals(Object o){
		if(!(o instanceof ReteAstratta)) return false;
		if(o==this)return true;
		ReteAstratta<T>r=(ReteAstratta<T>) o;
		if(this.numNodi()!=r.numNodi()||this.numConnessioni()!=r.numConnessioni())return false;
		for(String u: this){
			if(!r.esisteNodo(u))return false;
			if(!equals(this,r,u))return false;
		}
		return true;
	}//equals
	
	public String toString(){
		StringBuilder sb= new StringBuilder(500);
		for(String u: this){
			sb.append(u);sb.append(':');sb.append(' ');
			Iterator<? extends Connessione> it=this.adiacenti(u);
			while(it.hasNext()){sb.append(it.next());}
			sb.append('\n');
		}
		return sb.toString();
	}//toString
	
	//l' hashCode() non so come farlo per il momento
}// ReteAstratta
