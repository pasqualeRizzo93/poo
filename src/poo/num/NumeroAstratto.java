package poo.num;

import java.util.Iterator;

public abstract class NumeroAstratto implements Numero {

	@Override
	public abstract Numero somma(Numero n);

	@Override
	public abstract Numero moltiplica(Numero n);

	@Override
	public boolean ePositivo() {
		Iterator<Cifra> it= this.iterator();
		Cifra corrente=null;
		while(it.hasNext()){
			corrente=it.next();
		}
				return corrente.getCifra()>0;
			
		}//ePositivo
	

	@Override
	public boolean eNegativo() {
		Iterator<Cifra> it= this.iterator();
		Cifra corrente=null;
		while(it.hasNext()){
			corrente=it.next();
		}
				return corrente.getCifra()<0;
	}//eNegativo

	@Override
	public abstract void cambiaSegno();
	
	@Override
	public int compareTo(Numero n) {
		if(this.equals(n))return 0;
		int n1=Integer.parseInt(this.toString());
		int n2=Integer.parseInt(n.toString());
		return n1-n2;		
	}//compareTo
	
	public boolean equals(Object o){
		if(!(o instanceof Numero)) return false;
		if(o==this) return true;
		Numero n=(Numero) o;
		Iterator<Cifra> it1=this.iterator();
		Iterator<Cifra> it2=n.iterator();
		Cifra c1,c2;
		while(it1.hasNext()){
			c1=it1.next();c2=it2.next();
			if(!(c1.equals(c2)))return false;
		}
		return true;
	}//equals

	public int hashCode(){
		int mul=41;
		int h=0;
		for(Cifra c: this)
			 h=h+c.hashCode()*mul;
		return h;
	}//hashCode
	
	public String toString() {
		StringBuilder sb = new StringBuilder(200);
		sb.append(']');
		Iterator<Cifra> it = this.iterator();
		while (it.hasNext()) {
			sb.append(it.next());
		}// while
		sb.append('[');
		return sb.reverse().toString();
	}// toString
}//NumeroAstratto
