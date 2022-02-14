package calculator;

import java.util.List;
import java.util.stream.Collectors;

import calculator.exception.NumberIsNotNumericException;

public class Calculator {

    private final Separator separator;

    public Calculator(Separator separator) {
        this.separator = separator;
    }

    public int splitAndSum(String targetValue) {
        if (isNullOrEmpty(targetValue)) {
            return 0;
        }

        List<String> splitValues = separator.splitByUnits(targetValue);
        List<Integer> splitNumbers = parseValuesAsNumber(splitValues);

        return sumNumber(splitNumbers);
    }

    private boolean isNullOrEmpty(String value) {
        return (value == null || value.isEmpty());
    }

    private List<Integer> parseValuesAsNumber(List<String> values) {
        return values.stream()
                .map(this::parseValueAsNumber)
                .collect(Collectors.toList());
    }

    private int parseValueAsNumber(String value) {
        try {
            int number = Integer.parseInt(value);
            NumberValidator.validateNumber(number);
            return number;
        } catch (NumberFormatException exception) {
            throw new NumberIsNotNumericException();
        }
    }

    private int sumNumber(List<Integer> splitNumbers) {
        return splitNumbers.stream()
                .mapToInt(number -> number)
                .sum();
    }

}
