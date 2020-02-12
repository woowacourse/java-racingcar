package application.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (isNullOrEmptyText(text)) {
            return 0;
        }
        String delimiter = ",|:";
        String[] splitedText = splitText(text, delimiter);
        List<Integer> numbers = new ArrayList<>();
        splitText(text, delimiter);
        addNumbers(splitedText, numbers);
        return calculateNumberSum(numbers);
    }

    private static String[] splitText(String text, String delimiter) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiter = addCustomDelimiter(delimiter, customDelimiter);
            return matcher.group(2).split(delimiter);
        }
        return text.split(delimiter);
    }

    private static String addCustomDelimiter(String delimiter, String customDelimiter) {
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter);
        sb.append("|");
        sb.append(customDelimiter);
        return sb.toString();
    }

    private static int calculateNumberSum(List<Integer> numbers) {
        int sum = 0;
        for (int integer : numbers) {
            sum = sum + integer;
        }
        return sum;
    }

    private static void addNumbers(String[] splitString, List<Integer> numbers) {
        for (String string : splitString) {
            int convertNumber = getConvertNumber(string);
            throwRuntimeExceptionWhenNegativeNumber(convertNumber);
            numbers.add(convertNumber);
        }
    }

    private static void throwRuntimeExceptionWhenNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수를 입력하였습니다.");
        }
    }

    private static int getConvertNumber(String string) {
        return Integer.parseInt(string);
    }

    private static boolean isNullOrEmptyText(String text) {
        return text == null || text.isEmpty();
    }
}
