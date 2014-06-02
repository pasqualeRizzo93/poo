package poo.esempi_libro;
import java.util.*; 
public class QuadratoMagico {
	public static void main (String [] args){
		Scanner sc=new Scanner (System.in);
		System.out.print("Inserire la dimensione del quadrato. ");
		int N=sc.nextInt ();
		if (N%2==0 || N<1) throw new RuntimeException ("Dimensione errata!");
		int [] [] qM=new int [N][N];
		for (int i=0; i<N; i++)
			for (int j=0; j<N; j++)
				qM[i][j]=0;
		int rig=N-1, col=N/2;
		for (int k=1; k<=N*N; k++) {
			qM[rig][col]=k;
			if (qM[(rig+1)%N][(col+1)%N]==0) {
				rig=(rig+1)%N;
				col=(col+1)%N;
			}
			else rig=rig+1;
		}
		for (int i=0; i<N; i++){
			for (int j=0; j<N; j++){
				System.out.println(qM[i][j]+" ");
	}
		}
	}
}
