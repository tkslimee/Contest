import java.io.IOException;

public class ALDS1_6_B {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for ( int i=0; i<n; i++ ) {
			A[i] = sc.nextInt();
		}
		int index = partition(A,0,n-1);
		for ( int i=0; i<n; i++ ) {
			if ( i == index ) {
				System.out.print("["+A[i]+"]");
			} else {
				System.out.print(A[i]);
			}
			if ( i != n-1 ) {
				System.out.print(" ");
			} else {
				System.out.println("");
			}
		}
	}

	static int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p-1;
		for ( int j=p; j<r; j++ ) {
			if ( A[j] <= x ) {
				int tmp = A[++i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		int tmp2 = A[r];
		A[r] = A[i+1];
		A[i+1] = tmp2;
		return i+1;
	}
}
