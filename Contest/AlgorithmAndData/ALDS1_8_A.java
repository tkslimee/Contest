import java.io.IOException;

public class ALDS1_8_A {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
    }
}

//ノードクラス
class BinarySearchTreeNode {
	private int key;
	private BinarySearchTreeNode parent;
	private BinarySearchTreeNode left;
	private BinarySearchTreeNode right;
	
	//コンストラクタ
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
//2分探索木(メソッド等を実装)
class BinarySearchTree {
	//ダミーノード
	private BinarySearchTreeNode dammy;
	//ルートノード
	private BinarySearchTreeNode root;
	
	//コンストラクタ
	public BinarySearchTree() {
		this.root = dammy;
	}
	
	//挿入
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