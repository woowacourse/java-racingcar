package cal;

import java.util.Scanner;

public class StringCalculator {

    int calculate(String value) throws IllegalArgumentException{
        String[] strings = value.split(" ");
        int length = strings.length;
        int result = Integer.parseInt(strings[0]);

        for (int i = 1; i < length; i += 2) {
            Operator oper = Operator.getOperator(strings[i]);
            int next = Integer.parseInt(strings[i + 1]);
            result = oper.calculate(result, next);
        }
        return result;
    }

    String inputData() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        try {
            String[] values = value.split(" ");
            check(values);
            return value;
        } catch (IllegalArgumentException e) {
            return inputData();
        }
    }

    private void check(String[] values) {
        int n = values.length;
        checkLength(n);

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                isInt(values[i]);
            }
            if (i % 2 == 1) {
                isOperator(values[i]);
            }
        }
    }

    private void isInt(String value) {
        if (value.matches("\\D")) {
            throw new IllegalArgumentException("int miss");
        }
    }

    private void isOperator(String value) {
        if (!value.matches("[*]|[+]|-|/")) {
            throw new IllegalArgumentException("operator miss");
        }
    }

    private void checkLength(int length) {
        if (length % 2 == 0) {
            throw new IllegalArgumentException("length error");
        }
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        String value = stringCalculator.inputData();
        System.out.println(stringCalculator.calculate(value));
    }
}
