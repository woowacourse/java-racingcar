package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class StringCalculator {
    private static final String CUSTOM_DELIMETER_SIGN = "//.*\\n.*";

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
        checkNotContainNegative(tokens);
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }

    public static void checkNotContainNegative(String[] tokens) {
        Boolean isNegative = Arrays.asList(tokens).stream().anyMatch(x -> Integer.parseInt(x) < 0);
        if (isNegative) {
            throw new RuntimeException();
        }
    }

    public static boolean isNumber(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");
    }
}
