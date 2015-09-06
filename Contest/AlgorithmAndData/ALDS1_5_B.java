import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//マージソート
public class ALDS1_5_B {
	public static int cnt = 0;
	public static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] S = new int[n];
		for ( int i=0; i<n; i++ ) {
			S[i] = sc.nextInt();
		}
		mergeSort(S, 0, n);
		for ( int i=0; i<n; i++ ) {
			System.out.print(S[i]);
			if ( i < n-1 ) {
				System.out.print(" ");
			} else {
				System.out.println("");
			}
		}
		System.out.println(cnt);
	}
	
	static void mergeSort(int[] A, int left, int right) {
		if ( left+1 < right ) {
			int mid = (left+right)/2;
			mergeSort(A,left,mid);
			mergeSort(A,mid,right);
			merge(A,left,mid,right);
		}
	}
	
	static void merge(int[] A, int left, int mid, int right) {
		int n1 = mid-left;
		int n2 = right-mid;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for ( int i=0; i<=n1; i++ ) {
			if ( i==n1 ) {
				L[i] = INF;
				continue;
			}
			L[i] = A[i+left];
		}
		for ( int i=0; i<=n2; i++ ) {
			if ( i==n2 ) {
				R[i] = INF;
				continue;
			}
			R[i] = A[i+mid];
		}
		int h1 = 0;
		int h2 = 0;
		for ( int i=left; i<right; i++ ) {
			cnt++;
			if ( L[h1] <= R[h2] ) {
				A[i] = L[h1];
				h1++;
			} else {
				A[i] = R[h2];
				h2++;
			}
		}
	}
}