package poo.geometria;
import poo.util.Mat;
public class Retta{
	private Punto p1, p2;
	private double m, q;
	public Retta( Punto p1, Punto p2 ){
		if( p1.equals(p2) )
			throw new RuntimeException("Punti coincidenti");
		this.p1=new Punto(p1);
		this.p2=new Punto(p2);
		if( Mat.sufficientementeProssimi(p1.getX(), p2.getX()) ){
			//retta verticale
			m=Double.MAX_VALUE;
			q=Double.MAX_VALUE;
		}
		else{//(y2-y1)/(x2-x1)=(y-y1)/(x-x1)
			m=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());
			q=-p1.getX()*((p2.getY()-p1.getY())/
			  (p2.getX()-p1.getX()))+p1.getY();

		}
	}
	public Retta( double m, double q ){
		if( Mat.sufficientementeProssimi( Math.abs(m),Double.MAX_VALUE ) ||
			Mat.sufficientementeProssimi( Math.abs(q),Double.MAX_VALUE ) )
			throw new RuntimeException("Retta indeterminata");
		this.m=m;
		this.q=q;
		//retta certamente NON verticale
		if( orizzontale() ){
			p1=new Punto(0,q);//esempio
			p2=new Punto(3,q);//esempio
		}
		else{ //retta obliqua: intercette con gli assi
			p1=new Punto(0,q);
			p2=new Punto(-q/m,0);
		}
	}
	public Retta( double m, Punto p ){
		if( Mat.sufficientementeProssimi(Math.abs(m),Double.MAX_VALUE) ){ //retta verticale
			this.m=m; this.q=Double.MAX_VALUE;
			p1=new Punto(p);
			p2=new Punto( p.getX(), p1.getY()+1 ); //esempio
		}
		else{ //(y-y1)=m(x-x1)
			this.m=m; this.q=-m*p.getX()+p.getY();
			p1=new Punto(p);
			p2=new Punto(0,q); //esempio
		}
	}
	public Retta( double a, double b, double c ){
		//retta assegnata in veste implicita: ax+by+c=0
		if( Mat.sufficientementeProssimi(b,0) ){
			if( Mat.sufficientementeProssimi(a,0) )
				throw new RuntimeException("Retta indeterminata");
			//retta verticale
			this.m=Double.MAX_VALUE;
			this.q=Double.MAX_VALUE;
			if( Mat.sufficientementeProssimi(c,0) ){
				p1=new Punto();
				p2=new Punto(0,1);//esempio
			}
			else{
				p1=new Punto(-c/a, 0);
				p2=new Punto(-c/a, 1); //esempio
			}
		}
		else{
			if( Mat.sufficientementeProssimi(a,0) ){//orizzontale
				this.m=0; this.q=-c/b;
				p1=new Punto(0,q);
				p2=new Punto(1,q);//esempio
			}
			else{//obliqua
				this.m=-a/b; this.q=-c/b;
				//intercette con gli assi
				p1=new Punto(0,q);
				p2=new Punto(-q/m,0);
			}
		}
	}
	public Retta( Retta r ){
		this.m=r.m; this.q=r.q;
		this.p1=new Punto( r.p1 );
		this.p2=new Punto( r.p2 );
	}
	public double getCoefficienteAngolare(){
		return m;
	}//getCoeffAngolare
	public double getTermineNoto(){
		return q;
	}//getTermineNoto
	public boolean parallela( Retta r ){
		if( this.verticale() && r.verticale() ) return true;
		return Mat.sufficientementeProssimi( this.m, r.m );
	}//parallela
	public boolean perpendicolare( Retta r ){
		if( this.verticale() && r.orizzontale() ||
		    this.orizzontale() && r.verticale() ) return true;
		if( this.verticale() || r.verticale() ) return false;
		return Mat.sufficientementeProssimi( this.m, -1/r.m );
	}//perpendicolare
	public boolean verticale(){
		if( Mat.sufficientementeProssimi( Math.abs(m),Double.MAX_VALUE ) )
			return true;
		return false;
	}//verticale
	public boolean orizzontale(){
		if( Mat.sufficientementeProssimi(m,0) ) return true;
		return false;
	}//orizzontale
	public boolean obliqua(){
		return !this.orizzontale() && !this.verticale();
	}//obliqua
	public boolean interseca( Retta r ){
		return !this.parallela(r);
	}//interseca
	public Punto puntoIntersezione( Retta r ){
		if( this.parallela(r) ){
			if( this.equals(r) )
				throw new RuntimeException("Infinite intersezioni");
			throw new RuntimeException("Nessuna intersezione");
		}
		double x=0, y=0;
		if( this.obliqua() && r.obliqua() ){
			x=(r.q-this.q)/(this.m-r.m);
			y=this.m*x+this.q; //usando la prima equazione
		}
		else if( this.verticale() ){
			x=this.p1.getX();
			y=r.m*x+r.q;
		}
		else if( r.verticale() ){
			x=r.p1.getX();
			y=this.m*x+this.q;
		}
		else if( this.orizzontale() && r.verticale() ){
			x=r.p1.getX();
			y=p1.getY();
		}
		else if( this.verticale() && r.orizzontale() ){
			x=p1.getX();
			y=r.p1.getY();
		}
		return new Punto(x,y);
	}//puntoIntersezione
	public String toString(){
		if( this.verticale() ) return "x="+String.format("%1.2f",p1.getX());
		else if( this.orizzontale() ) return "y="+String.format("%1.2f",q);
		String s="y="+m+"x";
		if( q>0 ) s+="+";
		s+=q;
		return s;
	}//toString
	public boolean equals( Object o ){
		if( !(o instanceof Retta) ) return false;
		if( o==this ) return true;
		Retta r=(Retta)o;
		return Mat.sufficientementeProssimi( this.m, r.m ) && 
			   Mat.sufficientementeProssimi( this.q, r.q );
	}//equals
	public static void main( String[] args ){
		Retta r=new Retta( new Punto(2,3), new Punto(7,4) );
		System.out.println(r);
		System.out.println("m="+r.getCoefficienteAngolare()+
		                   " q="+r.getTermineNoto() );
		Retta r1=new Retta(-0.2, 3);
		System.out.println(r1);
		Retta r2=new Retta( new Punto(3,5), new Punto(3,8) );
		System.out.println(r2);
		System.out.println( r.interseca(r2) );
		System.out.println("Punto di intersezione tra "+r+" e "+
		                    r2+" = "+r.puntoIntersezione(r2));
		System.out.println("Punto di intersezione tra "+r1+" e "+
		                    r2+" = "+r1.puntoIntersezione(r2));
		Retta r3=new Retta( 0, 4 ); //retta orizzontale
		Retta r4=new Retta( new Punto(3,0), new Punto(3,2) );
		System.out.println( "r3: "+r3+" perpendicolare a r4: "+r4+
		                    " "+r3.perpendicolare(r4) );
		if( r3.verticale() ) System.out.println(r3+" e' verticale");
		if( r3.orizzontale() ) System.out.println(r3+" e' orizzontale");
		if( r4.verticale() ) System.out.println(r4+" e' verticale");
		if( r4.orizzontale() ) System.out.println(r4+" e' orizzontale");
		Retta r5=new Retta(new Punto( 5,7), new Punto(5,12) );
		System.out.println(r5);
		Retta r6=new Retta(Double.MAX_VALUE, new Punto(3,5));
		System.out.println(r6);
		Retta r7=new Retta( 2, 5, -4 ); //forma implicita
		System.out.println(r7);
		Retta r8=new Retta( 2, 0, 3 );
		System.out.println(r8);
	}//main
}//Retta
