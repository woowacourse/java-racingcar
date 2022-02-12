package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.utils.InputValidator;

public class Application {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String BASE_DELIMITER_PATTERN = ",|:";
    private static final String OR = "|";
    private static final int DELIMITER = 1;
    private static final int NUMBERS = 2;

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println(runCalculator(askInput().replace("\\n", "\n")));
    }

    private static String askInput() throws IOException {
        return bufferedReader.readLine();
    }

    public static int runCalculator(String input) {
        if (InputValidator.isInputNullOrBlankOrEmpty(input)) {
            return 0;
        }
        return sumAndDivideInput(input);
    }

    private static int sumAndDivideInput(String input) {
        if (hasCustomDelimiterInInput(input)) {
            List<String> numbersDividedByCustomDelimiter = divideNumbersByCustomDelimiter(input);
            InputValidator.checkValidateNumbers(divideNumbersByCustomDelimiter(input));
            return makeSumOfNumbers(numbersDividedByCustomDelimiter);
        }
        InputValidator.checkValidateNumbers(List.of(input.split("")));
        return makeSumOfNumbers(divideInput(input));
    }

    private static boolean hasCustomDelimiterInInput(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private static List<String> divideNumbersByCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(DELIMITER) + OR + BASE_DELIMITER_PATTERN;
            return Arrays.asList(matcher.group(NUMBERS).split(delimiter));
        }
        throw new RuntimeException();
    }

    private static List<String> divideInput(String input) {
        return Arrays.asList(input.split(BASE_DELIMITER_PATTERN));
    }

    private static int makeSumOfNumbers(List<String> numbers) {
        int sumOfNumbers = 0;
        for (String number : numbers) {
            sumOfNumbers += Integer.parseInt(sumOfNumber(number));
        }
        return sumOfNumbers;
    }

    private static String sumOfNumber(String number) {
        if (InputValidator.isInputNullOrBlankOrEmpty(number)) {
            return "0";
        }
        return number;
    }
}
