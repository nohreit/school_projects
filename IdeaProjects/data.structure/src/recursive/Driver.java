package recursive;

import java.util.Scanner;

public class Driver {
    public static void main(String [] args){
        Driver driver = new Driver();
        driver.execute();
    }

    public Driver(){}

    private void execute() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Recursive recursive = new Recursive();
        pln(n+"! = "+recursive.factorial(n));
        p("Sequence of Fibonacci("+ n +"): ");
        pln(recursive.fibonacci(n));
        pln(recursive.B(n));
        pln(recursive.P(2));
        
    }

    public static void pln(Object o){ System.out.println(o);}

    public static void p(Object o){ System.out.print(o);}


}
