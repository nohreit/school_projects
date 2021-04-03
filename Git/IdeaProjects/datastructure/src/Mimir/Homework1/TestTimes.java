package Mimir.Homework1;

import java.util.Arrays;

public class TestTimes implements TestTimesInterface {

    long[] arrayTestTimes;
    long startTime, endTime;
    int counter;

    public TestTimes() {
        this.arrayTestTimes = new long[10];
        this.startTime = 0;
        this.endTime = 0;
        this.counter = 0;
    }

    @Override
    public long getLastTestTime() {
        if (counter > 0 && counter < 10) {
            return arrayTestTimes[counter - 1];
        }
        return counter >= 10 ? arrayTestTimes[arrayTestTimes.length - 1] : 0;
    }

    @Override
    public long[] getTestTimes() {
        return arrayTestTimes;
    }

    @Override
    public void resetTestTimes() {
        Arrays.fill(arrayTestTimes, 0);
    }

    @Override
    public void addTestTime(long testTime) {
        if (counter < 10) {
            arrayTestTimes[counter] = testTime;
        } else { // if counter > arrayTestTimes.length
            for (int i = 0; i < arrayTestTimes.length - 1; i++) {
                arrayTestTimes[i] = arrayTestTimes[i + 1]; // shift each elements by -1 rank and ...
            }
            arrayTestTimes[arrayTestTimes.length - 1] = testTime; // ... add latest test time at the last index.
        }
        counter++;
    }

    @Override
    public double getAverageTestTime() {
        double sum = 0;
        for (int i = 0; i < arrayTestTimes.length; i++)
            sum += arrayTestTimes[i];
        return sum / arrayTestTimes.length;
    }
}
