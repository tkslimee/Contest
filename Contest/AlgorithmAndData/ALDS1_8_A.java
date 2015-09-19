import java.io.IOException;

public class ALDS1_8_A {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
    }
}

//�m�[�h�N���X
class BinarySearchTreeNode {
	private int key;
	private BinarySearchTreeNode parent;
	private BinarySearchTreeNode left;
	private BinarySearchTreeNode right;
	
	//�R���X�g���N�^
	public BinarySearchTreeNode() {
	}
	public BinarySearchTreeNode(int key) {
		this.key = key;
	}

	public void setParent(BinarySearchTreeNode n) {
		this.parent = n;
	}
	public void setLeft(BinarySearchTreeNode n) {
		this.left = n;
	}
	public void setRight(BinarySearchTreeNode n) {
		this.right = n;
	}
	public BinarySearchTreeNode getParent() {
		return this.parent;
	}
	public BinarySearchTreeNode getLeft() {
		return this.left;
	}
	public BinarySearchTreeNode getRight() {
		return this.right;
	}
	public int getKey() {
		return this.key;
	}
}
//2���T����(���\�b�h��������)
class BinarySearchTree {
	//�_�~�[�m�[�h
	private BinarySearchTreeNode dammy;
	//���[�g�m�[�h
	private BinarySearchTreeNode root;
	
	//�R���X�g���N�^
	public BinarySearchTree() {
		this.root = dammy;
	}
	
	//�}��
	public void insert(BinarySearchTreeNode z) {
		BinarySearchTreeNode x = root;
		while ( x != dammy ) {
			if ( z.getKey() < x.getKey() ) {
				x = x.left;
			} else {
				
			}
		}
	}
}