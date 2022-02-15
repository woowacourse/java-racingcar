package calculator;

import static calculator.NumberExceptionStatus.NUMBER_IS_NOT_NUMERIC_EXCEPTION_STATUS;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private final Separator separator;

    public Calculator(Separator separator) {
        this.separator = separator;
    }

    public int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        List<String> splitValues = separator.splitByUnits(text);
        List<Integer> splitNumbers = parseAsNumbers(splitValues);
        return sumNumber(splitNumbers);
    }

    private boolean isNullOrEmpty(String text) {
        return (text == null) || (text.isEmpty());
    }

    private List<Integer> parseAsNumbers(List<String> values) {
        return values.stream()
                .map(this::parseAsNumber)
                .collect(Collectors.toUnmodifiableList());
    }

    private int parseAsNumber(String text) {
        try {
            int number = Integer.parseInt(text);
            NumberValidator.validateNumber(number);
            return number;
        } catch (NumberFormatException exception) {
            throw new RuntimeException(NUMBER_IS_NOT_NUMERIC_EXCEPTION_STATUS.getMessage());
        }
    }

    private int sumNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(number -> number)
                .sum();
    }

}
