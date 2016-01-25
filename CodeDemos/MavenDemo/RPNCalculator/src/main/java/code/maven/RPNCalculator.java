package code.maven;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by anayonkar on 25/1/16.
 */
public class RPNCalculator {
    private final Stack<Integer> stack = new Stack<>();
    private int firstNumber;
    private int secondNumber;

    public RPNCalculator() {
    }
    public int evaluate(String arg) {
        //return 0;
        //return 15;
        StringTokenizer st = new StringTokenizer(arg);
        while(st.hasMoreTokens()) {
            //System.out.println("Token is: " + st.nextToken());
            String token = st.nextToken();
            System.out.println("Token is: " + token);
            //if(token.equals("+")) {
            if(isOperator(token)) {
                //firstNumber = stack.pop();
                //secondNumber = stack.pop();
                //result = firstNumber + secondNumber;
                //stack.push(result);
                int result = handleOperation(stack.pop(), stack.pop(), token);
                System.out.println("Result is : " + result);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        //return 15;
        return stack.pop();
    }
    private boolean isOperator(String arg) {
        switch(arg) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                return false;
        }
    }
    private int handleOperation(int firstNumber, int secondNumber, String operator) {
        switch(operator) {
            case "+":
                return secondNumber + firstNumber;
            case "-":
                return secondNumber - firstNumber;
            case "*":
                return secondNumber * firstNumber;
            case "/":
                return secondNumber / firstNumber;
            default:
                throw new RuntimeException("Invalid operator" + operator);
        }
    }
    public static void main(String[] args) {
        RPNCalculator rpnCalculator = new RPNCalculator();
        rpnCalculator.evaluate("1  2  +");
    }
}
