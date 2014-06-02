package poo.sistema;

import poo.util.Mat;

public class Gauss extends Sistema {
	public Gauss (double [] [] a, double [] y) {
		super (a,y); //controlla se il sistema è ben definito
		this.a=new double [a.length][a.length+1]; //quando non si usa il this ci si riferisce al parametro 
		for (int i=0; i<a.length; i++) {
			System.arraycopy(a[i], 0, this.a[i], 0, a[i].length);
			this.a[i][a.length]=y[i];
		}
	}//costruttore
	private double [] [] a;
	@Override
	public double [] risolvi () {
		triangolizza ();
		return calcoloSoluzione ();
	}//risolvi
	protected void triangolizza () {
		int n=getN ();
		for (int j=0; j<n; j++) {
			//ipotesi: a[j][j]!=0
			for (int i=j+1; i<n; i++) {
				//azzera a[i][j]
				double c=a[i][j]/a[j][j];
				//dalla riga i-esima sottrai la riga j-esima*c
				for (int k=j; k<=n; k++)
					a[i][k]=a[i][k]-a[j][k]*c;
			}
		}
	}//triangolizza
	protected double [] calcoloSoluzione () {
		int n=getN();
		double [] x=new double [n];
		for (int i=n-1; i>=0; i--) {
			double sm=a[i][n];
			for (int j=i+1; j<n; j++)
				sm=sm-a[i][j]*x[i];
			x[i]=sm/a[i][i];
		}
		return x;
	}//calcoloSoluzione
	public String toString () {
		StringBuilder sb=new StringBuilder (500);
		for (int i=0; i<getN(); i++){
			for (int j=0; j<=getN();j++){
				sb.append(String.format("1.2f", a[i][j]));
				sb.append(" ");
			}
			sb.append ('\n');
		}
		return sb.toString();
	}//toString
	protected void triangolarizza() { //questo metodo si usa nel caso in cui il pivot sia 0
		int n=getN();
		for (int j=0; j<n; j++) {
			if(Mat.sufficientementeProssimi(a[j][j], 0D)) {
				//cerca riga p tale che a[p][j]!=0
				int p=0;
				for(; p<n; p++) {
					if (!Mat.sufficientementeProssimi(a[p][j], 0D))	break;
					if (p==n) throw new SistemaSingolare();
					//scambia riga j con p
					double [] tmp=a[j];
					a[j]=a[p];
					a[p]=tmp;
				}
			}
			//azzera tutti gli elementi sotto la colonna j
			for (int i=j+1; i<n; i++) 
				//azzera a[i][j]
				if (!Mat.sufficientementeProssimi(a[i][j], 0D)) {
					double c=a[i][j]/a[j][j];
					for (int k=j; k<=n; k++)
						a[i][k]=a[i][k]-a[j][k]*c;
				}
		}
	}//triangolarizza
}//Gauss class
