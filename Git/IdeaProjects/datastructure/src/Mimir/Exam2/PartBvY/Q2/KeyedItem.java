package Mimir.Exam2.PartBvY.Q2;

public abstract class KeyedItem<KT extends Comparable<? super KT>> {
    private final KT searchKey;

    public KeyedItem(KT key) {
        searchKey = key;
    }

    public KT getKey() {
        return searchKey;
    }

}
