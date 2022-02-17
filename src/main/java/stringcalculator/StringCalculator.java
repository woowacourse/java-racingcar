package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    private static final String DELIMITER_PATTERN = "^\\/\\/(.)\\n";
    private static final String INPUT_FORMAT_PATTERN = "(" + DELIMITER_PATTERN + ")?(([0-9]+.{1})*[0-9]+)?";
    private static final String DELIMITER = ",|:";

    public static int sum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        validateInput(text);
        String delimiter = getDelimiterFromText(text);

        return sumIntegerArray(toIntegerArray(split(removeDelimiterFromText(text), delimiter)));
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static void validateInput(String text) {
        if (!text.matches(INPUT_FORMAT_PATTERN)) {
            throw new RuntimeException("잘못된 입력 형식입니다.");
        }
    }

    private static String getDelimiterFromText(String text) {
        Matcher matcher = Pattern.compile(DELIMITER_PATTERN)
                .matcher(text);

        if (matcher.find()) {
            return matcher.group(CUSTOM_DELIMITER_GROUP_INDEX);
        }

        return DELIMITER;
    }

    private static String removeDelimiterFromText(String text) {
        return text.replaceAll(DELIMITER_PATTERN, "");
    }

    private static String[] split(String text, String customDelimiter) {
        return text.split(customDelimiter);
    }

    private static Integer[] toIntegerArray(String[] strings) {
        return Arrays.stream(strings)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }

    private static int sumIntegerArray(Integer[] integers) {
        return Arrays.stream(integers).mapToInt(Integer::intValue).sum();
    }
}