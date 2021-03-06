import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// スタックを使った深さ優先探索
public class ALDS1_11_B {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] M = new int[n+1][n+1];
        int[][] ts = new int[n+1][2]; // 一つ目が訪れたとき、2つ目が探索が終わったとき
        for ( int i=0; i<n; i++ ) {
        	Arrays.fill(M[i], 0);
        	Arrays.fill(ts[i], 0);
        }
        for ( int i=0; i<n; i++ ) {
        	int v = sc.nextInt();
        	int cnt = sc.nextInt();
        	for ( int j=0; j<cnt; j++ ) {
        		int to = sc.nextInt();
        		M[v][to] = 1;
        	}
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int time = 0;
        for ( int l=1; l<=n; l++ ) {
        	if ( ts[l][1] == 0 ) {
        		stack.addFirst(l);
        		ts[l][0] = ++time;
        	}
        	while ( !stack.isEmpty() ) {
        		int v = stack.peek();
        		boolean flag = false; // 遷移先が無いときにfalse,あったらtrue
        		for ( int i=1; i<=n; i++) {
        			if ( M[v][i] != 0 && ts[i][0] == 0 ) {
        				flag = true;
        				ts[i][0] = ++time;
        				stack.addFirst(i);
        				break;
        			}
        		}
        		if ( !flag ) {
        			ts[v][1] = ++time;
        			stack.removeFirst();
        		}
        	}
        }
        for ( int i=1; i<=n; i++ ) {
        	System.out.println(i+" "+ts[i][0]+" "+ts[i][1]);
        }
    }
}
