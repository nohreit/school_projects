package Mimir.Homework4;

import java.util.Iterator;
import java.util.List;

public class ElementIterator<E> implements Iterator<E> {
    int cursor;
    List<E> list;

    public ElementIterator(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.size() >= cursor + 1;
    }

    @Override
    public E next() {
        E e = list.get(cursor);
        cursor++;
        return e;
    }
}
