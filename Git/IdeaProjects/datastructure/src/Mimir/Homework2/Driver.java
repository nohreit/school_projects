package Mimir.Homework2;

import java.util.Arrays;
import java.util.Random;

public class Driver implements DriverInterface {
    public static void main(String[] args) {

        Driver driver = new Driver();

        print("**********ONE THOUSAND**********\n");
        for (int arrayTypes = 0; arrayTypes < 5; arrayTypes++) { // For all 5 types of array
            print("ArrayTypes = " + arrayTypes + "\n");
            for (int sortTypes = 0; sortTypes < 3; sortTypes++) { // For all 3 types of sort
                print("SortTypes = " + sortTypes + "\n");
                driver.runSort(chooseSortType(sortTypes), chooseArrayType(arrayTypes), 1000, 10);
            }
        }

        print("\n\n**********TEN THOUSAND**********\n");
        for (int arrayTypes = 0; arrayTypes < 5; arrayTypes++) { // For all 5 types of array
            print("ArrayTypes = " + arrayTypes + "\n");
            for (int sortTypes = 0; sortTypes < 3; sortTypes++) { // For all 3 types of sort
                print("SortTypes = " + sortTypes + "\n");
                driver.runSort(chooseSortType(sortTypes), chooseArrayType(arrayTypes), 10000, 10);
            }
        }

        print("**********END**********\n");

    }

    public Driver() {
    }

    @Override
    public Integer[] createArray(ArrayType arrayType, int arraySize) {
        Integer[] array = new Integer[arraySize];
        switch (arrayType) {
            case Equal:
                Arrays.fill(array, 0);
                break;
            case Random:
                for (int i = 0; i < arraySize; i++)
                    array[i] = new Random().nextInt(); // Generate a random integer value
                break;
            case Increasing:
                for (int i = 0; i < arraySize; i++)
                    array[i] = i;
                break;
            case Decreasing:
                for (int i = 0; i < arraySize; i++)
                    array[i] = arraySize - i;
                break;
            case IncreasingAndRandom:
                for (int i = 0; i < arraySize; i++)
                    array[i] = new Random().nextInt();
                new BubbleSort().sort(array);
                break;
        }
        return array;
    }

    @Override
    public TestTimes runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes) {
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();
        TestTimes testTimes = new TestTimes();

        switch (sortType) {
            case BubbleSort:
                print("**********BUBBLE SORT**********\n");
                for (int i = 0; i < numberOfTimes; i++) { // For each type of sort in each type of array, run 10 times
                    testTimes.startTime = System.nanoTime();
                    bubbleSort.sort(new Driver().createArray(arrayType, arraySize));
                    testTimes.endTime = System.nanoTime();
                    testTimes.addTestTime(testTimes.endTime - testTimes.startTime);
                }
                break;
            case InsertionSort:
                print("**********INSERTION SORT**********\n");
                for (int i = 0; i < numberOfTimes; i++) {
                    testTimes.startTime = System.nanoTime();
                    insertionSort.sort(new Driver().createArray(arrayType, arraySize));
                    testTimes.endTime = System.nanoTime();
                    testTimes.addTestTime(testTimes.endTime - testTimes.startTime);
                }
                break;
            case SelectionSort:
                print("**********SELECTION SORT**********\n");
                for (int i = 0; i < numberOfTimes; i++) {
                    testTimes.startTime = System.nanoTime();
                    selectionSort.sort(new Driver().createArray(arrayType, arraySize));
                    testTimes.endTime = System.nanoTime();
                    testTimes.addTestTime(testTimes.endTime - testTimes.startTime);
                }
                break;
        }

        return testTimes;
    }

    public static void swap(int i, int j, Integer[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    public static ArrayType chooseArrayType(int pickType) {
        ArrayType arrayType = null;
        switch (pickType) {
            case 0:
                arrayType = ArrayType.Equal;
                break;
            case 1:
                arrayType = ArrayType.Random;
                break;
            case 2:
                arrayType = ArrayType.Increasing;
                break;
            case 3:
                arrayType = ArrayType.Decreasing;
                break;
            case 4:
                arrayType = ArrayType.IncreasingAndRandom;
                break;
        }
        return arrayType;
    }

    public static SortType chooseSortType(int pickType) {
        SortType sortType = null;
        switch (pickType) {
            case 0:
                sortType = SortType.BubbleSort;
                break;
            case 1:
                sortType = SortType.InsertionSort;
                break;
            case 2:
                sortType = SortType.SelectionSort;
                break;
        }
        return sortType;
    }
}
