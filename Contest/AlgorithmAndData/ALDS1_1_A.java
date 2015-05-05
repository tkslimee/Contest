import java.util.Scanner;

public class ALDS1_1_A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for ( int i=0; i<n; i++ ) {
			a[i] = sc.nextInt();
		}
		insertionSort(a);
	}
	
	static void insertionSort(int[] a) {
		for ( int k=0; k<a.length; k++ ) {
			System.out.print(a[k]);
			if ( k!=a.length-1 )System.out.print(" ");
		}
		System.out.println("");
		for ( int i=1; i<a.length; i++ ) {
			int v = a[i];
			int j;
			for ( j=i-1; j>=0; j-- ) {
				if ( a[j] > v ) {
					a[j+1] = a[j];
				} else {
					break;
				}
			}
			a[j+1] = v;
			for ( int k=0; k<a.length; k++ ) {
				System.out.print(a[k]);
				if ( k!=a.length-1 )System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
