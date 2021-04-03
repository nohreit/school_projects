package Mimir.Homework1;

public class BinarySearch extends TestTimes implements SearchInterface {

    public BinarySearch() {
        super();
    }

    @Override
    public int search(int[] listOfNumbers, int target) {
        int midpt = listOfNumbers.length / 2; // take the index in the middle of the array

        for (int i = midpt; i > -1; i--) { // search the target from the middle to 0
            if (listOfNumbers[i] == target)
                return i;
        }
        for (int i = midpt; i < listOfNumbers.length; i++) { // search the target from the middle to array.length
            if (listOfNumbers[i] == target)
                return i;
        }
        return -1;
    }
}
