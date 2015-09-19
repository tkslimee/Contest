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

	public void setKey(int key) {
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
	private BinarySearchTreeNode dammy = new BinarySearchTreeNode(Integer.MIN_VALUE);
	
	//ルートノード
	private BinarySearchTreeNode root;
	
	//コンストラクタ
	public BinarySearchTree() {
		this.root = dammy;
		root.setParent(dammy);
	}
	
	public BinarySearchTreeNode getRoot() {
		return this.root;
	}
	
	//挿入
	public void insert(BinarySearchTreeNode z) {
		BinarySearchTreeNode y = dammy;
		BinarySearchTreeNode x = root;
		while ( x != dammy ) {
			y = x;
			if ( z.getKey() < x.getKey() ) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
		}
		z.setParent(y);
		z.setLeft(dammy);
		z.setRight(dammy);
		if ( y == dammy ) {
			root = z;
			root.setParent(dammy);
		} else if ( z.getKey() < y.getKey() ) {
			y.setLeft(z);
		} else {
			y.setRight(z);
		}
	}
	
	//　探索
	public BinarySearchTreeNode find(int key) {
		BinarySearchTreeNode ret = dammy;
		BinarySearchTreeNode x = root;
		while ( x != dammy ) {
			if ( x.getKey() == key ) {
				ret = x;break;
			} else if ( x.getKey() > key ) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
		}
		return ret;
	}
	
	// 削除
	public void delete(int key) {
		BinarySearchTreeNode y = dammy;
		BinarySearchTreeNode x = root;
		boolean flag = false;
		while ( x != dammy ) {
			// xが存在したとき
			if ( x.getKey() == key ) {
				flag = true;
				break;
			}
			y = x;
			if ( x.getKey() > key ) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
		}
		if ( flag ) {
			// 子がいない、もしくは一人のとき
			if ( x.getLeft() == dammy || x.getRight() == dammy ) {
				deleteNoneOrOneChild(x);
			// 子が両方にいるとき
			} else {
				BinarySearchTreeNode next = getSuccessor(x);
				if ( y == dammy ) {
					root.setKey(next.getKey());
				} else {
					if ( y.getKey() > x.getKey() ) {
						y.getLeft().setKey(next.getKey());
						y.getLeft().setParent(y);
					} else {
						y.getRight().setKey(next.getKey());
						y.getRight().setParent(y);
					}
				}
				deleteNoneOrOneChild(next);
			}
		}
	}
	
	// 子供がいない、もしくは、子供が一人のときのノード削除
	public void deleteNoneOrOneChild(BinarySearchTreeNode x) {
		BinarySearchTreeNode y = x.getParent();
		// 子がいないとき
		if ( x.getLeft() == dammy && x.getRight() == dammy ) {
			if ( y == dammy ) {
				root = dammy;
				root.setParent(dammy);
			} else {
				if ( y.getKey() > x.getKey() )y.setLeft(dammy);
				else y.setRight(dammy);
			}
		// 子がどちらか片方のとき
		} else if ( x.getLeft() == dammy || x.getRight() == dammy ) {
			if ( y == dammy ) {
				if ( x.getLeft() != dammy )root = x.getLeft();
				else root = x.getRight();
				root.setParent(dammy);
			} else {
				if ( x.getLeft() != dammy ) { 
					x.getLeft().setParent(y);
					if ( y.getKey() > x.getKey() )y.setLeft(x.getLeft());
					else y.setRight(x.getLeft());
				} else {
					x.getRight().setParent(y);
					if ( y.getKey() > x.getKey() )y.setLeft(x.getRight());
					else y.setRight(x.getRight());
				}
			}
		}
	}
	
	public void deleteNode(BinarySearchTreeNode x) {
		//削除する対象を決める
		BinarySearchTreeNode delete_node;
		if ( x.getLeft() == dammy || x.getRight() == dammy ) {
			delete_node = x;
		} else {
			delete_node = getSuccessor(x);
		}
		//削除するノードの子供
		BinarySearchTreeNode child_del = dammy;
		if ( delete_node.getLeft() != dammy ) child_del = delete_node.getLeft();
		else child_del = delete_node.getRight();
		
		if ( child_del != dammy ) {
			child_del.setParent(delete_node.getParent());
		}
		
		if ( delete_node.getParent() == dammy ) {
			root = child_del;
		} else if ( delete_node.getParent().getKey() > delete_node.getKey() ) {
			delete_node.getParent().setLeft(child_del);
		} else {
			delete_node.getParent().setRight(child_del);
		}
		// 子供が2つあるとき
		if ( delete_node != x ) {
			x.setKey(delete_node.getKey());
		}
	}
	
	// 次節点の探索
	public BinarySearchTreeNode getSuccessor(BinarySearchTreeNode x) {
		if ( x.getRight() != dammy ) {
			return getMinimum(x.getRight());
		}
		BinarySearchTreeNode y = x.getParent();
		while ( y != dammy && y.getRight() == x ) {
			x = y;
			y = y.getParent();
		}
		return y;
	}
	
	// 二分探索木の最小値
	public BinarySearchTreeNode getMinimum(BinarySearchTreeNode x) {
		while ( x.getLeft() != dammy ) {
			x = x.getLeft();
		}
		return x;
	}
	
	// 先行順巡回でノードを出力
	public void preOrder(BinarySearchTreeNode z) {
		if ( z.getKey() != Integer.MIN_VALUE ) {
			System.out.print(" "+z.getKey());
			preOrder(z.getLeft());
			preOrder(z.getRight());
		}
	}

	// 中間順巡回でノードを出力(小さい順)
	public void inOrder(BinarySearchTreeNode z) {
		if ( z.getKey() != Integer.MIN_VALUE ) {
			inOrder(z.getLeft());
			System.out.print(" "+z.getKey());
			inOrder(z.getRight());
		}
	}
	// 後行順巡回でノードを出力
	public void postOrder(BinarySearchTreeNode z) {
		if ( z.getKey() != Integer.MIN_VALUE ) {
			postOrder(z.getLeft());
			System.out.print(" "+z.getKey());
			postOrder(z.getRight());
		}
	}
}
