import java.io.IOException;

// ç≈ëÂÅEç≈è¨ÉqÅ[Év
public class ALDS1_9_B {
	public static long nil = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        long[] heap = new long[H+1];
        for ( int i=1; i<=H; i++ ) {
        	heap[i] = sc.nextLong();
        }
        buildMaxHeap(heap);
        for ( int i=1; i<=H; i++ ) {
        	System.out.print(" "+heap[i]);
        }
        System.out.println("");
    }

    static void buildMaxHeap(long[] A) {
    	for ( int i = (A.length-1)/2; i>=1; i--) {
    		maxHeapify(A, i);
    	}
    }
    
    static void maxHeapify(long[] A, int i) {
    	int H = A.length-1;
    	int left = getLeft(i);
    	int right = getRight(i);
    	int largest = 0;
    	if ( left <= H && A[i] < A[left] ) {
    		largest = left;
    	} else {
    		largest = i;
    	}
    	if ( right <= H && A[largest] < A[right] ) {
    		largest = right;
    	}
    	if ( largest != i ) {
    		long tmp = A[i];
    		A[i] = A[largest];
    		A[largest] = tmp;
    		maxHeapify(A, largest);
    	}
    }
    
    static int getLeft(int i) {
    	return 2*i;
    }
    static int getRight(int i) {
    	return 2*i+1;
    }
}
