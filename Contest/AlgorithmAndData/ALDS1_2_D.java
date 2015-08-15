import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ALDS1_2_D {
	public static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for ( int i=0; i<n; i++ ) {
			A[i] = sc.nextInt();
		}
		shellSort(A,n);
		System.out.println(cnt);
		for ( int i=0; i<n; i++ ) {
			System.out.println(A[i]);
		}
		sc.close();
	}

	static void insertionSort(int[] A,int n,int g){
		for ( int i=g; i<n; i++ ) {
			int v = A[i];
			int j = i-g;
			while ( j >= 0 && A[j] > v) {
				A[j+g] = A[j];
				j = j-g;
				cnt++;
			}
			A[j+g] = v;
		}
	}
	
	static void shellSort(int[] A, int n) {
		cnt = 0;
		int len = A.length;
		ArrayList<Integer> G_list = new ArrayList<Integer>();
		int g_max = 1;
		G_list.add(g_max);
		while ( g_max <= len-1 ) {
			if(g_max!=1)G_list.add(g_max);
			g_max = 3*g_max+1;
		}
		Collections.reverse(G_list);
		int m = G_list.size();
		System.out.println(m);
		for ( int i=0; i<m; i++ ) {
			System.out.print(G_list.get(i));
			if ( i != m-1 ) {
				System.out.print(" ");
			} else {
				System.out.println("");
			}
		}
		for ( int i=0; i<m; i++ ) {
			insertionSort(A, len, G_list.get(i));
		}
	}
}
