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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.calculate(scanner.nextLine()));
    }
}
