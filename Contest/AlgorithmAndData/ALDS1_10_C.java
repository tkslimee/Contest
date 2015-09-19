import java.io.IOException;
import java.util.Arrays;

// Å’·‹¤’Ê•”•ª—ñ(’´“TŒ^)
public class ALDS1_10_C {
	public static int[][] dp;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for ( int i=0; i<n; i++ ) {
        	String x = sc.next();
        	String y = sc.next();
        	dp = new int[x.length()+1][y.length()+1];
        	for ( int j=0; j<dp.length; j++ ) {
        		Arrays.fill(dp[j], -1);
        	}
        	System.out.println(lcs(x,y));
        }
    }
    
    static int lcs(String x, String y) {
    	int m = x.length();
    	int n = y.length();
    	for ( int i=0; i<=m; i++ ) {
    		dp[i][0] = 0;
    	}
    	for ( int i=0; i<=n; i++ ) {
    		dp[0][i] = 0;
    	}
    	for ( int i=1; i<=m; i++ ) {
    		for ( int j=1; j<=n; j++ ) {
    			if ( x.charAt(i-1) == y.charAt(j-1) ) {
    				dp[i][j] = dp[i-1][j-1]+1;
    			} else {
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    			}
//    			System.out.println("dp["+i+"]["+j+"]:"+dp[i][j]);
    		}
    	}
    	return dp[m][n];
    }
}
