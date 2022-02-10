package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        System.out.println(runCalculator(askInput()));
    }

    public static int runCalculator(String input) {
        if (isNotValidateInput(input)) {
            return 0;
        }

        return sumAndDivideInput(input);
    }

    private static boolean isNotValidateInput(String input) {
        if (isNullInput(input) || isEmptyInput(input) || isBlankInput(input)) {
            return true;
        }
        return false;
    }

    private static boolean isBlankInput(String input) {
        return input.isBlank();
    }

    private static boolean isEmptyInput(String input) {
        return input.isEmpty();
    }

    private static boolean isNullInput(String input) {
        return input == null;
    }

    private static String askInput() throws IOException {
        return bufferedReader.readLine();
    }

    private static int sumAndDivideInput(String input) {
        if (hasCustomDelimiterInInput(input)) {
            return makeSumOfNumbers(divideNumbersByCustomDelimiter(input));
        }
        return makeSumOfNumbers(divideInput(input));
    }

    private static boolean hasCustomDelimiterInInput(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private static List<String> divideNumbersByCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1) + "|,|:";;
            return Arrays.asList(matcher.group(2).split(delimiter));
        }
        throw new RuntimeException();
    }

    private static int makeSumOfNumbers(List<String> numbers) {
        int sumOfNumbers = 0;
        for (String number : numbers) {
            sumOfNumbers += Integer.parseInt(number);
        }
        return sumOfNumbers;
    }

    private static List<String> divideInput(String input) {
        return Arrays.asList(input.split(",|:"));
    }
}
