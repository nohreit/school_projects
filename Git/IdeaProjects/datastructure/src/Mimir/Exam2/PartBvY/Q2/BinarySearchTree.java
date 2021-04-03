package Mimir.Exam2.PartBvY.Q2;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchTree
        <T extends KeyedItem<KT>, KT extends Comparable<? super KT>>
        extends BinaryTreeRefBased<T> {


// Q1. Create a protected method named findRightMost(TreeNode<T> tNode) so that it returns the rightmost descendant of the node.

    protected T findRightMost(TreeNode<T> tNode){
        if(tNode.rightChild == null){
            return tNode.item;
        }
        else{
            return findRightMost(tNode.rightChild);//recursive call passing in leftChild
        }
    }

// Q2. Create a public method named getMinAndMaxFromBST that returns an ArrayList of type T containing the minimum and maximum values of the BinarySearchTree.

    public ArrayList<T> getMinAndMaxFromBST(){
        if(isEmpty()) return null;
        ArrayList<T> minMax = new ArrayList<>();
        minMax.add(this.findLeftMost(this.root));
        minMax.add(this.findRightMost(this.root));
        return minMax;
    }

// Q3. Create a public method named getPredecessorRootSuccessor() that returns an ArrayList of type T containing the predecessor to the root, the root, and the successor to the root of the BinarySearchTree.

    public ArrayList<T> getPredecessorRootSuccessor(){
        TreeNode<T> predecessor = null;
        if(root.leftChild != null){
            predecessor = root.leftChild;

            while(predecessor.rightChild != null){
                predecessor = predecessor.rightChild;
            }
        }


        TreeNode<T> successor = null;
        if(root.rightChild != null){
            successor = root.rightChild;

            while(successor.leftChild != null){
                successor = successor.leftChild;
            }
        }


        ArrayList<T> predecessorRootSuccessor = new ArrayList<T>();

        if (predecessor != null){
            predecessorRootSuccessor.add(predecessor.item);
        }
        else {
            predecessorRootSuccessor.add(null);
        }

        predecessorRootSuccessor.add(root.item);

        if (successor != null){
            predecessorRootSuccessor.add(successor.item);
        }
        else {
            predecessorRootSuccessor.add(null);
        }

        return predecessorRootSuccessor;
    }

    public BinarySearchTree() {

    }

    public BinarySearchTree(T rootItem) {
        super(rootItem);
    }

    @Override
    public void setRootItem(T item) throws UnsupportedOperationException {
        // TODO Auto-generated method stub

    }


    public void insert(T item) {
        root = insertItem(root, item);
    }

    protected TreeNode<T> insertItem(TreeNode<T> tNode, T item) {
        TreeNode<T> newSubTree;
        if (tNode == null) {//insert after leaf
            tNode = new TreeNode<T>(item, null, null);
            return tNode; //return existing tNode
        }
        T nodeItem = tNode.item;//use item to find insertion point
        if (item.getKey().compareTo(nodeItem.getKey()) < 0) { //go left
            newSubTree = insertItem(tNode.leftChild, item); //recursive call
            tNode.leftChild = newSubTree;
            return tNode; //return the reference to the new tNode
        } else {//go right
            newSubTree = insertItem(tNode.rightChild, item);//recursive call
            tNode.rightChild = newSubTree;
            return tNode;//return the reference to the new tNode
        }
    }

    public T retrieve(KT searchKey) {
        return retrieveItem(root, searchKey);
    }

    protected T retrieveItem(TreeNode<T> tNode, KT searchKey) {
        T treeItem;
        if (tNode == null) {
            treeItem = null;
        } else {
            T nodeItem = tNode.item;
            if (searchKey.compareTo(nodeItem.getKey()) == 0) {
                treeItem = tNode.item;
            } else if (searchKey.compareTo(nodeItem.getKey()) < 0) {//go left
                treeItem = retrieveItem(tNode.leftChild, searchKey);//recursive call passing in leftChild
            } else {
                treeItem = retrieveItem(tNode.rightChild, searchKey);//recursive call passing in rightChild
            }
        }
        return treeItem;
    }


    //delete using searchKey
    public void delete(KT searchKey) throws TreeException {
        root = deleteItem(root, searchKey);
    }

    //delete using item to get searchKey
    public void delete(T item) throws TreeException {
        root = deleteItem(root, item.getKey());
    }

    /**
     * called by delete
     * calls deleteNode
     */
    protected TreeNode<T> deleteItem(TreeNode<T> tNode, KT searchKey) {
        TreeNode<T> newSubTree;
        if (tNode == null) {
            throw new TreeException("ITEM NOT FOUND");
        } else {
            T nodeItem = tNode.item;
            if (searchKey.compareTo(nodeItem.getKey()) == 0) {
                tNode = deleteNode(tNode); //call deleteNode method
            } else if (searchKey.compareTo(nodeItem.getKey()) < 0) {//go left
                newSubTree = deleteItem(tNode.leftChild, searchKey); //recursive call
                tNode.leftChild = newSubTree;
            } else {//go right
                newSubTree = deleteItem(tNode.rightChild, searchKey); //recursive call
                tNode.rightChild = newSubTree;
            }
        }
        return tNode;
    }

    /**
     * called by deleteItem, which is called by delete
     * calls findLeftMost, deleteLeftMost
     *
     * @param tNode
     * @return tNode
     */
    protected TreeNode<T> deleteNode(TreeNode<T> tNode) {
        T replacementItem;
        if ((tNode.leftChild == null) && (tNode.rightChild == null)) {//is a leaf - no children
            return null;
        } else if (tNode.leftChild == null) {//has no leftChild, only has rightChild
            return tNode.rightChild;
        } else if (tNode.rightChild == null) {//has no rightChild, only has leftChild
            return tNode.leftChild;
        } else {//has two children
            replacementItem = findLeftMost(tNode.rightChild);//find inorder successor
            tNode.item = replacementItem;
            tNode.rightChild = deleteLeftMost(tNode.rightChild);//delete inorder successor
            return tNode;
        }
    }

    protected T findLeftMost(TreeNode<T> tNode) {
        if (tNode.leftChild == null) {//no left child
            return tNode.item;
        } else {
            return findLeftMost(tNode.leftChild);//recursive call passing in leftChild
        }
    }


    protected TreeNode<T> deleteLeftMost(TreeNode<T> tNode) {
        if (tNode.leftChild == null) {
            return tNode.rightChild;//when there is no rightChild null is returned
        } else {
            tNode.leftChild = deleteLeftMost(tNode.leftChild);//recursive call passing in leftChild
            return tNode;
        }
    }


}