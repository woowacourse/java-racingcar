package calculator;

public class StringCalculator {

    private static final String BASIC_DELIMITER = ";|,";

    public static int plusByDelimiterFrom(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] customDelimiterAndNumbers = input.split("\n");
        if (customDelimiterAndNumbers.length == 1) {
            return plus(customDelimiterAndNumbers[0], BASIC_DELIMITER);
        }
        String newDelimiter = makeDelimiter(customDelimiterAndNumbers[0]);
        return plus(customDelimiterAndNumbers[1], newDelimiter);
    }

    private static String makeDelimiter(String customDelimiterAndNumber) {
        String[] customDelimiter = customDelimiterAndNumber.split("//");
        return BASIC_DELIMITER + "|" + customDelimiter[1];
    }

    private static int plus(String customDelimiterAndNumber, String newDelimiter) {
        String valuesString = customDelimiterAndNumber;
        String[] values = valuesString.split(newDelimiter);

        int result = 0;
        for (String value : values) {
            result += parseInt(value);
        }
        return result;
    }

    private static int parseInt(String value) {
        int result = Integer.parseInt(value);
        if (result < 0) {
            throw new IllegalArgumentException();
        }
        return result;
    }

}
