package Mimir.Homework3;

public class Node<I>{
    private I data;
    private Node<I> next;

    public Node(I data){
        this.data = data;
        this.next = null;
    }

    public Node(I data, Node<I> next){
        this.data = data;
        this.next = next;
    }

    public I getData() {
        return data;
    }

    public void setData(I data) {
        this.data = data;
    }

    public Node<I> getNext() {
        return next;
    }

    public void setNext(Node<I> next) {
        this.next = next;
    }
}
