package Mimir.Homework4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayBasedQueue<E> implements QueueInterface<E> {
    private Object[] arr;
    private int numItems;

    public ArrayBasedQueue() {
        int MAX = 10000;
        this.arr = new Object[MAX];
        this.numItems = 0;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int size() {
        return this.numItems;
    }

    @Override
    public void enqueue(E e) throws IllegalStateException, NullPointerException {
        if (e != null) arr[numItems++] = e;
        else if (size() == arr.length) throw new IllegalStateException("Array is full");
        else throw new NullPointerException("Null value forbidden");
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) return null;
        return (E) this.arr[0];
    }

    @Override
    public E dequeue() {
        E item = null;
        if (!isEmpty()) {
            item = peek();
            if (!isEmpty() && numItems < arr.length) System.arraycopy(arr, 1, arr, 0, numItems);
            arr[numItems - 1] = null;
        }
        numItems--;
        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E dequeue(int index) throws NoSuchElementException {
        if (index >= 0 && index < numItems) {
            E item = (E) arr[index];
            if (!isEmpty()) {
                if (numItems - index >= 0) System.arraycopy(arr, index + 1,
                        arr, index, numItems - index);
                arr[numItems - 1] = null;
            }
            numItems--;
            return item;
        } else throw new NoSuchElementException("No such element in the set");
    }

    @Override
    public void removeAll() {
        arr = new Object[10];
        numItems = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<E> iterator() {
        return new ElementIterator<>((List<E>) Arrays.asList(arr));
    }
}
