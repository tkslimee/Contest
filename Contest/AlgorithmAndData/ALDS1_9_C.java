import java.io.IOException;
import java.util.Arrays;

// 優先度付きキュー
public class ALDS1_9_C {
	public static int MAX = 2000000;
	public static long[] heap;
	public static int H = 0;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        heap = new long[MAX+1];
        Arrays.fill(heap,-1);
        while ( true ) {
        	String s = sc.next();
        	if ( s.charAt(0) == 'i' ) {
        		long x = sc.nextLong();
        		insert(heap,x);
        	} else if ( s.charAt(1) == 'x' ) {
        		System.out.println(heapExtractMax(heap));
        	} else break;
        }
    }
    
    static void insert(long[] A, long x) {
    	H++;
    	int h = H;
    	A[h] = x;
    	while ( A[h] > A[getParent(h)] && h > 1 ) {
    		long tmp = A[getParent(h)];
    		A[getParent(h)] = x;
    		A[h] = tmp;
    		h = getParent(h);
    	}
    }

    static int getParent(int i) {
    	return i/2;
    }

    static long heapExtractMax(long[] A) {
    	if ( H < 1 )return -1;
    	long max = A[1];
    	A[1] = A[H];
    	H--;
    	maxHeapify(A, 1);
    	return max;
    }

    static void maxHeapify(long[] A, int i) {
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
