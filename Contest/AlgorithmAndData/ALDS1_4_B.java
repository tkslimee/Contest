import java.util.Scanner;


public class ALDS1_4_B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] S = new int[n];
		for ( int i=0; i<n; i++ ) {
			S[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		int ans = 0;
		for ( int i=0; i<q; i++ ) {
			int num = sc.nextInt();
			ans = binarySearch(S,num)>=0 ? ans+1 : ans;
		}
		System.out.println(ans);
	}
	//　二分探索。見つかった場合はインデックスを、見つからなかった場合は-1を返す
	static int binarySearch(int[] A, int key) {
		int l = 0;
		int r = A.length;
		while ( l < r ) {
			int m = (l+r)/2;
			if ( A[m] == key ) return m;
			if ( A[m] < key ) {
				l = m+1;
			} else {
				r = m;
			}
		}
		return -1;
	}
}
