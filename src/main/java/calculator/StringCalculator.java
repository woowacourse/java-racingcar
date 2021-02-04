package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class StringCalculator {
    public static List<String> tokens;

    public static int splitAndSum(String text) {

        if (isEmpty(text)) {
            return 0;
        }

        if (isOneDigit(text)) {
            return Integer.parseInt(text);
        }

        divideByDelimiter(text);
        throwRuntimeExceptionWhenContainsNegative();
        return getSum();
    }

    public static void divideByDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            divideByCustomDelimiter(m);
            return;
        }

        divideByDefaultDelimiter(text);
    }

    public static void divideByCustomDelimiter(Matcher m) {
        String customDelimiter = m.group(1);
        tokens = Arrays.asList(m.group(2).split(customDelimiter));
    }

    public static void divideByDefaultDelimiter(String text) {
        tokens = Arrays.asList(text.split(",|:"));
    }

    public static void throwRuntimeExceptionWhenContainsNegative() {

        if (tokens.stream()
                .filter(token -> Integer.parseInt(token) < 0)
                .findAny()
                .isPresent()) {
            throw new RuntimeException();
        }
    }

    public static int getSum() {
        return tokens.stream().mapToInt(Integer::valueOf).sum();
    }

    public static boolean isEmpty(String text) {

        if (text == null) {
            return true;
        }

        if (text.isEmpty()) {
            return true;
        }

        return false;
    }

    public static boolean isOneDigit(String text) {

        if (text.length() == 1 && Character.isDigit(text.charAt(0))) {
            return true;
        }
        
        return false;
    }
}
