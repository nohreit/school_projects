package Course.AlgebraicExpressions;

import java.util.Stack;

public abstract class AlgebraicExpressions {

    public static void main(String [] args){

        System.out.println(toPrefix("5+3"));
//        System.out.println(toPostfix("5*3"));
    }

    public static int toPostfix(String s){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(isOperand(ch)) {
                stack.push(Character.getNumericValue(ch));
            }else{
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                result = getResult(operand1, ch, operand2);
                stack.push(result);
            }
        }
        return result;
    }

    public static int toPrefix(String s){
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = s.length()-1; i >= 0; i--){
            char ch = s.charAt(i);
            if(isOperand(ch)) {
                stack.push(Character.getNumericValue(ch));
            }else{
                int operand1 = stack.pop(); // It seems that stack is empty.
                int operand2 = stack.pop();
                result = getResult(operand1, ch, operand2);
                stack.push(result);
            }
        }
        return result;
    }

    private static int getResult(int operand1, char operator, int operand2) {
        int result = 0;

        switch (operator){
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
        }
        return result;
    }

    private static boolean isOperand(char ch) {
        return Character.isDigit(ch);
    }

}
