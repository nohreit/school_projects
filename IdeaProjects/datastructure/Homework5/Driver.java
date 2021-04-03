package Mimir.Homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Driver implements DriverInterface {

    public static void main(String[] args){
        Driver driver = new Driver();
        driver.execute();
    }

    public Driver(){}

    public void execute(){
        BinarySearchTree<Integer,String> bst = this.createAndPopulateBST(this.getVectorOfTreeItems());
        println("Is it balanced? "+ (bst.isBalanced() ? "Yes" : "No"));
        println("Height: "+bst.height());
        bst.balance();
        println("Is it balanced now? "+ (bst.isBalanced() ? "Yes" : "No"));

    }

    @Override
    @SuppressWarnings("unchecked")
    public Vector<TreeItem<Integer, String>> getVectorOfTreeItems() {
        final int MAX = 131071;
        TreeItem<Integer, String>[] treeItem = new TreeItem[MAX];
        for (int i = 0; i < treeItem.length; i++) {
            treeItem[i] = new TreeItem<> (i,String.valueOf(Math.random()*100000));
        }
        return new Vector<>(new ArrayList<>(Arrays.asList(treeItem)));
    }

    @Override
    public BinarySearchTree<Integer, String> createAndPopulateBST(Vector<TreeItem<Integer, String>> treeItems) {
        BinarySearchTree<Integer,String> bst = new BinarySearchTree<>();
        for (TreeItem<Integer,String> item : this.getVectorOfTreeItems()) {
            bst.insert(item);
        }
        return bst;
    }

    public static void println(Object o) {
        System.out.println(o);
    }

    public static void print(Object o) {
        System.out.print(o);
    }
}
