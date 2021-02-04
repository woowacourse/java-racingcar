package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String VERTICAL_LINE = "|";

    public static int splitAndSum(String text) {
        if (checkEmptyOrNullString(text)) {
            return 0;
        }

        if (text.length() == 1 && Character.isDigit(text.charAt(0))) {
            return Integer.parseInt(text);
        }

        String[] numbers = text.split(COMMA + VERTICAL_LINE + COLON);
        int result = 0;

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            numbers = matcher.group(2).split(delimiter);
        }

        if (!checkAllDigit(numbers)) {
            throw new RuntimeException();
        }
        result = sum(numbers);

        return result;
    }

    private static boolean checkEmptyOrNullString(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean checkAllDigit(String[] numbers) {
        return Arrays.stream(numbers).allMatch(n -> n.matches("\\d+"));
    }


    private static int sum(String[] numbers) {
         return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
