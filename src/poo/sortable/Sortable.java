package poo.sortable;
public abstract class Sortable {
	public abstract int compareTo (Sortable to);
	public static void sort (Sortable [] a) { //selection sort
		for (int j=a.length-1; j>0; j--) {
			int iMax=0;//indice del massimo
			for (int i=1; i<=j; i++)
				if (a[i].compareTo(a[iMax])>0)//l'array a è di tipo Sortable e xciò i suoi elementi si eguagliano con il compareTo
					iMax=i;
			Sortable tmp=a[iMax];//scambio di elementi. Si crea aliasing
			a[iMax]=a[j];
			a[j]=tmp;
		}
	}
}
