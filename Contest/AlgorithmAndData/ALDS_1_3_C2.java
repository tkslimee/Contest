import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ALDS_1_3_C2 {
	public static void main(String[] args) throws IOException{
//		FileReader file = new FileReader("ALDS1_3_C-in10.txt");
//		Scanner sc = new Scanner(file);
//		int n = sc.nextInt();
//		DLinkedList2 list = new DLinkedList2();
//		for ( int i=0; i<n; i++ ) {
//			String call = sc.next();
//			if ( call.compareTo("insert") == 0 ) {
//				int call_num = sc.nextInt();
//				list.addFirst(call_num);
//			} else if ( call.compareTo("delete") == 0 ) {
//				int call_num = sc.nextInt();
//				list.delete(call_num);
//			} else if ( call.compareTo("deleteFirst") == 0 ) {
//				list.deleteFirst();
//			} else {
//				list.deleteLast();
//			}
//		}
//		System.out.println(list.ListtoString());
//		File outfile = new File("test.txt");
//		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outfile)));
//		pw.println(list.ListtoString());
//		pw.close();
	}
}

class Cell2 {
	private int data;
	private Cell2 next;
	private Cell2 prev;
	
	public Cell2(int o) {
		data = o;
	}
	public void setNext(Cell2 next) {
		this.next = next;
	}
	public Cell2 getNext() {
		return next;
	}
	public void setPrev(Cell2 prev) {
		this.prev = prev;
	}
	public Cell2 getPrev() {
		return prev;
	}
	public Object getData() {
		return data;
	}
}

class DLinkedList2 {
	//�_�~�[�Z���ւ̎Q��
	private Cell2 dummy;
	//�R���X�g���N�^
	public DLinkedList2() {
		dummy = new Cell2(-1);
		dummy.setNext(dummy);
		dummy.setPrev(dummy);
	}
	//���X�g�̐擪�ɗv�f��ǉ�
	public void addFirst(int data) {
		//�Z���𐶐�
		Cell2 c = new Cell2(data);
		c.setNext(dummy.getNext());
		c.setPrev(dummy);
		dummy.getNext().setPrev(c);
		dummy.setNext(c);
	}
	//���X�g�̐擪�̗v�f���폜���Ď擾
	public Object deleteFirst() {
		Cell2 first_cell = dummy.getNext();
		if ( first_cell == dummy ) {
			return null;
		}
		first_cell.getNext().setPrev(dummy);
		dummy.setNext(first_cell.getNext());
		return first_cell.getData();
	}
	//���X�g�̖����̗v�f���폜���Ď擾
	public Object deleteLast() {
		Cell2 last_cell = dummy.getPrev();
		if ( last_cell == dummy ) {
			return null;
		}
		last_cell.getPrev().setNext(dummy);
		dummy.setPrev(last_cell.getPrev());
		return last_cell.getData();
	}
	//�f�[�^x�����ŏ��̗v�f��A�����X�g����폜���Ď擾
	public Object delete(Object x) {
		Cell2 c = dummy.getNext();
		if ( c == dummy ) {
			return null;
		}
		while ( c != dummy ) {
			if ( c.getData() == x ) {
				c.getNext().setPrev(c.getPrev());
				c.getPrev().setNext(c.getNext());
				return c.getData();
			}
			c = c.getNext();
		}
		return null;
	}
	//���݂̗v�f�𕶎���ɂ��ďo��
	public String ListtoString() {
		Cell2 c = dummy.getNext();
		if ( c == dummy ) {
			return null;
		}
		StringBuilder ret = new StringBuilder();
		while ( true ) {
			ret.append(c.getData().toString());
			c = c.getNext();
			if ( c == dummy ) {
				break;
			} else {
				ret.append(" ");
			}
		}
		return ret.toString();
	}
}

//class Scanner {
//    
//    private BufferedReader br;
//    private StringTokenizer tok;
//     
//    public Scanner(FileReader is) throws IOException{
//        br = new BufferedReader(is);
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