package Mimir.Exam2.PartBvY.Q1;

import java.util.ArrayList;

interface StepCounter<T> {
    void resetNumComparisons();
    void resetNumSwaps();
    void resetAllCounters();
    int getNumComparisons();
    int getNumSwaps();
    void incrementNumComparisons();
    void incrementNumSwaps();
    void displayNumComparisonsAndNumSwaps();
}
