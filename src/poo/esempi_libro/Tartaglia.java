package poo.esempi_libro;
public class Tartaglia {
	public static void main (String [] args) {
		int [] a=new int [10];
		int [] b=new int [10];
		for (int i=0; i<10; i++) {
			b[0]=1;
			b[i]=1;
			for (int j=1; j<i; j++) 
				b[j]=a[j]+a[j-1];
			for (int j=0; j<=i; j++)
				System.out.print(b[j]+"\t");
			System.out.println();
			System.arraycopy(b,0,a,0,i+1);
		}
	}//main
}//Tartaglia
