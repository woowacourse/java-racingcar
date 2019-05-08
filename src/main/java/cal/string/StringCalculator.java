package cal.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {
    final static int PLUS = 0;
    final static int MINUS = 1;
    final static int DIV = 2;
    final static int MUL = 3;


    public String[] stringParser() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
//        String value = inputString;
        return value.split(" ");
    }

    public int calculate(String inputString) {
        String[] parsedStrings =  inputString.split(" ");
//        return recursiveCalculate(Arrays.asList(parsedStrings));
          return arrayCalculate(parsedStrings);
    }

    public int operator(String operatorInput) {
        if(operatorInput.equals("+")){
            return PLUS;
        }

        if(operatorInput.equals("-")){
            return MINUS;
        }

        if(operatorInput.equals("/")){
            return DIV;
        }

        if(operatorInput.equals("*")){
            return MUL;
        }
        throw new IllegalArgumentException();
    }

    public int minCalculate(int a, int b, int op) {
        if (op == PLUS) {
            return a + b;
        }

        if (op == MINUS) {
            return a - b;
        }

        if (op == DIV) {
            return a / b;
        }

        if (op == MUL) {
            return a * b;
        }
        throw new IllegalArgumentException();
    }

    public int arrayCalculate(String[] parsedStrings){
        int result, op;
        op = operator(parsedStrings[1]);
        result = Integer.parseInt(parsedStrings[0]);

        for (int i=1; i<parsedStrings.length; i+=2) {
//            if (i % 2 == 1) {
//
//            }
//            if (i % 2 == 0) {
//                result = minCalculate(result, Integer.parseInt(parsedStrings[i]), op);
//            }
            op = operator(parsedStrings[i]);
            result = minCalculate(result, Integer.parseInt(parsedStrings[i+1]), op);
        }
        return result;
    }



    public int recursiveCalculate(List<String> parsedStrings) {
        int size = parsedStrings.size();
        if (size == 1) {
            return Integer.parseInt(parsedStrings.get(0));
        }
        int leftOperand = recursiveCalculate(parsedStrings.subList(0, size - 2));
        int rightOperand = Integer.parseInt(parsedStrings.get(size - 1));
        int op = operator(parsedStrings.get(size - 2));

        return minCalculate(leftOperand, rightOperand, op);
    }



    public static void main(String[] args) {

    }

}
