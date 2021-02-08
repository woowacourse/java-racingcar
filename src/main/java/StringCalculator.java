import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String PRE_DELIMITER = "[,:";
    private static final String END_DELIMITER = "]";
    private static final int BLANK = 0;
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String input) {
        if (isBlank(input)) {
            return BLANK;
        }

        String[] numbers = splitInput(input);
        exceptionHandler(numbers);
        return sum(numbers);
    }

    private static boolean isBlank(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static void exceptionHandler(String[] input) {
        Arrays.stream(input)
                .filter(number -> !NUMBER_PATTERN.matcher(number).matches())
                .findAny()
                .ifPresent(s -> {
                    throw new RuntimeException();
                });
    }

    public static String[] splitInput(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String number = m.group(2);
            return number.split(PRE_DELIMITER + customDelimiter + END_DELIMITER);
        }
        return input.split(PRE_DELIMITER + END_DELIMITER);
    }
}
