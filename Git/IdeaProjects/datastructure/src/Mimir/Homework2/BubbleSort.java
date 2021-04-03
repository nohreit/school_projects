package Mimir.Homework2;

public class BubbleSort extends TestTimes implements SortInterface {
    public BubbleSort() {
        super();
    }

    @Override
    public void sort(Integer[] arrayToSort) {
        this.startTime = System.nanoTime();
        bubbleSort(arrayToSort);
        this.endTime = System.nanoTime();
        this.addTestTime(this.endTime - this.startTime);
    }

    /**
     * @param arr compares side by side and swaps to sort
     *            O(n^2)
     */
    public static void bubbleSort(Integer[] arr) {
        boolean notSorted = true;
        while (notSorted) {
            notSorted = false; //we will set to true if we have to swap
            for (int i = 0; i < arr.length - 1; i++) {
                int j = i + 1;
                if (arr[i] > arr[j]) { //arr[i].compareTo(arr[j]) > 0
                    Driver.swap(i, j, arr);
                    notSorted = true; //set our flag to true so we re-enter the loop and compare
                }
            }
        }
    }
}
