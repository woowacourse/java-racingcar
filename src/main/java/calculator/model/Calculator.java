package calculator.model;

import java.util.List;

import calculator.utils.InputValidator;

public class Calculator {
    private static final String DEFAULT_NUMBER = "0";

    public int makeSumOfNumbers(List<String> numbers) {
        return numbers.stream()
                .mapToInt(num -> Integer.parseInt(sumOfNumber(num)))
                .sum();
    }

    private String sumOfNumber(String number) {
        if (InputValidator.isInputNullOrBlankOrEmpty(number)) {
            return DEFAULT_NUMBER;
        }
        return number;
    }
}
