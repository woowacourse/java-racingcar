package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String defaultSeparator = ",|:";
    private static final String delimiterSeparator = "|";

    public static int calculate(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        if (isNumeric(input)) {
            int pos = Integer.parseInt(input);
            checkPositive(pos);
            return pos;
        }

        int[] numbers = splitByNumbers(input);
        checkAllPositive(numbers);
        return addAll(numbers);
    }

    private static boolean isNullOrEmpty(String input) {
        if (input == null) {
            return true;
        }

        return input.trim().isEmpty();
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void checkPositive(int n) {
        if (n < 0) {
            throw new RuntimeException("음수 입력");
        }
    }

    private static int[] splitByNumbers(String line) {
        String[] strings = splitBySeparator(line);
        checkAllNumeric(strings);
        return parseToIntegerArray(strings);
    }

    private static String[] splitBySeparator(String input) {
        StringBuilder customSeparator = new StringBuilder();

        Matcher matcher = Pattern.compile("//(.+)\n(.*)").matcher(input);
        if (matcher.find()) {
            customSeparator.append(delimiterSeparator);
            customSeparator.append(matcher.group(1));
            input = matcher.group(2);
        }

        return input.split(defaultSeparator + customSeparator.toString());
    }

    private static void checkAllNumeric(String[] numericStrings) {
        if (!Arrays.stream(numericStrings).allMatch(n -> isNumeric(n))) {
            throw new IllegalArgumentException("정수가 아닌 숫자 입력");
        }
    }

    private static int[] parseToIntegerArray(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void checkAllPositive(int[] posArr) {
        Arrays.stream(posArr).forEach(n -> checkPositive(n));
    }

    private static int addAll(int[] intArr) {
        int sum = 0;

        for (int num : intArr) {
            sum += num;
        }

        return sum;
    }
}
