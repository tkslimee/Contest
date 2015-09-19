import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class ALDS1_3_D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int ans = 0;
		Deque<Integer> deque1 = new ArrayDeque<Integer>();
		Deque<Integer> pos = new ArrayDeque<Integer>();
		Deque<Integer> eacharea = new ArrayDeque<Integer>();
		for ( int i=0; i<str.length(); i++ ) {
			char c = str.charAt(i);
			if ( c == '\\' ) {
				deque1.addFirst(i);
			} else if ( c == '/' ) {
				if ( deque1.size() > 0 ) {
					int left = deque1.removeFirst();
					ans += i-left;
					int tmp_ans = i-left;
					while ( pos.size() > 0 && pos.peekFirst() > left ) {
						tmp_ans += eacharea.removeFirst();
						pos.removeFirst();
					}
					eacharea.addFirst(tmp_ans);
					pos.addFirst(left);
				}
			}
		}
		System.out.println(ans);
		int area_size = eacharea.size();
		System.out.print(area_size);
		if ( area_size != 0 ) {
			System.out.print(" ");
		}
		for ( int i=0; i<area_size; i++ ) {
			System.out.print(eacharea.removeLast());
			if ( i != area_size-1 ) {
				System.out.print(" ");
			}
		}
		System.out.println("");
		sc.close();
	}
}
