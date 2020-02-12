package application.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static String[] splitString;
    private static List<Integer> numbers = new ArrayList<>();
    private static String delimiter = ",|:";

    public static int splitAndSum(String text) {
        if (isNullOrEmptyText(text)) {
            return 0;
        }
        splitText(text);
        addNumbers(splitString);
        return calculateNumberSum();
    }

    private static void splitText(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            splitString = matcher.group(2).split(customDelimiter);
        } else {
            splitString = text.split(delimiter);
        }
    }

    private static int calculateNumberSum() {
        int sum = 0;
        for (int integer : numbers) {
            sum = sum + integer;
        }
        return sum;
    }

    private static void addNumbers(String[] splitString) {
        for (String string : splitString) {
            int convertNumber = getConvertNumber(string);
            numbers.add(convertNumber);
        }
    }

    private static int getConvertNumber(String string) {
        return Integer.parseInt(string);
    }

    private static boolean isNullOrEmptyText(String text) {
        return text == null || text.isEmpty();
    }
}
