package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String VERTICAL_LINE = "|";

    public static int splitAndSum(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }

        if (string.length() == 1 && Character.isDigit(string.charAt(0))) {
            return Integer.parseInt(string);
        }

        String[] numbers = string.split(COMMA + VERTICAL_LINE + COLON);
        int result = 0;

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(string);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            numbers = matcher.group(2).split(delimiter);
        }

        result = sum(numbers);

        return result;
    }

    private static boolean checkDigit(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!checkDigit(number)) {
                throw new RuntimeException();
            }
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
