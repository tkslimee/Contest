import java.io.IOException;

public class ALDS1_9_A {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        long[] heap = new long[H+1];
        
        for ( int i=1; i<=H; i++ ) {
        	heap[i] = sc.nextLong();
        }
        for ( int i=1; i<=H; i++ ) {
        	System.out.print("node "+i+": ");
        	System.out.print("key = "+heap[i]+", ");
        	if ( i/2 >= 1 ) {
        		System.out.print("parent key = "+heap[i/2]+", ");
        	}
        	if ( 2*i <= H ) {
        		System.out.print("left key = "+heap[2*i]+", ");
        	}
        	if ( 2*i+1 <= H ) {
        		System.out.print("right key = "+heap[2*i+1]+", ");
        	}
        	System.out.println("");
        }
    }
}
