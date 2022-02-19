package calculator;

import java.util.List;
import java.util.stream.Collectors;

import calculator.exception.NumberExceptionStatus;
import calculator.exception.WrongArgumentException;

public class Calculator {

    private final Separator separator;

    public Calculator(final Separator separator) {
        this.separator = separator;
    }

    public int splitAndSum(final String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        final List<String> splitValues = separator.splitByUnits(text);
        final List<Integer> splitNumbers = parseAsNumbers(splitValues);
        return sumNumber(splitNumbers);
    }

    private boolean isNullOrEmpty(final String text) {
        return (text == null) || (text.isEmpty());
    }

    private List<Integer> parseAsNumbers(final List<String> values) {
        return values.stream()
                .map(this::parseAsNumber)
                .collect(Collectors.toUnmodifiableList());
    }

    private int parseAsNumber(final String text) {
        try {
            final int number = Integer.parseInt(text);
            NumberValidator.validateNumber(number);
            return number;
        } catch (NumberFormatException exception) {
            throw new WrongArgumentException(NumberExceptionStatus.NUMBER_IS_NOT_NUMERIC);
        }
    }

    private int sumNumber(final List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(number -> number)
                .sum();
    }

}
