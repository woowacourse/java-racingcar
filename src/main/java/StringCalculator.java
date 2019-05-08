import java.util.Scanner;

public class StringCalculator {

    int plus(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int mul(int a, int b) {
        return a * b;
    }

    int div(int a, int b) {
        return a / b;
    }

    int operation(int result, String oper, int next) {
        if (oper.equals("+")) {
            return plus(result, next);
        }
        if (oper.equals("-")) {
            return sub(result, next);
        }
        if (oper.equals("*")) {
            return mul(result, next);
        }
        if (oper.equals("/")) {
            return div(result, next);
        }
        return -1;
    }

    int calculate(String value) {
        String[] strings = value.split(" ");
        int length = strings.length;
        int result = Integer.parseInt(strings[0]);

        for (int i = 1; i < length; i += 2) {
            result = operation(result, strings[i], Integer.parseInt(strings[i + 1]));
        }
        return result;
    }

    void isInt(String value) {
        if (value.matches("\\D")) {
            throw new IllegalArgumentException("int miss");
        }
    }

    void isOperator(String value) {
        if (!value.matches("[*]|[+]|-|/")) {
            throw new IllegalArgumentException("operator miss");
        }
    }

    void checkLength(int length){
        if (length % 2 == 0) {
            throw new IllegalArgumentException("length error");
        }
    }

    void check(String[] values) {
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

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        String value = stringCalculator.inputData();
        System.out.println(stringCalculator.calculate(value));
    }
}
