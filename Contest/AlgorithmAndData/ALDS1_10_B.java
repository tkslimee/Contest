import java.io.IOException;

public class ALDS1_10_B {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] M = new int[n+1][2];
        int[] p = new int[n+1];
        for ( int i=1; i<=n; i++ ) {
        	M[i][0] = sc.nextInt();
        	M[i][1] = p[i] = sc.nextInt();
        }
        p[0] = M[1][0];
        int[][] dp = new int[n+1][n+1];
        for ( int i=1; i<=n; i++ ) {
        	dp[i][i] = 0;
        }
        for ( int i=2; i<=n; i++ ) {
        	for ( int j=1; j<=n-i+1; j++ ) {
        		int l = j+i-1;
        		dp[j][l] = Integer.MAX_VALUE;
        		for ( int k=0; k<i-1; k++ ) {
        			dp[j][l] = Math.min(dp[j][l], dp[j][j+k]+dp[j+k+1][l]+p[j-1]*p[j+k]*p[l]);
        		}
        	}
        }
        System.out.println(dp[1][n]);
    }
}
