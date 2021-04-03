//package Mimir.Homework4;

import java.util.*;

public class ArrayBasedStack<E> implements StackInterface<E> {
    private Object[] arr;
    private int numItems;

    public ArrayBasedStack(){
        final int MAX = 10000;
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
    public void push(E e) throws IllegalStateException, NullPointerException {
        if(e != null) arr[numItems++] = e;
        else if (size() == arr.length) throw new IllegalStateException("Array is full");
        else throw new NullPointerException("Null value forbidden");
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if(isEmpty()) return null;
        return (E) this.arr[this.size()-1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        E item = (E) arr[this.size()-1];
        arr[this.size()-1] = null;
        this.numItems--;
        return item;
    }

    @Override
    public void clear() {
        arr = new Object[10];
        numItems = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<E> iterator() {
        return new ElementIterator<>((List<E>) Arrays.asList(arr));
    }
}
