package Mimir.Homework5;

public class BinarySearchTree <K extends Comparable<? super K>, V> implements Iterable<TreeItem<K,V>> {

	private TreeNode<K,V> root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
//	public BinarySearchTree(TreeNode<K,V> root) {
//		this.root = root;
//	}

	public TreeNode<K, V> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<K, V> root) {
		this.root = root;
	}
	
	public boolean isEmpty() {
		boolean answer = true;
		
		if (this.root != null) {
			answer = false;
		}
		
		return answer;
	}
	
	public void makeEmpty() {
		this.root = null;
	}
	
	public TreeItem<K,V> getRootItem() throws TreeException {
		if (this.root != null) {
			return this.root.getTreeItem();
		} else {
			throw new TreeException("TreeException: Tree is empty, no TreeItem to return");
		}
	}

	public TreeItem<K,V> find(K key) {
		return (findItem(this.root, key));
	}
	
	public void insert(TreeItem<K,V> treeItem) {
		if(this.root == null) this.root = insertItem(null, null, treeItem);
		else{
			TreeNode<K,V> node = this.root;
			while (node != null){
				if(node.getLeftChild() != null) node = node.getLeftChild();
				else node = node.getRightChild();
			}
		}
	}

	@Override
	public TreeIterator<K,V> iterator() {
		return new TreeIterator<>(this);
	}
	
	public void delete(K key) {
		this.root = deleteItem(this.root, key);
	}

	public int height(){
		return this.treeHeight(this.root);
	}

	private int treeHeight(TreeNode<K,V> node) {
		if (node == null) {
			return 0;
		}
		return (1 + Math.max(treeHeight(node.getLeftChild()), treeHeight(node.getRightChild())));
	}


	public boolean isBalanced(){
		return treeIsBalanced(root);
	}

	private boolean treeIsBalanced(TreeNode<K,V> node) {
		if(node == null){
			return true;
		}
		if(Math.abs( treeHeight(node.getLeftChild()) - treeHeight(node.getRightChild()) )  <=   1  ){

			return  ( treeIsBalanced(node.getLeftChild()) && treeIsBalanced(node.getRightChild()) );
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public void balance(){
		TreeIterator<K,V> it = this.iterator();
		TreeItem<K,V>[] arr = new TreeItem[it.size()];

		if(!isEmpty()){
			this.balanceTree(arr, 0, arr.length-1);
		}else println("Empty list");
	}
	private TreeNode<K,V> balanceTree(TreeItem<K,V>[] arr, int first, int last){
		TreeNode<K,V> node = null;
		if (first == last){
			int rootIndex = (first+last)/2;
			node = new TreeNode<>(arr[rootIndex]);
			//if we were using array based implementation of BST insertion would be O(1) because we could calculate the left/right child
			//leftChildIndex = (2*parentIndex)+1   , rightChildIndex = (2*parentIndex)+2   , parentIndex = (childIndex-1)/2
			node.setLeftChild(balanceTree(arr, first, (rootIndex)));//left recursive
			node.setRightChild(balanceTree(arr, (rootIndex+1), last));//right recursive
		}
		return node;
	}

	public static void println(Object o) {
		System.out.println(o);
	}

	public static void print(Object o) {
		System.out.print(o);
	}

/* **************************************************************************** */
/*                           Private Methods                                    */
/* **************************************************************************** */
	
	private int compareKeys(K k1, K k2) {
		return k1.compareTo(k2);
	}
	
	private TreeItem<K,V> findItem(TreeNode<K,V> node, K key) {
		if (node == null) {
			return null;
		} else if (compareKeys(node.getTreeItem().getKey(), key) == 0) {
			return node.getTreeItem();
		} else if (compareKeys(node.getTreeItem().getKey(), key) > 0) {
			return (findItem(node.getLeftChild(), key));
		} else {
			return (findItem(node.getRightChild(), key));
		}			
	}

	private TreeNode<K,V> insertItem(TreeNode<K,V> node, TreeNode<K,V> parent, TreeItem<K,V> treeItem) {
		if (node == null) {
			node = new TreeNode<>(treeItem);
			node.setParent(parent);
		} else if (compareKeys(node.getTreeItem().getKey(), treeItem.getKey()) > 0) {
			node.setLeftChild(insertItem(node.getLeftChild(), node, treeItem));
		} else {
			node.setRightChild(insertItem(node.getRightChild(), node, treeItem));
		}
		
		return node;
	}
	
	private TreeNode<K,V> deleteItem(TreeNode<K,V> node, K key) {
		if (node == null) {
			throw new TreeException("TreeException - Item to delete is not found");
		} else {
			TreeItem<K,V> item = node.getTreeItem();
			if (compareKeys(item.getKey(), key) == 0) {
				node = deleteNode(node);
			} else if (compareKeys(item.getKey(), key) > 0) {
				node.setLeftChild(deleteItem(node.getLeftChild(), key));
			} else {
				node.setRightChild(deleteItem(node.getRightChild(), key));
			}
		}
		return node;
	}
	
	private TreeNode<K,V> deleteNode(TreeNode<K,V> node) {
		if (isLeafNode(node)) {
			return null;
		} else if (noLeftChild(node)) {
			return node.getRightChild();
		} else if (noRightChild(node)) {
			return node.getLeftChild();
		} else {
			TreeNode<K,V> successor = findSuccessorNode(node.getRightChild());
			node.setTreeItem(successor.getTreeItem());
			node.setRightChild(deleteSuccessorNode(node.getRightChild()));
			return node;
		}
	}
	
	private boolean isLeafNode(TreeNode<K,V> node) {
		return ((node.getLeftChild() == null) && (node.getRightChild() == null));
	}
	
	private boolean noLeftChild(TreeNode<K,V> node) {
		return (node.getLeftChild() == null);
	}
	
	private boolean noRightChild(TreeNode<K,V> node) {
		return (node.getRightChild() == null);
	}
	
	private TreeNode<K,V> findSuccessorNode(TreeNode<K,V> node) {
		if (node.getLeftChild() == null) {
			return node;
		} else {
			return findSuccessorNode(node.getLeftChild());
		}
	}
	
	private TreeNode<K,V> deleteSuccessorNode(TreeNode<K,V> node) {
		if (node.getLeftChild() == null) {
			return node.getRightChild();
		} else {
			node.setLeftChild(deleteSuccessorNode(node.getLeftChild()));
			return node;
		}
	}
}
