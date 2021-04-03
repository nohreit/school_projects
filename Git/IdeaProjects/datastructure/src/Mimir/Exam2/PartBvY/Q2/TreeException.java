package Mimir.Exam2.PartBvY.Q2;

public class TreeException extends RuntimeException {

    public TreeException() {
        super("Tree Exception: ");
    }

    public TreeException(String message) {
        super("Tree Exception: " + message);
    }
}
