package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final List<String> delimiterList = new ArrayList<>();

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String COLON = ":";
    private static final String COMMA = ",";

    static {
        delimiterList.add(COLON);
        delimiterList.add(COMMA);
    }

    public static int splitAndSum(String inputText) {
        if (isEmpty(inputText)) {
            return 0;
        }

        inputText = parseCustomDelimiter(inputText);

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

    private static String parseCustomDelimiter(String inputText) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(inputText);
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


