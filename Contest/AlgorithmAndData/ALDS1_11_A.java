import java.io.IOException;
import java.util.Arrays;

// ƒOƒ‰ƒt‚Ì•\Œ»
public class ALDS1_11_A {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] M = new int[n][n];
        for ( int i=0; i<n; i++ ) {
        	Arrays.fill(M[i], 0);
        }
        for ( int i=0; i<n; i++ ) {
        	int v = sc.nextInt() - 1;
        	int cnt = sc.nextInt();
        	for ( int j=0; j<cnt; j++ ) {
        		int to = sc.nextInt() - 1;
        		M[v][to] = 1;
        	}
        }
        for ( int i=0; i<n; i++ ) {
        	for ( int j=0; j<n; j++ ) {
        		System.out.print(M[i][j]);
        		if ( j == n-1 ) {
        			System.out.println("");
        		} else {
        			System.out.print(" ");
        		}
        	}
        }
    }
}
