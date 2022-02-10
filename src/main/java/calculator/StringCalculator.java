package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class StringCalculator {
    static int sum;
    static final String CUSTOM_DELIMETER_SIGN = "//.*\\n.*";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(splitAndSum(input));
    }

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (isNumber(input)) {
            return Integer.parseInt(input);
        }

        String[] tokens = tokenizer(input);
        return adder(tokens);
    }

    public static String[] tokenizer(String input) {
        if (input.matches(CUSTOM_DELIMETER_SIGN)) {
            String[] tempStr = input.split("\\n");
            String customDelimiter = tempStr[0].substring(2);
            String[] tokens = tempStr[1].split(customDelimiter);
            return tokens;
        }

        String[] tokens = input.split("[,:]");
        return tokens;
    }

    public static int adder(String[] tokens) {
        negativeCheck(tokens);
        zeroFill();
        Arrays.asList(tokens).forEach(x -> sum += Integer.parseInt(x));
        return sum;
    }

    public static void negativeCheck(String[] tokens) {
        if (Arrays.asList(tokens).stream().anyMatch(x -> Integer.parseInt(x) < 0)) {
            throw new RuntimeException();
        }
    }

    public static void zeroFill() {
        sum = 0;
    }

    public static boolean isNumber(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");
    }
}
