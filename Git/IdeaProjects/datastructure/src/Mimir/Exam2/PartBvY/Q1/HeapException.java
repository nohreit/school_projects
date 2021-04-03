package Mimir.Exam2.PartBvY.Q1;

public class HeapException extends Exception {

    public HeapException(){
        super("Heap Exception: ");
    }

    public HeapException(String message){
        super("Heap Exception: " + message);
    }
}