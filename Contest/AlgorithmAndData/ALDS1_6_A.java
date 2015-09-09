import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

//計数ソート
public class ALDS1_6_A {
	public static int[] C = new int[10000];

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] A = new int[n+1];
        int[] B = new int[n+1];
        for ( int i=1; i<=n; i++ ) {
        	A[i] = sc.nextInt();
        }
        CountingSort(A,B,10000);
        for ( int i=1; i<=n; i++ ) {
        	out.print(B[i]);
        	if ( i != n ) {
        		out.print(" ");
        	} else {
        		out.println("");
        	}
        }
        out.close();
    }

    static void CountingSort(int[] A, int[] B, int k) {
    	Arrays.fill(C, 0);
    	for ( int i=1; i<A.length; i++ ) {
    		C[A[i]]++;
    	}
    	for ( int i=1; i<k; i++ ) {
    		C[i] += C[i-1];
    	}
    	for ( int i=A.length-1; i>=1; i-- ) {
    		B[C[A[i]]] = A[i];
    		C[A[i]]--;
    	}
    }
}
