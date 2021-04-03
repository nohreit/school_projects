package Mimir.Homework2;

public class SelectionSort extends TestTimes implements SortInterface {
    public SelectionSort() {
        super();
    }

    @Override
    public void sort(Integer[] arrayToSort) {
        this.startTime = System.nanoTime();
        selectionSort(arrayToSort);
        this.endTime = System.nanoTime();
        this.addTestTime(this.endTime - this.startTime);
    }

    /**
     * @param arr finds min repeatedly and swaps to sort
     *            O(n^2)
     */
    public static void selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minI]) {
                    minI = j; //new minIndex
                }
            }
            Driver.swap(i, minI, arr);

        }
    }
}
