package calculator;

import calculator.utils.SplitByDelimiterToNumbersGenerator;
import calculator.validator.InputValidator;

import java.util.List;

public class StringCalculator {
    private static final int NULL_OR_EMPTY_VALUE = 0;

    public int calculate(final String input) {
        if (InputValidator.isNullOrEmpty(input)) {
            return NULL_OR_EMPTY_VALUE;
        }
        List<String> inputNumbers = SplitByDelimiterToNumbersGenerator.split(input);
        InputValidator.checkRightPositiveInteger(inputNumbers);
        return inputNumbers.stream()
            .mapToInt(Integer::valueOf)
            .sum();
    }
}
