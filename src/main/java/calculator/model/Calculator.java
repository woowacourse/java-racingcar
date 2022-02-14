package calculator.model;

import calculator.utils.InputValidator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String BASE_DELIMITER_PATTERN = ",|:";
    private static final String OR = "|";
    private static final int DELIMITER = 1;
    private static final int NUMBERS = 2;

    public int sumAndDivideInput(String input) {
        if (hasCustomDelimiterInInput(input)) {
            List<String> numbersDividedByCustom = dividesByCustomAndCheckValidate(input);
            return makeSumOfNumbers(numbersDividedByCustom);
        }
        InputValidator.checkValidateNumbers(List.of(input.split("")));
        return makeSumOfNumbers(divideNumbersByDelimiter(input));
    }

    private boolean hasCustomDelimiterInInput(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        return matcher.find();
    }

    private List<String> dividesByCustomAndCheckValidate(String input) {
        List<String> numbers = divideNumbersByCustomDelimiter(input);
        InputValidator.checkValidateNumbers(numbers);
        return numbers;
    }

    private List<String> divideNumbersByCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(DELIMITER) + OR + BASE_DELIMITER_PATTERN;
            return List.of(matcher.group(NUMBERS).split(delimiter));
        }
        throw new RuntimeException();
    }

    private List<String> divideNumbersByDelimiter(String input) {
        return List.of(input.split(BASE_DELIMITER_PATTERN));
    }

    private int makeSumOfNumbers(List<String> numbers) {
        return numbers.stream()
                .mapToInt(num -> Integer.parseInt(sumOfNumber(num)))
                .sum();
    }

    private String sumOfNumber(String number) {
        if (InputValidator.isInputNullOrBlankOrEmpty(number)) {
            return "0";
        }
        return number;
    }
}
