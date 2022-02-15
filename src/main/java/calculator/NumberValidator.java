package calculator;

import static calculator.exception.NumberExceptionMessage.NUMBER_IS_NEGATIVE_EXCEPTION_MESSAGE;

import calculator.exception.CalculatorException;

public class NumberValidator {

    private static final NumberValidator NUMBER_VALIDATOR = new NumberValidator();

    private NumberValidator() { }

    public static void validateNumber(int number) {
        NUMBER_VALIDATOR.validateNumberIsNegative(number);
    }

    private void validateNumberIsNegative(int number) {
        if (number < 0) {
            throw new CalculatorException(NUMBER_IS_NEGATIVE_EXCEPTION_MESSAGE.getMessage());
        }
    }

}
