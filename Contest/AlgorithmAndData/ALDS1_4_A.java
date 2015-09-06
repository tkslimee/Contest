import java.util.Scanner;

public class ALDS1_4_A {
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
			ans = linearSearch(S,num)>=0 ? ans+1 : ans;
		}
		System.out.println(ans);
	}
	//　線形探索。見つかった場合はインデックスを、見つからなかった場合は-1を返す
	static int linearSearch(int[] A, int key) {
		for ( int i=0; i<A.length; i++ ) {
			if ( A[i] == key ) return i;
		}
		return -1;
	}
}