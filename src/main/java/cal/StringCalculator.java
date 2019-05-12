package cal;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    final static int EVEN_NUMBER = 2;
    List<Integer> numbers = new ArrayList<>();
    List<Character> operators = new ArrayList<>();

    public int calculate(String[] input) throws ArithmeticException {
        int num1 = 0;

        for (int i = 0; i < input.length; i++) {
            putList(input[i], i);
        }

        num1 = numbers.get(0);
        for (int i = 0; i < numbers.size() - 1; i++) {
            int num2 = numbers.get(i + 1);
            char operator = operators.get(i);
            num1 = subCalculate(num1, num2, operator);
        }

        return num1;
    }

    public static int subCalculate(int num1, int num2, char operator) throws ArithmeticException {
        return Operator.fromName(operator).calculate(num1, num2);
    }

    private void putList(String input, int index) {
        if (index % EVEN_NUMBER == 0) { // 숫자 인덱스
            numbers.add(Integer.parseInt(input));
            return;
        }
        operators.add(input.charAt(0));
        return;
    }
}
