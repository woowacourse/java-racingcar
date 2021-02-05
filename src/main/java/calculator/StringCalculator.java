package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static List<String> delimiterList = new ArrayList<>();

    static {
        delimiterList.add(":");
        delimiterList.add(",");
    }

    public static int splitAndSum(String inputText) {
        if (isEmpty(inputText)) {
            return 0;
        }

        inputText = parseCustomDelimeter(inputText);

        String[] numbers = split(inputText);
        validateNumbers(numbers);
        return Arrays.stream(numbers).
                mapToInt(Integer::parseInt).
                sum();
    }

    private static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            validateNotNumber(number);
            validateNegative(number);
        }
    }

    private static void validateNegative(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException();
        }
    }

    private static void validateNotNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static String parseCustomDelimeter(String inputText) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiterList.add(customDelimiter);
            return m.group(2);
        }
        return inputText;
    }

    private static boolean isEmpty(String inputText) {
        return inputText == null || inputText.isEmpty();
    }

    private static String[] split(String inputText) {
        String pattern = String.join("|", delimiterList);
        return inputText.split(pattern);
    }
}


