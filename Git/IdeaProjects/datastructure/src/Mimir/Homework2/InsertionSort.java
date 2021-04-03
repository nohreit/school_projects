package Mimir.Homework2;

public class InsertionSort extends TestTimes implements SortInterface {
    public InsertionSort() {
        super();
    }

    @Override
    public void sort(Integer[] arrayToSort) {
        this.startTime = System.nanoTime();
        insertionSort(arrayToSort);
        this.endTime = System.nanoTime();
        this.addTestTime(this.endTime - this.startTime);
    }

    /**
     * @param arr shifts and inserts to sort
     *            O(n^2)
     */
    public static void insertionSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int loc = i; //arbitrary location
            int elementToInsert = arr[i];
            while (loc > 0 && arr[loc - 1] > elementToInsert) {
                arr[loc] = arr[loc - 1]; //shift all necessary elements
                loc--;
            }
            arr[loc] = elementToInsert;//insert the element into the correct spot
        }
    }
}
