package calculator.model;

import java.util.List;

import calculator.utils.InputValidator;
import calculator.view.InputView;

public class Calculator {
    private static final String DEFAULT_NUMBER = "0";

    public int sumAndDivideInput(String input) {
        if (InputView.hasCustomDelimiterInInput(input)) {
            return makeSumOfNumbers(InputView.dividesByCustomAndCheckValidate(input));
        }
        return makeSumOfNumbers(InputView.divideNumbersByDelimiterAndCheckValidate(input));
    }

    private int makeSumOfNumbers(List<String> numbers) {
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
