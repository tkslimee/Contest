import java.io.IOException;
import java.util.Arrays;

public class ALDS1_10_A {
	public static int[] dp;
	public static int[] dp2;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        dp2 = new int[n+1];
        Arrays.fill(dp, 0);
        Arrays.fill(dp2, 0);
//        System.out.println(fib(n));
        System.out.println(fib2(n));
    }
    static int fib(int n) {
    	if ( dp[n] > 0 ) return dp[n];
    	if ( n == 0 ) return dp[0] = 1;
    	if ( n == 1 ) return dp[1] = 1;
    	return dp[n] = fib(n-1) + fib(n-2);
    }
    static int fib2(int n) {
    	dp2[0] = dp2[1] = 1;
    	for ( int i=2; i<=n; i++ ) {
    		dp2[i] = dp2[i-1]+dp2[i-2];
    	}
    	return dp2[n];
    }
}
