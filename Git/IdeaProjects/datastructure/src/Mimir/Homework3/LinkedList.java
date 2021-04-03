package Mimir.Homework3;

public class LinkedList<I extends Comparable<I>> implements ListInterface<I> {
    private Node<I> head;
    private int numItems;

    public LinkedList() {
        this.head = null;
        this.numItems = 0;
    }

    @Override
    public int size() {
        return this.numItems;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void add(I element) {
        Node<I> node = new Node<>(element);
        if (this.head == null)
            this.head = node;
        else {
            Node<I> item = this.head;
            while (item.getNext() != null) {
                item = item.getNext();
            }
            item.setNext(node);
        }
        this.numItems++;
    }

    @Override
    public boolean add(I element, int index) {
        Node<I> node = new Node<>(element);
        if (this.head == null)
            this.head = node;
        else {
            if (index == 0) {
                node.setNext(this.head);
                this.head = node;
            } else if (index > 0 && index <= numItems) {
                Node<I> item = this.head;
                for (int i = 0; i < index - 1; i++) {
                    item = item.getNext();
                }
                node.setNext(item.getNext());
                item.setNext(node);
            }
        }
        numItems++;

        return this.get(index) == element;
    }

    @Override
    public void addSorted(I element) {
        Node<I> newNode = new Node<>(element);

        if (this.head == null) {
            this.head = newNode;
        } else {
            int i = 0;
            Node<I> previous = this.head;
            while (i < this.numItems) {
                if (previous.getNext() == null) {
                    if (newNode.getData().compareTo(previous.getData()) >= 0) {
                        previous.setNext(newNode);
                    } else {
                        newNode.setNext(previous);
                        previous = newNode;
                    }
                } else {

                    if (this.isBetween(previous, newNode)) {
                        newNode.setNext(previous.getNext());
                        previous.setNext(newNode);
                    } else if (newNode.getData().compareTo(previous.getData()) < 0) {
                        newNode.setNext(previous);
                        previous = newNode;
                    }
                }
                this.head = (i == 0 ? previous : this.head); //Update the head after sorting for the first loop
                previous = previous.getNext();
                i++;
            }
        }
        numItems++;
    }

    private boolean isBetween(Node<I> previous, Node<I> newNode) {
        return previous.getData().compareTo(newNode.getData()) < 0
                && previous.getNext().getData().compareTo(newNode.getData()) >= 0;
    }

    @Override
    public I get(int index) {
        Node<I> item = this.head;
        I data = null;
        if (index >= 0 && index < this.numItems) {
            for (int i = 0; i < index; i++) {
                item = item.getNext();
            }
            data = item.getData();
        }
        return data;
    }

    private Node<I> getNode(int index) {
        Node<I> item = this.head;
        if (index >= 0 && index < this.numItems) {
            for (int i = 0; i < index; i++) {
                item = item.getNext();
            }
        }
        return item;
    }

//    private int getIndex(I data) {
//        ListNode<I> item = this.head;
//        int i = 0;
//        for (i = 0; i <= this.numItems; i++) {
//            if (this.get(i) == data)
//                return i;
//        }
//        return -1;
//    }

    @Override
    public I replace(I element, int index) {
        this.getNode(index).setData(element);
        return this.get(index);
    }

    @Override
    public boolean remove(int index) {
        if (index == -1) {
            return false;
        } else {
            if (index == 0) {
                this.head = this.head.getNext();
            } else {
                this.getNode(index - 1).setNext(this.getNode(index).getNext());
            }
            this.numItems--;
        }
        return this.getNode(index) != null;
    }

    @Override
    public void removeAll() {
        this.head = null;
        this.numItems = 0;
    }
}