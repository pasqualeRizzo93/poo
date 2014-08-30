package poo.num;

import java.util.Iterator;

public abstract class NumeroAstratto implements Numero {

	protected abstract Numero create();
	
	@Override
	public Numero somma(Numero n){
		Numero s=create();
		int somma;
		int riporto=0;
		Iterator<Cifra> it1=this.iterator();
		Iterator<Cifra> it2=n.iterator();
		while(it1.hasNext() && it2.hasNext()){
			Cifra c1=it1.next(),c2=it2.next();
			somma=c1.getCifra()+c2.getCifra()+riporto;
			if(somma<=9){
				s.add(new Cifra(somma));				
			}else{
				riporto=somma/10;
				somma%=10;
				s.add(new Cifra(somma));
			}
				if(!it1.hasNext()){
					while(it2.hasNext());
					s.add(it2.next());
				}else if(!it2.hasNext()){
					while(it1.hasNext()){
						s.add(it1.next());
					}
				}
				
		}//primissimo_while
		
		return s;
	}

	@Override
	public Numero moltiplica(Numero n){
		Numero s=null;
		int prodotto;
		int riporto=0;
		Iterator<Cifra> it1=this.iterator();
		Iterator<Cifra> it2=n.iterator();
		while(it1.hasNext() && it2.hasNext()){
			Cifra c1=it1.next(),c2=it2.next();
			prodotto=c1.getCifra()*c2.getCifra()+riporto;
			if(prodotto<=9){
				s.add(new Cifra(prodotto));				
			}else{
				riporto=prodotto/10;
				prodotto%=10;
				s.add(new Cifra(prodotto));
			}
				if(!it1.hasNext()){
					while(it2.hasNext());
					s.add(it2.next());
				}else if(!it2.hasNext()){
					while(it1.hasNext()){
						s.add(it1.next());
					}
				}
				
		}//primissimo_while
		
		return s;
	}

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
	
	public abstract void add(Cifra c) ;
	
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
		Iterator<Cifra> it = this.iterator();
		while (it.hasNext()) {
			sb.append(it.next());
		}// while
		return sb.reverse().toString();
	}// toString
	
}//NumeroAstratto
