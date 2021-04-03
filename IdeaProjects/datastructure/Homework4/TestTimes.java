//package Mimir.Homework4;

import java.util.Arrays;

public class TestTimes implements TestTimesInterface {

    protected double[] arrayTestTimes;
    protected double[] arrayMemoryUsage;
    protected double startTime, endTime;
    protected int counter;
    protected TimeUnits timeUnits;
    protected MemoryUnits memoryUnits;
    protected Runtime runtime;
//    protected double memoryUsage;

    public TestTimes() {
        this.arrayTestTimes = new double[10];
        this.arrayMemoryUsage = new double[10];
        this.startTime = 0;
        this.endTime = 0;
        this.counter = 0;
        this.timeUnits = TimeUnits.NanoSeconds;
        this.memoryUnits = MemoryUnits.Bytes;
        this.runtime = Runtime.getRuntime();
//        this.memoryUsage = this.runtime.totalMemory() - this.runtime.freeMemory();
    }

    @Override
    public TimeUnits getTimeUnits() {
        return this.timeUnits;
    }

    @Override
    public void setTimeUnits(TimeUnits timeUnits) {
        this.timeUnits = timeUnits;
    }

    @Override
    public MemoryUnits getMemoryUnits() {
        return this.memoryUnits;
    }

    @Override
    public void setMemoryUnits(MemoryUnits memoryUnits) {
        this.memoryUnits = memoryUnits;
    }

    @Override
    public double getLastTestTime() {
        if (counter > 0 && counter < 10) {
            return arrayTestTimes[counter - 1];
        }
        return counter >= 10 ? arrayTestTimes[arrayTestTimes.length - 1] : 0;
    }

    @Override
    public double getLastMemoryUsage() {
        if (counter > 0 && counter < 10) {
            return arrayMemoryUsage[counter - 1];
        }
        return counter >= 10 ? arrayMemoryUsage[arrayMemoryUsage.length - 1] : 0;
    }

    @Override
    public double[] getTestTimes() {
        return arrayTestTimes;
    }

    @Override
    public double[] getMemoryUsages() {
        return arrayMemoryUsage;
    }

    @Override
    public void resetTestTimes() {
        Arrays.fill(arrayTestTimes, 0);
    }

    @Override
    public void addTestTime(long runTime) {
        if (counter < 10) {
            arrayTestTimes[counter] = runTime;
            arrayMemoryUsage[counter] = runtime.totalMemory() - runtime.freeMemory();
        } else {
            if (arrayTestTimes.length - 1 >= 0) {
                System.arraycopy(arrayTestTimes, 1, arrayTestTimes,
                        0, arrayTestTimes.length - 1);
                System.arraycopy(arrayMemoryUsage, 1, arrayMemoryUsage,
                        0, arrayMemoryUsage.length - 1);
            }
            arrayTestTimes[arrayTestTimes.length - 1] = runTime;
            arrayMemoryUsage[arrayMemoryUsage.length -1] = runtime.totalMemory() - runtime.freeMemory();
        }
        counter++;
    }

    @Override
    public double getAverageTestTime() {
        double sum = 0;
        for (double arrayTestTime : arrayTestTimes) sum += arrayTestTime;
        return sum / arrayTestTimes.length;
    }

    @Override
    public double getAverageMemoryUsage() {
        double sum = 0;
        for (double memoryUsage : arrayMemoryUsage) sum += memoryUsage;
        return sum / arrayMemoryUsage.length;
    }
}
