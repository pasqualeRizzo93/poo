package poo.util;
import poo.agendina.Nominativo;
import poo.sortable.*;
public final class Array{
	private Array(){}

	public static int ricercaLineare( int []v, int x ){
		for( int i=0; i<v.length; i++ )
			if( v[i]==x ) return i;
		return -1;
	}//ricercaLineare

	public static int ricercaLineareOttimizzata( int []v, int x ){
		//v e' supposto ordinato per valori crescenti
		for( int i=0; i<v.length; i++ ){
			if( v[i]==x ) return i;
			if( v[i]>x ) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata

	public static int ricercaLineare( double []v, double x ){
		for( int i=0; i<v.length; i++ )
			if( v[i]==x ) return i;
		return -1;
	}//ricercaLineare

	public static int ricercaLineareOttimizzata( double []v, double x ){
		//v e' supposto ordinato per valori crescenti
		for( int i=0; i<v.length; i++ ){
			if( v[i]==x ) return i;
			if( v[i]>x ) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata

	public static int ricercaLineare( Comparable []v, Comparable x ){
		for( int i=0; i<v.length; i++ )
			if( v[i].compareTo(x)==0 ) return i;
		return -1;
	}//ricercaLineare

	public static int ricercaLineareOttimizzata( Comparable []v, Comparable x ){
		//v e' supposto ordinato per valori crescenti
		for( int i=0; i<v.length; i++ ){
			if( v[i].compareTo(x)==0 ) return i;
			if( v[i].compareTo(x)>0 ) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata

    public static void bubbleSort( int []v ){
		int ius=0; //assegnazione fittizia
		for( int j=v.length-1; j>0; j=ius ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i]>v[i+1] ){//scambia
			       int tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; ius=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

    public static void bubbleSort( double []v ){
		int ius=0; //assegnazione fittizia
		for( int j=v.length-1; j>0; j=ius ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i]>v[i+1] ){//scambia
			       double tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; ius=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

	public static void bubbleSort( Comparable []v ){
		int ius=0; //assegnazione fittizia
		for( int j=v.length-1; j>0; j=ius ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i].compareTo( v[i+1] )>0 ){//scambia
			       Comparable tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; ius=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

	public static void selectionSort( int []v ){
		for( int j=v.length-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			     if( v[i]>v[indMax] ) indMax=i;
			//scambia v[indMax] con v[j]
			int park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static void selectionSort( double []v ){
		for( int j=v.length-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			     if( v[i]>v[indMax] ) indMax=i;
			//scambia v[indMax] con v[j]
			double park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static void selectionSort( Comparable []v ){
		for( int j=v.length-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			     if( v[i].compareTo(v[indMax])>0 ) indMax=i;
			//scambia v[indMax] con v[j]
			Comparable park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static void insertionSort( int []v ){
		for( int i=1; i<v.length; i++ ){
			int x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1]>x ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort

	public static void insertionSort( double []v ){
		for( int i=1; i<v.length; i++ ){
			double x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1]>x ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort

	public static void insertionSort( Comparable []v ){
		for( int i=1; i<v.length; i++ ){
			Comparable x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1].compareTo(x)>0 ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort

	public static int ricercaBinaria( int []v, int x ){
		//ipotesi: v è ordinato per valori crescenti
	    int inf=0, sup=v.length-1;
	    while( inf<=sup ){
			int med=(inf+sup)/2;
			if( v[med]==x ) return med;
			if( v[med]>x ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	public static int ricercaBinaria( double []v, double x ){
		//ipotesi: v è ordinato per valori crescenti
	    int inf=0, sup=v.length-1;
	    while( inf<=sup ){
			int med=(inf+sup)/2;
			if( v[med]==x ) return med;
			if( v[med]>x ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	public static int ricercaBinaria( Comparable []v, Comparable x ){
		//ipotesi: v è ordinato per valori crescenti
		int inf=0, sup=v.length-1;
		while( inf<=sup ){
			int med=(inf+sup)/2;
			int esito=v[med].compareTo(x);
			if( esito==0 ) return med;
			if( esito>0 ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

    //nei metodi che seguono, l'array v è supposto riempito da 0 a size-1

	public static int ricercaLineare( Comparable []v, Comparable x, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int i=0; i<size; i++ )
			if( v[i].compareTo(x)==0 ) return i;
		return -1;
	}//ricercaLineare

	public static int ricercaLineareOttimizzata( Comparable []v, Comparable x, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		//v e' supposto ordinato per valori crescenti
		for( int i=0; i<size; i++ ){
			if( v[i].compareTo(x)==0 ) return i;
			if( v[i].compareTo(x)>0 ) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata

    public static void bubbleSort( int []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		int limite=0; //assegnazione fittizia
		for( int j=size-1; j>0; j=limite ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i]>v[i+1] ){//scambia
			       int tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; limite=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

  	public static void bubbleSort( double []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		int limite=0; //assegnazione fittizia
		for( int j=size-1; j>0; j=limite ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i]>v[i+1] ){//scambia
			       double tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; limite=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

	public static void bubbleSort( Comparable []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		int ius=0; //assegnazione fittizia
		for( int j=size-1; j>0; j=ius ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i].compareTo( v[i+1] )>0 ){//scambia
			       Comparable tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; ius=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

	public static void selectionSort( int []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int j=size-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			     if( v[i]>v[indMax] ) indMax=i;
			//scambia v[indMax] con v[j]
			int park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static void selectionSort( double []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int j=size-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			     if( v[i]>v[indMax] ) indMax=i;
			//scambia v[indMax] con v[j]
			double park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static void selectionSort( Comparable []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int j=size-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			    if( v[i].compareTo(v[indMax])>0 ) indMax=i;
			//scambia v[indMax] con v[j]
			Comparable park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static void insertionSort( int []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int i=1; i<size; i++ ){
			int x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1]>x ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort

	public static void insertionSort( double []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int i=1; i<size; i++ ){
			double x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1]>x ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort

	public static void insertionSort( Comparable []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int i=1; i<v.length; i++ ){
			Comparable x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1].compareTo(x)>0 ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort


	public static int ricercaBinaria( int []v, int x, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		//ipotesi: v è ordinato per valori crescenti
	    int inf=0, sup=size-1;
	    while( inf<=sup ){
			int med=(inf+sup)/2;
			if( v[med]==x ) return med;
			if( v[med]>x ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria
	
	

	public static int ricercaBinaria( double []v, double x, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		//ipotesi: v è ordinato per valori crescenti
	    int inf=0, sup=size-1;
	    while( inf<=sup ){
			int med=(inf+sup)/2;
			if( v[med]==x ) return med;
			if( v[med]>x ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	public static int ricercaBinaria( Comparable []v, Comparable x, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		//ipotesi: v è ordinato per valori crescenti
		int inf=0, sup=size-1;
		while( inf<=sup ){
			int med=(inf+sup)/2;
			int esito=v[med].compareTo(x);
			if( esito==0 ) return med;
			if( esito>0 ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria
	public static int ricercaBinaria(Vector v, Object x){
		//ipotesi: v è ordinato per valori crescenti
		int inf=0, sup=v.size()-1;
		while( inf<=sup ){
			int med=(inf+sup)/2;
			int esito=((Comparable)v.get(med)).compareTo(x);
			if( esito==0 ) return med;
			if( esito>0 ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria
	
	public static int[] bucketSort(int[]v, int da, int a){
		int[] bucket=new int[(a-da)+1];
		for(int i=0; i<v.length; i++){
			for(int j=da; j<=a; j++){
				if(j==v[i]){
					bucket[j]=bucket[j]+1; 
					break;
				}
			}
		}				
		return bucket;
	}

	
}//array