package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DELIMITER_PATTERN = "^\\/\\/(.)\\\\n";
    private static final String INPUT_FORMAT_PATTERN = DELIMITER_PATTERN + ".+";
    private static final String DELIMITER = ",|:";

    public static void validateInput(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열을 입력할 수 없습니다.");
        }
    }

    public static String[] split(String text, String customDelimiter) {
        return text.split(customDelimiter);
    }

    public static int toNumber(String text) {
        try {
            return Integer.parseUnsignedInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException("올바른 숫자가 아닙니다.");
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

    public static int sum(String text) {
        validateInput(text);
        String delimiter = getDelimiterFromText(text);

        return Arrays.stream(split(removeDelimiterFromText(text), delimiter))
                .map(StringCalculator::toNumber)
                .reduce(0, Integer::sum);
    }

    public static String removeDelimiterFromText(String text) {
        return text.replaceAll(DELIMITER_PATTERN, "");
    }
}