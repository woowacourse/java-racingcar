import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static String pre_delimiter = "[,:";
    static String end_delimiter = "]";
    static int BLANK = 0;

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
                .mapToInt(number -> Integer.parseInt(number))
                .sum();
    }

    public static void exceptionHandler(String[] input) {
        String pattern = "^[0-9]*$";
        Arrays.stream(input)
                .filter(number -> !Pattern.matches(pattern, number))
                .findAny()
                .ifPresent(s -> {
                    throw new RuntimeException();
                });
    }

    public static String[] splitInput(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String number = m.group(2);
            return number.split(pre_delimiter + customDelimiter + end_delimiter);
        }
        return input.split(pre_delimiter + end_delimiter);
    }
}
