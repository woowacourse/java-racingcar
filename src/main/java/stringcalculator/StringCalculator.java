package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DELIMITER_PATTERN = "^\\/\\/(.)\\n";
    private static final String INPUT_FORMAT_PATTERN = "(" + DELIMITER_PATTERN + ")?(([0-9]+.{1})*[0-9]+)?";
    private static final String DELIMITER = ",|:";

    public static void validateInput(String text) {
        if (!text.matches(INPUT_FORMAT_PATTERN)) {
            throw new RuntimeException("잘못된 입력 형식입니다.");
        }
    }

    public static String[] split(String text, String customDelimiter) {
        return text.split(customDelimiter);
    }

    public static int toNumber(String text) {
        int number = Integer.parseInt(text);
        validateNegativeNumber(number);

        return number;
    }

    public static void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    public static String getDelimiterFromText(String text) {
        Matcher matcher = Pattern.compile(DELIMITER_PATTERN)
            .matcher(text);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return DELIMITER;
    }

    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static int sum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        validateInput(text);
        String delimiter = getDelimiterFromText(text);

        return sumIntegerArray(toIntegerArray(split(removeDelimiterFromText(text), delimiter)));
    }

    public static Integer[] toIntegerArray(String[] strings) {
        return Arrays.stream(strings)
            .map(Integer::parseInt)
            .toArray(Integer[]::new);
    }

    public static int sumIntegerArray(Integer[] integers) {
        return Arrays.stream(integers).mapToInt(Integer::intValue).sum();
    }

    public static String removeDelimiterFromText(String text) {
        return text.replaceAll(DELIMITER_PATTERN, "");
    }
}
