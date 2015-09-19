import java.util.Scanner;

public class ALDS1_3_C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		DLinkedList list = new DLinkedList();
		for ( int i=0; i<n; i++ ) {
			String call = sc.next();
			if ( call.compareTo("insert") == 0 ) {
				int call_num = sc.nextInt();
				list.addFirst(call_num);
			} else if ( call.compareTo("delete") == 0 ) {
				int call_num = sc.nextInt();
				list.delete(call_num);
			} else if ( call.compareTo("deleteFirst") == 0 ) {
				list.deleteFirst();
			} else {
				list.deleteLast();
			}
		}
		System.out.println(list.ListtoString());
		sc.close();
	}
}

class Cell {
	private Object data;
	private Cell next;
	private Cell prev;
	
	public Cell(Object o) {
		data = o;
	}
	public void setNext(Cell next) {
		this.next = next;
	}
	public Cell getNext() {
		return next;
	}
	public void setPrev(Cell prev) {
		this.prev = prev;
	}
	public Cell getPrev() {
		return prev;
	}
	public Object getData() {
		return data;
	}
}

class DLinkedList {
	//�_�~�[�Z���ւ̎Q��
	private Cell dummy;
	//�R���X�g���N�^
	public DLinkedList() {
		dummy = new Cell(null);
		dummy.setNext(dummy);
		dummy.setPrev(dummy);
	}
	//���X�g�̐擪�ɗv�f��ǉ�
	public void addFirst(Object data) {
		//�Z���𐶐�
		Cell c = new Cell(data);
		c.setNext(dummy.getNext());
		c.setPrev(dummy);
		dummy.getNext().setPrev(c);
		dummy.setNext(c);
	}
	//���X�g�̐擪�̗v�f���폜���Ď擾
	public Object deleteFirst() {
		Cell first_cell = dummy.getNext();
		if ( first_cell == dummy ) {
			return null;
		}
		first_cell.getNext().setPrev(dummy);
		dummy.setNext(first_cell.getNext());
		return first_cell.getData();
	}
	//���X�g�̖����̗v�f���폜���Ď擾
	public Object deleteLast() {
		Cell last_cell = dummy.getPrev();
		if ( last_cell == dummy ) {
			return null;
		}
		last_cell.getPrev().setNext(dummy);
		dummy.setPrev(last_cell.getPrev());
		return last_cell.getData();
	}
	//�f�[�^x�����ŏ��̗v�f��A�����X�g����폜���Ď擾
	public Object delete(Object x) {
		Cell c = dummy.getNext();
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
		Cell c = dummy.getNext();
		if ( c == dummy ) {
			return null;
		}
		String ret = "";
		while ( true ) {
			ret = ret.concat(c.getData().toString());
			c = c.getNext();
			if ( c == dummy ) {
				break;
			} else {
				ret = ret.concat(" ");
			}
		}
		return ret;
	}
}