//package Mimir.Homework3;
//
//public class SortingType <I extends Comparable<I>>{
//    /**
//     * MergeSort  - divide and conquer
//     *
//     * @param arr Worst Case Time Complexity O(nlogn)
//     *            Space Complexity O(n)  because of additonal array storage
//     *            Uses 2 iterative helper methods
//     */
//    public void mergeSort(I[] arr) {
//        if (arr.length > 1) {
//            int halfLen = arr.length / 2;
//            I[] leftArr = new I[halfLen];
//            Comparable[] rightArr = new Comparable[arr.length - halfLen];
//            divide(arr, leftArr, rightArr);//split big into two halves copying the values
//            mergeSort(leftArr);
//            mergeSort(rightArr);
//            merge(arr, leftArr, rightArr);//compare and merge back into big array
//        }
//
//    }
//
//
//    private static void merge(Comparable[] arr, Comparable[] leftArr, Comparable[] rightArr) {
//        int bigI = 0;
//        int leftI = 0;
//        int rightI = 0;
//        while (leftI < leftArr.length && rightI < rightArr.length) {
//            if (leftArr[leftI].compareTo(rightArr[rightI]) < 0) {
//                arr[bigI] = leftArr[leftI];
//                leftI++;
//            } else {
//                arr[bigI] = rightArr[rightI];
//                rightI++;
//            }
//            bigI++;
//        }
//        while (leftI < leftArr.length) {
//            arr[bigI] = leftArr[leftI];
//            leftI++;
//            bigI++;
//        }
//        while (rightI < rightArr.length) {
//            arr[bigI] = rightArr[rightI];
//            rightI++;
//            bigI++;
//        }
//
//
//    }
//
//    private static void divide(Comparable[] arr, Comparable[] leftArr, Comparable[] rightArr) {
//        for (int i = 0; i < leftArr.length; i++) {
//            leftArr[i] = arr[i];
//        }
//        for (int i = 0; i < rightArr.length; i++) {
//            rightArr[i] = arr[i + leftArr.length];//copying remaining values after midpoint
//        }
//    }
//

//    /**
//     * @param arr shifts and inserts to sort
//     *            O(n^2)
//     */
//    public static void insertionSort(Comparable[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            int loc = i; //arbitrary location
//            int elementToInsert = arr[i];
//            while (loc > 0 && arr[loc - 1] > elementToInsert) {
//                arr[loc] = arr[loc - 1]; //shift all necessary elements
//                loc--;
//            }
//            arr[loc] = elementToInsert;//insert the element into the correct spot
//        }
//    }
//
//
//    /**
//     * @param arr compares side by side and swaps to sort
//     *            O(n^2)
//     */
//    public static void bubbleSort(Comparable[] arr) {
//        boolean notSorted = true;
//        while (notSorted) {
//            notSorted = false; //we will set to true if we have to swap
//            for (int i = 0; i < arr.length - 1; i++) {
//                int j = i + 1;
//                if (arr[i] > arr[j]) {  //arr[i].compareTo(arr[j]) > 0
//                    swap(i, j, arr);
//                    notSorted = true; //set our flag to true so we re-enter the loop and compare
//                }
//            }
//        }
//    }
//
//
//    /**
//     * @param arr finds min repeatedly and swaps to sort
//     *            O(n^2)
//     */
//    public static void selectionSort(Comparable[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minI = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minI]) {
//                    minI = j; //new minIndex
//                }
//            }
//            swap(i, minI, arr);
//
//        }
//    }
//
//    private static void swap(int i, int j, Comparable[] arr) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }


//}
