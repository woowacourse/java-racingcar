package cal;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private final static int EVEN = 2;

    private List<Integer> numbers = new ArrayList<>();
    private List<Character> operators = new ArrayList<>();

    protected int add(int num1, int num2) {
        return num1 + num2;
    }

    protected int minus(int num1, int num2) {
        return num1 - num2;
    }

    protected int multiple(int num1, int num2) {
        return num1 * num2;
    }

    protected int divide(int num1, int num2) throws ArithmeticException {
        if (num2 == 0) {
            numbers.clear();
            operators.clear();
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }

    protected int calculate(String[] input) throws ArithmeticException {
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

    private int subCalculate(int num1, int num2, char operator) throws ArithmeticException {// 이거 좋게 구현하는 힌트
        if (operator == '+') return add(num1, num2);

        if (operator == '-') return minus(num1, num2);

        if (operator == '*') return multiple(num1, num2);

        if (operator == '/') return divide(num1, num2);

        return -1;
    }

    private void putList(String input, int index) {
        if (index % EVEN == 0) { // 숫자 인덱스
            numbers.add(Integer.parseInt(input));
            return;
        }
        operators.add(input.charAt(0));
        return;
    }
}
