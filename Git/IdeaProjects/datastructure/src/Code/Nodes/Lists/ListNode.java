package Code.Nodes.Lists;

public class ListNode<I>{
    private I data;
    private ListNode<I> next;

    public ListNode(I data){
        this.data = data;
        this.next = null;
    }

    public ListNode(I data, ListNode<I> next){
        this.data = data;
        this.next = next;
    }

    public I getData() {
        return data;
    }

    public void setData(I data) {
        this.data = data;
    }

    public ListNode<I> getNext() {
        return next;
    }

    public void setNext(ListNode<I> next) {
        this.next = next;
    }
}
