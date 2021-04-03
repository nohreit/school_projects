package Mimir.Homework3;

import java.util.Arrays;

public class ArrayBasedList<I extends Comparable<I>> implements ListInterface <I> {

    private Object[] items; //starts out empty
    private int numItems;//tracks num of items as well as next index to store

    public ArrayBasedList(int size) {
        items = new Object[size];
        numItems = 0;
    }

    @Override
    public boolean isEmpty() {
        return (numItems == 0);
    }


    @Override
    public void add(I element) {
        if (numItems >= items.length)
            Driver.println("Cannot add " + element.toString() + ". The list is full!");
        else
            items[numItems++] = element;
    }

    @Override
    public boolean add(I element, int index) {
        if (index < 0) {
            Driver.println("invalid index cannot add " + element.toString());
        } else if (numItems >= items.length) {
            Driver.println("NO MORE ROOM cannot add " + element.toString());
        } else if (index >= numItems) {//index specified is at the end or further but that's ok we append
            items[numItems++] = element;
        } else {//here we have index >=0  && index < numItems
//            for (int i = numItems; i > index; i--) {//be careful.. index 0, therefore i>index because of the i-1 in the loop
//                items[i] = items[i - 1];
//            }
            System.arraycopy(items, index, items, index + 1, numItems - index);
            items[index] = element;
        }

        return get(index) != null;
    }

    @Override
    public void addSorted(I element) {
        this.add(element);
        Arrays.sort(items);
    }

    @SuppressWarnings("unchecked")
    public I get(int index) {
        return (index >= 0 && index < numItems) ? (I) items[index] : null;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public I replace(I element, int index) {
        items[index] = element;
        return (items[index] == element) ? get(index) : null;
    }

    @Override
    public boolean remove(int index) {
        if (index >= 0 && index < numItems) {
//            for (int position = index; position < numItems - 1; position++) {
//                items[position] = items[position + 1];
//            }
            if (numItems - 1 - index >= 0) System.arraycopy(items, index + 1, items, index,
                    numItems - 1 - index);
            numItems--;
        }
        return items[index] == null;
    }

    @Override
    public void removeAll() {
        items = new Object[items.length];
        numItems = 0;
    }
}
