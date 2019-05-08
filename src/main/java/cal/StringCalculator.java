package cal;

import java.util.Scanner;

public class StringCalculator {
    String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    String[] splitStringBySpace(String inputString) {
        return inputString.split(" ");
    }

    int matchCalculate(int i, String oper, int j) {
        Calculator cal = new Calculator();

        if (oper.equals("+")) {
            return cal.plus(i, j);
        }
        if (oper.equals("-")) {
            return cal.minus(i, j);
        }
        if (oper.equals("*")) {
            return cal.multiply(i, j);
        }
        if (oper.equals("/")) {
            return cal.divide(i, j);
        }

        throw new IllegalArgumentException();
    }

    int calculate (String[] input) {
        int result = Integer.parseInt(input[0]);

        for(int i = 1; i < input.length; i = i + 2){
            result = matchCalculate(result, input[i], Integer.parseInt(input[i + 1]));
        }

        return result;
    }
}
