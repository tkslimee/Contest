import java.util.Scanner;

public class ALDS1_3_B {
	public static int head_time=1;
	public static int tail_time=1;
	public static int head_name=1;
	public static int tail_name=1;
	public static int[] Q_time = new int[100005];
	public static String[] Q_name = new String[100005];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		String[] name = new String[n];
		int[] time = new int[n];
		for ( int i=0; i<n; i++ ) {
			name[i] = sc.next();
			time[i] = sc.nextInt();
			enqueue(time[i],name[i]);
		}
		head_time = head_name = 1;
		tail_time = tail_name = n+1;
		int sum_time = 0;

		int tmp_time;
		String tmp_name;
		while ( !isEmpty() ) {
			tmp_time = dequeue_time();
			tmp_name = dequeue_name();
			if ( Math.min(tmp_time, q) != q || tmp_time == q ) {
				sum_time += tmp_time;
				System.out.println(tmp_name+" "+sum_time);
			} else {
				sum_time += q;
				tmp_time -= q;
				enqueue(tmp_time, tmp_name);
			}
		}
		sc.close();
	}
	
	static boolean isEmpty() {
		return head_time == tail_time;
	}

	static void enqueue(int time, String name) {
		Q_time[tail_time] = time;
		Q_name[tail_name] = name;
		tail_time = (tail_time+1)%100000;
		tail_name = (tail_name+1)%100000;
	}
	
	static int dequeue_time() {
		int out_index = head_time;
		head_time = (head_time+1)%100000;
		return Q_time[out_index];
	}

	static String dequeue_name() {
		int out_index = head_name;
		head_name = (head_name+1)%100000;
		return Q_name[out_index];
	}

}
