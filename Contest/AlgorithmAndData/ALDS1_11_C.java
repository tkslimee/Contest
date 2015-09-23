import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ALDS1_11_C {
	public static int INF = Integer.MAX_VALUE;
	
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
        int[] dis = new int[n+1];
        Arrays.fill(dis, INF);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);
        dis[1] = 0;
        while ( !queue.isEmpty() ) {
        	int v = queue.removeFirst();
        	for ( int i=2; i<=n; i++ ) {
        		if ( v != i && M[v][i] != 0 && dis[i] > dis[v]+1 ) {
        			dis[i] = dis[v]+1;
        			queue.addLast(i);
        		}
        	}
        }
        for ( int i=1; i<=n; i++ ) {
        	dis[i] = dis[i]==INF ? -1 : dis[i];
        	System.out.println(i+" "+dis[i]);
        }
    }
}
