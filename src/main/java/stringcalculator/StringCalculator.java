package stringcalculator;

import java.util.Arrays;

public class StringCalculator {
    private static final String DELIMITER_PATTERN = "^\\/\\/.\\\\n";
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
        return text.split("\\\\n")[0].split("//")[1];
    }

    public static int sum(String text) {
        validateInput(text);

        String delimiter = DELIMITER;
        if (hasCustomDelimiter(text)) {
            delimiter = getDelimiterFromText(text);
        }

        return Arrays.stream(split(removeDelimiterFromText(text), delimiter))
                .map(StringCalculator::toNumber)
                .reduce(0, Integer::sum);
    }

    public static boolean hasCustomDelimiter(String text) {
        return text.matches(INPUT_FORMAT_PATTERN);
    }

    public static String removeDelimiterFromText(String text) {
        return text.replaceAll(DELIMITER_PATTERN, "");
    }
}