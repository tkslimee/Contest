import java.io.IOException;
import java.util.Arrays;

public class ALDS1_11_C {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] M = new int[n+1][n+1];
        for ( int i=0; i<n; i++ ) {
        	Arrays.fill(M[i], 0);
        }
        for ( int i=0; i<n; i++ ) {
        	int v = sc.nextInt();
        	int cnt = sc.nextInt();
        	for ( int j=0; j<cnt; j++ ) {
        		int to = sc.nextInt();
        		M[v][to] = 1;
        	}
        }
    }
}
