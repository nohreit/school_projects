package Code.Nodes.Lists;

public class LinkedList<E extends Comparable<E>> {
    private ListNode<E> head;
    private int numItems;

    public LinkedList() {
        this.head = null;
        this.numItems = 0;
    }


    public int size() {
        return numItems;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void add(E element) {
        ListNode<E> listNode = new ListNode<>(element);
        if (this.head == null)
            this.head = listNode;
        else {
            ListNode<E> item = this.head;
            while (item.getNext() != null) {
                item = item.getNext();
            }
            item.setNext(listNode);
        }
        this.numItems++;
    }

    public void add(E element, int index) {
        ListNode<E> listNode = new ListNode<>(element);
        if (this.head == null)
            this.head = listNode;
        else {
            if (index == 0) {
                listNode.setNext(this.head);
                this.head = listNode;
            } else if (index > 0 && index <= numItems) {
                ListNode<E> item = this.head;
                for (int i = 0; i < index - 1; i++) {
                    item = item.getNext();
                }
                listNode.setNext(item.getNext());
                item.setNext(listNode);
            }
        }
        numItems++;
    }

    public void addSorted(E element) {
        ListNode<E> newListNode = new ListNode<>(element);

        if (this.head == null) {
            this.head = newListNode;
        } else {
            int i = 0;
            ListNode<E> previous = this.head;
            while (i < this.numItems) {
                if (previous.getNext() == null) {
                    if (newListNode.getData().compareTo(previous.getData()) >= 0) {
                        previous.setNext(newListNode);
                    } else {
                        newListNode.setNext(previous);
                        previous = newListNode;
                    }
                } else {

                    if (this.isBetween(previous, newListNode)) {
                        newListNode.setNext(previous.getNext());
                        previous.setNext(newListNode);
                    } else if (newListNode.getData().compareTo(previous.getData()) < 0) {
                        newListNode.setNext(previous);
                        previous = newListNode;
                    }
                }
                this.head = (i == 0 ? previous : this.head); //Update the head after sorting for the first loop
                previous = previous.getNext();
                i++;
            }
        }
        numItems++;
    }

    public boolean isBetween(ListNode<E> previous, ListNode<E> newListNode) {
        return previous.getData().compareTo(newListNode.getData()) < 0
                && previous.getNext().getData().compareTo(newListNode.getData()) >= 0;
    }

    public E get(int index) {
        ListNode<E> item = this.head;
        E data = null;
        if (index >= 0 && index < this.numItems) {
            for (int i = 0; i < index; i++) {
                item = item.getNext();
            }
            data = item.getData();
        }
        return data;
    }

    public ListNode<E> getNode(int index) {
        ListNode<E> item = this.head;
        if (index >= 0 && index < this.numItems) {
            for (int i = 0; i < index; i++) {
                item = item.getNext();
            }
        }
        return item;
    }

    public int getIndex(E data) {
        ListNode<E> item = this.head;
        int i = 0;
        for (i = 0; i <= this.numItems; i++) {
            if (this.get(i) == data)
                return i;
        }
        return -1;
    }

    public E replace(E element, int index) {
        this.getNode(index).setData(element);
        return this.get(index);
    }

    public boolean remove(int index) {
        if(index == -1) {
            return false;
        }else{
            if(index == 0){
                this.head = this.head.getNext();
            }else{
                this.getNode(index - 1).setNext(this.getNode(index).getNext());
            }
            this.numItems--;
        }
        return this.getNode(index) != null;
    }

    public void removeAll(){
        this.head = null;
        this.numItems = 0;
    }
}
