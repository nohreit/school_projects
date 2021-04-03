package recursive;

public class Recursive {

    public Recursive(){}

    // Examples of recursive methods

    public int factorial(int n){
        if(n < 0) throw new ArithmeticException("Negative value forbidden");
        int result;
        result = (n == 0 || n == 1) ? 1 : n * factorial(n-1);
        return result;
    }
    
    public int fibonacci(int n){
        if(n < 0) throw new ArithmeticException("Negative value forbidden");
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else return fibonacci(n-1)+fibonacci(n-2);
    }

    public int P(int n){
        Driver.pln("Parade");
        if(n == 1) return 2;
        else if(n == 2) return 3;
        else return fibonacci(n);
    }

    public int F(int n){
        Driver.pln("Float ");
        return P(n-1);
    }

    public int B(int n){
        Driver.pln("Band ");
        return F(n-1);
    }
}
