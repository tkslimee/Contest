import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
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
