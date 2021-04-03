package Mimir.Exam2.PartBvY.Q1;

import java.util.Arrays;
import java.util.Scanner;
public class Driver{

    public static void main(String [] args){
        try {

            Scanner kb = new Scanner(System.in);
            String [] nums1  = kb.nextLine().split(", ");
            Heap<Integer> h = new Heap<Integer>();
            for (String s : nums1) {
                h.insert(Integer.parseInt(s));
                h.displayNumComparisonsAndNumSwaps();
            }
            System.out.println("\n---HEAP's ARRAY CONTENT---");
            h.displayContent();
            System.out.print(Arrays.toString(h.getThreeLargest()));
        } catch (HeapException e) {
            e.printStackTrace();
        }
    }
}