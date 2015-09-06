import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class ALDS1_4_C {
	public static int M = 1046527;
	public static String[] H = new String[M];
	public static int nil = -1;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for ( int i=0; i<M; i++ ) {
			H[i] = "";
		}
//		for ( int i=0; i<n; i++ ) {
//			String order = sc.next();
//			String key = sc.next();
//			if ( order.charAt(0) == 'i' ) {
//				insert(key);
//			} else {
//				if ( find(key) ) {
//					System.out.println("yes");
//				} else {
//					System.out.println("no");
//				}
//			}
//		}
		//javaのライブラリを使った実装
		HashSet<String> hash = new HashSet<String>();
		for ( int i=0; i<n; i++ ) {
			String order = sc.next();
			String key = sc.next();
			if ( order.charAt(0) == 'i' ) {
				hash.add(key);
			} else {
				if ( hash.contains(key) ) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		}
	}
	static int getInt(char c) {
		if ( c == 'A' ) return 1;
		else if ( c == 'C' ) return 2;
		else if ( c == 'G' ) return 3;
		else if ( c == 'T' ) return 4;
		else return 0;
	}
	static long getKey(String str) {
		long ans = 0;
		long p = 1;
		for ( int i=0; i<str.length(); i++ ) {
			ans += p*(getInt(str.charAt(i)));
			p *= 5;
		}
		return ans;
	}
	//ハッシュ関数1(まずはこれ)
	static int h1(long key) {
		return (int)key%M;
	}
	//ハッシュ関数2(ハッシュ関数1で被ってしまったときはこれを使って被らないように頑張る)
	static int h2(long key) {
		return (int)(1 + key%(M-1));
	}
	//ハッシュHに挿入。既に挿入済みの場合0を、挿入に成功した場合1を返す
	static int insert(String str) {
		long key = getKey(str);
		for ( int i = 0; ;i++) {
			int h = (h1(key) + i*h2(key)) % M;
			if ( H[h].compareTo("") == 0 ) {
				H[h] = str;
				return 1;
			} else if ( H[h].compareTo(str) == 0 ) {
				return 0;
			}
		}
	}
	//ハッシュHを検索
	static boolean find(String str) {
		long key = getKey(str);
		for ( int i = 0; ;i++) {
			int h = (h1(key) + i*h2(key)) % M;
			if ( H[h].compareTo("") == 0 ) {
				return false;
			} else if ( H[h].compareTo(str) == 0 ) {
				return true;
			}
		}
	}
}

//class Scanner {
//    
//    private BufferedReader br;
//    private StringTokenizer tok;
//     
//    public Scanner(InputStream is) throws IOException{
//        br = new BufferedReader(new InputStreamReader(is));
//        getLine();
//    }
//     
//    private void getLine() throws IOException{
//        while(tok == null || !hasNext()){
//            tok = new StringTokenizer(br.readLine());
//        }
//    }
//     
//    private boolean hasNext(){
//        return tok.hasMoreTokens();
//    }
//     
//    public String next() throws IOException{
//        if(hasNext()){
//            return tok.nextToken();
//        }else{
//            getLine();
//            return tok.nextToken();
//        }
//    }
//     
//    public int nextInt() throws IOException{
//        if(hasNext()){
//            return Integer.parseInt(tok.nextToken());
//        }else{
//            getLine();
//            return Integer.parseInt(tok.nextToken());
//        }
//    }
//     
//    public long nextLong() throws IOException{
//        if(hasNext()){
//            return Long.parseLong(tok.nextToken());
//        }else{
//            getLine();
//            return Long.parseLong(tok.nextToken());
//        }
//    }
//     
//    public double nextDouble() throws IOException{
//        if(hasNext()){
//            return Double.parseDouble(tok.nextToken());
//        }else{
//            getLine();
//            return Double.parseDouble(tok.nextToken());
//        }
//    }
//}