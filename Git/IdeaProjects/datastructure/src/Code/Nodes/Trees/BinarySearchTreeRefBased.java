//package Code.Nodes.Trees;
//
//public class BinarySearchTreeRefBased<T extends KeyedItem<KT>,
//        KT extends Comparable<? super KT>>
//        extends BinaryTreeRefBased<T>{
//
//
//    public BinarySearchTreeRefBased(T rootItem){
//        super(rootItem);
//    }
//
//
//    @Override
//    public void setRootItem(T item) throws TreeException {
////		super.setRootItem(item);
//        throw new TreeException("root was set at construction... "
//                + "we don't want to mess up the ordering");
//    }
//
//    @Override
//    public void insert(T item){
//        root = insertItem(root, item);
//    }
//
//    private TreeNode<T> insertItem(TreeNode<T> theNode, T item) {
//        TreeNode<T> newSubTree;
//        if(theNode == null){//insert after the leaf
//            theNode = new TreeNode<>(item, null, null);
//            return theNode;
//        }
//        T nodeItem = theNode.item; //use the item to find the insertion point
//        if(item.getKey().compareTo(nodeItem.getKey())  < 0 ){//go left
//            newSubTree = insertItem(theNode.leftChild, item); //recurive call go left
//            theNode.leftChild = newSubTree;
//        }
//        else{//go right (item key is equal or greater than curr Node)
//            newSubTree = insertItem(theNode.rightChild, item);
//            theNode.rightChild = newSubTree;
//        }
//        return theNode;
//    }
//
//
//    public T retrieve(KT searchKey){
//        return retrieveItem(root, searchKey);
//    }
//
//    private T retrieveItem(TreeNode<T> theNode, KT searchKey) {
//        T treeItem;
//        if(theNode == null){
//            treeItem = null;
//        }
//        else{
//            T nodeItem = theNode.item;
//            if(searchKey.compareTo(nodeItem.getKey()) == 0 ){//found
//                treeItem = theNode.item;
//            }
//            else if( searchKey.compareTo(nodeItem.getKey()) < 0){//go left
//                treeItem = retrieveItem(theNode.leftChild, searchKey);//recursive call
//            }
//            else{
//                treeItem = retrieveItem(theNode.rightChild, searchKey);//recursive call
//            }
//        }
//        return treeItem;
//    }
//
//
//    /**
//     * calls deleteItem passes in root and the item's search key
//     */
//    @Override
//    public void delete(T item){
//        try {
//            root = deleteItem(root, item.getKey());
//        } catch (TreeException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    public void delete(KT key){
//        try {
//            root = deleteItem(root, key);
//        } catch (TreeException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * called by delete
//     * calls deleteNode
//     * recursive method calls self when going left/right
//     */
//    private TreeNode<T> deleteItem(TreeNode<T> tNode, KT key) throws TreeException {
//        TreeNode<T>  theNewSubTree;
//        if(tNode == null){
//            throw new TreeException("Item not found for deletion "+key);
//        }
//        T nodeItem = tNode.item;
//        if(key.compareTo(nodeItem.getKey())   ==  0){
//            tNode = deleteNode(tNode); //call deleteNode method
//        }
//        else if(key.compareTo(nodeItem.getKey())   <  0){ //go left
//            theNewSubTree = deleteItem(tNode.leftChild, key);
//            tNode.leftChild = theNewSubTree;
//        }
//        else{//go right
//            theNewSubTree = deleteItem(tNode.rightChild, key);
//            tNode.rightChild = theNewSubTree;
//        }
//        return tNode;
//    }
//
//
//    /**
//     * called by deleteItem, which is called by delete
//     * calls findLeftMost
//     * calls deleteLeftMost
//     * @param tNode object
//     * @return <code>null, tNode.rightChild, tNode.leftChild or tNode</code>
//     */
//    private TreeNode<T> deleteNode(TreeNode<T> tNode) {
//        if( tNode.leftChild == null && tNode.rightChild==null){// is a leaf
//            return null;
//        }
//        else if(tNode.leftChild == null){//no left child
//            return tNode.rightChild;
//        }
//        else if(tNode.rightChild == null){//no right child only left
//            return tNode.leftChild;
//        }
//        else{
//            tNode.item = findLeftMost(tNode.rightChild);
//            tNode.rightChild = deleteLeftMost(tNode.rightChild);
//            return tNode;
//        }
//    }
//
//
//    private T findLeftMost(TreeNode<T> tNode){
//        if(tNode.leftChild == null){
//            return tNode.item;
//        }
//        else{
//            return findLeftMost(tNode.leftChild);//recursive call passing in leftChild
//        }
//    }
//
//
//    private TreeNode<T> deleteLeftMost(TreeNode<T> tNode){
//        if(tNode.leftChild == null){
//            return tNode.rightChild; //when there is no rightChild null is returned
//        }
//        else{
//            tNode.leftChild = deleteLeftMost(tNode.leftChild);//recursive call passing in leftChild
//            return tNode;
//        }
//
//
//    }
//
//
//    public int getHeight(){
//        return this.getTreeHeight(root);
//    }
//
//    private int getTreeHeight(TreeNode<T> node) {
//        return node == null ? 0 : (1 +
//                Math.max(this.getTreeHeight(node.leftChild),
//                        this.getTreeHeight(node.rightChild)
//                )
//        );
//    }
//
//    public boolean isBalanced(){
//        return this.getIsBalanced(root);
//    }
//
//    private boolean getIsBalanced(TreeNode<T> node) {
//        if(node == null) return true;
//        if(Math.abs(this.getTreeHeight(node.leftChild) -
//                this.getTreeHeight(node.rightChild));
//    }
//
//
//}
