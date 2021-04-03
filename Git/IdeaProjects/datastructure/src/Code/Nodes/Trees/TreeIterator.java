package Code.Nodes.Trees;

import java.util.Iterator;
import java.util.LinkedList;

public class TreeIterator<T> implements Iterator<T> {
    private BinaryTreeRefBased<T> binTree;
    private TreeNode<T> currentNode;
    private LinkedList <TreeNode<T>> queue;

    public TreeIterator(BinaryTreeRefBased<T> binTree){
        this.binTree = binTree;
        currentNode = null;
        queue = new LinkedList<TreeNode<T>>(); //empty queue for traversal
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        return queue.remove().item;
    }

    public void remove() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    public void setPreorder(){
        queue.clear();
        this.preorder(this.binTree.root);
    }

    /*
    * visits the nodes in ascending order
    */
    public void setInorder(){
        queue.clear();
        this.inorder(this.binTree.root);
    }

    /*
     * visits the leftmost in ascending order
     */
    public void setPostorder(){
        queue.clear();
        this.postorder(this.binTree.root);
    }



    private void preorder(TreeNode<T> treeNode){
        if (treeNode != null) {
            queue.add(treeNode);
            preorder(treeNode.leftChild);
            preorder(treeNode.rightChild);
        }
    }

    private void inorder(TreeNode<T> treeNode){
        if (treeNode != null) {
            inorder(treeNode.leftChild);
            queue.add(treeNode);
            inorder(treeNode.rightChild);
        }
    }

    private void postorder(TreeNode<T> treeNode){
        if (treeNode != null) {
            postorder(treeNode.leftChild);
            postorder(treeNode.rightChild);
            queue.add(treeNode);
        }
    }
}
