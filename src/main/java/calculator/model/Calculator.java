package calculator.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.utils.CalculatorInputValidator;

public class Calculator {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String BASE_DELIMITER_PATTERN = ",|:";
    private static final String OR = "|";
    private static final int DELIMITER = 1;
    private static final int NUMBERS = 2;

    public int sumAndDivideInput(String input) {
        if (hasCustomDelimiterInInput(input)) {
            List<String> numbersDividedByCustomDelimiter = divideNumbersByCustomDelimiter(input);
            CalculatorInputValidator.checkValidateNumbers(divideNumbersByCustomDelimiter(input));
            return makeSumOfNumbers(numbersDividedByCustomDelimiter);
        }
        CalculatorInputValidator.checkValidateNumbers(List.of(input.split("")));
        return makeSumOfNumbers(divideInput(input));
    }

    private boolean hasCustomDelimiterInInput(String input) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private List<String> divideNumbersByCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(DELIMITER) + OR + BASE_DELIMITER_PATTERN;
            return List.of(matcher.group(NUMBERS).split(delimiter));
        }
        throw new RuntimeException();
    }

    private List<String> divideInput(String input) {
        return List.of(input.split(BASE_DELIMITER_PATTERN));
    }

    private int makeSumOfNumbers(List<String> numbers) {
        int sumOfNumbers = 0;
        for (String number : numbers) {
            sumOfNumbers += Integer.parseInt(sumOfNumber(number));
        }
        return sumOfNumbers;
    }

    private String sumOfNumber(String number) {
        if (CalculatorInputValidator.isInputNullOrBlankOrEmpty(number)) {
            return "0";
        }
        return number;
    }
}
