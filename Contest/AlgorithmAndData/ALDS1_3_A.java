import java.util.Scanner;

public class ALDS1_3_A {
	public static int top;
	public static int[] S = new int[10000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
//		System.out.println(s);
		String[] s_list = s.split(" ",0);
//		for ( int i=0; i<s_list.length; i++ ) {
//			System.out.println(s_list[i]);
//		}

		int top = 0;
		for ( int i=0; i<s_list.length; i++ ) {
			char c = s_list[i].charAt(0);
			if ( c == '+' || c == '-' || c == '*' ) {
				int b = pop();
				int a = pop();
//				System.out.println(a+","+b);
				int ans;
				if ( c == '+' ){ ans = a+b; }
				else if ( c == '-' ){ ans = a-b;}
				else{ ans = a*b;}
				push(ans);
			} else {
				int c_num = Integer.parseInt(s_list[i]);
				push(c_num);
			}
		}
		System.out.println(pop());
		sc.close();
	}
	
	static void initialize() {
		top = 0;
	}
	
	static boolean isEmpty() {
		return top == 0;
	}
	
	static void push(int a) {
		S[++top] = a;
	}
	
	static int pop() {
		return S[top--];
	}
}
