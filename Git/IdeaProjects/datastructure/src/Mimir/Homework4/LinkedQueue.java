package Mimir.Homework4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements QueueInterface<E> {
    final int maxQueue = 10000;
    private Node<E> head;
    private int numItems;

    public LinkedQueue() {
        this.head = null;
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
    public void enqueue(E e) throws IllegalStateException, NullPointerException {
        Node<E> data = new Node<>(e);
        if (e == null) throw new NullPointerException("Null value forbidden");
        else if (size() > maxQueue) throw new IllegalStateException("The queue is full!!");

        if (isEmpty()) this.head = data;
        else {
            Node<E> item = this.head;
            while (item.getNext() != null) {
                item = item.getNext();
            }
            item.setNext(data);
            data.setPrevious(item);
        }
        this.numItems++;
    }

    @Override
    public E peek() {
        return this.head.getData();
    }

    @Override
    public E dequeue() {
        E item = peek();
        if (!isEmpty()) {
            this.head = this.head.getNext();
        }
        numItems--;
        return item;
    }

    @Override
    public E dequeue(int index) throws NoSuchElementException {
        if (index == 0) {
            E item = peek();
            dequeue();
            return item;
        } else if (index >= 0 && index < size()) {
            Node<E> item = this.head;
            int i = 0;
            if (!isEmpty()) {
                while (item.getNext() != null && i++ != index) {
                    item = item.getNext();
                }
                item.getPrevious().setNext(item.getNext());
            }
            numItems--;
            return item.getData();
        } else throw new NoSuchElementException("No such element in the set");
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
    public void removeAll() {
        this.head = null;
        this.numItems = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator<>(this.asList(this.head));
    }
}
