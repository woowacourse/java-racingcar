package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static int splitAndSum(String number) {
        if (number==null || number.isEmpty()) {
            return isNullOrZero();
        }
        if (number.contains("-")) {
            throw new RuntimeException();
        }
        if (isNumber(number)) {
            return isLengthOne(number);
        }
        if (number.contains(",") || number.contains(":")) {
            return isCommaOrColon(number);
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(number);
        if (m.find()) {
            return isCustom(m);
        }
        return -1;
    }

    private static boolean isNumber(String number) {
        return number.chars().allMatch( Character::isDigit );
    }

    private static int isCustom(Matcher m) {
        String customDelimiter = m.group(1);
        String[] tokens = m.group(2).split(customDelimiter);
        int sum = 0;
        for (int i=0; i<tokens.length;i++){
            sum += Integer.parseInt(tokens[i]);
        }
        return sum;
    }

    private static int isCommaOrColon(String number) {
        String[] numbers = number.split(",|:");
        int sum = 0;
        for (int i=0; i<numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }

    private static int isLengthOne(String number) {
        return Integer.parseInt(number);
    }

    private static int isNullOrZero() {
        return 0;
    }
}
