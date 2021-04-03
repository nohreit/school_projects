package Mimir.Homework4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedStack<E> implements StackInterface<E> {
    final int maxQueue = 10000;
    private Node<E> bottom;
    private int numItems;

    public LinkedStack() {
        this.bottom = null;
        this.numItems = 0;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public void push(E e) throws IllegalStateException, NullPointerException {
        Node<E> data = new Node<>(e);
        if (e == null) throw new NullPointerException("Null value forbidden");
        else if (size() > maxQueue) throw new IllegalStateException("The queue is full!!");

        if (isEmpty()) this.bottom = data;
        else {
            Node<E> item = this.bottom;
            while (item.getNext() != null) {
                item = item.getNext();
            }
            item.setNext(data);
            data.setPrevious(item);
            this.bottom.setPrevious(data);
        }
        this.numItems++;
    }

    @Override
    public E peek() {
        return this.bottom.getPrevious().getData();
    }

    @Override
    public E pop() {
        E item = peek();
        if (!isEmpty()) {
            this.bottom.setPrevious(this.bottom.getPrevious().getPrevious());
            this.bottom.getPrevious().setNext(this.bottom);
        }
        numItems--;
        return item;
    }

    @Override
    public void clear() {
        this.bottom = null;
        this.numItems = 0;
    }

    private List<E> asList(Node<E> node) {
        List<E> list = new LinkedList<>();
        while (node != null) {
            list.add(node.getData());
            node = node.getNext();
        }
        return list;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator<>(this.asList(this.bottom));
    }
}
