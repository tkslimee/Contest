import java.util.Scanner;

public class ALDS_1_2_C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] c = new String[n];
		for (int i=0; i<c.length; i++) {
			c[i] = sc.next();
		}
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
