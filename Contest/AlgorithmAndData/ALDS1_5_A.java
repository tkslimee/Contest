import java.util.Scanner;

public class ALDS1_5_A {
	public static int n;
	public static int[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		A = new int[n];
		for ( int i=0; i<n; i++ ) {
			A[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		for ( int i=0; i<q; i++ ) {
			int m = sc.nextInt();
			if ( search(m,0) ) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
	static boolean search(int m, int index) {
		if ( m == 0 ) return true;
		if ( m < 0 || index >= n ) return false;
		return search(m, index+1) || search(m-A[index],index+1);
	}
}
