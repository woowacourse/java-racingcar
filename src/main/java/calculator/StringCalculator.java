package calculator;

public class StringCalculator {

    private final static String BASIC_DELIMITER = ",|:";
    private final static String PREFIX_FOR_CUSTOM_DELIMITER = "//";
    private final static String POSTFIX_FOR_CUSTOM_DELIMITER = "\n";
    private final static int CUSTOM_DELIMITER_TEXT_INDEX = 0;
    private final static int CUSTOM_DELIMITER_INDEX = 2;
    private final static int CUSTOM_TEXT_INDEX = 1;

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return sum(split(text));
    }

    private static String[] split(String text) {
        if (text.startsWith(PREFIX_FOR_CUSTOM_DELIMITER)) {
            String[] splitTexts = text.split(POSTFIX_FOR_CUSTOM_DELIMITER);

            String customDelimiter = splitTexts[CUSTOM_DELIMITER_TEXT_INDEX].substring(CUSTOM_DELIMITER_INDEX);
            String customText = splitTexts[CUSTOM_TEXT_INDEX];

            return customText.split(customDelimiter);
        }

        return text.split(BASIC_DELIMITER);
    }

    private static int sum(String[] tokens) {
        int result = 0;
        int number;
        for (String token : tokens) {
            number = Integer.parseInt(token);
            validateNegative(number);
            result += number;
        }
        return result;
    }

    private static void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
