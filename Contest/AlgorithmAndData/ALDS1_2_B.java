import java.util.Scanner;

public class ALDS1_2_B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for ( int i=0; i<n; i++ ) {
			a[i] = sc.nextInt();
		}
		int count = selectionSort(a);
		for ( int i=0; i<a.length; i++ ) {
			System.out.print(a[i]);
			if ( i!=a.length-1 )System.out.print(" ");
		}
		System.out.println("");
		System.out.println(count);
		sc.close();
	}
	
	static int selectionSort(int[] a) {
		int count = 0;
		for ( int i=0; i<a.length; i++ ) {
			int minj = i;
			for ( int j=i; j<a.length; j++ ) {
				if ( a[minj] > a[j] ) {
					minj = j; 
				}
			}
			if ( minj!=i )count++;
			int v = a[minj];
			a[minj] = a[i];
			a[i] = v;
		}
		return count;
	}
}
