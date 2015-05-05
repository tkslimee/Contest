import java.util.Scanner;


public class ALDS1_2_A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for ( int i=0; i<n; i++ ) {
			a[i] = sc.nextInt();
		}
		bubbleSort(a);
	}
	
	static void bubbleSort(int[] a) {
		 boolean flag = true;
		 int count = 0;
		 while ( flag ) {
			 flag = false;
			 for ( int i=0; i<a.length-1; i++ ) {
				 if ( a[i] > a[i+1] ) {
					 int v = a[i];
					 a[i] = a[i+1];
					 a[i+1] = v;
					 count++;
					 flag = true;
				 }
			 }
		 }
		 for ( int i=0; i<a.length; i++ ) {
			 System.out.print(a[i]);
			 if ( i!=a.length-1 )System.out.print(" ");
		 }
		 System.out.println("");
		 System.out.println(count);
	}
}
