package Mimir.Exam2.PartBvY.Q2;


public abstract class BinaryTreeRefBased<T> {

    protected TreeNode<T> root;

    public BinaryTreeRefBased() {
        root = null;
    }

    public BinaryTreeRefBased(T rootItem) {
        root = new TreeNode<T>(rootItem, null, null);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public T getRootItem() throws TreeException {
        if (root == null) {
            throw new TreeException("EMPTY TREE");
        } else {
            return root.item;
        }
    }

    public abstract void setRootItem(T item) throws UnsupportedOperationException;

//	public int getHeight(){
//
//	}

}
