package Mimir.Homework1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver implements DriverInterface {

    public static void main(String[] args) {
        TestTimes linearSearch = new TestTimes();
        TestTimes binarySearch = new TestTimes();
        Driver driver = new Driver();
        int[] arrayNum = driver.getListOfNumbers(); // generate array of 10^7 values

        /*****LINEAR SEARCH*****/
        print("Linear Search\n");
        linearSearch = driver.runLinearSearch(arrayNum, chooseTarget(), 30);
        print("Last 10 test times: ");
        for (long items : linearSearch.getTestTimes()) {
            print(items + " ");
        }
        print("\nLast added test time: " + linearSearch.getLastTestTime());
        print("\nTest time average: " + linearSearch.getAverageTestTime());
        linearSearch.resetTestTimes();
        print("\nReset: ");
        for (long items : linearSearch.getTestTimes()) {
            print(items + " ");
        }

        print("\n\n\n\n");
        /*****BINARY SEARCH*****/
        print("Binary Search\n");
        binarySearch = driver.runBinarySearch(arrayNum, chooseTarget(), 30);
        print("Last 10 test times: ");
        for (long items : binarySearch.getTestTimes()) {
            print(items + " ");
        }
        print("\nLast added test time: " + binarySearch.getLastTestTime());
        print("\nTest time average: " + binarySearch.getAverageTestTime());
        binarySearch.resetTestTimes();
        print("\nReset: ");
        for (long items : binarySearch.getTestTimes()) {
            print(items + " ");
        }

        /*****END****/
    }

    final int SIZE = 10000000;
    int[] array;

    public Driver() {
        this.array = new int[SIZE];
    }

    @Override
    public int[] getListOfNumbers() {
        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;
        return array;
    }

    @Override
    public int[] getTargets() {
        return new int[]{500, 10000, 100000, 1000000, 5000000, 7500000, 10000000};
    }

    @Override
    public TestTimes runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
        LinearSearch linearSearch = new LinearSearch();
        for (int i = 0; i < numberOfTimes; i++) {
            linearSearch.startTime = System.nanoTime();
            linearSearch.search(listOfNumbers, target); // The operation to measure
            linearSearch.endTime = System.nanoTime();
            linearSearch.addTestTime(linearSearch.endTime - linearSearch.startTime);
        }
        return linearSearch;
    }

    @Override
    public TestTimes runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
        BinarySearch binarySearch = new BinarySearch();
        for (int i = 0; i < numberOfTimes; i++) {
            binarySearch.startTime = System.nanoTime();
            binarySearch.search(listOfNumbers, target); // The operation to measure
            binarySearch.endTime = System.nanoTime();
            binarySearch.addTestTime(binarySearch.endTime - binarySearch.startTime);
        }
        return binarySearch;
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    public static int chooseTarget() {
        Scanner pick = new Scanner(System.in);
        int i;
        int val = 0;
        print("Choose your target:\n" +
                "1. 500\n" +
                "2. 10,000\n" +
                "3. 100,000\n" +
                "4. 1,000,000\n" +
                "5. 5,000,000\n" +
                "6. 7,500,000\n" +
                "7. 10,000,000\n" +
                "Or enter -1 to quit\n");

        try {
            i = pick.nextInt();
            switch (i) {
                case 1:
                    val = 0;
                    break;
                case 2:
                    val = 1;
                    break;
                case 3:
                    val = 2;
                    break;
                case 4:
                    val = 3;
                    break;
                case 5:
                    val = 4;
                    break;
                case 6:
                    val = 5;
                    break;
                case 7:
                    val = 6;
                    break;
                case -1:
                    print("Goodbye...");
                    System.exit(0);
                    break;
                default:
                    print("Wrong... Try again\n");
                    chooseTarget();
                    break;
            }
        } catch (InputMismatchException e) {
            print("Wrong... Try again\n");
            chooseTarget();
        }
        return val;
    }
}
