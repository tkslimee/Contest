import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// Ä‹A‚ğg‚Á‚½[‚³—Dæ’Tõ
public class Main {
	public static int[][] ts;
	public static int time = 0;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] M = new int[n+1][n+1];
        ts = new int[n+1][2]; // ˆê‚Â–Ú‚ª–K‚ê‚½‚Æ‚«A2‚Â–Ú‚ª’Tõ‚ªI‚í‚Á‚½‚Æ‚«
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
        for ( int l=1; l<=n; l++ ) {
        	if ( ts[l][1] == 0 ) {
        		dfs(l,M);
        	}
        }
        for ( int i=1; i<=n; i++ ) {
        	System.out.println(i+" "+ts[i][0]+" "+ts[i][1]);
        }
    }
    static void dfs(int v, int[][] m) {
    	if ( ts[v][0] == 0 ) {
    		ts[v][0] = ++time;
    	}
    	for ( int i=1; i<m.length; i++) {
    		if ( m[v][i] != 0 && ts[i][0] == 0 ) {
    			dfs(i,m);
    		}
    	}
    	ts[v][1] = ++time;
    }
}
class Scanner {
    
    private BufferedReader br;
    private StringTokenizer tok;
     
    public Scanner(InputStream is) throws IOException{
        br = new BufferedReader(new InputStreamReader(is));
        getLine();
    }
     
    private void getLine() throws IOException{
        while(tok == null || !hasNext()){
            tok = new StringTokenizer(br.readLine());
        }
    }
     
    private boolean hasNext(){
        return tok.hasMoreTokens();
    }
     
    public String next() throws IOException{
        if(hasNext()){
            return tok.nextToken();
        }else{
            getLine();
            return tok.nextToken();
        }
    }
     
    public int nextInt() throws IOException{
        if(hasNext()){
            return Integer.parseInt(tok.nextToken());
        }else{
            getLine();
            return Integer.parseInt(tok.nextToken());
        }
    }
     
    public long nextLong() throws IOException{
        if(hasNext()){
            return Long.parseLong(tok.nextToken());
        }else{
            getLine();
            return Long.parseLong(tok.nextToken());
        }
    }
     
    public double nextDouble() throws IOException{
        if(hasNext()){
            return Double.parseDouble(tok.nextToken());
        }else{
            getLine();
            return Double.parseDouble(tok.nextToken());
        }
    }
}
